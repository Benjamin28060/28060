package _28060.Procurement_Management_System;

public class Organization extends Entity {
    private String orgName;
    private String address;
    private String contactEmail;

    public Organization(int id, String orgName, String address, String contactEmail) {
        super(id);
        if (orgName.isBlank()) throw new IllegalArgumentException("Organization name cannot be empty");
        if (address.isBlank()) throw new IllegalArgumentException("Address cannot be empty");
        if (!contactEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new IllegalArgumentException("Invalid email");
        this.orgName = orgName;
        this.address = address;
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return super.toString() + ", Organization: " + orgName + ", Address: " + address + ", Email: " + contactEmail;
    }
}
