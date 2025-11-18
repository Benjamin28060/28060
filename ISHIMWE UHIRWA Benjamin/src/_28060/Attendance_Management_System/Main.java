package _28060.Attendance_Management_System;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String ID_PREFIX = "28060 | ";

    public static void main(String[] args) {
        System.out.println(ID_PREFIX + "=== ATTENDANCE MANAGEMENT SYSTEM ===");

        // --- Institution Info ---
        String institutionName = inputString("Enter Institution Name: ");
        String institutionCode = inputRegex("Enter Institution Code (≥3 chars): ", ".{3,}");
        String institutionAddress = inputString("Enter Institution Address: ");

        // --- Department Info ---
        String departmentName = inputString("Enter Department Name: ");
        String departmentHead = inputString("Enter Department Head: ");

        // --- Course Info ---
        String courseName = inputString("Enter Course Name: ");
        String courseCode = inputString("Enter Course Code: ");
        int credits = inputIntMin("Enter Course Credits (>0): ", 1);

        // --- Instructor Info ---
        String instructorName = inputString("Enter Instructor Name: ");
        String instructorEmail = inputRegex("Enter Instructor Email: ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        String instructorPhone = inputRegex("Enter Instructor Phone (10 digits): ", "\\d{10}");

        // --- Student Info ---
        String studentName = inputString("Enter Student Name: ");
        String studentID = inputString("Enter Student ID: ");
        int studentAge = inputIntMin("Enter Student Age (>0): ", 1);

        // --- Class Session Info ---
        Date sessionDate = new Date();
        String topic = inputString("Enter Session Topic: ");
        String sessionID = inputString("Enter Session ID: ");

        // --- Attendance Record ---
        String status = inputOption("Enter Attendance Status (Present/Absent): ", new String[]{"Present", "Absent"});

        // --- Leave Request ---
        Date requestDate = new Date();
        String reason = inputString("Enter Leave Reason: ");
        boolean approved = inputOption("Leave Approved? (true/false): ", new String[]{"true","false"}).equalsIgnoreCase("true");

        // --- Generate Attendance Summary ---
        Date reportDate = new Date();

        try {
            AttendanceSummary summary = new AttendanceSummary(
                    1, institutionName, institutionCode, institutionAddress,
                    departmentName, departmentHead,
                    courseName, courseCode, credits,
                    instructorName, instructorEmail, instructorPhone,
                    studentName, studentID, studentAge,
                    sessionDate, topic,
                    sessionID, status,
                    requestDate, reason, approved,
                    reportDate
            );

            System.out.println("\n" + ID_PREFIX + "ATTENDANCE SUMMARY GENERATED SUCCESSFULLY:");
            System.out.println(summary);

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
