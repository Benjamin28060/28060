package _28060.Payroll_Management_System;

public class Deduction extends SalaryStructure {
    private double rssbContribution;
    private double payeTax;
    private double loanDeduction;

    public Deduction(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                     String deptName, String deptCode, String managerName,
                     int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                     int month, int year, java.util.Date startDate, java.util.Date endDate,
                     double basicPay, double transportAllowance, double housingAllowance,
                     double payeTax, double loanDeduction) {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
                employeeID, fullName, position, baseSalary, rssbRegistered,
                month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance);

        this.rssbContribution = basicPay * 0.05; // 5% of basic pay
        if (payeTax < 0 || loanDeduction < 0) throw new IllegalArgumentException("Deductions must be ≥ 0");
        this.payeTax = payeTax;
        this.loanDeduction = loanDeduction;
    }

    public double getTotalDeductions() {
        return rssbContribution + payeTax + loanDeduction;
    }

    @Override
    public String toString() {
        return super.toString() + ", Deductions: RSSB=" + rssbContribution + ", PAYE=" + payeTax + ", Loan=" + loanDeduction;
    }
}
