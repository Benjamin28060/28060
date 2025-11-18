package _28060.Payroll_Management_System;

public class Department extends Organization {
    private String deptName;
    private String deptCode;
    private String managerName;

    public Department(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                      String deptName, String deptCode, String managerName) {
        super(id, orgName, orgCode, rssbNumber, contactEmail);
        if (deptName.isBlank() || managerName.isBlank()) throw new IllegalArgumentException("Department and manager name cannot be empty");
        if (deptCode.length() < 3) throw new IllegalArgumentException("Department code must be ≥ 3 chars");

        this.deptName = deptName;
        this.deptCode = deptCode.toUpperCase();
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + deptName + " (" + deptCode + "), Manager: " + managerName;
    }
}
