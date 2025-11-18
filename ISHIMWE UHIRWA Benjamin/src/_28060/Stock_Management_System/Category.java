package _28060.Stock_Management_System;

public class Category extends Warehouse {
    private String categoryName;
    private String categoryCode;

    public Category(int id, String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode) {
        super(id, warehouseName, location, contactNumber);

        if (categoryName == null || categoryName.isBlank())
            throw new IllegalArgumentException("27801 | Category name cannot be empty");

        if (categoryCode == null || categoryCode.length() < 3 || !categoryCode.matches("[a-zA-Z0-9]+"))
            throw new IllegalArgumentException("27801 | Category code must be alphanumeric and ≥3 chars");

        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() { return categoryName; }
    public String getCategoryCode() { return categoryCode; }
}
