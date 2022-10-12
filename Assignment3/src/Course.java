public class Course {
    // Variables
    private int id;
    private String name;
    private String title;
    private int creditHours;

    // Constructor
    public Course(int id, String name, String title, int creditHours) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.creditHours = creditHours;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getCreditHours() {
        return creditHours;
    }

    // toString Override
    @Override
    public String toString() {
        // Output the course information
        return "Course ID: " + id + " Course Name: " + name + " Course Title: " + title + " Credit Hours: " + creditHours;
    }
}
