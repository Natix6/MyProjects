
public class PrivateCar extends CarData implements Car {

    static boolean available;
    static boolean rentable;


    public PrivateCar(int number, String creator, int yearMade, int seats) {
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
        return getKm() * 20;
    }

    @Override
    public String toString() {
        return "PrivateCar [number=" + getNumber() + ", creator=" + getCreator() + ", yearMade=" + getYearMade() + ", seats=" + getSeats()
                + ", km=" + getKm() + "]";
    }
    
    
}
