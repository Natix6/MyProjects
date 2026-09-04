public abstract class CarData {

    private final int number;
    private final String creator;
    private final int yearMade;
    private final int seats;
    private int km;

    public CarData(int number, String creator, int yearMade, int seats) {
        this.creator = creator;
        this.number = number;
        this.seats = seats;
        this.yearMade = yearMade;
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

    
}
