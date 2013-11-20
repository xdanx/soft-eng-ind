package com.acmetelecom;

class ConsolePrinter implements Printer
{

	public void printHeading(String name, String phoneNumber, String pricePlan) 
	{		
		System.out.println("--- Printing user information ---");
		System.out.println("User: "+ name + " - Phone: " + phoneNumber + " - Price: " + pricePlan );

	}

	public void printItem(String time, String callee, String duration, String cost) 
	{
		System.out.println("* Time: " + time + " - Called " + callee);
		System.out.println("* Duration: " + duration + " - Cost: " + cost);
	}
	public void printTotal(String total) 
	{		
        System.out.println("Total: " + total);
        System.out.println();
	}
	

}