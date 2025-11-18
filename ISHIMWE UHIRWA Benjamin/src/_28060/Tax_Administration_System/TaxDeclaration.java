package _28060.Tax_Administration_System;

public class TaxDeclaration extends Employee {
    private String declarationMonth;
    private double totalIncome;

    public TaxDeclaration(int id, String authorityName, String region, String email,
                          String categoryName, double rate, String code,
                          String tin, String taxpayerName, String address,
                          String employerName, String employerTIN, String contact,
                          String employeeName, double salary, String employeeTIN,
                          String declarationMonth, double totalIncome) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact,
                employeeName, salary, employeeTIN);
        if (totalIncome < 0) throw new IllegalArgumentException("Total income cannot be negative");
        this.declarationMonth = declarationMonth;
        this.totalIncome = totalIncome;
    }

    @Override
    public String toString() {
        return super.toString() + ", Declaration Month: " + declarationMonth + ", Total Income: " + totalIncome;
    }
}
