package _27801.Procurement_Management_System;

import java.util.Date;

public class PurchaseOrder extends Product {
    private String poNumber;
    private Date orderDate;
    private double totalAmount;

    public PurchaseOrder(int id, String orgName, String address, String contactEmail,
                         String deptName, String deptCode,
                         String supplierName, String supplierTIN, String contact,
                         String productName, double unitPrice, int quantity,
                         String poNumber, Date orderDate, double totalAmount) {
        super(id, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
                productName, unitPrice, quantity);
        if (poNumber.isBlank()) throw new IllegalArgumentException("PO Number cannot be empty");
        if (orderDate == null) throw new IllegalArgumentException("Order date cannot be null");
        if (totalAmount <= 0) throw new IllegalArgumentException("Total amount must be >0");
        this.poNumber = poNumber;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return super.toString() + ", PO: " + poNumber + ", OrderDate: " + orderDate + ", TotalAmount: " + totalAmount;
    }
}
