package _28060.Procurement_Management_System;

public class Supplier extends Department {
    private String supplierName;
    private String supplierTIN;
    private String contact;

    public Supplier(int id, String orgName, String address, String contactEmail,
                    String deptName, String deptCode,
                    String supplierName, String supplierTIN, String contact) {
        super(id, orgName, address, contactEmail, deptName, deptCode);
        if (supplierName.isBlank()) throw new IllegalArgumentException("Supplier name cannot be empty");
        if (!supplierTIN.matches("\\d{9}")) throw new IllegalArgumentException("TIN must be 9 digits");
        if (!contact.matches("\\d{10}")) throw new IllegalArgumentException("Contact must be 10 digits");
        this.supplierName = supplierName;
        this.supplierTIN = supplierTIN;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return super.toString() + ", Supplier: " + supplierName + ", TIN: " + supplierTIN + ", Contact: " + contact;
    }
}
