package com.domain.erp.qa;

public class Customertest {

	public static void main(String[] args) {
		Customer cus=new Customer(100,"nahlah");
		PremiumCustomer pre=new PremiumCustomer(200,"ali",20);
		
		System.out.println(cus);
		System.out.println("normalcustomer"+cus.calculateDiscount(500));
		System.out.println(pre);
		System.out.println("premiumcustomer"+pre.calculateDiscount(500));
		

	}

}
