package _28060.Flight_Booking_System;

public class Flight extends Airline {
    private String flightNumber;
    private String departure;
    private String destination;
    private double baseFare;

    public Flight(int id, String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail,
                  String flightNumber, String departure, String destination, double baseFare) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail);

        if (flightNumber == null || flightNumber.isBlank())
            throw new IllegalArgumentException("27801 | Flight number cannot be empty");

        if (departure == null || departure.isBlank())
            throw new IllegalArgumentException("27801 | Departure cannot be empty");

        if (destination == null || destination.isBlank())
            throw new IllegalArgumentException("27801 | Destination cannot be empty");

        if (baseFare <= 0)
            throw new IllegalArgumentException("27801 | Base fare must be greater than 0");

        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.baseFare = baseFare;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDeparture() { return departure; }
    public String getDestination() { return destination; }
    public double getBaseFare() { return baseFare; }
}
