# ERP Automation Framework — Core Java

## Overview
Core Java implementation demonstrating production-ready 
skills used in enterprise QA automation for ERP systems.

## Tech Stack
- Java 8
- TestNG
- Maven
- Eclipse IDE

## Project Structure

### domain — ERP Domain Model
- **Product.java** — Encapsulation with price validation
- **Customer.java** — Base customer with discount calculation
- **PremiumCustomer.java** — Loyalty-based discount (Polymorphism)
- **Invoice.java** — Autoboxing/Unboxing with collections
- **Customerrecord.java** — equals/hashCode/toString override
- **Supporttickets.java** — CRM ticket management
- **TestDay18.java** — Integration of all domain classes

### collections — Collections Framework
- **ERPCollections.java** — ArrayList, HashMap, LinkedHashSet,
  PriorityQueue, Comparator, duplicate removal,
  grouping by module, sorting by value

### exceptions — Exception Handling
- **ERPExceptions.java** — Custom exceptions,
  try-with-resources, exception chaining, multi-catch

### streams — Lambda and Streams
- **ERPStreams.java** — filter, map, collect,
  groupingBy, distinct, count, sum

### utils — Framework Utilities
- **ConfigReader.java** — Properties file reading
- **config.properties** — Framework configuration

## Key Concepts Demonstrated
- OOP: Encapsulation, Inheritance, Polymorphism, Abstraction
- Collections: ArrayList, HashMap, HashSet, P
