package com.acmetelecom.tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.*;

import static org.junit.Assert.*;

import com.acmetelecom.Bill;
import com.acmetelecom.Call;
import com.acmetelecom.HtmlBillPrinter;
import com.acmetelecom.customer.Customer;

public class HtmlBillPrinterTest {

	@Test
	public void testHtmlBillPrinter_1()
		throws Exception {

		HtmlBillPrinter result = new HtmlBillPrinter();

		assertNotNull(result);
	}

	@Test
	public void testFormatDate_1()
		throws Exception {
		HtmlBillPrinter fixture = new HtmlBillPrinter();
		DateTime date = new DateTime();

		String result = fixture.formatDate(date);

		assertEquals("11/21/13 4:31 PM", result);
	}

	@Test
	public void testFormatMoney_1()
		throws Exception {
		HtmlBillPrinter fixture = new HtmlBillPrinter();
		BigDecimal pence = new BigDecimal(1.0);

		String result = fixture.formatMoney(pence);

		assertEquals("0.01", result);
	}

	@Test
	public void testPrintBill_1()
		throws Exception {
		HtmlBillPrinter fixture = new HtmlBillPrinter();
		Bill bill = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		String result = fixture.printBill(bill);

		assertNotNull(result);
	}

	@Test
	public void testPrintBill_2()
		throws Exception {
		HtmlBillPrinter fixture = new HtmlBillPrinter();
		Bill bill = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		String result = fixture.printBill(bill);

		assertNotNull(result);
	}

	@Test
	public void testPrintBill_3()
		throws Exception {
		HtmlBillPrinter fixture = new HtmlBillPrinter();
		Bill bill = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		String result = fixture.printBill(bill);

		assertNotNull(result);
	}

	@Test
	public void testPrintBill_4()
		throws Exception {
		HtmlBillPrinter fixture = new HtmlBillPrinter();
		Bill bill = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		String result = fixture.printBill(bill);

		assertNotNull(result);
	}

	@Test
	public void testPrintBill_5()
		throws Exception {
		HtmlBillPrinter fixture = new HtmlBillPrinter();
		Bill bill = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		String result = fixture.printBill(bill);

		assertNotNull(result);
	}

	@Test
	public void testPrintBill_6()
		throws Exception {
		HtmlBillPrinter fixture = new HtmlBillPrinter();
		Bill bill = new Bill(new Customer("", "", ""), new ArrayList<Call>(), new BigDecimal(1.0));

		String result = fixture.printBill(bill);

		assertNotNull(result);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(HtmlBillPrinterTest.class);
	}
}