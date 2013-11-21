package com.acmetelecom.tests;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.*;

import com.acmetelecom.Call;
import com.acmetelecom.CallEvent;
import com.acmetelecom.tests.CallTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CallTest {
	public String caleeNumber = "0987654321";
	public Long caleeTime = (long) 1234567;
	public String calerNumber = "0987654322";
	public Long calerTime = (long) 7654321;
	public CallEvent start;
	public CallEvent end; 
	
	@Before
	public void initialize(){
		start = mock(CallEvent.class);
		when(start.getCallee()).thenReturn(caleeNumber);
		when(start.time()).thenReturn(caleeTime);
		
		end = mock(CallEvent.class);
		when(end.getCallee()).thenReturn(caleeNumber);
		when(end.time()).thenReturn(calerTime);
	}

	@Test
	public void testNotNull() {
		Call call = new Call(start, end);
		assertNotNull(call);
	}
	
	@Test
	public void testGetCalee() {
		Call call = new Call(start, end);
		assertEquals(call.getCallee(), caleeNumber);
	}
	
	@Test
	public void testGetDurationSeconds() {
		Call call = new Call(start, end);
		assertEquals(call.getDurationSeconds(), (calerTime-caleeTime)/1000);
	}
	
	@Test
	public void testGetStartTime() {
		Call call = new Call(start, end);
		assertEquals(call.getStartTime(), new DateTime(start.time()));
	}
	
	@Test
	public void testGetEndTime() {
		Call call = new Call(start, end);
		assertEquals(call.getEndTime(), new DateTime(end.time()));
	}
	
	@Test
	public void testCall_1()
		throws Exception {
		CallEvent start = new CallEvent("", "", 1L, CallEvent.Stage.END);
		CallEvent end = new CallEvent("", "", 1L, CallEvent.Stage.END);

		Call result = new Call(start, end);

		assertNotNull(result);
		assertEquals("", result.getCallee());
		assertEquals(0, result.getDurationSeconds());
		assertEquals(null, result.getCost());
	}

	@Test
	public void testGetCallee_1()
		throws Exception {
		Call fixture = new Call(new CallEvent("", "", 1L, CallEvent.Stage.END), new CallEvent("", "", 1L, CallEvent.Stage.END));
		fixture.setCost(new BigDecimal(1.0));

		String result = fixture.getCallee();

		assertEquals("", result);
	}

	@Test
	public void testGetCost_1()
		throws Exception {
		Call fixture = new Call(new CallEvent("", "", 1L, CallEvent.Stage.END), new CallEvent("", "", 1L, CallEvent.Stage.END));
		fixture.setCost(new BigDecimal(1.0));

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
	public void testGetDurationSeconds_1()
		throws Exception {
		Call fixture = new Call(new CallEvent("", "", 1L, CallEvent.Stage.END), new CallEvent("", "", 1L, CallEvent.Stage.END));
		fixture.setCost(new BigDecimal(1.0));

		int result = fixture.getDurationSeconds();

		assertEquals(0, result);
	}

	@Test
	public void testGetEndTime_1()
		throws Exception {
		Call fixture = new Call(new CallEvent("", "", 1L, CallEvent.Stage.END), new CallEvent("", "", 1L, CallEvent.Stage.END));
		fixture.setCost(new BigDecimal(1.0));

		DateTime result = fixture.getEndTime();

		assertNotNull(result);
		assertEquals(1L, result.getMillis());
		assertEquals(1970, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(1, result.getDayOfYear());
		assertEquals(4, result.getDayOfWeek());
		assertEquals(1, result.getDayOfMonth());
		assertEquals(1, result.getWeekOfWeekyear());
		assertEquals(1970, result.getWeekyear());
		assertEquals(1, result.getMonthOfYear());
		assertEquals(1970, result.getYearOfEra());
		assertEquals(70, result.getYearOfCentury());
		assertEquals(19, result.getCenturyOfEra());
		assertEquals(1, result.getMillisOfSecond());
		assertEquals(3600001, result.getMillisOfDay());
		assertEquals(0, result.getSecondOfMinute());
		assertEquals(3600, result.getSecondOfDay());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(60, result.getMinuteOfDay());
		assertEquals(1, result.getHourOfDay());
		assertEquals("1970-01-01T01:00:00.001+01:00", result.toString());
		assertEquals(false, result.isAfterNow());
		assertEquals(true, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetStartTime_1()
		throws Exception {
		Call fixture = new Call(new CallEvent("", "", 1L, CallEvent.Stage.END), new CallEvent("", "", 1L, CallEvent.Stage.END));
		fixture.setCost(new BigDecimal(1.0));

		DateTime result = fixture.getStartTime();

		assertNotNull(result);
		assertEquals(1L, result.getMillis());
		assertEquals(1970, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(1, result.getDayOfYear());
		assertEquals(4, result.getDayOfWeek());
		assertEquals(1, result.getDayOfMonth());
		assertEquals(1, result.getWeekOfWeekyear());
		assertEquals(1970, result.getWeekyear());
		assertEquals(1, result.getMonthOfYear());
		assertEquals(1970, result.getYearOfEra());
		assertEquals(70, result.getYearOfCentury());
		assertEquals(19, result.getCenturyOfEra());
		assertEquals(1, result.getMillisOfSecond());
		assertEquals(3600001, result.getMillisOfDay());
		assertEquals(0, result.getSecondOfMinute());
		assertEquals(3600, result.getSecondOfDay());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(60, result.getMinuteOfDay());
		assertEquals(1, result.getHourOfDay());
		assertEquals("1970-01-01T01:00:00.001+01:00", result.toString());
		assertEquals(false, result.isAfterNow());
		assertEquals(true, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testSetCost_1()
		throws Exception {
		Call fixture = new Call(new CallEvent("", "", 1L, CallEvent.Stage.END), new CallEvent("", "", 1L, CallEvent.Stage.END));
		fixture.setCost(new BigDecimal(1.0));
		BigDecimal cost = new BigDecimal(1.0);

		fixture.setCost(cost);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CallTest.class);
	}
}