package com.acmetelecom;

import java.util.Calendar;
import java.util.Date;
import org.joda.time.*;


class DaytimePeakPeriod {

    public boolean offPeak(DateTime time) 
    {
        int hour = time.getHourOfDay();
        return hour < 7 || hour >= 19;
    }
    
    
    /*
     * Given an input date, the function returns the next delimiter, either peak
     * or off peak.
     * 
     * e.g. getNextHigherDelimiter(18 Nov, 18.51) will return 18 Nov, 19.00 
     */
    public DateTime getNextHigherDelimiter(Date input)
    {
        DateTime dt = new DateTime(input);
        
        if(dt.getHourOfDay() >= 7  && dt.getHourOfDay() < 19)
            dt.withHourOfDay(19);
        else 
        {
            if(dt.getHourOfDay() < 7)
                dt.withHourOfDay(7);
            else 
            {
                dt.plusDays(1);
                dt.withHourOfDay(7);
            }
        }
        return dt;
    }
    
    public DateTime getNextLowerDelimiter(Date input)
    {
        DateTime dt = new DateTime(input);
        
        if(dt.getHourOfDay() >= 7  && dt.getHourOfDay() < 19)
            dt.withHourOfDay(7);
        else 
        {
            if(dt.getHourOfDay() < 7)
            {
                dt.plusDays(-1);
                dt.withHourOfDay(19);
            }
            else 
            {
                dt.withHourOfDay(19);
            }
        }
        return dt;      
    }
}
