package com.acmetelecom;

import com.acmetelecom.print.*;
import com.acmetelecom.utils.MoneyFormatter;
import com.acmetelecom.utils.LineItem;

import com.acmetelecom.customer.Customer;

import java.util.List;

public class BillGenerator {

	static Printer printer;
	
	public BillGenerator(){
		printer = new APIPrinter();
	}
	
    public boolean send(Customer customer, List<LineItem> calls, String totalBill) 
    {
    	boolean statusOk = true;
    	
        statusOk &= printer.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());

        for (LineItem call : calls) {
        	statusOk &= printer.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
        }
        statusOk &= printer.printTotal(totalBill);
        
        return statusOk;
    }

}
