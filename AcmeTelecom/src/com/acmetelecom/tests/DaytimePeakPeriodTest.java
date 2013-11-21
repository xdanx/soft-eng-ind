package com.acmetelecom.tests;

import org.joda.time.DateTime;
import org.junit.*;

import com.acmetelecom.DaytimePeakPeriod;

import static org.junit.Assert.*;

public class DaytimePeakPeriodTest {

	@Test
	public void testGetDifferenceInHours_1()
		throws Exception {
		DateTime start = new DateTime();
		DateTime end = new DateTime();

		int result = DaytimePeakPeriod.getDifferenceInHours(start, end);

		assertEquals(0, result);
	}

	@Test
	public void testGetDifferenceInSeconds_1()
		throws Exception {
		DateTime start = new DateTime();
		DateTime end = new DateTime();

		int result = DaytimePeakPeriod.getDifferenceInSeconds(start, end);

		assertEquals(0, result);
	}

	@Test
	public void testGetNextHigherDelimiter_1()
		throws Exception {
		DateTime dt = new DateTime();
		dt.toDateMidnight();
		dt.plusHours(2);
		dt.plusMinutes(50);
		dt.plusSeconds(600);

		DateTime result = DaytimePeakPeriod.getNextHigherDelimiter(dt);

		assertNotNull(result);
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(dt.getDayOfYear(), result.getDayOfYear());
		assertEquals(dt.getDayOfMonth(), result.getDayOfMonth());
		assertEquals(19, result.getHourOfDay());
		assertEquals(2013, result.getWeekyear());
		assertEquals(dt.getMonthOfYear(), result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(true, result.isAfterNow());
		assertEquals(false, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextHigherDelimiter_2()
		throws Exception {
		DateTime dt = new DateTime();
		dt.plusHours(2);
		dt.plusMinutes(50);
		dt.plusSeconds(600);

		DateTime result = DaytimePeakPeriod.getNextHigherDelimiter(dt);

		assertNotNull(result);
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(dt.getDayOfYear(), result.getDayOfYear());
		assertEquals(dt.getDayOfMonth(), result.getDayOfMonth());
		assertEquals(19, result.getHourOfDay());
		assertEquals(2013, result.getWeekyear());
		assertEquals(dt.getMonthOfYear(), result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(true, result.isAfterNow());
		assertEquals(false, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextHigherDelimiter_3()
		throws Exception {
		DateTime dt = new DateTime();
		dt.plusHours(2);
		dt.plusMinutes(50);
		dt.plusSeconds(600);

		DateTime result = DaytimePeakPeriod.getNextHigherDelimiter(dt);

		assertNotNull(result);
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(dt.getDayOfYear(), result.getDayOfYear());
		assertEquals(dt.getDayOfMonth(), result.getDayOfMonth());
		assertEquals(19, result.getHourOfDay());
		assertEquals(2013, result.getWeekyear());
		assertEquals(dt.getMonthOfYear(), result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(true, result.isAfterNow());
		assertEquals(false, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextLowerDelimiter_1()
		throws Exception {
		DateTime dt = new DateTime();
		dt = dt.toDateMidnight().toDateTime();
		dt = dt.plusHours(2);
		dt = dt.plusMinutes(50);
		dt = dt.plusSeconds(600);

		DateTime result = DaytimePeakPeriod.getNextLowerDelimiter(dt);

		assertNotNull(result);
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(dt.getDayOfYear()-1, result.getDayOfYear());
		assertEquals(dt.getDayOfMonth()-1, result.getDayOfMonth());
		assertEquals(19, result.getHourOfDay());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(1140, result.getMinuteOfDay());
		assertEquals(false, result.isAfterNow());
		assertEquals(true, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextLowerDelimiter_2()
		throws Exception {
		DateTime dt = new DateTime();
		dt.toDateMidnight();
		dt.plusHours(2);
		dt.plusMinutes(50);
		dt.plusSeconds(600);

		DateTime result = DaytimePeakPeriod.getNextLowerDelimiter(dt);

		assertNotNull(result);
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(dt.getDayOfYear(), result.getDayOfYear());
		assertEquals(dt.getDayOfMonth(), result.getDayOfMonth());
		assertEquals(7, result.getHourOfDay());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(420, result.getMinuteOfDay());
		assertEquals(false, result.isAfterNow());
		assertEquals(true, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextLowerDelimiter_3()
		throws Exception {
		DateTime dt = new DateTime();
		dt = dt.toDateMidnight().toDateTime();
		dt = dt.plusHours(2);
		dt = dt.plusMinutes(50);
		dt = dt.plusSeconds(600);

		DateTime result = DaytimePeakPeriod.getNextLowerDelimiter(dt);

		assertNotNull(result);
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(dt.getDayOfYear()-1, result.getDayOfYear());
		assertEquals(dt.getDayOfMonth()-1, result.getDayOfMonth());
		assertEquals(19, result.getHourOfDay());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(1140, result.getMinuteOfDay());
		assertEquals(false, result.isAfterNow());
		assertEquals(true, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testOffPeak_1()
		throws Exception {
		DaytimePeakPeriod fixture = new DaytimePeakPeriod();
		DateTime time = new DateTime();

		boolean result = fixture.offPeak(time);

		assertEquals(false, result);
	}

	@Test
	public void testOffPeak_2()
		throws Exception {
		DaytimePeakPeriod fixture = new DaytimePeakPeriod();
		DateTime time = new DateTime();

		boolean result = fixture.offPeak(time);

		assertEquals(false, result);
	}

	@Test
	public void testOffPeak_3()
		throws Exception {
		DaytimePeakPeriod fixture = new DaytimePeakPeriod();
		DateTime time = new DateTime();

		boolean result = fixture.offPeak(time);

		assertEquals(false, result);
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DaytimePeakPeriodTest.class);
	}
}