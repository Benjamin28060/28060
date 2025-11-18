package _28060.Procurement_Management_System;

public class Inspection extends Delivery {
    private String inspectorName;
    private String status;
    private String remarks;

    public Inspection(int id, String orgName, String address, String contactEmail,
                      String deptName, String deptCode,
                      String supplierName, String supplierTIN, String contact,
                      String productName, double unitPrice, int quantity,
                      String poNumber, java.util.Date orderDate, double totalAmount,
                      java.util.Date deliveryDate, String deliveredBy,
                      String inspectorName, String status, String remarks) {
        super(id, orgName, address, contactEmail, deptName, deptCode,
                supplierName, supplierTIN, contact,
                productName, unitPrice, quantity,
                poNumber, orderDate, totalAmount,
                deliveryDate, deliveredBy);
        if (inspectorName.isBlank()) throw new IllegalArgumentException("Inspector name cannot be empty");
        if (!status.equalsIgnoreCase("Passed") && !status.equalsIgnoreCase("Failed"))
            throw new IllegalArgumentException("Status must be Passed or Failed");
        this.inspectorName = inspectorName;
        this.status = status;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return super.toString() + ", Inspector: " + inspectorName + ", Status: " + status + ", Remarks: " + remarks;
    }
}
