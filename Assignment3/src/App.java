import java.io.File;
import java.util.Scanner;

public class App {

   private static boolean continueExec = true;
   static Database db;
   static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws Exception {
      if (checkDatabaseExists()) {
         // System.out.println("Database exists");
         // Create a new instance of the Database
         db = new Database();
         if (requestDBReset()) {
            // Drop
            db.drop();
            // Migrate the DB tables first to ensure they exist
            db.migrate();
            // Seed the tables
            db.seed();
            // Continue
            promptUserMenu();
         } else {
            // Continue
            promptUserMenu();
         }
      } else {
         // File does not exist
         // System.out.println("Database does not exist");
         // Create a new database file
         createDatabaseFile();

         // Initialize the database
         Database db = new Database();
         db.migrate();
         db.seed();
      }
   }

   private static boolean checkDatabaseExists() {
      File file = new File("db.sqlite");
      return file.exists();
   }

   private static void promptDatabaseReset() {
      System.out.print("\nWould you like to reset the database? (y/n): ");
   }

   private static boolean requestDBReset() {
      // Prompt request to user
      promptDatabaseReset();

      String response = scanner.nextLine();

      // Check if user input is y or n
      if (response.equals("y")) {
         // System.out.println("Requesting resetting of database");
         return true;
      } else if (response.equals("n")) {
         // System.out.println("Not resetting database");
         return false;
      } else {
         System.out.println("Invalid response");
         return requestDBReset();
      }
   }

   public static void createDatabaseFile() {
      // Create a new file
      new File("db.sqlite");

      // Confirm that the file was created
      if (checkDatabaseExists()) {
         // System.out.println("Database file created");
      } else {
         // System.out.println("Database file not created");
      }
   }

   public static void promptUserMenu() {
      // While the continueExec boolean is true, continue to prompt the user
      // for input regarding which menu option they want.
      while (continueExec) {
         System.out.println("\nPlease select an option:");
         // System.out.println("1. Add a new course");
         // System.out.println("2. Add a new professor");
         // System.out.println("3. Add a new classroom");
         // System.out.println("4. View all courses");
         // System.out.println("5. View all professors");
         // System.out.println("6. View all classrooms");
         System.out.println("1. Import Schedule File");
         System.out.println("7. Exit");
         System.out.println("8. Exit & Destroy Database");
         System.out.print("Enter your choice: ");

         // Get the user input and determine what option they selected
         int option = scanner.nextInt();

         switch (option) {
            case 1:
               // Import Schedule File
               // System.out.println("Importing schedule file");
               importScheduleFile();
               break;
            case 7:
               // Exit
               // System.out.println("Exiting");
               System.exit(0);
               break;
            case 8:
               // Exit & Destroy Database
               // System.out.println("Exiting and destroying database");
               db.drop();
               deleteDBFile();
               System.exit(0);
               break;
            default:
               System.out.println("Invalid option");
               break;
         }
      }
   }

   private static void deleteDBFile() {
      File file = new File("db.sqlite");
      file.delete();
   }

   private static void importScheduleFile() {
      // Prompt user for file name
      System.out.print("Enter the absolute file path: ");
      String response = scanner.next();
         if(checkFileExists(response)) {
            // File exists
            System.out.println("File exists");
            // Import the file
         } else {
            // File does not exist
            System.out.println("File does not exist");
            importScheduleFile();
         }
   }

   private static boolean checkFileExists(String filePath) {
      File file = new File(filePath);
      return file.exists();
   }
}
