package _28060.Attendance_Management_System;

import java.util.Date;

public class ClassSession extends Student {
    private Date sessionDate;
    private String topic;

    public ClassSession(int id, String institutionName, String code, String address,
                        String departmentName, String departmentHead,
                        String courseName, String courseCode, int credits,
                        String instructorName, String email, String phone,
                        String studentName, String studentID, int age,
                        Date sessionDate, String topic) {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age);
        if (sessionDate == null) throw new IllegalArgumentException("Session date cannot be null");
        if (topic.isBlank()) throw new IllegalArgumentException("Topic cannot be empty");

        this.sessionDate = sessionDate;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return super.toString() + ", Session Date: " + sessionDate + ", Topic: " + topic;
    }
}
