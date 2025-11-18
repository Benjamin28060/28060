package _28060.Stock_Management_System;

import java.time.LocalDate;

public class Sale extends Purchase {
    private LocalDate saleDate;
    private int soldQuantity;
    private String customerName;

    public Sale(int id, String warehouseName, String location, String contactNumber,
                String categoryName, String categoryCode,
                String supplierName, String supplierEmail, String supplierPhone,
                String productName, double unitPrice, int stockLimit,
                int quantityAvailable, int reorderLevel,
                LocalDate purchaseDate, int purchasedQuantity, String supplierNameForPurchase,
                LocalDate saleDate, int soldQuantity, String customerName) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit,
                quantityAvailable, reorderLevel, purchaseDate, purchasedQuantity, supplierNameForPurchase);

        if (saleDate == null)
            throw new IllegalArgumentException("27801 | Sale date cannot be null");

        if (soldQuantity <= 0)
            throw new IllegalArgumentException("27801 | Sold quantity must be greater than 0");

        if (customerName == null || customerName.isBlank())
            throw new IllegalArgumentException("27801 | Customer name cannot be empty");

        this.saleDate = saleDate;
        this.soldQuantity = soldQuantity;
        this.customerName = customerName;
    }

    public LocalDate getSaleDate() { return saleDate; }
    public int getSoldQuantity() { return soldQuantity; }
    public String getCustomerName() { return customerName; }
}
