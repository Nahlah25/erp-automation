package com.domain.erp.qa;

public class TestDay18 {

    public static void main(String[] args) {

        // Encapsulation - Product
        Product p = new Product(1, "ERP Module", 500);
        p.setPrice(-100);
        p.setPrice(600);
        System.out.println(p);

        // Polymorphism
        Customer cus = new Customer(101, "Ahmed");
        PremiumCustomer pre = new PremiumCustomer(102, "Sara", 3);
        System.out.println("Standard: " + cus.calculateDiscount(0));
        System.out.println("Premium: " + pre.calculateDiscount(3));

        // Autoboxing - Invoice
        Invoice inv = new Invoice(501, 1500.00,"C101");
        inv.additem(201);
        inv.additem(202);
        inv.additem(203);
        inv.printitems();
        System.out.println(inv);

        // equals/hashCode
        Customerecord r1 = new Customerecord(1, "Nahlah");
        Customerecord r2 = new Customerecord(1, "Nahlah");
        Customerecord r3 = new Customerecord(2, "Sara");
        System.out.println("r1 equals r2: " + r1.equals(r2));
        System.out.println("r1 equals r3: " + r1.equals(r3));
        System.out.println(r1);
    }
}