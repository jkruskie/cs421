import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

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
                + " ('CSC 316', 'Data Structures \u0026 Algorithms', 4), \n"
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
                + " VALUES('James'),\n"
                + " ('Smith'),\n"
                + " ('Jones'),\n"
                + " ('Vasquez'),\n"
                + " ('Abdul'),\n"
                + " ('Thomas');";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            // System.out.println("Seeding professors table...");
            stmt.execute(sql);
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }
    }

    public void close() {
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

    public void insertScheduleFile(ScheduleFile sf) {
        // Print the schedule file
        // System.out.println(sf.toString());
        // System.out.println(sf.getCourseName());

        // Initialize variables for inserting into database
        Course course = findCourse(sf.getCourseName());
        Professor professor = findProfessor(sf.getProfessorName());

        // Print the scheduleFile
        // System.out.println(sf.toString());

        // Print the course
        // System.out.println(course.toString());

        // Print the course
        // System.out.println(professor.toString());

        // Okay... So now we have the professor, course, and
        // schedule file information
        // Now we query the schedule_table to see if any courses
        // are already scheduled for the same time.

        // Create a new schedule object using the course, professor,
        // and schedule file information
        Schedule schedule = new Schedule(course, professor, sf);

        // Create an arraylist of schedules
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();

        schedules = findSchedule(sf.getStartTime(), sf.getEndTime(), sf.getDays());

        // Find other instances of the course to determine the
        // section number
        int section = findSection(course.getId());

        schedule.setSection(section);

        // Check the size of the schedules arraylist
        // If it's 0, then we can insert the schedule
        // If it's not 0, then we need to find an alternate time
        if (schedules.size() == 0) {
            System.out.println("No conflicts found. Inserting schedule...");

            // Then we should be good to schedule what ever
            // classroom is available.
            // So we'll query the classroom_table to find
            // A and assign the tuid to the schedule
            schedule.setClassroomId(findClassroomTuid("A"));

            // Insert the schedule
            System.out.println("Inserting schedule... NO CONFLICTS");
            insertSchedule(schedule);
        } else {
            System.out.println("There is a conflict with the schedule");
            // And here's where the real fun begins
            // Everything has been all fun and games till now.
            String[] alternateTime = findAlternateTime(schedule, course);

            // Update the schedule object with
            // the newly found data
            schedule.setStartTime(alternateTime[0]);
            schedule.setEndTime(alternateTime[1]);
            schedule.setDays(alternateTime[2]);
            schedule.setClassroomId(Integer.parseInt(alternateTime[3]));

            // Insert the schedule

            System.out.println("Class rescheduled to " + schedule.getDays() + " from " + schedule.getStartTime() + " to " + schedule.getEndTime() + " in classroom " + schedule.getClassroomId());
            System.out.println("Inserting schedule... CONFLICTS");

            // Output the schedule
            System.out.println(schedule.toString());

            insertSchedule(schedule);
        }
    }

    private Course findCourse(String name) {
        // Find the course from the courses_table
        // by using the course_title and return the entire row

        String sql = "SELECT * FROM courses_table WHERE course_id = ?;";

        try (Connection conn = this.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // set the value
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            // Check if the course was found
            if (rs.next()) {
                // Create a new course object
                Course course = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

                return course;
            } else {
                System.out.println("Course not found");
                return null;
            }
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }
        return null;
    }

    private Professor findProfessor(String name) {
        // Find the professor from the professors_table
        // by using the professor_name and return the entire row

        String sql = "SELECT * FROM professors_table WHERE professor_name = ?;";

        try (Connection conn = this.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // set the value
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            // Check if the professor was found
            if (rs.next()) {
                // Create a new professor object
                Professor professor = new Professor(rs.getInt(1), rs.getString(2));

                return professor;
            } else {
                System.out.println("Professor not found");
                return null;
            }
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }
        return null;
    }

    private ArrayList<Schedule> findSchedule(String startTime, String endTime, String days) {

        // Add AM or PM to the start and end times using the
        // addAmOrPmToTime method
        // startTime = addAmOrPmToTime(startTime);
        // endTime = addAmOrPmToTime(endTime);

        // Output them to the console
        // System.out.println(startTime);
        // System.out.println(endTime);

        // Output them to the console
        // System.out.println(startTime);
        // System.out.println(endTime);

        // Cool so now that we have 24HR times we can
        // Select all rows from the schedule_table where the
        // the startTime is between the start_time and end_time
        // and the end_time is between the start_time and end_time
        // and the days are the same

        // Query Summed Up:
        // Select everything from the schedule where
        // the start time < the GIVEN end time
        // and the end time > the GIVEN start time
        // and the days are the same
        // AND THEN join the classroom table to actually
        // get the classroom name
        String sql = "SELECT * FROM schedule_table LEFT JOIN classroom_table ON schedule_table.classroom_tuid = classroom_table.tuid WHERE time(start_time) < time(?) AND time(end_time)> time(?) AND days = ?;";
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();

        try (Connection conn = this.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // set the value
            stmt.setString(1, endTime);
            stmt.setString(2, startTime);
            stmt.setString(3, days);

            ResultSet rs = stmt.executeQuery();

            System.out.println("Searching for schedule conflicts...");

            // Check if the professor was found
            while (rs.next()) {
                // Output the course_tuid, start_time, end_time, and days
                // System.out.println("Course TUID: " + rs.getInt("course_tuid") + "\nStart: " +
                // rs.getString("start_time") + "\nEnd: " + rs.getString("end_time") + "\nDay: "
                // + rs.getString("days") + "\nRoom: " + rs.getString("classroom_name"));

                // Add the results to the schedules arraylist
                schedules.add(new Schedule(rs.getInt("tuid"), rs.getInt("course_tuid"), rs.getInt("classroom_tuid"),
                        rs.getInt("professor_tuid"), rs.getInt("section"), rs.getString("start_time"),
                        rs.getString("end_time"), rs.getString("days")));
            }

            return schedules;
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }

        return null;
    }

    private void insertSchedule(Schedule schedule) {
        // Insert the schedule into the schedule_table
        // and return true if it was successful
        // and false if it was not

        String sql = "INSERT INTO schedule_table(course_tuid, classroom_tuid, professor_tuid, section, start_time, end_time, days) VALUES(?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = this.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the values
            stmt.setInt(1, schedule.getCourseId());
            stmt.setInt(2, schedule.getClassroomId());
            stmt.setInt(3, schedule.getProfessorId());
            stmt.setInt(4, schedule.getSection());
            stmt.setString(5, schedule.getStartTime());
            stmt.setString(6, schedule.getEndTime());
            stmt.setString(7, schedule.getDays());

            // Execute the query
            stmt.executeUpdate();

        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }

    }

    private int findSection(int courseTuid) {
        // Find the section number for the course
        // by using the course_tuid and return the section number

        String sql = "SELECT * FROM schedule_table WHERE course_tuid = ?;";

        try (Connection conn = this.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // set the value
            stmt.setInt(1, courseTuid);

            ResultSet rs = stmt.executeQuery();

            // Get the total count of the results
            int count = 1;

            // Check if the professor was found
            if (rs.next()) {
                count++;
            }

            // System.out.println("TOTAL CURRENT ENTRIES: " + count);

            return count;
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }
        return -1;
    }

    // Return the classroom tuid from the classroom name
    private int findClassroomTuid(String classroomName) {
        // Find the classroom from the classroom_table
        // by using the classroom_name and return the tuid

        String sql = "SELECT * FROM classroom_table WHERE classroom_name = ?;";

        try (Connection conn = this.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // set the value
            stmt.setString(1, classroomName);

            ResultSet rs = stmt.executeQuery();

            // Check if the professor was found
            if (rs.next()) {
                // Create a new professor object
                return rs.getInt(1);
            } else {
                System.out.println("Classroom not found");
                return -1;
            }
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }
        return -1;
    }

    private String[] findAlternateTime(Schedule schedule, Course course) {
        // Okay so first we're going to check the credit hours
        // to determine what the available days are.

        // If credit hours are 3 or 4, then available days are
        // MW, TR, or F
        // If credit hours are 1 or 2, then available days are
        // M,T,W,R,F

        if (course.getCreditHours() == 4) {
            // available times are:
            // 8:30-10:30
            // 10:30-12:30
            // 12:30-2:30
            // 2:30-4:30
            // Cracks knuckles... Here we go...

            // System.out.println("4 CREDIT HOUR COURSE");

            // An array of the available start times
            String[] startTimes = { "08:30:00", "10:30:00", "12:30:00", "14:30:00" };
            // An array of the available end times
            String[] endTimes = { "10:30:00", "12:30:00", "14:30:00", "16:30:00" };
            String currentTime = schedule.getStartTime();
            // Get the index of the currentTime within the startTimes array
            int index = Arrays.asList(startTimes).indexOf(currentTime);
            boolean foundTimeSlot = false;
            String[] date = new String[4];
            ArrayList<Schedule> schedules;
            while (!foundTimeSlot) {

                // Check the same date for a different room
                schedules = findSchedule(startTimes[index], endTimes[index], schedule.getDays());

                // We shouldn't have to worry about schedules being empty
                // as we've already checked for conflicts

                // Loop through and create a csv
                // of the used classrooms
                String usedClassrooms = "";
                for (Schedule s : schedules) {
                    // If last index, don't add comma
                    if (schedules.indexOf(s) == schedules.size() - 1) {
                        usedClassrooms += s.getClassroomId();
                    } else {
                        usedClassrooms += s.getClassroomId() + ",";
                    }
                    System.out.println("Unavailable classroom: " + s.getClassroomId());
                }

                // Query the classroom_table to get all the classrooms
                // except for the ones that are already being used
                ArrayList<Integer> availableClassrooms = findAvailableClassrooms(usedClassrooms);

                // If classrooms available, then set the classroom id
                // and return the new schedule
                if (availableClassrooms.size() > 0) {
                    System.out.println("Available classrooms: " + availableClassrooms);
                    date[0] = startTimes[index];
                    date[1] = endTimes[index];
                    date[2] = schedule.getDays();
                    date[3] = availableClassrooms.get(0).toString();
                    foundTimeSlot = true;
                    // return date;
                }

                // if (schedule.getDays() == "MW") {

                //     // We'll check TR
                //     schedules = findSchedule(startTimes[index], endTimes[index], "TR");
                //     if (schedules.size() == 0) {
                //         // We found a time slot
                //         date[0] = startTimes[index];
                //         date[1] = endTimes[index];
                //         date[2] = "TR";
                //         foundTimeSlot = true;
                //         // return date;
                //     }

                // }
            }
            return date;
        } else if (course.getCreditHours() == 3) {
            // available times are:
            // 9:00-10:30
            // 10:00-11:30
            // 11:00-12:30
            // 12:00-1:30
            // 1:00-2:30
            // 2:00-3:30
            // 3:00-4:30
            String[] date = new String[3];
            date[0] = "12";
            date[1] = "12";
            date[2] = "TR";
            return date;
        } else if (course.getCreditHours() == 2) {
            // available times are any mark between:
            // 9:00 and 2:00
            String[] date = new String[3];
            date[0] = "12";
            date[1] = "12";
            date[2] = "TR";
            return date;
        } else {
            // available times are any mark between:
            // 9:00 and 3:00
            String[] date = new String[3];
            date[0] = "12";
            date[1] = "12";
            date[2] = "TR";
            return date;
        }
    }

    private ArrayList<Integer> findAvailableClassrooms(String usedClassrooms) {
        // Query the classroom_table to get all the classrooms
        // except for the ones that are already being used

        String sql = "SELECT * FROM classroom_table WHERE tuid NOT IN (?);";

        try (Connection conn = this.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // set the value
            stmt.setString(1, usedClassrooms);

            ResultSet rs = stmt.executeQuery();

            // Create an arraylist of the available classrooms
            ArrayList<Integer> availableClassrooms = new ArrayList<Integer>();

            // Check if the professor was found
            while (rs.next()) {
                // Create a new professor object
                availableClassrooms.add(rs.getInt(1));
            }

            return availableClassrooms;
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }
        return null;
    }
}
