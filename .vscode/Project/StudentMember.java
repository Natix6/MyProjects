public class StudentMember extends Member {

    private static final int MAX_ITEMS = 5;
    private static final double FEE_MULTIPLIER = 0.5;

    public StudentMember(String name, int id) {
        super(name, id);
    }

    public double getFeeMultiplier() {
        return FEE_MULTIPLIER;
    }

    public int getMaxItems() {
        return MAX_ITEMS;
    }
        
}
