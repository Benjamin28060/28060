package _28060.Flight_Booking_System;

import java.time.LocalDate;

public final class Ticket extends Payment {
    private String ticketNumber;
    private LocalDate issueDate;

    public Ticket(int id, String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail,
                  String flightNumber, String departure, String destination, double baseFare,
                  String pilotName, String licenseNumber, int experienceYears,
                  String crewName, String role, String shift,
                  String passengerName, int age, String gender, String contact,
                  LocalDate bookingDate, String seatNumber, String travelClass,
                  LocalDate paymentDate, String paymentMethod, double amountPaid,
                  String ticketNumber) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears,
                crewName, role, shift, passengerName, age, gender, contact,
                bookingDate, seatNumber, travelClass, paymentDate, paymentMethod, amountPaid);

        if (ticketNumber == null || ticketNumber.isBlank())
            throw new IllegalArgumentException("27801 | Ticket number cannot be empty");

        this.ticketNumber = ticketNumber;
        this.issueDate = LocalDate.now();
    }

    public String getTicketNumber() { return ticketNumber; }
    public LocalDate getIssueDate() { return issueDate; }

    public double calculateFare() {
        double taxes = 0.15 * getBaseFare();
        double discount = getTravelClass().equalsIgnoreCase("Business") ? 50 :
                getTravelClass().equalsIgnoreCase("First") ? 100 : 0;
        return getBaseFare() + taxes - discount;
    }

    public String generateTicket() {
        String idPrefix = "27801 | ";
        return idPrefix + "Ticket Number: " + ticketNumber + "\n" +
                idPrefix + "Passenger: " + getPassengerName() + " | Age: " + getAge() + " | Gender: " + getGender() + "\n" +
                idPrefix + "Flight: " + getFlightNumber() + " | From: " + getDeparture() + " To: " + getDestination() + "\n" +
                idPrefix + "Seat: " + getSeatNumber() + " | Class: " + getTravelClass() + "\n" +
                idPrefix + "Amount Paid: $" + getAmountPaid() + " | Fare Calculated: $" + calculateFare() + "\n" +
                idPrefix + "Issued on: " + issueDate;
    }
}
