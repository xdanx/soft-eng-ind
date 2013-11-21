package com.acmetelecom;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class ConsolePrinter implements BillPrinter
{

	public String printBill(Bill bill) {
		StringBuilder output = new StringBuilder();
		output.append ("--- Printing user information ---\n");
		output.append ("User: "+ bill.customer.getFullName() + " - Phone: " + 
						bill.customer.getPhoneNumber() + " - Price: " + bill.customer.getPricePlan() + "\n");	
		
		for( Call call : bill.calls ) {
			output.append ("* Time: " + formatDate(call.getStartTime())); 
			output.append (" - Called " + call.getCallee() + "\n");
			output.append ("* Duration: " + call.getDurationMinutes());
			output.append (" - Cost: " + formatMoney(call.getCost()) + "\n");	
		
		}
		output.append ("Total: " + formatMoney(bill.getCost()) + "\n");
       	
		return output.toString();
	}
	
	public String formatMoney(BigDecimal pence) {
		return MoneyFormatter.penceToPounds(pence);
	}
	
	public String formatDate(DateTime date) {
		return SimpleDateFormat.getInstance().format(new Date(date.getMillis()));
	}	

}
