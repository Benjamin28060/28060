package _28060.Stock_Management_System;

public class Product extends Supplier {
    private String productName;
    private double unitPrice;
    private int stockLimit;

    public Product(int id, String warehouseName, String location, String contactNumber,
                   String categoryName, String categoryCode,
                   String supplierName, String supplierEmail, String supplierPhone,
                   String productName, double unitPrice, int stockLimit) {
        super(id, warehouseName, location, contactNumber, categoryName, categoryCode,
                supplierName, supplierEmail, supplierPhone);

        if (productName == null || productName.isBlank())
            throw new IllegalArgumentException("27801 | Product name cannot be empty");

        if (unitPrice <= 0)
            throw new IllegalArgumentException("27801 | Unit price must be greater than 0");

        if (stockLimit < 0)
            throw new IllegalArgumentException("27801 | Stock limit cannot be negative");

        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stockLimit = stockLimit;
    }

    public String getProductName() { return productName; }
    public double getUnitPrice() { return unitPrice; }
    public int getStockLimit() { return stockLimit; }
}
