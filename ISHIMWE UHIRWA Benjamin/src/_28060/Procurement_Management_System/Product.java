package _28060.Procurement_Management_System;

public class Product extends Supplier {
    private String productName;
    private double unitPrice;
    private int quantity;

    public Product(int id, String orgName, String address, String contactEmail,
                   String deptName, String deptCode,
                   String supplierName, String supplierTIN, String contact,
                   String productName, double unitPrice, int quantity) {
        super(id, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact);
        if (productName.isBlank()) throw new IllegalArgumentException("Product name cannot be empty");
        if (unitPrice <= 0) throw new IllegalArgumentException("Unit price must be >0");
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getTotal() {
        return unitPrice * quantity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Product: " + productName + ", UnitPrice: " + unitPrice + ", Quantity: " + quantity;
    }
}
