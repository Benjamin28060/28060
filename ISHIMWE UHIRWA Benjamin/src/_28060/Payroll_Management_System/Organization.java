package _28060.Payroll_Management_System;

public class Organization extends Entity {
    private String orgName;
    private String orgCode;
    private String rssbNumber;
    private String contactEmail;

    public Organization(int id, String orgName, String orgCode, String rssbNumber, String contactEmail) {
        super(id);
        if (orgName.isBlank()) throw new IllegalArgumentException("Organization name cannot be empty");
        if (orgCode.length() < 3) throw new IllegalArgumentException("Org code must be ≥ 3 chars");
        if (!rssbNumber.matches("\\d{8}")) throw new IllegalArgumentException("RSSB Number must be 8 digits");
        if (!contactEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) throw new IllegalArgumentException("Invalid email");

        this.orgName = orgName;
        this.orgCode = orgCode.toUpperCase();
        this.rssbNumber = rssbNumber;
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return super.toString() + ", Organization: " + orgName + ", Code: " + orgCode + ", RSSB: " + rssbNumber + ", Email: " + contactEmail;
    }
}
