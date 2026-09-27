import java.util.ArrayList;
import java.util.List;

public abstract class Member implements Identifiable {

    private int id;
    private String name;
    private List<Borrowable> libraryItems = new ArrayList<>();

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addItem(Borrowable item) {
        libraryItems.add(item);
    }

    public List<Borrowable> getLibraryItems() {
        return libraryItems;
    }

    public void removeItem(Borrowable item) {
        libraryItems.remove(item);
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract int getMaxItems();
    public abstract double getFeeMultiplier();

}