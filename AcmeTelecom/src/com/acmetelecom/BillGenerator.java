package com.acmetelecom;

import com.acmetelecom.print.ConsolePrinter;
import com.acmetelecom.utils.MoneyFormatter;
import com.acmetelecom.utils.LineItem;
import com.acmetelecom.print.Printer;
import com.acmetelecom.print.HtmlPrinter;
import com.acmetelecom.customer.Customer;

import java.util.List;

public class BillGenerator {

	static Printer consoleprinter;
	
	public BillGenerator(){
		consoleprinter = new ConsolePrinter();
	}
	
    public boolean send(Customer customer, List<LineItem> calls, String totalBill) 
    {
    	boolean statusOk = true;
    	
        Printer printer = HtmlPrinter.getInstance();
        // printer.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());
        statusOk &= consoleprinter.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());

        for (LineItem call : calls) {
            //printer.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
        	statusOk &= consoleprinter.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
        }
        //printer.printTotal(totalBill);
        statusOk &= consoleprinter.printTotal(totalBill);
        
        return statusOk;
    }

}
