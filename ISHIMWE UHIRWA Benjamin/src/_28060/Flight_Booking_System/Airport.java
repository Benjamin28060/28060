package _28060.Flight_Booking_System;

public class Airport extends Entity {
    private String airportName;
    private String code;
    private String location;

    public Airport(int id, String airportName, String code, String location) {
        super(id);

        if (airportName == null || airportName.isBlank())
            throw new IllegalArgumentException("27801 | Airport name cannot be empty");

        if (code == null || !code.matches("[a-zA-Z]{3}"))
            throw new IllegalArgumentException("27801 | Airport code must be 3 letters");

        if (location == null || location.isBlank())
            throw new IllegalArgumentException("27801 | Airport location cannot be empty");

        this.airportName = airportName;
        this.code = code.toUpperCase();
        this.location = location;
    }

    public String getAirportName() { return airportName; }
    public String getCode() { return code; }
    public String getLocation() { return location; }
}
