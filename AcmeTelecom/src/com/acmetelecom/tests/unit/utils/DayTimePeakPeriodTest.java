/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acmetelecom.tests.unit.utils;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.acmetelecom.utils.DaytimePeakPeriod;
import org.joda.time.DateTime;
/**
 *
 * @author rr2210
 */
public class DayTimePeakPeriodTest 
{
	public String calleeNumber = "0987654321";
	public String callerNumber = "1234567890";
	public long time = 10;
	
	@Test
	public void testOffPeak() 
        {
            DaytimePeakPeriod period = new DaytimePeakPeriod();
            DateTime          dt     = new DateTime();

            dt.toDateMidnight();
            assertEquals("midnight is always offPeak ", period.offPeak(dt), true);
            
            dt.plusHours(7);
            assertEquals("7 o'clock ", period.offPeak(dt), false);            

            dt.plusHours(3);
            assertEquals("10 o'clock ", period.offPeak(dt), false);     
            
            dt.plusHours(8); 
            dt.plusMinutes(59);
            assertEquals("18:59 o'clock ", period.offPeak(dt), false); 
            
            dt.plusMinutes(1);
            assertEquals("19 o'clock ", period.offPeak(dt), true);             
	}
        

        
	@Test
	public void getDifferenceInSecondsTest() 
        {
            DateTime dt1 = new DateTime();
            DateTime dt2 = new DateTime();
		
            dt1.toDateMidnight(); dt1.plusYears(100000);
            dt2.toDateMidnight(); dt2.plusYears(-100000);
            
            assertTrue("seconds between for a long call of 200000 years ", DaytimePeakPeriod.getDifferenceInSeconds(dt1, dt2) > 0 );
	}         
        
        
	@Test
	public void getDifferenceInSecondsHoursTest() 
        {
            DateTime dt1 = new DateTime();
            DateTime dt2 = new DateTime();
		
            dt1.toDateMidnight(); dt1.plusYears(1000000);
            dt2.toDateMidnight(); dt2.plusYears(-1000000);
            
            assertTrue("hours between for a long call of 200000 years ", DaytimePeakPeriod.getDifferenceInHours(dt1, dt2) > 0 );
	}         
        
	
	@Test
	public void getNextHigherDelimiterTest() 
        {
            DateTime dt = new DateTime();
            dt.toDateMidnight(); 
            dt.plusHours(5);
            
            assertEquals("next higher delimiter of 5 ", DaytimePeakPeriod.getNextHigherDelimiter(dt).getHourOfDay(), 7);
            
            dt.plusHours(2);
            assertEquals("next higher delimiter of 7 ", DaytimePeakPeriod.getNextHigherDelimiter(dt).getHourOfDay(), 19);           

            dt.plusHours(3);
            assertEquals("next higher delimiter of 10 ", DaytimePeakPeriod.getNextHigherDelimiter(dt).getHourOfDay(), 19);     
            
            dt.plusHours(8); 
            dt.plusMinutes(59);
            assertEquals("next higher delimiter of 18:59 ", DaytimePeakPeriod.getNextHigherDelimiter(dt).getHourOfDay(), 19); 
            
            dt.plusHours(5);
            assertEquals("next higher delimiter of 23:59 ", DaytimePeakPeriod.getNextHigherDelimiter(dt).getHourOfDay(), 7);  
	} 
        
        
	@Test
	public void getNextLowerDelimiterTest() 
        {
            DateTime dt = new DateTime();
            
            
            dt.toDateMidnight(); 
            dt.plusHours(5);
            
            assertEquals("next lower delimiter of 5 ", DaytimePeakPeriod.getNextLowerDelimiter(dt).getHourOfDay(), 19);
            
            dt.plusHours(2);
            assertEquals("next lower delimiter of 7 ", DaytimePeakPeriod.getNextLowerDelimiter(dt).getHourOfDay(), 7);           

            dt.plusHours(3);
            assertEquals("next lower delimiter of 10 ", DaytimePeakPeriod.getNextLowerDelimiter(dt).getHourOfDay(), 7);     
            
            dt.plusHours(8); 
            dt.plusMinutes(59);
            assertEquals("next lower delimiter of 18:59 ", DaytimePeakPeriod.getNextLowerDelimiter(dt).getHourOfDay(), 7); 
            
            dt.plusHours(5);
            assertEquals("next lower delimiter of 23:59 ", DaytimePeakPeriod.getNextLowerDelimiter(dt).getHourOfDay(), 19);  
	}         

}