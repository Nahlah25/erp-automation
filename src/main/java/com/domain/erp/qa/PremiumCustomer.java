package com.domain.erp.qa;

public class PremiumCustomer extends Customer {
	private int loyaltypoints;
	
	public PremiumCustomer(int id, String name,int loyaltypoints) {
		super(id, name);
		this.loyaltypoints=loyaltypoints;
	
	}
	
@Override
public double calculateDiscount(double amount) {
	return amount*(loyaltypoints/100.0);
}
public String toString() {
	return super.tostring()+",loyaltypoints="+loyaltypoints;
}
}
 
		
