package _28060.Stock_Management_System;

public class Supplier extends Category {
    private String supplierName;
    private String supplierEmail;
    private String supplierPhone;

    public Supplier(int id, String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode,
                    String supplierName, String supplierEmail, String supplierPhone) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode);

        if (supplierName == null || supplierName.isBlank())
            throw new IllegalArgumentException("27801 | Supplier name cannot be empty");

        if (supplierEmail == null || !supplierEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new IllegalArgumentException("27801 | Invalid supplier email");

        if (supplierPhone == null || !supplierPhone.matches("\\d{10}"))
            throw new IllegalArgumentException("27801 | Supplier phone must be 10 digits");

        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierName() { return supplierName; }
    public String getSupplierEmail() { return supplierEmail; }
    public String getSupplierPhone() { return supplierPhone; }
}
