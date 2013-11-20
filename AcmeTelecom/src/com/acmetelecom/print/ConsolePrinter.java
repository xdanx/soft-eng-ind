package com.acmetelecom.print;

import com.acmetelecom.print.Printer;

public class ConsolePrinter implements Printer
{

	public boolean printHeading(String name, String phoneNumber, String pricePlan) 
	{		
		System.out.println("--- Printing user information ---");
		System.out.println("User: "+ name + " - Phone: " + phoneNumber + " - Price: " + pricePlan );
		
		return true;

	}

	public boolean printItem(String time, String callee, String duration, String cost) 
	{
		System.out.println("Time: " + time + " - Caller " + callee);
		System.out.println("Duration: " + duration + " - Cost: " + cost);
		
		return true;
	}
	public boolean printTotal(String total) 
	{		
        System.out.println("Total: " + total);
        System.out.println();
        
        return true;
	}
	

}