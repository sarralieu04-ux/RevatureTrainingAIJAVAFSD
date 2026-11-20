package com.company.salary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class SalaryCalculator {

    // Business rules kept in one place so they are easy to change.
    static final BigDecimal HRA_RATE = new BigDecimal("0.20");
    static final BigDecimal DA_RATE = new BigDecimal("0.10");
    static final BigDecimal TAX_THRESHOLD = new BigDecimal("20000");
    static final BigDecimal PROFESSIONAL_TAX = new BigDecimal("200");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String employeeId = readNonEmpty(scanner, "Enter employee ID: ");
        String employeeName = readNonEmpty(scanner, "Enter employee name: ");
        BigDecimal basic = readPositiveAmount(scanner, "Enter basic salary (Rs.): ");

        BigDecimal hra = calculateHra(basic);
        BigDecimal da = calculateDa(basic);
        BigDecimal gross = calculateGross(basic, hra, da);
        BigDecimal tax = calculateProfessionalTax(gross);
        BigDecimal net = calculateNet(gross, tax);

        printPayslip(employeeId, employeeName, basic, hra, da, gross, tax, net);
        scanner.close();
    }

    // Each amount is rounded to 2 decimals (paise) half-up, so printed figures add up.
    static BigDecimal calculateHra(BigDecimal basic) {
        return basic.multiply(HRA_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    static BigDecimal calculateDa(BigDecimal basic) {
        return basic.multiply(DA_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    static BigDecimal calculateGross(BigDecimal basic, BigDecimal hra, BigDecimal da) {
        return basic.add(hra).add(da);
    }

    // "Above Rs. 20,000" means strictly greater than: exactly 20,000 pays no tax.
    static BigDecimal calculateProfessionalTax(BigDecimal gross) {
        if (gross.compareTo(TAX_THRESHOLD) > 0) {
            return PROFESSIONAL_TAX;
        }
        return BigDecimal.ZERO;
    }

    static BigDecimal calculateNet(BigDecimal gross, BigDecimal tax) {
        return gross.subtract(tax);
    }

    static String readNonEmpty(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Input ended before all details were entered.");
            }
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    static BigDecimal readPositiveAmount(Scanner scanner, String prompt) {
        while (true) {
            String text = readNonEmpty(scanner, prompt);
            try {
                BigDecimal value = new BigDecimal(text);
                if (value.signum() > 0) {
                    return value;
                }
                System.out.println("Salary must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static void printPayslip(String id, String name, BigDecimal basic, BigDecimal hra,
            BigDecimal da, BigDecimal gross, BigDecimal tax, BigDecimal net) {
        System.out.println("\n----- Salary Slip -----");
        System.out.println("Employee ID: " + id);
        System.out.println("Employee name: " + name);
        System.out.printf(Locale.ENGLISH, "Basic salary: Rs. %.2f%n", basic);
        System.out.printf(Locale.ENGLISH, "HRA (20%%): Rs. %.2f%n", hra);
        System.out.printf(Locale.ENGLISH, "DA (10%%): Rs. %.2f%n", da);
        System.out.printf(Locale.ENGLISH, "Gross salary: Rs. %.2f%n", gross);
        System.out.printf(Locale.ENGLISH, "Professional tax: Rs. %.2f%n", tax);
        System.out.printf(Locale.ENGLISH, "Net salary: Rs. %.2f%n", net);
    }
}