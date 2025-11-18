package _28060.Payroll_Management_System;

public class Employee extends Department {
    private int employeeID;
    private String fullName;
    private String position;
    private double baseSalary;
    private boolean rssbRegistered;

    public Employee(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                    String deptName, String deptCode, String managerName,
                    int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered) {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName);
        if (employeeID < 1000) throw new IllegalArgumentException("Employee ID must be ≥ 1000");
        if (fullName.isBlank() || position.isBlank()) throw new IllegalArgumentException("Full name and position cannot be empty");
        if (baseSalary <= 0) throw new IllegalArgumentException("Base salary must be > 0");

        this.employeeID = employeeID;
        this.fullName = fullName;
        this.position = position;
        this.baseSalary = baseSalary;
        this.rssbRegistered = rssbRegistered;
    }

    public double getBaseSalary() { return baseSalary; }
    public boolean isRssbRegistered() { return rssbRegistered; }

    @Override
    public String toString() {
        return super.toString() + ", Employee: " + fullName + " (" + employeeID + "), Position: " + position + ", Base Salary: " + baseSalary + ", RSSB: " + rssbRegistered;
    }
}
