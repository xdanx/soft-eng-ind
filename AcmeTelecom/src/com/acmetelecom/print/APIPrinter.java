package com.acmetelecom.print;

import com.acmetelecom.print.Printer;

public class APIPrinter implements Printer
{

	public boolean printHeading(String name, String phoneNumber, String pricePlan) 
	{
		if(name == null || name.isEmpty()
			|| phoneNumber == null || phoneNumber.isEmpty() 
			|| pricePlan == null || pricePlan.isEmpty())
			return false;
		
		System.out.print("{ \"name\": \"" + name + "\", \"phone\": \"" + phoneNumber + "\", ");
		// We need to start printing the header for the calls in the json array here.
		System.out.print("\"calls\": [ ");
		return true;
	}

	public boolean printItem(String time, String callee, String duration, String cost) 
	{
		if(time == null || time.isEmpty() 
				|| callee == null || callee.isEmpty()
				|| duration == null || duration.isEmpty()
				|| cost == null || cost.isEmpty())
				return false;
		
		System.out.print("{\"time\": \"" + time + "\", ");
		System.out.print("\"callee\": \"" + callee + "\", ");
		System.out.print("\"duration\": \"" + duration +"\"} ,");

		return true;
	}

	public boolean printTotal(String total) 
	{
		if(total == null || total.isEmpty())
			return false;
		// In order to correctly print the JSON without any problems, we need to print a back-space character
		// Unfortunately in Eclipse
		System.out.print("\b");
		System.out.println(" ], \"total\": \"" + total + "\" }");

		return true;
	}
	
	
}
