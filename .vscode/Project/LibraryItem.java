public class LibraryItem implements Identifiable {

    private String name;
    private int id;

    public LibraryItem(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override 
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Name: " + name + " ID: " + id;
    }
}

;