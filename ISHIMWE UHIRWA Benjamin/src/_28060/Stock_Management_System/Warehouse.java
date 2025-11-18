package _28060.Stock_Management_System;

public class Warehouse extends Entity {
    private String warehouseName;
    private String location;
    private String contactNumber;

    public Warehouse(int id, String warehouseName, String location, String contactNumber) {
        super(id);

        if (warehouseName == null || warehouseName.isBlank())
            throw new IllegalArgumentException("27801 | Warehouse name cannot be empty");

        if (location == null || location.isBlank())
            throw new IllegalArgumentException("27801 | Location cannot be empty");

        if (contactNumber == null || !contactNumber.matches("\\d{10}"))
            throw new IllegalArgumentException("27801 | Phone must be 10 digits");

        this.warehouseName = warehouseName;
        this.location = location;
        this.contactNumber = contactNumber;
    }

    public String getWarehouseName() { return warehouseName; }
    public String getLocation() { return location; }
    public String getContactNumber() { return contactNumber; }
}
