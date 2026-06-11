package com.domain.erp.qa;



	import java.util.*;
	import java.util.stream.*;

	public class ERPStreams {

	    public static void main(String[] args) {

	        // ERP Test Results
	        List<String> results = new ArrayList<>();
	        results.add("Login_TC001-PASS");
	        results.add("Invoice_TC001-FAIL");
	        results.add("Login_TC002-PASS");
	        results.add("Payroll_TC001-FAIL");
	        results.add("Invoice_TC002-FAIL");
	        results.add("Login_TC003-PASS");

	        // 1. Get all PASS results
	        System.out.println("=== PASS Results ===");
	        results.stream()
	               .filter(r -> r.contains("PASS"))
	               .forEach(System.out::println);

	        // 2. Count PASS and FAIL
	        long passCount = results.stream()
	                                .filter(r -> r.contains("PASS"))
	                                .count();
	        long failCount = results.stream()
	                                .filter(r -> r.contains("FAIL"))
	                                .count();
	        System.out.println("\nPASS: " + passCount);
	        System.out.println("FAIL: " + failCount);

	        // 3. Get all module names
	        System.out.println("\n=== Modules ===");
	        results.stream()
	               .map(r -> r.split("_")[0])
	               .distinct()
	               .sorted()
	               .forEach(System.out::println);

	        // 4. Group by status
	        System.out.println("\n=== Group by Status ===");
	        Map<String, List<String>> byStatus = results.stream()
	            .collect(Collectors.groupingBy(
	                r -> r.split("-")[1]));
	        byStatus.forEach((status, list) ->
	            System.out.println(status + ": " + list));

	        // 5. Employee streams
	        System.out.println("\n=== Employee Streams ===");
	        List<String[]> employees = new ArrayList<>();
	        employees.add(new String[]{"Ahmed", "5000", "Finance"});
	        employees.add(new String[]{"Nahlah", "3000", "HR"});
	        employees.add(new String[]{"Sara", "7000", "Finance"});
	        employees.add(new String[]{"Ali", "2000", "IT"});

	        // Get Finance employees earning > 4000
	        System.out.println("Finance > 4000:");
	        employees.stream()
	                 .filter(e -> e[2].equals("Finance"))
	                 .filter(e -> Integer.parseInt(e[1]) > 4000)
	                 .map(e -> e[0] + ": " + e[1])
	                 .forEach(System.out::println);

	        // Total salary
	        int total = employees.stream()
	                             .mapToInt(e -> Integer.parseInt(e[1]))
	                             .sum();
	        System.out.println("Total salary: " + total);
	    }
	}

