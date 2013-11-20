package com.acmetelecom;

import java.util.Iterator;
import java.util.List;

import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.CustomerDatabase;

// rewritten BillingSystem; left both in for now
public class BillingSys {
	CallLog callLog;
	CustomerRecords customerRecords;
	BillCreator billCreator;
	public BillingSys(CallLog callLog, CustomerRecords customerDatabase, BillCreator billCreator) {
		this.callLog = callLog;
		this.customerRecords = customerRecords;
		this.billCreator = billCreator;
	}

  public void callInitiated(String caller, String callee) {
  	callLog.logCallStart(caller, callee, System.currentTimeMillis());
  }

  public void callCompleted(String caller, String callee) {
  	callLog.logCallEnd(caller, callee, System.currentTimeMillis());
	}

	public void createCustomerBills() {
		writeBills(getBills(callLog));
	}
	
	public List<String> getBills(CallLog callLog) {
		return billCreator.createBills(callLog, customerRecords);
	}
	
	public void writeBills(List<String> bills) {
			for (String bill : bills) {
				System.out.println(bill);
			}
	}
}

