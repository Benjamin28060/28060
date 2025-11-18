package _28060.Payroll_Management_System;

public class Payroll extends Allowance {
    private double grossSalary;
    private double totalDeductions;
    private double netSalary;

    public Payroll(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                   String deptName, String deptCode, String managerName,
                   int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                   int month, int year, java.util.Date startDate, java.util.Date endDate,
                   double basicPay, double transportAllowance, double housingAllowance,
                   double payeTax, double loanDeduction,
                   double overtimeHours, double overtimeRate, double bonus) {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
                employeeID, fullName, position, baseSalary, rssbRegistered,
                month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance,
                payeTax, loanDeduction, overtimeHours, overtimeRate, bonus);

        this.grossSalary = basicPay + getTotalAllowance();
        this.totalDeductions = getTotalDeductions();
        this.netSalary = grossSalary - totalDeductions;
    }

    public double getNetSalary() { return netSalary; }

    @Override
    public String toString() {
        return super.toString() + ", Gross Salary=" + grossSalary + ", Total Deductions=" + totalDeductions + ", Net Salary=" + netSalary;
    }
}
