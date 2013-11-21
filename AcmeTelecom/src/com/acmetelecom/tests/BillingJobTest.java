package com.acmetelecom.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.*;

import static org.junit.Assert.*;

import com.acmetelecom.ArrayCallLog;
import com.acmetelecom.Bill;
import com.acmetelecom.BillingJob;
import com.acmetelecom.Call;
import com.acmetelecom.CallEvent;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.Tariff;

public class BillingJobTest {
	@Test
	public void testAggregateCalls_1()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Iterable<CallEvent> callEvents = new ArrayCallLog();

		Map<String, List<CallEvent>> result = fixture.aggregateCalls(callEvents);

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testAggregateCalls_2()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Iterable<CallEvent> callEvents = new ArrayCallLog();

		Map<String, List<CallEvent>> result = fixture.aggregateCalls(callEvents);

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testAggregateCalls_3()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Iterable<CallEvent> callEvents = new ArrayCallLog();

		Map<String, List<CallEvent>> result = fixture.aggregateCalls(callEvents);

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testCreateBill_1()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Customer customer = new Customer("", "", "");
		List<CallEvent> callEvents = new ArrayList<CallEvent>();
		Tariff tariff = Tariff.Business;
		
		Bill result = fixture.createBill(customer, tariff, callEvents);

		assertNotNull(result);
	}

	@Test
	public void testCreateBill_2()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Customer customer = new Customer("", "", "");
		List<CallEvent> callEvents = new ArrayList<CallEvent>();
		Tariff tariff = Tariff.Business;
		
		Bill result = fixture.createBill(customer, tariff, callEvents);

		assertNotNull(result);
	}

	@Test
	public void testCreateBill_3()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Customer customer = new Customer("", "", "");
		List<CallEvent> callEvents = new ArrayList<CallEvent>();
		Tariff tariff = Tariff.Business;
		
		Bill result = fixture.createBill(customer, tariff, callEvents);

		assertNotNull(result);
	}

	@Test
	public void testCreateBill_4()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Customer customer = new Customer("", "", "");
		List<CallEvent> callEvents = new ArrayList<CallEvent>();
		Tariff tariff = Tariff.Business;
		
		Bill result = fixture.createBill(customer, tariff, callEvents);

		assertNotNull(result);
	}

	@Test
	public void testCreateBill_5()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Customer customer = new Customer("", "", "");
		List<CallEvent> callEvents = new ArrayList<CallEvent>();
		Tariff tariff = Tariff.Business;
		
		Bill result = fixture.createBill(customer, tariff, callEvents);

		assertNotNull(result);
	}

	@Test
	public void testCreateBill_6()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Customer customer = new Customer("", "", "");
		List<CallEvent> callEvents = new ArrayList<CallEvent>();
		Tariff tariff = Tariff.Business;
		
		Bill result = fixture.createBill(customer, tariff, callEvents);

		assertNotNull(result);
	}

	@Test
	public void testCreateBill_7()
		throws Exception {
		BillingJob fixture = new BillingJob();
		Customer customer = new Customer("", "", "");
		List<CallEvent> callEvents = new ArrayList<CallEvent>();
		Tariff tariff = Tariff.Business;
		
		Bill result = fixture.createBill(customer, tariff, callEvents);

		assertNotNull(result);
	}

	@Test
	public void testGetCalls_1()
		throws Exception {
		BillingJob fixture = new BillingJob();
		List<CallEvent> callEvents = new ArrayList<CallEvent>();

		List<Call> result = fixture.getCalls(callEvents);

		assertEquals(null, result);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BillingJobTest.class);
	}
}