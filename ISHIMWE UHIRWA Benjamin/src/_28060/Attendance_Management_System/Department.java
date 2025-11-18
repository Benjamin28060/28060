package _28060.Attendance_Management_System;

public class Department extends Institution {
    private String departmentName;
    private String departmentHead;

    public Department(int id, String institutionName, String code, String address,
                      String departmentName, String departmentHead) {
        super(id, institutionName, code, address);
        if (departmentName.isBlank()) throw new IllegalArgumentException("Department name cannot be empty");
        if (departmentHead.isBlank()) throw new IllegalArgumentException("Department head cannot be empty");

        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + departmentName + ", Head: " + departmentHead;
    }
}
