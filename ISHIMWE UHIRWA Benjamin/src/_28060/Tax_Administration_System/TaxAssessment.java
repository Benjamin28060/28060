package _28060.Tax_Administration_System;

import java.util.Date;

public class TaxAssessment extends TaxDeclaration {
    private Date assessmentDate;
    private double assessedTax;

    public TaxAssessment(int id, String authorityName, String region, String email,
                         String categoryName, double rate, String code,
                         String tin, String taxpayerName, String address,
                         String employerName, String employerTIN, String contact,
                         String employeeName, double salary, String employeeTIN,
                         String declarationMonth, double totalIncome,
                         Date assessmentDate, double assessedTax) {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact,
                employeeName, salary, employeeTIN, declarationMonth, totalIncome);
        if (assessedTax < 0) throw new IllegalArgumentException("Assessed tax cannot be negative");
        this.assessmentDate = assessmentDate;
        this.assessedTax = assessedTax;
    }

    @Override
    public String toString() {
        return super.toString() + ", Assessment Date: " + assessmentDate + ", Assessed Tax: " + assessedTax;
    }
}
