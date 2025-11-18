package _28060.Attendance_Management_System;

public class Student extends Instructor {
    private String studentName;
    private String studentID;
    private int age;

    public Student(int id, String institutionName, String code, String address,
                   String departmentName, String departmentHead,
                   String courseName, String courseCode, int credits,
                   String instructorName, String email, String phone,
                   String studentName, String studentID, int age) {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone);
        if (studentName.isBlank()) throw new IllegalArgumentException("Student name cannot be empty");
        if (studentID.isBlank()) throw new IllegalArgumentException("Student ID cannot be empty");
        if (age <= 0) throw new IllegalArgumentException("Age must be > 0");

        this.studentName = studentName;
        this.studentID = studentID;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student: " + studentName + " (" + studentID + "), Age: " + age;
    }
}
