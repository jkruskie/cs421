public class Classroom {
    // Variables
    private int id;
    private String name;
    private int capacity;

    // Constructor
    public Classroom(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

}
