import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        if (checkDatabaseExists()) {
            System.out.println("Database exists");
            // Create a new instance of the Database
            Database db = new Database();
            if (requestDBReset()) {
                // Initialize the DB first to ensure tables exist
                db.initialize();
                // Reset
                db.reset();
            } else {
                // Continue
            }
        } else {
            // File does not exist
            System.out.println("Database does not exist");
            // Create a new database file
            createDatabaseFile();
            
            // Initialize the database
            Database db = new Database();
            db.initialize();
        }
    }

    private static boolean checkDatabaseExists() {
        File file = new File("db.sqlite");
        return file.exists();
    }

    private static void promptDatabaseReset() {
        System.out.println("Would you like to reset the database? (y/n)");
    }

    private static boolean requestDBReset() {
        // Prompt request to user
        promptDatabaseReset();

        // Create new scanner and get user input
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        // Check if user input is y or n
        if (response.equals("y")) {
            System.out.println("Requesting resetting of database");
            return true;
        } else if (response.equals("n")) {
            System.out.println("Not resetting database");
            return false;
        } else {
            System.out.println("Invalid response");
            return requestDBReset();
        }
    }

    public static void createDatabaseFile()
    {
        // Create a new file
        new File("db.sqlite");

        // Confirm that the file was created
        if(checkDatabaseExists()) {
            System.out.println("Database file created");
        } else {
            System.out.println("Database file not created");
        }
    }
}
