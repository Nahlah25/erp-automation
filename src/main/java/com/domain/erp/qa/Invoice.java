package com.domain.erp.qa;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	private int invoiceid;
	private double totalamount;
	private String Customerid;  
    private List<Integer> itemids=new ArrayList<Integer>();
    
	public Invoice(int invoiceid, double totalamount, String Customerid) {

		this.invoiceid = invoiceid;
		this.totalamount = totalamount;
		this.Customerid = Customerid;
		
	}
	//autoboxing
	public void additem(int itemid) {
		itemids.addAll(itemids);
	}
	public void printitems() {
		for(Integer id:itemids) {
			//unboxing
			int unboxed=id;
			System.out.println(unboxed);}}
	public int getInvoiceid() {
		return invoiceid;}
	public double getTotalamount() {
		return totalamount;
	}
	public String getCustomerid() {
		return Customerid;}
	
	public String toString() {
		return "customerid"+Customerid+
				",totalamount"+totalamount+
				",invoiceid"+invoiceid+
				",itemid"+itemids;
	}
    
 


}
