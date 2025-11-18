package _28060.Procurement_Management_System;

public class Department extends Organization {
    private String deptName;
    private String deptCode;

    public Department(int id, String orgName, String address, String contactEmail,
                      String deptName, String deptCode) {
        super(id, orgName, address, contactEmail);
        if (deptName.isBlank()) throw new IllegalArgumentException("Department name cannot be empty");
        if (!deptCode.matches("[a-zA-Z0-9]{3,}")) throw new IllegalArgumentException("Department code must be alphanumeric and ≥3 chars");
        this.deptName = deptName;
        this.deptCode = deptCode.toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + deptName + ", Code: " + deptCode;
    }
}
