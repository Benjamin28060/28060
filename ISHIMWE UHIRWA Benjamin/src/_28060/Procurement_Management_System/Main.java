package _28060.Procurement_Management_System;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String ID_PREFIX = "27801 | ";

    public static void main(String[] args) {
        System.out.println(ID_PREFIX + "=== PROCUREMENT MANAGEMENT SYSTEM ===");

        // --- Organization Info ---
        String orgName = inputString("Enter Organization Name: ");
        String orgAddress = inputString("Enter Organization Address: ");
        String orgEmail = inputRegex("Enter Organization Email: ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

        // --- Department Info ---
        String deptName = inputString("Enter Department Name: ");
        String deptCode = inputRegex("Enter Department Code (≥3 alphanumeric chars): ", "[a-zA-Z0-9]{3,}");

        // --- Supplier Info ---
        String supplierName = inputString("Enter Supplier Name: ");
        String supplierTIN = inputRegex("Enter Supplier TIN (9 digits): ", "\\d{9}");
        String supplierContact = inputRegex("Enter Supplier Contact (10 digits): ", "\\d{10}");

        // --- Product Info ---
        String productName = inputString("Enter Product Name: ");
        double unitPrice = inputPositiveDouble("Enter Unit Price (>0): ");
        int quantity = inputIntMin("Enter Quantity (≥0): ", 0);

        // --- Purchase Order Info ---
        String poNumber = inputString("Enter Purchase Order Number: ");
        Date orderDate = new Date();  // Current date
        double totalAmount = unitPrice * quantity;

        // --- Delivery Info ---
        Date deliveryDate = new Date(); // Current date
        String deliveredBy = inputString("Enter Delivered By: ");

        // --- Inspection Info ---
        String inspectorName = inputString("Enter Inspector Name: ");
        String status = inputOption("Enter Inspection Status (Passed/Failed): ", new String[]{"Passed","Failed"});
        String remarks = inputString("Enter Remarks: ");

        // --- Invoice Info ---
        String invoiceNo = inputString("Enter Invoice Number: ");
        double invoiceAmount = inputPositiveDouble("Enter Invoice Amount (>0): ");

        // --- Procurement Report ---
        Date reportDate = new Date();
        String summary = inputString("Enter Report Summary: ");

        try {
            ProcurementReport report = new ProcurementReport(
                    1, orgName, orgAddress, orgEmail,
                    deptName, deptCode,
                    supplierName, supplierTIN, supplierContact,
                    productName, unitPrice, quantity,
                    poNumber, orderDate, totalAmount,
                    deliveryDate, deliveredBy,
                    inspectorName, status, remarks,
                    invoiceNo, invoiceAmount,
                    reportDate, summary
            );

            System.out.println("\n" + ID_PREFIX + "PROCUREMENT REPORT GENERATED SUCCESSFULLY:");
            System.out.println(report);

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
