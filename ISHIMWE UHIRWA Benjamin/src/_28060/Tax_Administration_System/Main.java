package _28060.Tax_Administration_System;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String ID_PREFIX = "27801 | ";

    public static void main(String[] args) {
        System.out.println(ID_PREFIX + "=== TAX ADMINISTRATION SYSTEM ===");

        // --- Tax Authority Info ---
        String authorityName = inputString("Enter Tax Authority Name: ");
        String region = inputString("Enter Region: ");
        String email = inputRegex("Enter Authority Email: ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

        // --- Tax Category Info ---
        String categoryName = inputString("Enter Tax Category Name: ");
        double rate = inputPositiveDouble("Enter Tax Rate (0 < rate <= 1): ");
        String code = inputRegex("Enter Tax Code (>=3 chars): ", ".{3,}");

        // --- Taxpayer Info ---
        String tin = inputRegex("Enter Taxpayer TIN (9 digits): ", "\\d{9}");
        String taxpayerName = inputString("Enter Taxpayer Name: ");
        String address = inputString("Enter Address: ");

        // --- Employer Info ---
        String employerName = inputString("Enter Employer Name: ");
        String employerTIN = inputRegex("Enter Employer TIN (9 digits): ", "\\d{9}");
        String contact = inputRegex("Enter Employer Contact (10 digits): ", "\\d{10}");

        // --- Employee Info ---
        String employeeName = inputString("Enter Employee Name: ");
        double salary = inputPositiveDouble("Enter Salary (>0): ");
        String employeeTIN = inputRegex("Enter Employee TIN (9 digits): ", "\\d{9}");

        // --- Tax Declaration Info ---
        String declarationMonth = inputString("Enter Declaration Month: ");
        double totalIncome = inputPositiveDouble("Enter Total Income (>=0): ");

        // --- Tax Assessment Info ---
        Date assessmentDate = new Date();
        double assessedTax = inputPositiveDouble("Enter Assessed Tax (>=0): ");

        // --- Payment Info ---
        Date paymentDate = new Date();
        double paymentAmount = inputPositiveDouble("Enter Payment Amount (>0): ");

        // --- Tax Record Info ---
        String receiptNo = inputString("Enter Receipt Number: ");

        try {
            // Create TaxRecord object
            TaxRecord record = new TaxRecord(
                    1, authorityName, region, email,
                    categoryName, rate, code,
                    tin, taxpayerName, address,
                    employerName, employerTIN, contact,
                    employeeName, salary, employeeTIN,
                    declarationMonth, totalIncome,
                    assessmentDate, assessedTax,
                    paymentDate, paymentAmount,
                    receiptNo
            );

            System.out.println("\n" + ID_PREFIX + "TAX RECORD GENERATED SUCCESSFULLY:");
            System.out.println(record);

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
}
