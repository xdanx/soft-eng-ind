package com.acmetelecom;

import org.joda.time.DateTime;

import com.acmetelecom.customer.Customer;
import com.acmetelecom.utils.MoneyFormatter;
import java.math.BigDecimal;

public class Runner 
{
	public static void main(String[] args) throws Exception 
	{
            
        //    System.out.println(MoneyFormatter.penceToPounds(new BigDecimal(111)));
		System.out.println("Running...");
		BillingSystem billingSystem = new BillingSystem();
		DateTime dt		= new DateTime (2010, 11, 13, 15, 30, 00);
		long startCall 	= dt.getMillis();
		// Call ends after an hour
		long endCall 	= dt.plusDays(1).plusHours(0).getMillis();
		
		Customer customerFraier = new Customer("LUKE", "447722113434", "Standard");
		Customer customerBO$$ 	= new Customer("YODA", "447766511332", "Business");
		
		// LUKE seeks advice from YODA
		billingSystem.debugCallInitiated("447722113434", "447766511332", startCall);
		billingSystem.debugCallCompleted("447722113434", "447766511332", endCall);
		// Advice no more YODA gives
		billingSystem.debugCallInitiated("447766511332", "447722113434", startCall);
		billingSystem.debugCallCompleted("447766511332", "447722113434", endCall);      
		
		billingSystem.createBillFor(customerBO$$);
		billingSystem.createCustomerBills();

	}
}
