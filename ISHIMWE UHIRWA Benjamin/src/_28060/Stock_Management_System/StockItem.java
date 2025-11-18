package _28060.Stock_Management_System;

public class StockItem extends Product {
    private int quantityAvailable;
    private int reorderLevel;

    public StockItem(int id, String warehouseName, String location, String contactNumber,
                     String categoryName, String categoryCode,
                     String supplierName, String supplierEmail, String supplierPhone,
                     String productName, double unitPrice, int stockLimit,
                     int quantityAvailable, int reorderLevel) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit);

        if (quantityAvailable < 0)
            throw new IllegalArgumentException("27801 | Quantity available cannot be negative");

        if (reorderLevel < 0)
            throw new IllegalArgumentException("27801 | Reorder level cannot be negative");

        this.quantityAvailable = quantityAvailable;
        this.reorderLevel = reorderLevel;
    }

    public int getQuantityAvailable() { return quantityAvailable; }
    public int getReorderLevel() { return reorderLevel; }
}
