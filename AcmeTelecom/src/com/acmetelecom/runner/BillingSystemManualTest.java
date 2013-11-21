package com.acmetelecom.runner;

import java.util.List;

import com.acmetelecom.ArrayCallLog;
import com.acmetelecom.BillCreator;
import com.acmetelecom.CallLog;
import com.acmetelecom.HtmlBillPrinter;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.CustomerDatabase;

public class BillingSystemManualTest {
	public static void main(String[] args) {
		CallLog log = new ArrayCallLog();
		long time = 12 * 3600 * 1000;
		log.logCallStart("447722113434", "447766511332", time);
		
		time += 20000;
		log.logCallEnd("447722113434", "447766511332", time);
		log.logCallStart("447722113434", "447711111111", time);
		
		time += 30000;
		log.logCallEnd("447722113434", "447711111111", time);
		log.logCallStart("447777765432", "447711111111", time);
		time += 3600000;
		log.logCallEnd("447777765432", "447711111111", time);
		
		BillCreator billCreator = new BillCreator(new HtmlBillPrinter());
		List<String> bills = billCreator.createBills(log, CentralCustomerDatabase.getInstance(),
																									CentralTariffDatabase.getInstance());
		for (String bill : bills) {
			System.out.println(bill);
		}
	}
}
