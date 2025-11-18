package _28060.Stock_Management_System;

public class Inventory extends Sale {
    private int totalItems;
    private double stockValue;

    public Inventory(int id, String warehouseName, String location, String contactNumber,
                     String categoryName, String categoryCode,
                     String supplierName, String supplierEmail, String supplierPhone,
                     String productName, double unitPrice, int stockLimit,
                     int quantityAvailable, int reorderLevel,
                     java.time.LocalDate purchaseDate, int purchasedQuantity, String supplierNameForPurchase,
                     java.time.LocalDate saleDate, int soldQuantity, String customerName,
                     int totalItems, double stockValue) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit,
                quantityAvailable, reorderLevel, purchaseDate, purchasedQuantity, supplierNameForPurchase,
                saleDate, soldQuantity, customerName);

        if (totalItems < 0)
            throw new IllegalArgumentException("27801 | Total items cannot be negative");

        if (stockValue < 0)
            throw new IllegalArgumentException("27801 | Stock value cannot be negative");

        this.totalItems = totalItems;
        this.stockValue = stockValue;
    }

    public int getTotalItems() { return totalItems; }
    public double getStockValue() { return stockValue; }
}
