public class Van extends CarData implements Car {

    static boolean available;
    static boolean rentable;

    
    public Van(int number, String creator, int yearMade, int seats) {
        super(number, creator, yearMade, seats);
    }

    public void isRented(boolean ifRented) {
        if(!ifRented) {
            rentable = false;
        } else {
            rentable = true;
        }
    }

    public boolean isAvailable() {
        return !rentable;
    }

    @Override
    public double calcDailyPrice() {
        return getKm() * 40 + getSeats() * 10;
    }

    @Override
    public String toString() {
        return "Van [number=" + getNumber() + ", creator=" + getCreator() + ", yearMade=" + getYearMade() + ", seats=" + getSeats()
                + ", km=" + getKm() + "]";
    }

}
