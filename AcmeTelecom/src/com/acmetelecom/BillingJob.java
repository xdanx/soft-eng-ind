package com.acmetelecom;

import java.beans.EventSetDescriptor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.joda.time.DateTime;

import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.Tariff;

import com.acmetelecom.customer.CentralTariffDatabase;


/* resembles the structure of a map-reduce job
	if one chooses to implement log processing distributely
	it can call agreggateCalls in the map stage
	and createBill in the reduce stage.
*/
public class BillingJob {
	public Map<String, List<CallEvent>> aggregateCalls(Iterable<CallEvent> callEvents) {
		Map<String, List<CallEvent>> aggregated = new HashMap<String, List<CallEvent>>(); 
		for (CallEvent callEvent : callEvents) {
			String caller = callEvent.getCaller();
			if (!aggregated.containsKey(caller)) {
				List<CallEvent> events = new ArrayList<CallEvent>();
				events.add(callEvent);
				aggregated.put(caller, events);
			} else {
				List<CallEvent> events = aggregated.get(caller);
				events.add(callEvent);
			}
		}
		return aggregated;
	}
	
	public Bill createBill(Customer customer, List<CallEvent> callEvents) {
		/*TODO: put bill creation logic here. what dan and razvan implemented */
		
    List<Call> calls               = new ArrayList<Call>();
    DaytimePeakPeriod peakPeriod   = new DaytimePeakPeriod();
    BigDecimal totalBill           = new BigDecimal("0");
    BigDecimal cost                = new BigDecimal("0");
    CallEvent start                = null;
    

    for (CallEvent event : callEvents) 
    {
        if (event.getStage() == CallEvent.Stage.START) { 
            start = event;
        }
        if (event.getStage() == CallEvent.Stage.END && start != null) 
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
        DateTime startCall             = call.getStartTime();
        DateTime endCall               = call.getEndTime();
        DateTime startHigherDelimiter  = DaytimePeakPeriod.getNextHigherDelimiter(startCall); 
        DateTime endLowerDelimiter     = DaytimePeakPeriod.getNextLowerDelimiter(endCall);
        boolean isStartCallPeak        = !peakPeriod.offPeak(call.getStartTime());
        boolean isEndCallPeak          = !peakPeriod.offPeak(call.getEndTime());

        
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
        call.setCost(callCost);
        //items.add(new LineItem(call, callCost));
    }
           
		return new Bill(customer, calls, totalBill);
	}
	
	public List<Call> getCalls(List<CallEvent> callEvents) {
		return null;
	}
}
