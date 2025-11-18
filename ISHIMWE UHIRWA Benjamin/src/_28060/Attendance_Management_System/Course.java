package _28060.Attendance_Management_System;

public class Course extends Department {
    private String courseName;
    private String courseCode;
    private int credits;

    public Course(int id, String institutionName, String code, String address,
                  String departmentName, String departmentHead,
                  String courseName, String courseCode, int credits) {
        super(id, institutionName, code, address, departmentName, departmentHead);
        if (courseName.isBlank()) throw new IllegalArgumentException("Course name cannot be empty");
        if (courseCode.isBlank()) throw new IllegalArgumentException("Course code cannot be empty");
        if (credits <= 0) throw new IllegalArgumentException("Credits must be > 0");

        this.courseName = courseName;
        this.courseCode = courseCode.toUpperCase();
        this.credits = credits;
    }

    @Override
    public String toString() {
        return super.toString() + ", Course: " + courseName + " (" + courseCode + "), Credits: " + credits;
    }
}
