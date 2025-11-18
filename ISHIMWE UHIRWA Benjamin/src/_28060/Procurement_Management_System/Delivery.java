package _28060.Procurement_Management_System;

import java.util.Date;

public class Delivery extends PurchaseOrder {
    private Date deliveryDate;
    private String deliveredBy;

    public Delivery(int id, String orgName, String address, String contactEmail,
                    String deptName, String deptCode,
                    String supplierName, String supplierTIN, String contact,
                    String productName, double unitPrice, int quantity,
                    String poNumber, Date orderDate, double totalAmount,
                    Date deliveryDate, String deliveredBy) {
        super(id, orgName, address, contactEmail, deptName, deptCode,
                supplierName, supplierTIN, contact,
                productName, unitPrice, quantity,
                poNumber, orderDate, totalAmount);
        if (deliveryDate == null) throw new IllegalArgumentException("Delivery date cannot be null");
        if (deliveredBy.isBlank()) throw new IllegalArgumentException("DeliveredBy cannot be empty");
        this.deliveryDate = deliveryDate;
        this.deliveredBy = deliveredBy;
    }

    @Override
    public String toString() {
        return super.toString() + ", DeliveryDate: " + deliveryDate + ", DeliveredBy: " + deliveredBy;
    }
}
