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
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void initialize() {
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
            System.out.println("Creating schedule table...");
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS professors_table (\n"
                + "	tuid integer PRIMARY KEY,\n"
                + "	professor_name text NOT NULL);";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            System.out.println("Creating professors table...");
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS classroom_table (\n"
                + "	tuid integer PRIMARY KEY,\n"
                + "	classroom_name text NOT NULL,\n"
                + " capacity integer NOT NULL);";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            System.out.println("Creating classroom table...");
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS courses_table (\n"
                + "	tuid integer PRIMARY KEY,\n"
                + "	course_id text NOT NULL,\n"
                + "	course_title text NOT NULL,\n"
                + "	credit_hours integer NOT NULL);";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            System.out.println("Creating courses table...");
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void reset() {
        String sql = "DELETE FROM schedule_table;";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            System.out.println("Resetting schedule table...");
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "DELETE FROM professors_table;";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            System.out.println("Resetting professors table...");
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "DELETE FROM courses_table;";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            System.out.println("Resetting courses table...");
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
