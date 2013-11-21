package com.acmetelecom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import com.acmetelecom.customer.*;

public class BillCreator {
	
	public BillingJob billingJob;
	public BillPrinter billPrinter;
	
	public BillCreator(BillPrinter billPrinter) {
		this.billingJob = new BillingJob();
		this.billPrinter = billPrinter;
	}
	
	public List<String> createBills(CallLog log, CustomerDatabase customers) {
		Map<String, List<CallEvent>> callers = billingJob.aggregateCalls(log);
		List<String> printedBills = new ArrayList<String>();
		for (Customer customer : customers.getCustomers()) {
			List<CallEvent> events = callers.get(customer.getPhoneNumber());
			if (events == null) events = new ArrayList<CallEvent>(); // put an empty list; no calls
			Bill bill = billingJob.createBill(customer, events);
			printedBills.add(billPrinter.printBill(bill));
		}
		return printedBills;
	}
}
