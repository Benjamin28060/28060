package _28060.Tax_Administration_System;

public class Employee extends Employer {
    private String employeeName;
    private double salary;
    private String employeeTIN;

    public Employee(int id, String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address,
                    String employerName, String employerTIN, String contact,
                    String employeeName, double salary, String employeeTIN) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact);
        if (!employeeTIN.matches("\\d{9}")) throw new IllegalArgumentException("Employee TIN must be 9 digits");
        if (salary <= 0) throw new IllegalArgumentException("Salary must be > 0");
        this.employeeName = employeeName;
        this.salary = salary;
        this.employeeTIN = employeeTIN;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee: " + employeeName + ", Salary: " + salary + ", EmployeeTIN: " + employeeTIN;
    }
}
