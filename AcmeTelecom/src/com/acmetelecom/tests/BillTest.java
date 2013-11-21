package com.acmetelecom.tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

import com.acmetelecom.Bill;
import com.acmetelecom.Call;
import com.acmetelecom.customer.Customer;

public class BillTest {

	@Test
	public void testBill_1()
		throws Exception {
		Customer customer = new Customer("", "", "");
		List<Call> calls = new ArrayList<Call>();
		BigDecimal totalCost = new BigDecimal(1.0);

		Bill result = new Bill(customer, calls, totalCost);

		assertNotNull(result);
	}

	@Test
	public void testGetCalls_1()
		throws Exception {
		Bill fixture = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		List<Call> result = fixture.getCalls();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetCost_1()
		throws Exception {
		Bill fixture = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		BigDecimal result = fixture.getCost();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
		assertEquals(1, result.signum());
		assertEquals(0, result.scale());
		assertEquals(1, result.precision());
		assertEquals("1", result.toEngineeringString());
		assertEquals("1", result.toPlainString());
		assertEquals(1L, result.longValueExact());
		assertEquals(1, result.intValueExact());
		assertEquals((short) 1, result.shortValueExact());
		assertEquals((byte) 1, result.byteValueExact());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
	}

	@Test
	public void testGetCustomer_1()
		throws Exception {
		Bill fixture = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		Customer result = fixture.getCustomer();

		assertNotNull(result);
		assertEquals("", result.getFullName());
		assertEquals("", result.getPhoneNumber());
		assertEquals("", result.getPricePlan());
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BillTest.class);
	}
}