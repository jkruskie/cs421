public class Schedule {
    // Variables
    private int id;
    private int courseId;
    private int classroomId;
    private int professorId;
    private int section;
    private String startTime;
    private String endTime;
    private String days;

    // Constructor
    public Schedule(int id, int courseId, int classroomId, int professorId, int section, String startTime, String endTime, String days) {
        this.id = id;
        this.courseId = courseId;
        this.classroomId = classroomId;
        this.professorId = professorId;
        this.section = section;
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
    }

    // 2nd Constructor
    public Schedule(Course course, Professor professor, ScheduleFile sc) {
        this.courseId = course.getId();
        // this.classroomId; Because we don't have one yet
        this.professorId = professor.getId();
        // this.section = sc.getSection(); Because we don't have one yet
        this.startTime = sc.getStartTime();
        this.endTime = sc.getEndTime();
        this.days = sc.getDays();
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public int getSection() {
        return section;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDays() {
        return days;
    }

   
    // Setters
    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setDays(String days) {
        this.days = days;
    }


    // ToString Override
    @Override
    public String toString() {
        // Output the schedule information
        return "Schedule ID: " + id + " Course ID: " + courseId + " Classroom ID: " + classroomId + " Professor ID: " + professorId + " Section: " + section + " Start Time: " + startTime + " End Time: " + endTime + " Days: " + days;
    }
    
}
