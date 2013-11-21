package com.acmetelecom.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

import com.acmetelecom.ArrayCallLog;
import com.acmetelecom.BillCreator;
import com.acmetelecom.BillingSys;
import com.acmetelecom.CallLog;
import com.acmetelecom.HtmlBillPrinter;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CustomerDatabase;

public class BillingSysTest {
	
	@Test
	public void testBillingSys_1()
		throws Exception {
		CallLog callLog = new ArrayCallLog();
		CustomerDatabase customerDatabase = CentralCustomerDatabase.getInstance();
		BillCreator billCreator = new BillCreator(new HtmlBillPrinter());

		BillingSys result = new BillingSys(callLog, customerDatabase, billCreator);

		// add additional test code here
		assertNotNull(result);
	}

	@Test
	public void testCallCompleted_1()
		throws Exception {
		BillingSys fixture = new BillingSys(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), new BillCreator(new HtmlBillPrinter()));
		String caller = "";
		String callee = "";

		fixture.callCompleted(caller, callee);

	}

	@Test
	public void testCallInitiated_1()
		throws Exception {
		BillingSys fixture = new BillingSys(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), new BillCreator(new HtmlBillPrinter()));
		String caller = "";
		String callee = "";

		fixture.callInitiated(caller, callee);

	}

	@Test
	public void testCreateCustomerBills_1()
		throws Exception {
		BillingSys fixture = new BillingSys(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), new BillCreator(new HtmlBillPrinter()));

		fixture.createCustomerBills();
	}

	@Test
	public void testGetBills_1()
		throws Exception {
		BillingSys fixture = new BillingSys(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), new BillCreator(new HtmlBillPrinter()));
		CallLog callLog = new ArrayCallLog();

		List<String> result = fixture.getBills(callLog);

		assertNotNull(result);
	}

	@Test
	public void testWriteBills_1()
		throws Exception {
		BillingSys fixture = new BillingSys(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), new BillCreator(new HtmlBillPrinter()));
		List<String> bills = new ArrayList<String>();

		fixture.writeBills(bills);

	}

	@Test
	public void testWriteBills_2()
		throws Exception {
		BillingSys fixture = new BillingSys(new ArrayCallLog(), CentralCustomerDatabase.getInstance(), new BillCreator(new HtmlBillPrinter()));
		List<String> bills = new ArrayList<String>();

		fixture.writeBills(bills);

	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BillingSysTest.class);
	}
}