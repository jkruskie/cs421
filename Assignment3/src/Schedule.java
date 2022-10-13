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
    private String course;
    private String professor;
    private String classroom;
    private int credits;
    private int capacity;

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

        // 3rd Constructor
        public Schedule(int courseId, int classroomId, int professorId, int section, String startTime, String endTime, String days, String course, String professor, String classroom) {
            this.courseId = courseId;
            this.classroomId = classroomId;
            this.professorId = professorId;
            this.section = section;
            this.startTime = startTime;
            this.endTime = endTime;
            this.days = days;
            this.course = course;
            this.professor = professor;
            this.classroom = classroom;
        }

    // Empty constructor
    public Schedule() {
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

    public String getCourse() {
        return course;
    }

    public String getProfessor() {
        return professor;
    }

    public String getClassroom() {
        return classroom;
    }

    public Integer getCredits() {
        return credits;
    }

    public Integer getCapacity() {
        return capacity;
    }

   
    // Setters

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
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

    public void setCourse(String course) {
        this.course = course;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    // ToString Override
    @Override
    public String toString() {
        // Output the schedule information
        return "Schedule ID: " + id + " Course ID: " + courseId + " Classroom ID: " + classroomId + " Professor ID: " + professorId + " Section: " + section + " Start Time: " + startTime + " End Time: " + endTime + " Days: " + days;
    }
    
}
