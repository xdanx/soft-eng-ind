package com.acmetelecom;

import com.acmetelecom.print.ConsolePrinter;
import com.acmetelecom.utils.MoneyFormatter;
import com.acmetelecom.utils.LineItem;
import com.acmetelecom.print.Printer;
import com.acmetelecom.print.HtmlPrinter;
import com.acmetelecom.customer.Customer;

import java.util.List;

public class BillGenerator {

	static Printer consoleprinter = new ConsolePrinter();
	
    public void send(Customer customer, List<LineItem> calls, String totalBill) 
    {
        Printer printer = HtmlPrinter.getInstance();
        // printer.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());
        consoleprinter.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());

        for (LineItem call : calls) {
            //printer.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
            consoleprinter.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
        }
        //printer.printTotal(totalBill);
        consoleprinter.printTotal(totalBill);
    }

}
