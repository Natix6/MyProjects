public class RegularMember extends Member {

    private static final int MAX_ITEMS = 3;
    private static final double FEE_MULTIPLIER = 1;

    public RegularMember(String name, int id) {
        super(name, id);
    }

    public double getFeeMultiplier() {
        return FEE_MULTIPLIER;
    }

    public int getMaxItems() {
        return MAX_ITEMS;
    }
    
}
