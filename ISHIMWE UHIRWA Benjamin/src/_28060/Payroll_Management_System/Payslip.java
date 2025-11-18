package _28060.Payroll_Management_System;

import java.util.Date;

public final class Payslip extends Payroll {
    private String payslipNumber;
    private Date issueDate;

    public Payslip(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                   String deptName, String deptCode, String managerName,
                   int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                   int month, int year, java.util.Date startDate, java.util.Date endDate,
                   double basicPay, double transportAllowance, double housingAllowance,
                   double payeTax, double loanDeduction,
                   double overtimeHours, double overtimeRate, double bonus,
                   String payslipNumber, Date issueDate) {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
                employeeID, fullName, position, baseSalary, rssbRegistered,
                month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance,
                payeTax, loanDeduction, overtimeHours, overtimeRate, bonus);

        this.payslipNumber = payslipNumber;
        this.issueDate = issueDate;
    }

    public void generatePayslip() {
        System.out.println("27801 | ==== PAYSLIP ====");
        System.out.println("Payslip Number: " + payslipNumber);
        System.out.println("Employee: " + super.toString());
        System.out.println("Gross Salary: " + super.getBaseSalary() + " + Allowances = " + (super.getBaseSalary() + super.getTotalAllowance()));
        System.out.println("Total Deductions: RSSB + PAYE + Loan = " + super.getTotalDeductions());
        System.out.println("Net Salary: " + super.getNetSalary());
        System.out.println("Issue Date: " + issueDate);
    }
}
