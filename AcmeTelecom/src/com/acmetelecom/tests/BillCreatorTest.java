package com.acmetelecom.tests;

import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

import com.acmetelecom.ArrayCallLog;
import com.acmetelecom.BillCreator;
import com.acmetelecom.BillPrinter;
import com.acmetelecom.BillingJob;
import com.acmetelecom.CallLog;
import com.acmetelecom.HtmlBillPrinter;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.CustomerDatabase;
import com.acmetelecom.customer.TariffLibrary;

public class BillCreatorTest {
	@Test
	public void testBillCreator_1()
		throws Exception {
		BillPrinter billPrinter = new HtmlBillPrinter();

		BillCreator result = new BillCreator(billPrinter);

		assertNotNull(result);
	}

	@Test
	public void testCreateBills_1()
		throws Exception {
		BillCreator fixture = new BillCreator(new HtmlBillPrinter());
		fixture.billingJob = new BillingJob();
		CallLog log = new ArrayCallLog();
		CustomerDatabase customers = CentralCustomerDatabase.getInstance();
		TariffLibrary tariffLibrary = CentralTariffDatabase.getInstance();

		List<String> result = fixture.createBills(log, customers, tariffLibrary);

		assertNotNull(result);
	}

	@Test
	public void testCreateBills_2()
		throws Exception {
		BillCreator fixture = new BillCreator(new HtmlBillPrinter());
		fixture.billingJob = new BillingJob();
		CallLog log = new ArrayCallLog();
		CustomerDatabase customers = CentralCustomerDatabase.getInstance();
		TariffLibrary tariffLibrary = CentralTariffDatabase.getInstance();

		List<String> result = fixture.createBills(log, customers, tariffLibrary);

		assertNotNull(result);
	}

	@Test
	public void testCreateBills_3()
		throws Exception {
		BillCreator fixture = new BillCreator(new HtmlBillPrinter());
		fixture.billingJob = new BillingJob();
		CallLog log = new ArrayCallLog();
		CustomerDatabase customers = CentralCustomerDatabase.getInstance();
		TariffLibrary tariffLibrary = CentralTariffDatabase.getInstance();
		
		List<String> result = fixture.createBills(log, customers, tariffLibrary);

		assertNotNull(result);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BillCreatorTest.class);
	}
}