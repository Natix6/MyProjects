public class MotorCycle extends CarData implements Car {

    static boolean carRented = false;

    public MotorCycle(int number, String creator, int yearMade, int seats) {
        super(number, creator, yearMade, seats);
    }

    @Override
    public double calcDailyPrice() {
        return getKm() * 10;
    }

    @Override
    public String toString() {
        return  "\n" + "MotorCycle number=" + getNumber() + ", creator=" + getCreator() + ", yearMade=" + getYearMade() + ", seats=" + getSeats()
                + ", km=" + getKm();
    }

    public void setCarForRental(boolean rented) {
        carRented = rented;
    }

    public boolean isRented() {
        return carRented;
    }
  
}
