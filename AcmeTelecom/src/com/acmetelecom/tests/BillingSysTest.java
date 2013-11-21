package com.acmetelecom.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

import com.acmetelecom.APIPrinter;
import com.acmetelecom.ArrayCallLog;
import com.acmetelecom.BillCreator;
import com.acmetelecom.BillingSystem;
import com.acmetelecom.CallLog;
import com.acmetelecom.HtmlBillPrinter;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.CustomerDatabase;
import com.acmetelecom.customer.TariffLibrary;

public class BillingSysTest {
	
	@Test
	public void testBillingSys_1()
		throws Exception {
		CallLog callLog = new ArrayCallLog();
		CustomerDatabase customerDatabase = CentralCustomerDatabase.getInstance();
		TariffLibrary tariffsLibrary = CentralTariffDatabase.getInstance();
		BillCreator billCreator = new BillCreator(new APIPrinter());

		BillingSystem result = new BillingSystem(callLog, customerDatabase, tariffsLibrary, billCreator);

		assertNotNull(result);
	}

	@Test
	public void testCallCompleted_1()
		throws Exception {
		BillingSystem fixture = new BillingSystem(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), CentralTariffDatabase.getInstance(), new BillCreator(new APIPrinter()));
		String caller = "";
		String callee = "";
		Date date = new Date();
		
		fixture.callCompleted(caller, callee, date);

	}

	@Test
	public void testCallInitiated_1()
		throws Exception {
		BillingSystem fixture = new BillingSystem(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), CentralTariffDatabase.getInstance(), new BillCreator(new APIPrinter()));
		String caller = "";
		String callee = "";
		Date date = new Date();
		
		fixture.callCompleted(caller, callee, date);

	}

	@Test
	public void testCreateCustomerBills_1()
		throws Exception {
		BillingSystem fixture = new BillingSystem(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), CentralTariffDatabase.getInstance(), new BillCreator(new APIPrinter()));

		fixture.createCustomerBills();
	}

	@Test
	public void testGetBills_1()
		throws Exception {
		BillingSystem fixture = new BillingSystem(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), CentralTariffDatabase.getInstance(), new BillCreator(new APIPrinter()));
		CallLog callLog = new ArrayCallLog();

		List<String> result = fixture.getBills(callLog);

		assertNotNull(result);
	}

	@Test
	public void testWriteBills_1()
		throws Exception {
		BillingSystem fixture = new BillingSystem(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), CentralTariffDatabase.getInstance(), new BillCreator(new APIPrinter()));
		List<String> bills = new ArrayList<String>();

		fixture.writeBills(bills);

	}

	@Test
	public void testWriteBills_2()
		throws Exception {
		BillingSystem fixture = new BillingSystem(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), CentralTariffDatabase.getInstance(), new BillCreator(new APIPrinter()));
		List<String> bills = new ArrayList<String>();

		fixture.writeBills(bills);

	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BillingSysTest.class);
	}
}