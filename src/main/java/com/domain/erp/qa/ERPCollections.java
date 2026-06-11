package com.domain.erp.qa;

import java.util.*;
import java.util.stream.*;

public class ERPCollections {
// Program 1 — Remove duplicates preserving order
    public static void removeDuplicates() {
        System.out.println("=== P1: Remove Duplicates ===");

        List<Integer> empIds = new ArrayList<>();
        empIds.add(101); empIds.add(102);
        empIds.add(101); empIds.add(103);
        empIds.add(102);

        System.out.println("Before: " + empIds);

        Set<Integer> unique = new LinkedHashSet<>(empIds);
        List<Integer> result = new ArrayList<>(unique);

        System.out.println("After: " + result);
    }

    // Program 2 — Group test results by module
    public static void groupByModule() {
        System.out.println("\n=== P2: Group by Module ===");

        List<String> results = new ArrayList<>();
        results.add("Login_TC001-PASS");
        results.add("Invoice_TC001-FAIL");
        results.add("Login_TC002-PASS");
        results.add("Payroll_TC001-FAIL");
        results.add("Invoice_TC002-FAIL");

        Map<String, List<String>> grouped = new HashMap<>();

        for (String r : results) {
            String module = r.split("_")[0];
            if (!grouped.containsKey(module)) {
                grouped.put(module, new ArrayList<>());
            }
            grouped.get(module).add(r);
        }

        for (Map.Entry<String, List<String>> entry 
                : grouped.entrySet()) {
            System.out.println(entry.getKey() + 
                             ": " + entry.getValue());
        }
    }

    // Program 3 — Sort HashMap by value
    public static void sortByValue() {
        System.out.println("\n=== P3: Sort by Value ===");

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("Ahmed", 5000);
        salaries.put("Nahlah", 3000);
        salaries.put("Sara", 7000);
        salaries.put("Ali", 2000);

        List<Map.Entry<String, Integer>> list =
            new ArrayList<>(salaries.entrySet());

        list.sort((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() +
                             ": " + entry.getValue());
        }
    }

    // Program 4 — Intersection of two lists
    public static void listIntersection() {
        System.out.println("\n=== P4: List Intersection ===");

        List<String> erpTeam = new ArrayList<>(
            Arrays.asList("Ahmed", "Nahlah", "Sara", "Ali"));

        List<String> crmTeam = new ArrayList<>(
            Arrays.asList("Nahlah", "Reem", "Ahmed", "Khalid"));

        List<String> common = new ArrayList<>(erpTeam);
        common.retainAll(crmTeam);

        System.out.println("In both: " + common);
    }

    // Program 5 — Elements in list1 not in list2
    public static void listDifference() {
        System.out.println("\n=== P5: List Difference ===");

        List<String> erpTeam = new ArrayList<>(
            Arrays.asList("Ahmed", "Nahlah", "Sara", "Ali"));

        List<String> crmTeam = new ArrayList<>(
            Arrays.asList("Nahlah", "Reem", "Ahmed", "Khalid"));

        List<String> onlyERP = new ArrayList<>(erpTeam);
        onlyERP.removeAll(crmTeam);

        System.out.println("Only in ERP: " + onlyERP);
    }

    // Program 6 — Top 3 frequent modules
    public static void top3Frequent() {
        System.out.println("\n=== P6: Top 3 Frequent ===");

        List<String> log = Arrays.asList(
            "Login", "Invoice", "Login", "Payroll",
            "Login", "Invoice", "Payroll", "Invoice", "Salary"
        );

        // Count frequency
        Map<String, Integer> freq = new HashMap<>();
        for (String module : log) {
            freq.put(module, freq.getOrDefault(module, 0) + 1);
        }

        // Sort by frequency
        PriorityQueue<Map.Entry<String, Integer>> pq =
            new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        pq.addAll(freq.entrySet());

        System.out.println("Top 3:");
        int count = 0;
        while (!pq.isEmpty() && count < 3) {
            Map.Entry<String, Integer> entry = pq.poll();
            System.out.println(entry.getKey() +
                             ": " + entry.getValue() + " times");
            count++;
        }
    }

    // Program 7 — Employee sort by salary and name
    public static void comparatorSort() {
        System.out.println("\n=== P7: Comparator Sort ===");

        List<String[]> employees = new ArrayList<>();
        employees.add(new String[]{"Sara", "7000"});
        employees.add(new String[]{"Ahmed", "3000"});
        employees.add(new String[]{"Nahlah", "5000"});
        employees.add(new String[]{"Ali", "2000"});

        // Sort by salary
        employees.sort((e1, e2) ->
            Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]));

        System.out.println("By salary:");
        employees.forEach(e ->
            System.out.println(e[0] + ": " + e[1]));

        // Sort by name
        employees.sort((e1, e2) -> e1[0].compareTo(e2[0]));

        System.out.println("By name:");
        employees.forEach(e ->
            System.out.println(e[0] + ": " + e[1]));
    }

    // Program 8 — Duplicate test execution finder
    public static void findDuplicates() {
        System.out.println("\n=== P8: Find Duplicates ===");

        List<String> executedTests = new ArrayList<>();
        executedTests.add("Login_TC01");
        executedTests.add("Invoice_TC01");
        executedTests.add("Login_TC01");
        executedTests.add("Payroll_TC01");
        executedTests.add("Invoice_TC01");
        executedTests.add("Login_TC01");

        Map<String, Integer> counts = new HashMap<>();
        for (String test : executedTests) {
            counts.put(test,
                counts.getOrDefault(test, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry
                : counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() +
                    " → " + entry.getValue() +
                    " times - DUPLICATE");
            } else {
                System.out.println(entry.getKey() +
                    " → 1 time - OK");
            }
        }
    }

    public static void main(String[] args) {
        removeDuplicates();
        groupByModule();
        sortByValue();
        listIntersection();
        listDifference();
        top3Frequent();
        comparatorSort();
        findDuplicates();
    }
}
