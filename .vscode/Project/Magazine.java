public class Magazine extends LibraryItem implements Borrowable {

    private static int loanDays = 7;
    private static final int LATE_FEE = 1;
    
    public Magazine(String name, int id) {
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