package com.domain.erp.qa;

import java.util.ArrayList;
import java.util.List;

public class Supporttickets {
	public Supporttickets(String agentname) {
		this.agentname = agentname;
		
	}
	String agentname;
	List<Integer> ticketids=new ArrayList<Integer>();
	
	//autoboxing
	public void addticketid(int tcid) {
	  ticketids.add(tcid);
	}
	public void printtickets() {
		for(Integer tc:ticketids) {
			int unbox=tc;
			System.out.println(unbox);
		}}
		@Override
		public String toString() {
			return "name="+agentname+ ",ticketid="+ticketids;
		}
		public static void main(String[]args) {
			Supporttickets sup=new Supporttickets("nahlah");
			sup.addticketid(101);
			sup.addticketid(100);
			sup.printtickets();
			System.out.println(sup);
		}
	}

