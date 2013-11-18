package com.acmetelecom;

import com.acmetelecom.BillGenerator;
import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallEvent;
import com.acmetelecom.CallStart;
import com.acmetelecom.DaytimePeakPeriod;
import com.acmetelecom.MoneyFormatter;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.Tariff;

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

    private void createBillFor(Customer customer) {
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


    /**
     * 
     * @param customer 
     * rr2210
     */
    private void attemptCreateBill(Customer customer)
    {
        
        List<CallEvent> customerEvents = new ArrayList<CallEvent>();
        List<Call> calls = new ArrayList<Call>();
        List<LineItem> items = new ArrayList<LineItem>();
        DaytimePeakPeriod peakPeriod = new DaytimePeakPeriod();
        BigDecimal totalBill = new BigDecimal("0");
        BigDecimal cost      = new BigDecimal("0");
        CallEvent start = null;
        
        for (CallEvent callEvent : callLog) {
            if (callEvent.getCaller().equals(customer.getPhoneNumber())) {
                customerEvents.add(callEvent);
            }
        }


        for (CallEvent event : customerEvents) {
            if (event instanceof CallStart) {
                start = event;
            }
            if (event instanceof CallEnd && start != null) {
                calls.add(new Call(start, event));
                start = null;
            }
        }

               
        for (Call call : calls) 
        {
            Tariff tariff = CentralTariffDatabase.getInstance().tarriffFor(customer);
            cost = new BigDecimal("0");
            DateTime startCall = call.startTime();
            DateTime   endCall = call.endTime();
            boolean isStartCallPeak = peakPeriod.offPeak(call.startTime());
            boolean isEndCallPeak   = peakPeriod.offPeak(call.endTime());
            
            if (peakPeriod.offPeak(call.startTime()) && 
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
    
    static class LineItem {
        private Call call;
        private BigDecimal callCost;

        public LineItem(Call call, BigDecimal callCost) {
            this.call = call;
            this.callCost = callCost;
        }

        public String date() {
            return call.date();
        }

        public String callee() {
            return call.callee();
        }

        public String durationMinutes() {
            return "" + call.durationSeconds() / 60 + ":" + String.format("%02d", call.durationSeconds() % 60);
        }

        public BigDecimal cost() {
            return callCost;
        }
    }
}
