package com.acmetelecom;

import com.acmetelecom.utils.DaytimePeakPeriod;
import com.acmetelecom.BillGenerator;
import com.acmetelecom.calls.Call;
import com.acmetelecom.calls.CallEnd;
import com.acmetelecom.calls.CallEvent;
import com.acmetelecom.calls.CallStart;
import com.acmetelecom.utils.MoneyFormatter;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.Tariff;
import com.acmetelecom.utils.LineItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import org.joda.time.*;

public class BillingSystem 
{

    private List<CallEvent> callLog = new ArrayList<CallEvent>();

    public void callInitiated(String caller, String callee) {
        callLog.add(new CallStart(caller, callee));
    }

    public void callCompleted(String caller, String callee) {
        callLog.add(new CallEnd(caller, callee));
    }

    public void createCustomerBills() {
        List<Customer> customers = CentralCustomerDatabase.getInstance().getCustomers();
        for (Customer customer : customers) {
            createBillFor(customer);
        }
        callLog.clear();
    }

  

    /**
     * 
     * @param customer 
     * rr2210
     */
    protected void createBillFor(Customer customer)
    {
        
        List<CallEvent> customerEvents = new ArrayList<CallEvent>();
        List<Call> calls               = new ArrayList<Call>();
        List<LineItem> items           = new ArrayList<LineItem>();
        DaytimePeakPeriod peakPeriod   = new DaytimePeakPeriod();
        BigDecimal totalBill           = new BigDecimal("0");
        BigDecimal cost                = new BigDecimal("0");
        CallEvent start 	       = null;
        
        for (CallEvent callEvent : callLog) 
            if (callEvent.getCaller().equals(customer.getPhoneNumber())) 
                customerEvents.add(callEvent);

        for (CallEvent event : customerEvents) 
        {
            if (event instanceof CallStart) 
                start = event;
            if (event instanceof CallEnd && start != null) 
            {
                calls.add(new Call(start, event));
                start = null;
            }
        }

               
        for (Call call : calls) 
        {
            /* Declarations */
            Tariff tariff = CentralTariffDatabase.getInstance().tarriffFor(customer);
            cost = new BigDecimal("0");
            DateTime startCall             = call.startTime();
            DateTime endCall               = call.endTime();
            DateTime startHigherDelimiter  = DaytimePeakPeriod.getNextHigherDelimiter(startCall); 
            DateTime endLowerDelimiter     = DaytimePeakPeriod.getNextLowerDelimiter(endCall);
            boolean isStartCallPeak        = !peakPeriod.offPeak(call.startTime());
            boolean isEndCallPeak          = !peakPeriod.offPeak(call.endTime());

            
            /* if the startcall and end call are in the same interval */
            if(startHigherDelimiter.isAfter(endLowerDelimiter))
            {
                int callDuration = DaytimePeakPeriod.getDifferenceInSeconds(startCall, endCall);
                if(isStartCallPeak)
                    cost = cost.add (new BigDecimal(callDuration).multiply(tariff.peakRate()));
                else
                    cost = cost.add (new BigDecimal(callDuration).multiply(tariff.offPeakRate()));
            }
            /* if the startcall and end call are NOT in the same interval */
            else
            {
                int startCallToHigherDelimiter         = DaytimePeakPeriod.getDifferenceInSeconds(startCall, startHigherDelimiter);
                int endCallToLowerDelimiter            = DaytimePeakPeriod.getDifferenceInSeconds(endLowerDelimiter, endCall); 
                int differenceBetweenDelimitersInHours = DaytimePeakPeriod.getDifferenceInHours(startHigherDelimiter, endLowerDelimiter);
                int numberOf12HoursIntervals           = differenceBetweenDelimitersInHours/12;
                
                /* IF # intervals is even. */
                // Attention: 
            	// Number of seconds is: new BigDecimal((12*3600*(numberOf12HoursIntervals + 1))/2

                if(numberOf12HoursIntervals %2 == 0)
                {
                    if(isStartCallPeak)
                    {
                        cost = cost.add(new BigDecimal (startCallToHigherDelimiter).multiply(tariff.peakRate()));
                        cost = cost.add(new BigDecimal (21600 * numberOf12HoursIntervals).multiply(tariff.peakRate())); 
                        cost = cost.add(new BigDecimal (21600 * numberOf12HoursIntervals).multiply(tariff.offPeakRate()));   
                        cost = cost.add(new BigDecimal (endCallToLowerDelimiter).multiply(tariff.offPeakRate()));
                    }
                    else
                    {
                    	cost = cost.add(new BigDecimal (startCallToHigherDelimiter).multiply(tariff.offPeakRate()));
                    	cost = cost.add(new BigDecimal (21600 * numberOf12HoursIntervals).multiply(tariff.peakRate())); 
                    	cost = cost.add(new BigDecimal (21600 * numberOf12HoursIntervals).multiply(tariff.offPeakRate()));   
                    	cost = cost.add(new BigDecimal (endCallToLowerDelimiter).multiply(tariff.peakRate()));                        
                    }
                }
                /* IF # intervals is odd. */
                else
                {
                    if(isStartCallPeak)
                    {
                    	cost = cost.add(new BigDecimal (startCallToHigherDelimiter).multiply(tariff.peakRate()));
                    	cost = cost.add(new BigDecimal (21600 * (numberOf12HoursIntervals - 1)).multiply(tariff.peakRate())); 
                    	cost = cost.add(new BigDecimal (21600 * (numberOf12HoursIntervals + 1)).multiply(tariff.offPeakRate()));   
                    	cost = cost.add(new BigDecimal (endCallToLowerDelimiter).multiply(tariff.peakRate()));
                    }
                    else
                    {
                    	cost = cost.add(new BigDecimal (startCallToHigherDelimiter).multiply(tariff.offPeakRate()));
                    	cost = cost.add(new BigDecimal (21600 * (numberOf12HoursIntervals + 1)).multiply(tariff.peakRate()));
                    	cost = cost.add(new BigDecimal (21600 * (numberOf12HoursIntervals - 1)).multiply(tariff.offPeakRate()));   
                    	cost = cost.add(new BigDecimal (endCallToLowerDelimiter).multiply(tariff.offPeakRate()));                        
                    }                    
                }
            }

            cost = cost.setScale(0, RoundingMode.HALF_UP);
            BigDecimal callCost = cost;
            totalBill = totalBill.add(callCost);
            items.add(new LineItem(call, callCost));
        }

        new BillGenerator().send(customer, items, MoneyFormatter.penceToPounds(totalBill));
        
    }
    
    // Debug functions
    public void debugCallInitiated(String caller, String callee, long ts) {
        callLog.add(new CallStart(caller, callee, ts));
    }

    public void debugCallCompleted(String caller, String callee, long ts) {
        callLog.add(new CallEnd(caller, callee, ts));
    }
   
    
    // Old functions, not used  
    private void oldCreateBillFor(Customer customer) {
        List<CallEvent> customerEvents = new ArrayList<CallEvent>();
        for (CallEvent callEvent : callLog) {
            if (callEvent.getCaller().equals(customer.getPhoneNumber())) {
                customerEvents.add(callEvent);
            }
        }

        List<Call> calls = new ArrayList<Call>();

        CallEvent start = null;
        for (CallEvent event : customerEvents) {
            if (event instanceof CallStart) {
                start = event;
            }
            if (event instanceof CallEnd && start != null) {
                calls.add(new Call(start, event));
                start = null;
            }
        }

        BigDecimal totalBill = new BigDecimal(0);
        List<LineItem> items = new ArrayList<LineItem>();

        for (Call call : calls) {

            Tariff tariff = CentralTariffDatabase.getInstance().tarriffFor(customer);

            BigDecimal cost;

            DaytimePeakPeriod peakPeriod = new DaytimePeakPeriod();
            System.out.println(
                    peakPeriod.getDifferenceInSeconds(call.startTime(), call.endTime())
                    );
            if (	peakPeriod.offPeak(call.startTime()) && 
            		peakPeriod.offPeak(call.endTime()) && 
            		call.durationSeconds() < 12 * 60 * 60) 
            {
                cost = new BigDecimal(call.durationSeconds()).multiply(tariff.offPeakRate());
            } 
            else 
            {
                cost = new BigDecimal(call.durationSeconds()).multiply(tariff.peakRate());
            }

            cost = cost.setScale(0, RoundingMode.HALF_UP);
            BigDecimal callCost = cost;
            totalBill = totalBill.add(callCost);
            items.add(new LineItem(call, callCost));
        }

        new BillGenerator().send(customer, items, MoneyFormatter.penceToPounds(totalBill));
    }


}
