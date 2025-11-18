package _28060.Attendance_Management_System;

import java.util.Date;

public class LeaveRequest extends AttendanceRecord {
    private Date requestDate;
    private String reason;
    private boolean approved;

    public LeaveRequest(int id, String institutionName, String code, String address,
                        String departmentName, String departmentHead,
                        String courseName, String courseCode, int credits,
                        String instructorName, String email, String phone,
                        String studentName, String studentID, int age,
                        java.util.Date sessionDate, String topic,
                        String sessionID, String status,
                        Date requestDate, String reason, boolean approved) {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age, sessionDate, topic, sessionID, status);
        if (reason.isBlank()) throw new IllegalArgumentException("Reason cannot be empty");
        this.requestDate = requestDate;
        this.reason = reason;
        this.approved = approved;
    }

    @Override
    public String toString() {
        return super.toString() + ", LeaveRequest Date: " + requestDate + ", Reason: " + reason + ", Approved: " + approved;
    }
}
