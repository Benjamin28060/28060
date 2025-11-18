package _28060.Attendance_Management_System;

import java.util.Date;

public final class AttendanceSummary extends LeaveRequest {
    private Date reportDate;
    private int totalPresent;
    private int totalAbsent;
    private double attendancePercentage;

    public AttendanceSummary(int id, String institutionName, String code, String address,
                             String departmentName, String departmentHead,
                             String courseName, String courseCode, int credits,
                             String instructorName, String email, String phone,
                             String studentName, String studentID, int age,
                             java.util.Date sessionDate, String topic,
                             String sessionID, String status,
                             java.util.Date requestDate, String reason, boolean approved,
                             Date reportDate) {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age, sessionDate, topic, sessionID, status,
                requestDate, reason, approved);
        this.reportDate = reportDate;
        generateSummary();
    }

    private void generateSummary() {
        if (isPresent()) {
            totalPresent = 1;
            totalAbsent = 0;
        } else {
            totalPresent = 0;
            totalAbsent = 1;
        }
        attendancePercentage = totalPresent * 100.0 / (totalPresent + totalAbsent);
    }

    @Override
    public String toString() {
        return super.toString() + ", Report Date: " + reportDate +
                ", Total Present: " + totalPresent +
                ", Total Absent: " + totalAbsent +
                ", Attendance %: " + attendancePercentage;
    }
}
