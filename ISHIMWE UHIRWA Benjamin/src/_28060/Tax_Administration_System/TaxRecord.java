package _28060.Tax_Administration_System;

import java.util.Date;

public final class TaxRecord extends Payment {
    private String receiptNo;
    private double totalTax;

    public TaxRecord(int id, String authorityName, String region, String email,
                     String categoryName, double rate, String code,
                     String tin, String taxpayerName, String address,
                     String employerName, String employerTIN, String contact,
                     String employeeName, double salary, String employeeTIN,
                     String declarationMonth, double totalIncome,
                     Date assessmentDate, double assessedTax,
                     Date paymentDate, double paymentAmount,
                     String receiptNo) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact,
                employeeName, salary, employeeTIN, declarationMonth, totalIncome,
                assessmentDate, assessedTax, paymentDate, paymentAmount);
        this.receiptNo = receiptNo;
        computeTax();
    }

    private void computeTax() {
        this.totalTax = getSalary() * super.getRate(); // simple formula
    }

    @Override
    public String toString() {
        return super.toString() + ", Receipt No: " + receiptNo + ", Total Tax: " + totalTax;
    }
}
