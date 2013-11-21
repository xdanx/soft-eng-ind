package com.acmetelecom.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	BillTest.class,
	BillingJobTest.class,
	CallEventTest.class,
	CallTest.class,
	HtmlBillPrinterTest.class,
	DaytimePeakPeriodTest.class,
	BillCreatorTest.class,
	BillingSysTest.class,
	ArrayCallLogTest.class,
	MoneyFormatterTest.class,
})
public class TestAll {

	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
