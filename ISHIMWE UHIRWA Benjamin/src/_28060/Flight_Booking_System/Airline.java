package _28060.Flight_Booking_System;

public class Airline extends Airport {
    private String airlineName;
    private String airlineCode;
    private String contactEmail;

    public Airline(int id, String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail) {
        super(id, airportName, code, location);

        if (airlineName == null || airlineName.isBlank())
            throw new IllegalArgumentException("27801 | Airline name cannot be empty");

        if (airlineCode == null || !airlineCode.matches("[a-zA-Z]{2,4}"))
            throw new IllegalArgumentException("27801 | Airline code must be 2–4 letters");

        if (contactEmail == null || !contactEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new IllegalArgumentException("27801 | Invalid airline email");

        this.airlineName = airlineName;
        this.airlineCode = airlineCode.toUpperCase();
        this.contactEmail = contactEmail;
    }

    public String getAirlineName() { return airlineName; }
    public String getAirlineCode() { return airlineCode; }
    public String getContactEmail() { return contactEmail; }
}
