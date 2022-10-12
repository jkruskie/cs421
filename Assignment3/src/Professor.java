public class Professor {
    // Variables
    private int id;
    private String name;

    // Constructor
    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // ToString Override
    @Override
    public String toString() {
        // Output the professor information
        return "Professor ID: " + id + " Professor Name: " + name;
    }
}
