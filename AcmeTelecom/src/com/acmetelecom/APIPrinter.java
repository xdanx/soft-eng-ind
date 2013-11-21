package com.acmetelecom;


public class APIPrinter implements BillPrinter
{

	public boolean printHeading(String name, String phoneNumber, String pricePlan) 
	{
		System.out.print("{ \"name\": \"" + name + "\", \"phone\": \"" + phoneNumber + "\", ");
		// We need to start printing the header for the calls in the json array here.
		System.out.print("\"calls\": [ ");
		return true;
	}

	public boolean printItem(String time, String callee, String duration, String cost) 
	{
		System.out.print("{\"time\": \"" + time + "\", ");
		System.out.print("\"callee\": \"" + callee + "\", ");
		System.out.print("\"duration\": \"" + duration +"\"} ,");

		return true;
	}

	public boolean printTotal(String total) 
	{
		// In order to correctly print the JSON without any problems, we need to print a back-space character
		// Unfortunately in Eclipse
		System.out.print("\b");
		System.out.println(" ], \"total\": \"" + total + "\" }");

		return true;
	}

	@Override
	public String printBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
