package _28060.Attendance_Management_System;

public class AttendanceRecord extends ClassSession {
    private String studentID;
    private String sessionID;
    private String status;

    public AttendanceRecord(int id, String institutionName, String code, String address,
                            String departmentName, String departmentHead,
                            String courseName, String courseCode, int credits,
                            String instructorName, String email, String phone,
                            String studentName, String studentID, int age,
                            java.util.Date sessionDate, String topic,
                            String sessionID, String status) {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age, sessionDate, topic);
        if (!status.equalsIgnoreCase("Present") && !status.equalsIgnoreCase("Absent"))
            throw new IllegalArgumentException("Status must be Present or Absent");
        this.studentID = studentID;
        this.sessionID = sessionID;
        this.status = status;
    }

    public boolean isPresent() {
        return status.equalsIgnoreCase("Present");
    }

    @Override
    public String toString() {
        return super.toString() + ", Attendance Status: " + status;
    }
}
