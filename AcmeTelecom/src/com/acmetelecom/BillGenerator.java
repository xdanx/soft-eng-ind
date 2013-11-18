package com.acmetelecom;

import com.acmetelecom.customer.Customer;

import java.util.List;

public class BillGenerator {

	static Printer consoleprinter = new ConsolePrinter();
	
    public void send(Customer customer, List<BillingSystem.LineItem> calls, String totalBill) 
    {
        Printer printer = HtmlPrinter.getInstance();
        // printer.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());
        consoleprinter.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());

        for (BillingSystem.LineItem call : calls) {
            //printer.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
            consoleprinter.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
        }
        //printer.printTotal(totalBill);
        consoleprinter.printTotal(totalBill);
    }

}
