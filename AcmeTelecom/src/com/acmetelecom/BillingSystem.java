package com.acmetelecom;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;

import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.CustomerDatabase;
import com.acmetelecom.customer.TariffLibrary;

// rewritten BillingSystem; left both in for now
public class BillingSystem {
	CallLog callLog;
	CustomerDatabase customerDatabase;
	BillCreator billCreator;
	TariffLibrary tariffsLibrary;
	public BillingSystem(CallLog callLog, CustomerDatabase customerDatabase,
			TariffLibrary tariffsLibrary, BillCreator billCreator) {
		this.callLog = callLog;
		this.customerDatabase = customerDatabase;
		this.billCreator = billCreator;
		this.tariffsLibrary = tariffsLibrary;
	}

  public void callInitiated(String caller, String callee, Date date) {
  	callLog.logCallStart(caller, callee, date.getTime());
  }

  public void callCompleted(String caller, String callee, Date date) {
  	callLog.logCallEnd(caller, callee, date.getTime());
	}

	public void createCustomerBills() {
		writeBills(getBills(callLog));
	}
	
	public List<String> getBills(CallLog callLog) {
		return billCreator.createBills(callLog, customerDatabase, tariffsLibrary);
	}
	
	public void writeBills(List<String> bills) {
			for (String bill : bills) {
				System.out.println(bill);
			}
	}
}

