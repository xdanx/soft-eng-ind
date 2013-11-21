package com.acmetelecom.runner;

import java.util.List;

import org.joda.time.DateTime;

import com.acmetelecom.ArrayCallLog;
import com.acmetelecom.BillCreator;
import com.acmetelecom.CallLog;
import com.acmetelecom.ConsolePrinter;
import com.acmetelecom.HtmlBillPrinter;
import com.acmetelecom.customer.CentralCustomerDatabase;


public class BillingSystemManualTest {
	public static void main(String[] args) {
		CallLog log = new ArrayCallLog();
		
		DateTime dt		= new DateTime (2010, 11, 13, 18, 30, 00);
		long startCall 	= dt.getMillis();
		// Call ends after an hour
		long endCall 	= dt.plusDays(0).plusHours(1).getMillis();
		
		log.logCallStart("447722113434", "447766511332", startCall);
		log.logCallEnd("447722113434", "447766511332", endCall);

		log.logCallStart("447722113434", "447711111111", startCall);
		log.logCallEnd("447722113434", "447711111111", endCall);
		
		log.logCallStart("447777765432", "447711111111", startCall);
		log.logCallEnd("447777765432", "447711111111", endCall);
		
		BillCreator billCreator = new BillCreator(new ConsolePrinter());
		List<String> bills = billCreator.createBills(log, CentralCustomerDatabase.getInstance());
		for (String bill : bills) {
			System.out.println(bill);
		}
	}
}
