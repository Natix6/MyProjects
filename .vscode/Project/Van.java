public class Van extends CarData implements Car {
    
    public Van(int number, String creator, int yearMade, int seats) {
        super(number, creator, yearMade, seats);
    }

    @Override
    public double calcDailyPrice() {
        return getKm() * 40 + getSeats() * 10;
    }

    @Override
    public String toString() {
        return "\n" + "Van number=" + getNumber() + ", creator=" + getCreator() + ", yearMade=" + getYearMade() + ", seats=" + getSeats()
                + ", km=" + getKm();
    }

}
