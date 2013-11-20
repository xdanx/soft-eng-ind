package com.acmetelecom.tests.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calls.CallEvent;
import calls.CallStart;

public class CallStartTest {
	public String calleeNumber = "0987654321";
	public String callerNumber = "1234567890";
	public long time = 10;
	
	@Test
	public void givenACallStartEvent_AllInformationFromCallEventCanBeretrived() {
		CallEvent event = new CallStart(callerNumber, calleeNumber, time);
		
		assertEquals("call numbers should be the same",
					event.getCallee(), calleeNumber);
		assertEquals("caller number should be the same",
					event.getCaller(), callerNumber);
		assertEquals("wrong time", event.time(), time);
	}
	
	@Test
	public void givenACallStartEventWithoutTime_AllInformationFromCallEventCanBeretrived() {
		CallEvent event = new CallStart(callerNumber, calleeNumber);
		Long newTime = System.currentTimeMillis();
		
		assertEquals(event.getCallee(), calleeNumber);
		assertEquals(event.getCaller(), callerNumber);
		assertEquals(event.time()/100, newTime/100);
	} 

}
