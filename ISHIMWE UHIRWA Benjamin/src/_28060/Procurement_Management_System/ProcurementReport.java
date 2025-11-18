package _28600.Procurement_Management_System;

import java.util.Date;

public final class ProcurementReport extends Invoice {
    private Date reportDate;
    private String summary;
    private double totalInvoices;

    public ProcurementReport(int id, String orgName, String address, String contactEmail,
                             String deptName, String deptCode,
                             String supplierName, String supplierTIN, String contact,
                             String productName, double unitPrice, int quantity,
                             String poNumber, Date orderDate, double totalAmount,
                             Date deliveryDate, String deliveredBy,
                             String inspectorName, String status, String remarks,
                             String invoiceNo, double invoiceAmount,
                             Date reportDate, String summary) {
        super(id, orgName, address, contactEmail, deptName, deptCode,
                supplierName, supplierTIN, contact,
                productName, unitPrice, quantity,
                poNumber, orderDate, totalAmount,
                deliveryDate, deliveredBy,
                inspectorName, status, remarks,
                invoiceNo, invoiceAmount);
        this.reportDate = reportDate;
        this.summary = summary;
        calculateTotal();
    }

    private void calculateTotal() {
        // For simplicity, we take only the current invoice amount as total
        // In a real system, sum multiple invoices
        this.totalInvoices = getInvoiceAmount();
    }

    @Override
    public String toString() {
        return super.toString() + ", ReportDate: " + reportDate + ", Summary: " + summary + ", TotalInvoices: " + totalInvoices;
    }
}
