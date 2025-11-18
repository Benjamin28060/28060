package _28060.Tax_Administration_System;

public class Taxpayer extends TaxCategory {
    private String tin;
    private String taxpayerName;
    private String address;

    public Taxpayer(int id, String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address) {
        super(id, authorityName, region, email, categoryName, rate, code);
        if (!tin.matches("\\d{9}")) throw new IllegalArgumentException("TIN must be 9 digits");
        this.tin = tin;
        this.taxpayerName = taxpayerName;
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + ", TIN: " + tin + ", Name: " + taxpayerName + ", Address: " + address;
    }
}
