package com.acmetelecom;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Call {
    private CallEvent start;
    private CallEvent end;
    // normally doesn't belong here but this makes code smaller
    private BigDecimal cost;
        
    public Call(CallEvent start, CallEvent end) {
        this.start = start;
        this.end = end;
    }

    public String getCallee() {
        return start.getCallee();
    }

    public int getDurationSeconds() {
        return (int) (((end.time() - start.time()) / 1000));
    }
     
    public Date getStartTime() {
        return new Date(start.time());
    }

    public Date getEndTime() {
        return new Date(end.time());
    }
    
    public BigDecimal getCost() {
    	return cost;
    }
    
    public void setCost(BigDecimal cost) {
    	this.cost = cost;
    }
}
