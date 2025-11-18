package _28060.Stock_Management_System;

import java.time.LocalDate;

public final class StockReport extends Inventory {
    private LocalDate reportDate;
    private String remarks;

    public StockReport(int id, String warehouseName, String location, String contactNumber,
                       String categoryName, String categoryCode,
                       String supplierName, String supplierEmail, String supplierPhone,
                       String productName, double unitPrice, int stockLimit,
                       int quantityAvailable, int reorderLevel,
                       LocalDate purchaseDate, int purchasedQuantity, String supplierNameForPurchase,
                       LocalDate saleDate, int soldQuantity, String customerName,
                       int totalItems, double stockValue,
                       String remarks) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit,
                quantityAvailable, reorderLevel, purchaseDate, purchasedQuantity, supplierNameForPurchase,
                saleDate, soldQuantity, customerName, totalItems, stockValue);

        if (remarks == null || remarks.isBlank())
            throw new IllegalArgumentException("27801 | Remarks cannot be empty");

        this.reportDate = LocalDate.now();
        this.remarks = remarks;
    }

    public LocalDate getReportDate() { return reportDate; }
    public String getRemarks() { return remarks; }

    public String generateReport() {
        String idPrefix = "27801 | ";
        return idPrefix + "=== STOCK REPORT ===\n" +
                idPrefix + "Warehouse: " + getWarehouseName() + " | Location: " + getLocation() + "\n" +
                idPrefix + "Product: " + getProductName() + " | Category: " + getCategoryName() + "\n" +
                idPrefix + "Supplier: " + getSupplierName() + " | Purchased Qty: " + getPurchasedQuantity() + "\n" +
                idPrefix + "Sold Qty: " + getSoldQuantity() + " | Remaining Qty: " + getQuantityAvailable() + "\n" +
                idPrefix + "Total Items: " + getTotalItems() + " | Stock Value: $" + getStockValue() + "\n" +
                idPrefix + "Report Date: " + reportDate + " | Remarks: " + remarks;
    }
}
