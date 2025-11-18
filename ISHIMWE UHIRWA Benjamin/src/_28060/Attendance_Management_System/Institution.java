package _28060.Attendance_Management_System;

public class Institution extends Entity {
    private String institutionName;
    private String code;
    private String address;

    public Institution(int id, String institutionName, String code, String address) {
        super(id);
        if (institutionName.isBlank()) throw new IllegalArgumentException("Institution name cannot be empty");
        if (code.length() < 3) throw new IllegalArgumentException("Code must be ≥ 3 chars");
        if (address.isBlank()) throw new IllegalArgumentException("Address cannot be empty");

        this.institutionName = institutionName;
        this.code = code.toUpperCase();
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + ", Institution: " + institutionName + ", Code: " + code + ", Address: " + address;
    }
}
