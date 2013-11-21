package com.acmetelecom;

import java.util.Calendar;
import java.util.Date;
import org.joda.time.*;


public class DaytimePeakPeriod 
{

    public boolean offPeak(DateTime time) 
    {
        return (time.getHourOfDay() < 7 || time.getHourOfDay() >= 19);
    }
    
    /*
     * Given an input date, the function returns the next delimiter, either peak
     * or off peak.
     * 
     * e.g. getNextHigherDelimiter(18 Nov, 18.51) will return 18 Nov, 19.00 
     */
    public static DateTime getNextHigherDelimiter(DateTime dt)
    {
    	DateTime answer;
        if(dt.getHourOfDay() >= 7  && dt.getHourOfDay() < 19)
        {
            answer = dt.withHourOfDay(19).withMinuteOfHour(0).withSecondOfMinute(0);
        }	
        else 
        {
            if(dt.getHourOfDay() < 7)
            {
            	answer = dt.withHourOfDay(7).withMinuteOfHour(0).withSecondOfMinute(0);;
            }
            else 
            {
            	answer = dt.plusDays(1);
            	answer = answer.withHourOfDay(7).withMinuteOfHour(0).withSecondOfMinute(0);;
            }
        }
        return answer;
    }
    
    
    /*
     * Given an input date, the function returns the next lower, either peak
     * or off peak.
     * 
     * e.g. getNextLowerDelimiter(18 Nov, 18.51) will return 18 Nov, 7.00 
     */    
    public static DateTime getNextLowerDelimiter(DateTime dt)
    {       
    	DateTime answer;
        if(dt.getHourOfDay() >= 7  && dt.getHourOfDay() < 19)
        {
            answer = dt.withHourOfDay(7).withMinuteOfHour(0).withSecondOfMinute(0);
        }
        else 
        {
            if(dt.getHourOfDay() < 7)
            {
            	answer = dt.plusDays(-1);
            	answer = answer.withHourOfDay(19).withMinuteOfHour(0).withSecondOfMinute(0);
            }
            else 
            {
                answer = dt.withHourOfDay(19).withMinuteOfHour(0).withSecondOfMinute(0);
            }
        }
        return answer;      
    }
    

   /* ALERT:
    * 
    * toStandardSeconds() Throws:
    * UnsupportedOperationException - if the period contains years or months 
    * ArithmeticException - if the number of seconds is too large to be represented
    * 
    */
   public static int getDifferenceInSeconds(DateTime start, DateTime end)
   {
       Period diff = new Period(start, end);
       return diff.toStandardSeconds().getSeconds();
   }
  
   /*
    * ALERT: it might as well thorw some errors as above Seconds immutable Class
    * 
    */
   public static int getDifferenceInHours(DateTime start, DateTime end)
   {
       Period diff = new Period(start, end);
       return diff.toStandardHours().getHours();
   }   
    
}
