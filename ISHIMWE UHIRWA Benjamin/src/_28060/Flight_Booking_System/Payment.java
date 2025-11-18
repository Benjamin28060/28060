package _28060.Flight_Booking_System;

import java.time.LocalDate;

public class Payment extends Booking {
    private LocalDate paymentDate;
    private String paymentMethod;
    private double amountPaid;

    public Payment(int id, String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail,
                   String flightNumber, String departure, String destination, double baseFare,
                   String pilotName, String licenseNumber, int experienceYears,
                   String crewName, String role, String shift,
                   String passengerName, int age, String gender, String contact,
                   LocalDate bookingDate, String seatNumber, String travelClass,
                   LocalDate paymentDate, String paymentMethod, double amountPaid) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears,
                crewName, role, shift, passengerName, age, gender, contact, bookingDate, seatNumber, travelClass);

        if (paymentDate == null)
            throw new IllegalArgumentException("27801 | Payment date cannot be null");

        if (paymentMethod == null || paymentMethod.isBlank())
            throw new IllegalArgumentException("27801 | Payment method cannot be empty");

        if (amountPaid <= 0)
            throw new IllegalArgumentException("27801 | Amount paid must be greater than 0");

        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
    }

    public LocalDate getPaymentDate() { return paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public double getAmountPaid() { return amountPaid; }
}
