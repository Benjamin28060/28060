package _28060.Flight_Booking_System;

public class Passenger extends CabinCrew {
    private String passengerName;
    private int age;
    private String gender;
    private String contact;

    public Passenger(int id, String airportName, String code, String location,
                     String airlineName, String airlineCode, String contactEmail,
                     String flightNumber, String departure, String destination, double baseFare,
                     String pilotName, String licenseNumber, int experienceYears,
                     String crewName, String role, String shift,
                     String passengerName, int age, String gender, String contact) {
        super(id, airportName, code, location, airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears,
                crewName, role, shift);

        if (passengerName == null || passengerName.isBlank())
            throw new IllegalArgumentException("27801 | Passenger name cannot be empty");

        if (age <= 0)
            throw new IllegalArgumentException("27801 | Age must be greater than 0");

        if (gender == null || !(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other")))
            throw new IllegalArgumentException("27801 | Gender must be Male, Female, or Other");

        if (contact == null || !contact.matches("\\d{10}"))
            throw new IllegalArgumentException("27801 | Contact must be 10 digits");

        this.passengerName = passengerName;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }

    public String getPassengerName() { return passengerName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContact() { return contact; }
}
