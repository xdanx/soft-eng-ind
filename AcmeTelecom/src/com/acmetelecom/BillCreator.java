package com.acmetelecom;

import java.util.Iterator;
import java.util.Map;
import java.util.List;

import com.acmetelecom.customer.*;

public class BillCreator {
	
	public BillingJob billingJob;
	public BillPrinter billPrinter;
	
	public BillCreator(BillingJob billJob) {
		this.billingJob = billJob;
	}
	
	public List<String> createBills(CallLog log, CustomerRecords customers) {
		Map<String, List<CallEvent>> callers = billingJob.aggregateCalls(log);
		List<String> printedBills = new ArrayList<String>();
		for (String caller : callers.keySet()) {
			Bill bill = billingJob.createBill(caller, callers.get(caller));
			bill.setCustomerName(customers.getCustomerName(caller));
			printedBills.add(billPrinter.printBill(bill));
		}
		return printedBills;
	}
}
