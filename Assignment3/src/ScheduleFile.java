public class ScheduleFile {

   private String courseName;
   private String professorName;
   private String days;
   private String startTime;
   private String endTime;

   public ScheduleFile(String courseName, String professorName, String days, String startTime, String endTime) {
      this.courseName = courseName;
      this.professorName = professorName;
      this.days = days;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   // Getters 
   public String getCourseName() {
      return courseName;
   }

   public String getProfessorName() {
      return professorName;
   }

   public String getDays() {
      return days;
   }

   public String getStartTime() {
      return startTime;
   }

   public String getEndTime() {
      return endTime;
   }

   // toString override
   @Override
   public String toString() {
      return "ScheduleFile [courseName=" + courseName + ", professorName=" + professorName + ", days=" + days
            + ", startTime=" + startTime + ", endTime=" + endTime + "]";
   }
   
}
