package _28060.Tax_Administration_System;

import java.util.Date;

public class Payment extends TaxAssessment {
    private Date paymentDate;
    private double paymentAmount;

    public Payment(int id, String authorityName, String region, String email,
                   String categoryName, double rate, String code,
                   String tin, String taxpayerName, String address,
                   String employerName, String employerTIN, String contact,
                   String employeeName, double salary, String employeeTIN,
                   String declarationMonth, double totalIncome,
                   Date assessmentDate, double assessedTax,
                   Date paymentDate, double paymentAmount) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact,
                employeeName, salary, employeeTIN, declarationMonth, totalIncome,
                assessmentDate, assessedTax);
        if (paymentAmount <= 0) throw new IllegalArgumentException("Payment amount must be > 0");
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Payment Date: " + paymentDate + ", Payment Amount: " + paymentAmount;
    }
}
