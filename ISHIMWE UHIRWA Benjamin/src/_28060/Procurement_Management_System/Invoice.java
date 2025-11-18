package _28060.Procurement_Management_System;

public class Invoice extends Inspection {
    private String invoiceNo;
    private double invoiceAmount;

    public Invoice(int id, String orgName, String address, String contactEmail,
                   String deptName, String deptCode,
                   String supplierName, String supplierTIN, String contact,
                   String productName, double unitPrice, int quantity,
                   String poNumber, java.util.Date orderDate, double totalAmount,
                   java.util.Date deliveryDate, String deliveredBy,
                   String inspectorName, String status, String remarks,
                   String invoiceNo, double invoiceAmount) {
        super(id, orgName, address, contactEmail, deptName, deptCode,
                supplierName, supplierTIN, contact,
                productName, unitPrice, quantity,
                poNumber, orderDate, totalAmount,
                deliveryDate, deliveredBy,
                inspectorName, status, remarks);
        if (invoiceNo.isBlank()) throw new IllegalArgumentException("Invoice number cannot be empty");
        if (invoiceAmount <= 0) throw new IllegalArgumentException("Invoice amount must be >0");
        this.invoiceNo = invoiceNo;
        this.invoiceAmount = invoiceAmount;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    @Override
    public String toString() {
        return super.toString() + ", InvoiceNo: " + invoiceNo + ", InvoiceAmount: " + invoiceAmount;
    }
}
