public class MotorCycle implements Car {
    
    static boolean available;
    static boolean rentable;
    private final int number;
    private final String creator;
    private final int yearMade;
    private final int seats;
    private int km;
    int instances = 0;

    public MotorCycle(int number, String creator, int yearMade, int seats) {
        this.number = number;
        this.creator = creator;
        this.yearMade = yearMade;
        this.seats = seats;
        instances++;
        rentable = false;
    }

    private boolean setAvailability() {
        if(instances > 1) {
            return false;
        }
        return true; 
    }

    
    public int getNumber() {
        return number;
    }
    public String getCreator() {
        return creator;
    }
    public int getYearMade() {
        return yearMade;
    }
    public int getSeats() {
        return seats;
    }
    public int getKm() {
        return km;
    }
    public void setKm(int km) {
        this.km = km;
    }
    @Override
    public double calcDailyPrice() {
        return km * 10;
    }
    @Override
    public String toString() {
        return "MotorCycle [number=" + number + ", creator=" + creator + ", yearMade=" + yearMade + ", seats=" + seats
                + ", km=" + km + "]";
    }
    @Override
    public boolean isAvailable() {
        available = setAvailability();
        return available;
    }

    

    
}
