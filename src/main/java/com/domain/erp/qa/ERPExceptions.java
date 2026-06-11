package com.domain.erp.qa;


import java.io.*;

// Custom exceptions
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String msg) {
        super(msg);
    }
}

class TestDataNotFoundException extends RuntimeException {
    public TestDataNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

public class ERPExceptions {

    // P1 — Divide by zero
    public static void divisionTest() {
        System.out.println("=== P1: Division ===");
        try {
            int result = 50000 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Division complete\n");
        }
    }

    // P2 — Number format
    public static void numberFormatTest() {
        System.out.println("=== P2: Number Format ===");
        try {
            int salary = Integer.parseInt("ABC");
        } catch (NumberFormatException e) {
            System.out.println("Invalid format: " +
                e.getMessage());
        } finally {
            System.out.println("Parse complete\n");
        }
    }

    // P3 — Multi-catch
    public static void multiCatchTest() {
        System.out.println("=== P3: Multi-catch ===");
        String empId = null;
        int[] codes = new int[3];

        try {
            System.out.println(empId.length());
        } catch (NullPointerException e) {
            System.out.println("Null: " + e.getMessage());
        }

        try {
            System.out.println(codes[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index: " + e.getMessage());
        } finally {
            System.out.println("Multi-catch complete\n");
        }
    }

    // P4 — Custom exception
    public static void validateSalary(double salary)
            throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException(
                "Salary cannot be negative: " + salary);
        }
        if (salary > 50000) {
            throw new InvalidSalaryException(
                "Salary exceeds limit: " + salary);
        }
        System.out.println("Valid salary: " + salary);
    }

    // P5 — throw vs throws
    public static void validateEmpId(String id)
            throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException(
                "Employee ID cannot be null");
        }
        System.out.println("Valid ID: " + id);
    }

    // P6 — Exception chaining
    public static void loadTestData() throws Exception {
        try {
            throw new Exception("DB connection failed");
        } catch (Exception e) {
            throw new TestDataNotFoundException(
                "Test data load failed", e);
        }
    }

    public static void main(String[] args) {

        divisionTest();
        numberFormatTest();
        multiCatchTest();

        // Custom exception
        System.out.println("=== P4: Custom Exception ===");
        try {
            validateSalary(-500);
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            validateSalary(3000);
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // throw vs throws
        System.out.println("\n=== P5: throw vs throws ===");
        try {
            validateEmpId(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Validation done");
        }

        // Exception chaining
        System.out.println("\n=== P6: Exception Chaining ===");
        try {
            loadTestData();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Caused by: " +
                e.getCause().getMessage());
        }
    }
}
