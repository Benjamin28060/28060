package _28060.Tax_Administration_System;

public class TaxAuthority extends Entity {
    private String authorityName;
    private String region;
    private String email;

    public TaxAuthority(int id, String authorityName, String region, String email) {
        super(id);
        if (!email.matches("^(.+)@(.+)$")) throw new IllegalArgumentException("Invalid email");
        this.authorityName = authorityName;
        this.region = region;
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() + ", Authority: " + authorityName + ", Region: " + region + ", Email: " + email;
    }
}
