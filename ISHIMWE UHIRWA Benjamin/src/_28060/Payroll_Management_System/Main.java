package _28060.Payroll_Management_System;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String ID_PREFIX = "27801 | ";

    public static void main(String[] args) {
        System.out.println(ID_PREFIX + "=== PAYROLL MANAGEMENT SYSTEM (RSSB) ===");

        // --- Organization Info ---
        String orgName = inputString("Enter Organization Name: ");
        String orgCode = inputRegex("Enter Org Code (≥3 chars): ", ".{3,}");
        String rssbNumber = inputRegex("Enter RSSB Number (8 digits): ", "\\d{8}");
        String contactEmail = inputRegex("Enter Contact Email: ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

        // --- Department Info ---
        String deptName = inputString("Enter Department Name: ");
        String deptCode = inputRegex("Enter Dept Code (≥3 chars): ", ".{3,}");
        String managerName = inputString("Enter Manager Name: ");

        // --- Employee Info ---
        int employeeID = inputIntMin("Enter Employee ID (≥1000): ", 1000);
        String fullName = inputString("Enter Employee Full Name: ");
        String position = inputString("Enter Position: ");
        double baseSalary = inputPositiveDouble("Enter Base Salary (>0): ");
        boolean rssbRegistered = Boolean.parseBoolean(inputOption("Is Employee RSSB Registered? (true/false): ", new String[]{"true","false"}));

        // --- Payroll Period ---
        int month = inputIntMinMax("Enter Payroll Month (1-12): ", 1, 12);
        int year = inputIntMin("Enter Payroll Year (≥2000): ", 2000);
        Date startDate = new Date();
        Date endDate = new Date();

        // --- Salary Structure ---
        double basicPay = inputPositiveDouble("Enter Basic Pay (≥0): ");
        double transportAllowance = inputPositiveDouble("Enter Transport Allowance (≥0): ");
        double housingAllowance = inputPositiveDouble("Enter Housing Allowance (≥0): ");

        // --- Deductions ---
        double payeTax = inputPositiveDouble("Enter PAYE Tax (≥0): ");
        double loanDeduction = inputPositiveDouble("Enter Loan Deduction (≥0): ");

        // --- Allowances ---
        double overtimeHours = inputPositiveDouble("Enter Overtime Hours (≥0): ");
        double overtimeRate = inputPositiveDouble("Enter Overtime Rate (≥0): ");
        double bonus = inputPositiveDouble("Enter Bonus (≥0): ");

        // --- Payslip Info ---
        String payslipNumber = inputString("Enter Payslip Number: ");
        Date issueDate = new Date();

        try {
            // Create final Payslip object
            Payslip payslip = new Payslip(
                    27801, orgName, orgCode, rssbNumber, contactEmail,
                    deptName, deptCode, managerName,
                    employeeID, fullName, position, baseSalary, rssbRegistered,
                    month, year, startDate, endDate,
                    basicPay, transportAllowance, housingAllowance,
                    payeTax, loanDeduction,
                    overtimeHours, overtimeRate, bonus,
                    payslipNumber, issueDate
            );

            // Generate and display payslip
            payslip.generatePayslip();

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

    private static int inputIntMinMax(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(ID_PREFIX + prompt);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value >= min && value <= max) return value;
                else System.out.println(ID_PREFIX + "Value must be between " + min + " and " + max);
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
