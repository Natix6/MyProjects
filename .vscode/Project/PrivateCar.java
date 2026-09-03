

public class PrivateCar implements Car {

    private final int number;
    private final String creator;
    private final int yearMade;
    private final int seats;
    private int km;
    static boolean available;
    int instances = 0;
    static boolean rentable;


    public PrivateCar(int number, String creator, int yearMade, int seats) {
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

    public String move() {
        return "Cat is moving!";
    }

    public String eat() {
        return "Cat is eating!";
    }

    public String makeASound() {
        return "Cutie MEOWWW";
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

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public double calcDailyPrice() {
        return km * 20;
    }

    @Override
    public boolean isAvailable() {
        available = setAvailability();
        return available;
    }

    @Override
    public String toString() {
        return "PrivateCar [number=" + number + ", creator=" + creator + ", yearMade=" + yearMade + ", seats=" + seats
                + ", km=" + km + "]";
    }
    
    
}
