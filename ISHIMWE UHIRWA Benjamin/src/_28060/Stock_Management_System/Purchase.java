package _28060.Stock_Management_System;

import java.time.LocalDate;

public class Purchase extends StockItem {
    private LocalDate purchaseDate;
    private int purchasedQuantity;
    private String supplierName;

    public Purchase(int id, String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode,
                    String supplierName, String supplierEmail, String supplierPhone,
                    String productName, double unitPrice, int stockLimit,
                    int quantityAvailable, int reorderLevel,
                    LocalDate purchaseDate, int purchasedQuantity, String supplierNameForPurchase) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit,
                quantityAvailable, reorderLevel);

        if (purchaseDate == null)
            throw new IllegalArgumentException("27801 | Purchase date cannot be null");

        if (purchasedQuantity <= 0)
            throw new IllegalArgumentException("27801 | Purchased quantity must be greater than 0");

        if (supplierNameForPurchase == null || supplierNameForPurchase.isBlank())
            throw new IllegalArgumentException("27801 | Supplier name cannot be empty");

        this.purchaseDate = purchaseDate;
        this.purchasedQuantity = purchasedQuantity;
        this.supplierName = supplierNameForPurchase;
    }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public int getPurchasedQuantity() { return purchasedQuantity; }
    public String getSupplierNameForPurchase() { return supplierName; }
}
