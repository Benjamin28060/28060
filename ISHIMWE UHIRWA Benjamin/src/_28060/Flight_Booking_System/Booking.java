package _28060.Flight_Booking_System;

import java.time.LocalDate;

public class Booking extends Passenger {
    private LocalDate bookingDate;
    private String seatNumber;
    private String travelClass;

    public Booking(int id, String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail,
                   String flightNumber, String departure, String destination, double baseFare,
                   String pilotName, String licenseNumber, int experienceYears,
                   String crewName, String role, String shift,
                   String passengerName, int age, String gender, String contact,
                   LocalDate bookingDate, String seatNumber, String travelClass) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears,
                crewName, role, shift, passengerName, age, gender, contact);

        if (bookingDate == null)
            throw new IllegalArgumentException("27801 | Booking date cannot be null");

        if (seatNumber == null || seatNumber.isBlank())
            throw new IllegalArgumentException("27801 | Seat number cannot be empty");

        if (travelClass == null || !(travelClass.equalsIgnoreCase("Economy") || travelClass.equalsIgnoreCase("Business") || travelClass.equalsIgnoreCase("First")))
            throw new IllegalArgumentException("27801 | Travel class must be Economy, Business, or First");

        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.travelClass = travelClass;
    }

    public LocalDate getBookingDate() { return bookingDate; }
    public String getSeatNumber() { return seatNumber; }
    public String getTravelClass() { return travelClass; }
}
