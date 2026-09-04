public class MotorCycle extends CarData implements Car {
    
    static boolean available;
    static boolean rentable;
    static int instances = 0;

    
    public MotorCycle(int number, String creator, int yearMade, int seats) {
        super(number, creator, yearMade, seats);
        // instances++;
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

    // private boolean setAvailability() {
    //     if(instances > 1) {
    //         return false;
    //     } else {
    //     return true; 
    //     }
    // }

    @Override
    public double calcDailyPrice() {
        return getKm() * 10;
    }

    // @Override
    // public boolean isRented() {
    //     return rentable;
    // }

    @Override
    public String toString() {
        return "MotorCycle [number=" + getNumber() + ", creator=" + getCreator() + ", yearMade=" + getYearMade() + ", seats=" + getSeats()
                + ", km=" + getKm() + "]";
    }

    // public boolean isAvailable() {
    //     available = setAvailability();
    //     return available;
    // }

    

    
}
