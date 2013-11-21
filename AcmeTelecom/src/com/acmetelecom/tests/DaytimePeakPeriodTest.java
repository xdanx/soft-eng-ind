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

		DateTime result = DaytimePeakPeriod.getNextHigherDelimiter(dt);

		assertNotNull(result);
		assertEquals(1385060400026L, result.getMillis());
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(325, result.getDayOfYear());
		assertEquals(4, result.getDayOfWeek());
		assertEquals(21, result.getDayOfMonth());
		assertEquals(19, result.getHourOfDay());
		assertEquals(47, result.getWeekOfWeekyear());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(13, result.getYearOfCentury());
		assertEquals(20, result.getCenturyOfEra());
		assertEquals(26, result.getMillisOfSecond());
		assertEquals(68400026, result.getMillisOfDay());
		assertEquals(0, result.getSecondOfMinute());
		assertEquals(68400, result.getSecondOfDay());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(1140, result.getMinuteOfDay());
		assertEquals("2013-11-21T19:00:00.026Z", result.toString());
		assertEquals(true, result.isAfterNow());
		assertEquals(false, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextHigherDelimiter_2()
		throws Exception {
		DateTime dt = new DateTime();

		DateTime result = DaytimePeakPeriod.getNextHigherDelimiter(dt);

		assertNotNull(result);
		assertEquals(1385060400053L, result.getMillis());
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(325, result.getDayOfYear());
		assertEquals(4, result.getDayOfWeek());
		assertEquals(21, result.getDayOfMonth());
		assertEquals(19, result.getHourOfDay());
		assertEquals(47, result.getWeekOfWeekyear());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(13, result.getYearOfCentury());
		assertEquals(20, result.getCenturyOfEra());
		assertEquals(53, result.getMillisOfSecond());
		assertEquals(68400053, result.getMillisOfDay());
		assertEquals(0, result.getSecondOfMinute());
		assertEquals(68400, result.getSecondOfDay());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(1140, result.getMinuteOfDay());
		assertEquals("2013-11-21T19:00:00.053Z", result.toString());
		assertEquals(true, result.isAfterNow());
		assertEquals(false, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextHigherDelimiter_3()
		throws Exception {
		DateTime dt = new DateTime();

		DateTime result = DaytimePeakPeriod.getNextHigherDelimiter(dt);

		assertNotNull(result);
		assertEquals(1385060400055L, result.getMillis());
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(325, result.getDayOfYear());
		assertEquals(4, result.getDayOfWeek());
		assertEquals(21, result.getDayOfMonth());
		assertEquals(19, result.getHourOfDay());
		assertEquals(47, result.getWeekOfWeekyear());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(13, result.getYearOfCentury());
		assertEquals(20, result.getCenturyOfEra());
		assertEquals(55, result.getMillisOfSecond());
		assertEquals(68400055, result.getMillisOfDay());
		assertEquals(0, result.getSecondOfMinute());
		assertEquals(68400, result.getSecondOfDay());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(1140, result.getMinuteOfDay());
		assertEquals("2013-11-21T19:00:00.055Z", result.toString());
		assertEquals(true, result.isAfterNow());
		assertEquals(false, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextLowerDelimiter_1()
		throws Exception {
		DateTime dt = new DateTime();

		DateTime result = DaytimePeakPeriod.getNextLowerDelimiter(dt);

		assertNotNull(result);
		assertEquals(1385017200056L, result.getMillis());
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(325, result.getDayOfYear());
		assertEquals(4, result.getDayOfWeek());
		assertEquals(21, result.getDayOfMonth());
		assertEquals(7, result.getHourOfDay());
		assertEquals(47, result.getWeekOfWeekyear());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(13, result.getYearOfCentury());
		assertEquals(20, result.getCenturyOfEra());
		assertEquals(56, result.getMillisOfSecond());
		assertEquals(25200056, result.getMillisOfDay());
		assertEquals(0, result.getSecondOfMinute());
		assertEquals(25200, result.getSecondOfDay());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(420, result.getMinuteOfDay());
		assertEquals("2013-11-21T07:00:00.056Z", result.toString());
		assertEquals(false, result.isAfterNow());
		assertEquals(true, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextLowerDelimiter_2()
		throws Exception {
		DateTime dt = new DateTime();

		DateTime result = DaytimePeakPeriod.getNextLowerDelimiter(dt);

		assertNotNull(result);
		assertEquals(1385017200057L, result.getMillis());
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(325, result.getDayOfYear());
		assertEquals(4, result.getDayOfWeek());
		assertEquals(21, result.getDayOfMonth());
		assertEquals(7, result.getHourOfDay());
		assertEquals(47, result.getWeekOfWeekyear());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(13, result.getYearOfCentury());
		assertEquals(20, result.getCenturyOfEra());
		assertEquals(57, result.getMillisOfSecond());
		assertEquals(25200057, result.getMillisOfDay());
		assertEquals(0, result.getSecondOfMinute());
		assertEquals(25200, result.getSecondOfDay());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(420, result.getMinuteOfDay());
		assertEquals("2013-11-21T07:00:00.057Z", result.toString());
		assertEquals(false, result.isAfterNow());
		assertEquals(true, result.isBeforeNow());
		assertEquals(false, result.isEqualNow());
	}

	@Test
	public void testGetNextLowerDelimiter_3()
		throws Exception {
		DateTime dt = new DateTime();

		DateTime result = DaytimePeakPeriod.getNextLowerDelimiter(dt);

		assertNotNull(result);
		assertEquals(1385017200058L, result.getMillis());
		assertEquals(2013, result.getYear());
		assertEquals(1, result.getEra());
		assertEquals(325, result.getDayOfYear());
		assertEquals(4, result.getDayOfWeek());
		assertEquals(21, result.getDayOfMonth());
		assertEquals(7, result.getHourOfDay());
		assertEquals(47, result.getWeekOfWeekyear());
		assertEquals(2013, result.getWeekyear());
		assertEquals(11, result.getMonthOfYear());
		assertEquals(2013, result.getYearOfEra());
		assertEquals(13, result.getYearOfCentury());
		assertEquals(20, result.getCenturyOfEra());
		assertEquals(58, result.getMillisOfSecond());
		assertEquals(25200058, result.getMillisOfDay());
		assertEquals(0, result.getSecondOfMinute());
		assertEquals(25200, result.getSecondOfDay());
		assertEquals(0, result.getMinuteOfHour());
		assertEquals(420, result.getMinuteOfDay());
		assertEquals("2013-11-21T07:00:00.058Z", result.toString());
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