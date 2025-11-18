package _28060.Flight_Booking_System;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String ID_PREFIX = "27801 | ";

    public static void main(String[] args) {

        System.out.println(ID_PREFIX + "=== FLIGHT BOOKING SYSTEM ===");

        // --- Airport Info ---
        String airportName = inputString("Enter Airport Name: ");
        String airportCode = inputRegex("Enter Airport Code (3 letters): ", "[a-zA-Z]{3}");
        String airportLocation = inputString("Enter Airport Location: ");

        // --- Airline Info ---
        String airlineName = inputString("Enter Airline Name: ");
        String airlineCode = inputRegex("Enter Airline Code (2-4 letters): ", "[a-zA-Z]{2,4}");
        String airlineEmail = inputRegex("Enter Airline Email: ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

        // --- Flight Info ---
        String flightNumber = inputString("Enter Flight Number: ");
        String departure = inputString("Enter Departure Airport: ");
        String destination = inputString("Enter Destination Airport: ");
        double baseFare = inputPositiveDouble("Enter Base Fare (>0): ");

        // --- Pilot Info ---
        String pilotName = inputString("Enter Pilot Name: ");
        String licenseNumber = inputString("Enter Pilot License Number: ");
        int experienceYears = inputIntMin("Enter Pilot Experience Years (>=2): ", 2);

        // --- Cabin Crew Info ---
        String crewName = inputString("Enter Cabin Crew Name: ");
        String role = inputString("Enter Crew Role: ");
        String shift = inputOption("Enter Shift (Day/Night): ", new String[]{"Day","Night"});

        // --- Passenger Info ---
        String passengerName = inputString("Enter Passenger Name: ");
        int age = inputIntMin("Enter Passenger Age (>0): ", 1);
        String gender = inputOption("Enter Gender (Male/Female/Other): ", new String[]{"Male","Female","Other"});
        String contact = inputRegex("Enter Contact Number (10 digits): ", "\\d{10}");

        // --- Booking Info ---
        LocalDate bookingDate = LocalDate.now();
        String seatNumber = inputString("Enter Seat Number: ");
        String travelClass = inputOption("Enter Travel Class (Economy/Business/First): ",
                new String[]{"Economy","Business","First"});

        // --- Payment Info ---
        LocalDate paymentDate = LocalDate.now();
        String paymentMethod = inputString("Enter Payment Method: ");
        double amountPaid = inputPositiveDouble("Enter Amount Paid (>0): ");

        // --- Ticket Info ---
        String ticketNumber = inputString("Enter Ticket Number: ");

        // --- Create Ticket ---
        try {
            Ticket ticket = new Ticket(27801, airportName, airportCode, airportLocation,
                    airlineName, airlineCode, airlineEmail,
                    flightNumber, departure, destination, baseFare,
                    pilotName, licenseNumber, experienceYears,
                    crewName, role, shift,
                    passengerName, age, gender, contact,
                    bookingDate, seatNumber, travelClass,
                    paymentDate, paymentMethod, amountPaid,
                    ticketNumber);

            System.out.println("\n" + ticket.generateTicket());

        } catch (IllegalArgumentException e) {
            System.out.println(ID_PREFIX + "ERROR: " + e.getMessage());
        }

        sc.close();
    }

    // ---------------- Input Utility Methods ----------------

    private static String inputString(String prompt) {
        String input;
        while (true) {
            System.out.print(ID_PREFIX + prompt);
            input = sc.nextLine();
            if (!input.isBlank()) return input;
            System.out.println(ID_PREFIX + "Input cannot be empty!");
        }
    }

    private static String inputRegex(String prompt, String pattern) {
        String input;
        while (true) {
            System.out.print(ID_PREFIX + prompt);
            input = sc.nextLine();
            if (input.matches(pattern)) return input;
            System.out.println(ID_PREFIX + "Invalid input format, try again!");
        }
    }

    private static int inputIntMin(String prompt, int min) {
        int value;
        while (true) {
            System.out.print(ID_PREFIX + prompt);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value >= min) return value;
                else System.out.println(ID_PREFIX + "Value must be >= " + min);
            } else {
                System.out.println(ID_PREFIX + "Invalid number, try again!");
                sc.nextLine();
            }
        }
    }

    private static double inputPositiveDouble(String prompt) {
        double value;
        while (true) {
            System.out.print(ID_PREFIX + prompt);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine();
                if (value > 0) return value;
                else System.out.println(ID_PREFIX + "Value must be > 0");
            } else {
                System.out.println(ID_PREFIX + "Invalid number, try again!");
                sc.nextLine();
            }
        }
    }

    private static String inputOption(String prompt, String[] options) {
        String input;
        while (true) {
            System.out.print(ID_PREFIX + prompt);
            input = sc.nextLine();
            for (String option : options) {
                if (option.equalsIgnoreCase(input)) return option;
            }
            System.out.print(ID_PREFIX + "Invalid option. Choose from: ");
            for (String o : options) System.out.print(o + " ");
            System.out.println();
        }
    }
}
