public class Book extends LibraryItem implements Borrowable {

    private static final int LATE_FEE = 2;


    private static int loanDays = 21;

    public Book(String name, int id) {
        super(name, id);
    }

    @Override
    public int getLoanDays() {
        return loanDays;
    }

    @Override 
    public int getDailyLateFee() {
        return LATE_FEE;
    }


}