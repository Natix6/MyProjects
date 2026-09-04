public class MotorCycle extends CarData implements Car {
    
    static boolean available;
    static boolean rentable;

    
    public MotorCycle(int number, String creator, int yearMade, int seats) {
        super(number, creator, yearMade, seats);
        rentable = false;
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
        return getKm() * 10;
    }

    @Override
    public String toString() {
        return "MotorCycle [number=" + getNumber() + ", creator=" + getCreator() + ", yearMade=" + getYearMade() + ", seats=" + getSeats()
                + ", km=" + getKm() + "]";
    }
  
}
