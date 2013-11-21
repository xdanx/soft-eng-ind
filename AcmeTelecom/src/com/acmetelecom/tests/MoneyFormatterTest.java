package com.acmetelecom.tests;

import java.math.BigDecimal;

import org.junit.*;

import com.acmetelecom.MoneyFormatter;

import static org.junit.Assert.*;

public class MoneyFormatterTest {

	@Test
	public void testPenceToPounds_1()
		throws Exception {
		BigDecimal pence = new BigDecimal(1.0);

		String result = MoneyFormatter.penceToPounds(pence);

		assertEquals("0.01", result);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MoneyFormatterTest.class);
	}
}