package com.domain.erp.qa;

public class Customer {
	private int id;
	private String name;
 public Customer(int id,String name){
	 this.id=id;
	 this.name=name;
 }
  public double calculateDiscount(double amount) {
	  return 0.0;
  }
 public String tostring() {
	return "customer[id="+id+",name="+name+"]" ;
 }
}
