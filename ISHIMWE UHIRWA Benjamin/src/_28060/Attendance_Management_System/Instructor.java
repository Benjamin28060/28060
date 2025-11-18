package _28060.Attendance_Management_System;

public class Instructor extends Course {
    private String instructorName;
    private String email;
    private String phone;

    public Instructor(int id, String institutionName, String code, String address,
                      String departmentName, String departmentHead,
                      String courseName, String courseCode, int credits,
                      String instructorName, String email, String phone) {
        super(id, institutionName, code, address, departmentName, departmentHead, courseName, courseCode, credits);
        if (instructorName.isBlank()) throw new IllegalArgumentException("Instructor name cannot be empty");
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) throw new IllegalArgumentException("Invalid email");
        if (!phone.matches("\\d{10}")) throw new IllegalArgumentException("Phone must be 10 digits");

        this.instructorName = instructorName;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return super.toString() + ", Instructor: " + instructorName + ", Email: " + email + ", Phone: " + phone;
    }
}
