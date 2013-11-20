package com.acmetelecom.print;

public interface Printer {

    boolean printHeading(String name, String phoneNumber, String pricePlan);

    boolean printItem(String time, String callee, String duration, String cost);

    boolean printTotal(String total);
}
