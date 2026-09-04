
public class PrivateCar extends CarData implements Car {
    
    public PrivateCar(int number, String creator, int yearMade, int seats) {
        super(number, creator, yearMade, seats);
    }

    @Override
    public double calcDailyPrice() {
        return getKm() * 20;
    }

    @Override
    public String toString() {
        return "\n" + "PrivateCar number=" + getNumber() + ", creator=" + getCreator() + ", yearMade=" + getYearMade() + ", seats=" + getSeats()
                + ", km=" + getKm();
    }



    
    
}
