import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
   private Connection connect() {
      // SQLite connection string
      String url = "jdbc:sqlite:db.sqlite";
      Connection conn = null;
      try {
         conn = DriverManager.getConnection(url);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }
      return conn;
   }

   public void migrate() {
      String sql = "CREATE TABLE IF NOT EXISTS schedule_table (\n"
            + "	tuid integer PRIMARY KEY,\n"
            + "	course_tuid text NOT NULL,\n"
            + "	classroom_tuid text NOT NULL,\n"
            + "	professor_tuid text NOT NULL,\n"
            + "	section integer NOT NULL,\n"
            + "	start_time text NOT NULL,\n"
            + "	end_time text NOT NULL,\n"
            + "	days text NOT NULL);";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Creating schedule table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }

      sql = "CREATE TABLE IF NOT EXISTS professors_table (\n"
            + "	tuid integer PRIMARY KEY,\n"
            + "	professor_name text NOT NULL);";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Creating professors table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }

      sql = "CREATE TABLE IF NOT EXISTS classroom_table (\n"
            + "	tuid integer PRIMARY KEY,\n"
            + "	classroom_name text NOT NULL,\n"
            + " capacity integer NOT NULL);";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Creating classroom table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }

      sql = "CREATE TABLE IF NOT EXISTS courses_table (\n"
            + "	tuid integer PRIMARY KEY,\n"
            + "	course_id text NOT NULL,\n"
            + "	course_title text NOT NULL,\n"
            + "	credit_hours integer NOT NULL);";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Creating courses table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }
   }

   public void drop() {
      String sql = "DROP TABLE IF EXISTS schedule_table;";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Dropping schedule table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }

      sql = "DROP TABLE IF EXISTS professors_table;";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Dropping professors table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }

      sql = "DROP TABLE IF EXISTS courses_table;";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Dropping courses table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }

      sql = "DROP TABLE IF EXISTS classroom_table;";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Dropping classroom table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }
   }

   public void seed() {
      // Seed classrooms
      String sql = "INSERT INTO classroom_table(classroom_name, capacity)\n"
      + " VALUES('A', 30),\n"
      + " ('B', 25),\n"
      + " ('C', 20);";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Seeding classroom table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }

      // Seed courses
      sql = "INSERT INTO courses_table(course_id, course_title, credit_hours)\n"
      + " VALUES('CS 101', 'Intro to Computer Science', 3),\n"
      + " ('CS 105', 'Computers and Programming', 4),\n"
      + " ('CSC 105', 'Computers and Programming', 4), \n"
      + " ('CSC 107', 'Introduction to Code Preparation', 1), \n"
      + " ('CSC 116', 'Programming I', 4), \n"
      + " ('CSC 216', 'Programming II', 4), \n"
      + " ('CSC 227', 'Commenting and Naming Conventions', 2), \n"
      + " ('CSC 316', 'Data Structures & Algorithms', 4), \n"
      + " ('CSC 416', 'Advanced Algorithm Analysis', 3), \n"
      + " ('CSC 211', 'Introductory .NET Development', 3), \n"
      + " ('CSC 311', 'Advanced .NET Development', 4), \n"
      + " ('CSC 313', 'Real World Application Development', 3), \n"
      + " ('CSC 411', 'Data Driven Systems', 3), \n"
      + " ('CSC 412', 'Sensor Systems', 3), \n"
      + " ('CSC 413', 'Artificial Intelligence Systems', 3), \n"
      + " ('CSC 496', 'Software Engineering I', 4), \n"
      + " ('CSC 497', 'Software Engineering II', 4), \n"
      + " ('CSC 498', 'Software Engineering III', 4);";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Seeding courses table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }

      // Seed professors
      sql = "INSERT INTO professors_table(professor_name)\n"
      + " VALUES('james'),\n"
      + " ('smith'),\n"
      + " ('jones'),\n"
      + " ('vasques'),\n"
      + " ('abdul'),\n"
      + " ('thomas');";

      try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
         // create a new table
         // System.out.println("Seeding professors table...");
         stmt.execute(sql);
      } catch (SQLException e) {
         // System.out.println(e.getMessage());
      }
   }

   public void close()
   {
      // End connection to database
      Connection conn = this.connect();
      try {
         if (conn != null) {
            conn.close();
         }
      } catch (SQLException ex) {
         // System.out.println(ex.getMessage());
      }
   }
}
