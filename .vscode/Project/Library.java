import java.util.List;
import java.util.Map;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class ItemNotFoundException extends RuntimeException { 
    public ItemNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

class ItemAlreadyBorrowedException extends RuntimeException { 
    public ItemAlreadyBorrowedException(String errorMessage) {
        super(errorMessage);
    }
}

class BorrowLimitExceededException extends RuntimeException { 
    public BorrowLimitExceededException(String errorMessage) {
        super(errorMessage);
    }
}


public class Library {

    private void throwExceptionsForBorrow(int id, int memberId) {

        if(!(libraryRepo.contains(id))) {
            throw new ItemNotFoundException("Item not found");
        } else if(!availableItems.contains(id)) {
            throw new ItemAlreadyBorrowedException("Item already borrowed :");
        } else if(!memberRepo.contains(memberId)) {
            throw new IllegalArgumentException("Member doesn't exist"); 
        } else if(memberRepo.get(memberId).getLibraryItems().size() >= memberRepo.get(memberId).getMaxItems()) {
            throw new BorrowLimitExceededException("Borrow Limit Exceeded"); 
        }
    }

    private void throwExceptionsForReturn(int id, int memberId) {

        if(!libraryRepo.contains(id)) {
            throw new ItemNotFoundException("Item's id is not in the library");
        } else if(availableItems.contains(id)) {
            throw new IllegalArgumentException("Item isn't borrowed bruh");
        } else if(!memberRepo.contains(memberId)) {
            throw new IllegalArgumentException("Member doesnt exist");
        }
    }

    Repository<LibraryItem> libraryRepo = new Repository<>();
    Repository<Member> memberRepo = new Repository<>();
    Repository<Loan> loanMap = new Repository<>();

    List<Integer> availableItems = new ArrayList<>();

    public void addItem(LibraryItem item) {
        libraryRepo.add(item);
        availableItems.add(item.getId());
    }

    public void addMember(Member member) {
        if(memberRepo.contains(member.getId())) {
            throw new IllegalArgumentException("Member ID already exists");
        }
        memberRepo.add(member);
    }

    public LibraryItem borrowItem(int memberId, int id, java.time.LocalDate localDate) {

        throwExceptionsForBorrow(id, memberId);
        if(!(libraryRepo.get(id) instanceof Borrowable)) {
            throw new IllegalArgumentException("Not a borrowable item: " + libraryRepo.get(id));
        }
        Borrowable borrowable = (Borrowable) libraryRepo.get(id);
        java.time.LocalDate backDate = localDate.plusDays(borrowable.getLoanDays());
        availableItems.remove(Integer.valueOf(id));
        memberRepo.get(memberId).addItem((Borrowable) libraryRepo.get(id));
        loanMap.add(new Loan(memberRepo.get(memberId), libraryRepo.get(id), localDate, backDate));
        return libraryRepo.get(id);
    }

    public double returnItem(int memberId, int id, java.time.LocalDate date) {
        throwExceptionsForReturn(id, memberId);
        memberRepo.get(memberId).removeItem((Borrowable) libraryRepo.get(id));
        loanMap.remove(id);
        availableItems.add(id);
        if(date.isAfter(loanMap.get(id).backDate)) {
            Borrowable borrowableItem = (Borrowable) libraryRepo.get(id);
            return borrowableItem.getDailyLateFee() * ChronoUnit.DAYS.between(loanMap.get(id).backDate, date) * memberRepo.get(memberId).getFeeMultiplier();
        }
        return 0;
    }

    public void printAllAvailableItems() {
        availableItems.forEach(a -> System.out.println(libraryRepo.get(a)));
    }

    public void printMemberItems(int memberId) {
        List<Borrowable> yes = memberRepo.get(memberId).getLibraryItems();
        yes.forEach(a -> System.out.println(a.getLoanDays()));
        System.out.println(yes);
    }

    public void printAllLate() {

        List<Loan> temp = new ArrayList<>();
        java.time.LocalDate localDate = LocalDate.of(2026, 1, 20);


        for(Integer key : loanMap.getKeys()) {
            Loan loan = loanMap.get(key);
            if(localDate.isAfter(loan.backDate)) {
                temp.add(loanMap.get(key));
            }
            
        }

        temp.sort(Comparator.comparingLong((Loan l) -> ChronoUnit.DAYS.between(l.backDate, localDate)).reversed());  
        System.out.println(temp);      


    }

}

