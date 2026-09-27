public class Loan implements Identifiable {

    Member member;
    LibraryItem item;
    java.time.LocalDate date;
    java.time.LocalDate backDate;

    public Loan(Member member, LibraryItem item, java.time.LocalDate date, java.time.LocalDate backDate) {

        this.member = member;
        this.item = item;
        this.date = date;
        this.backDate = backDate;

    }

    @Override
    public String toString() {
    return member.getName() + " - " + item.getName() + ", due: " + backDate;
    }

    @Override 
    public int getId() {
        return item.getId();
    }

    


    
}
