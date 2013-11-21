package com.acmetelecom.tests;

import org.junit.*;

import com.acmetelecom.CallEvent;

import static org.junit.Assert.*;

public class CallEventTest {
	@Test
	public void testCallEvent_1()
		throws Exception {
		String caller = "";
		String callee = "";
		long timeStamp = 1L;
		CallEvent.Stage stage = CallEvent.Stage.END;

		CallEvent result = new CallEvent(caller, callee, timeStamp, stage);

		assertNotNull(result);
		assertEquals(1L, result.time());
		assertEquals("", result.getCaller());
		assertEquals("", result.getCallee());
	}

	@Test
	public void testGetCallee_1()
		throws Exception {
		CallEvent fixture = new CallEvent("", "", 1L, CallEvent.Stage.END);

		String result = fixture.getCallee();

		assertEquals("", result);
	}

	@Test
	public void testGetCaller_1()
		throws Exception {
		CallEvent fixture = new CallEvent("", "", 1L, CallEvent.Stage.END);

		String result = fixture.getCaller();

		assertEquals("", result);
	}

	@Test
	public void testGetStage_1()
		throws Exception {
		CallEvent fixture = new CallEvent("", "", 1L, CallEvent.Stage.END);

		CallEvent.Stage result = fixture.getStage();

		assertNotNull(result);
		assertEquals("END", result.name());
		assertEquals("END", result.toString());
		assertEquals(1, result.ordinal());
	}

	@Test
	public void testTime_1()
		throws Exception {
		CallEvent fixture = new CallEvent("", "", 1L, CallEvent.Stage.END);

		long result = fixture.time();

		assertEquals(1L, result);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CallEventTest.class);
	}
}