package com.acmetelecom.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.*;

import com.acmetelecom.ArrayCallLog;
import com.acmetelecom.CallEvent;

import static org.junit.Assert.*;

public class ArrayCallLogTest {
	@Test
	public void testArrayCallLog_1()
		throws Exception {

		ArrayCallLog result = new ArrayCallLog();

		assertNotNull(result);
	}

	@Test
	public void testIterator_1()
		throws Exception {
		ArrayCallLog fixture = new ArrayCallLog();
		fixture.callEvents = new ArrayList<CallEvent>();

		Iterator<CallEvent> result = fixture.iterator();

		assertNotNull(result);
		assertEquals(false, result.hasNext());
	}

	@Test
	public void testLogCallEnd_1()
		throws Exception {
		ArrayCallLog fixture = new ArrayCallLog();
		fixture.callEvents = new ArrayList<CallEvent>();
		String caller = "";
		String callee = "";
		long timestamp = 1L;

		fixture.logCallEnd(caller, callee, timestamp);
	}

	@Test
	public void testLogCallStart_1()
		throws Exception {
		ArrayCallLog fixture = new ArrayCallLog();
		fixture.callEvents = new ArrayList<CallEvent>();
		String caller = "";
		String callee = "";
		long timestamp = 1L;

		fixture.logCallStart(caller, callee, timestamp);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ArrayCallLogTest.class);
	}
}