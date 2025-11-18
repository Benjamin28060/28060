package _28060.Stock_Management_System;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String ID_PREFIX = "27801 | ";

    public static void main(String[] args) {
        System.out.println(ID_PREFIX + "=== STOCK MANAGEMENT SYSTEM ===");

        try {
            // --- Warehouse ---
            String warehouseName = inputString("Enter Warehouse Name: ");
            String location = inputString("Enter Location: ");
            String contactNumber = inputRegex("Enter Contact Number (10 digits): ", "\\d{10}");

            // --- Category ---
            String categoryName = inputString("Enter Category Name: ");
            String categoryCode = inputRegex("Enter Category Code (≥3 chars alphanumeric): ", "[a-zA-Z0-9]{3,}");

            // --- Supplier ---
            String supplierName = inputString("Enter Supplier Name: ");
            String supplierEmail = inputRegex("Enter Supplier Email: ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
            String supplierPhone = inputRegex("Enter Supplier Phone (10 digits): ", "\\d{10}");

            // --- Product ---
            String productName = inputString("Enter Product Name: ");
            double unitPrice = inputPositiveDouble("Enter Unit Price (>0): ");
            int stockLimit = inputIntMin("Enter Stock Limit (≥0): ", 0);

            // --- Stock Item ---
            int quantityAvailable = inputIntMin("Enter Quantity Available (≥0): ", 0);
            int reorderLevel = inputIntMin("Enter Reorder Level (≥0): ", 0);

            // --- Purchase ---
            LocalDate purchaseDate = LocalDate.now();
            int purchasedQuantity = inputIntMin("Enter Purchased Quantity (>0): ", 1);
            String supplierNameForPurchase = inputString("Enter Supplier Name for Purchase: ");

            // --- Sale ---
            LocalDate saleDate = LocalDate.now();
            int soldQuantity = inputIntMin("Enter Sold Quantity (>0): ", 1);
            String customerName = inputString("Enter Customer Name: ");

            // --- Inventory ---
            int totalItems = inputIntMin("Enter Total Items (≥0): ", 0);
            double stockValue = inputPositiveDouble("Enter Total Stock Value (≥0): ");

            // --- Remarks ---
            String remarks = inputString("Enter Remarks: ");

            // --- Create Report ---
            StockReport report = new StockReport(
                    27801, warehouseName, location, contactNumber,
                    categoryName, categoryCode, supplierName, supplierEmail, supplierPhone,
                    productName, unitPrice, stockLimit, quantityAvailable, reorderLevel,
                    purchaseDate, purchasedQuantity, supplierNameForPurchase,
                    saleDate, soldQuantity, customerName, totalItems, stockValue,
                    remarks
            );

            System.out.println("\n" + report.generateReport());

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
                if (value >= 0) return value;
                else System.out.println(ID_PREFIX + "Value must be ≥ 0");
            } else {
                System.out.println(ID_PREFIX + "Invalid number, try again!");
                sc.nextLine();
            }
        }
    }
}
