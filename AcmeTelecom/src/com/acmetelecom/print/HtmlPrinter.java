package com.acmetelecom.print;

public class HtmlPrinter implements Printer {

    private static Printer instance = new HtmlPrinter();

    private HtmlPrinter() {
    }

    public static Printer getInstance() {
        return instance;
    }

    public boolean printHeading(String name, String phoneNumber, String pricePlan) {
    	boolean statusOk = true;
    	
        statusOk &= beginHtml();
        System.out.println(h2(name + "/" + phoneNumber + " - " + "Price Plan: " + pricePlan));
        statusOk &= beginTable();
        
        return statusOk;
    }

    private boolean beginTable() {
        System.out.println("<table border=\"1\">");
        System.out.println(tr(th("Time") + th("Number") + th("Duration") + th("Cost")));
        
        return true;
    }

    private boolean endTable() {
        System.out.println("</table>");
        
        return true;
    }

    private String h2(String text) {
        return "<h2>" + text + "</h2>";
    }

    public boolean printItem(String time, String callee, String duration, String cost) {
        System.out.println(tr(td(time) + td(callee) + td(duration) + td(cost)));
        
        return true;
    }

    private String tr(String text) {
        return "<tr>" + text + "</tr>";
    }

    private String th(String text) {
        return "<th width=\"160\">" + text + "</th>";
    }

    private String td(String text) {
        return "<td>" + text + "</td>";
    }

    public boolean printTotal(String total) {
    	boolean statusOk = true;
    	
    	statusOk &= endTable();
        System.out.println(h2("Total: " + total));
        statusOk &= endHtml();
        
        return statusOk;
    }

    private boolean beginHtml() {
        System.out.println("<html>");
        System.out.println("<head></head>");
        System.out.println("<body>");
        System.out.println("<h1>");
        System.out.println("Acme Telecom");
        System.out.println("</h1>");
        
        return true;
    }

    private boolean endHtml() {
        System.out.println("</body>");
        System.out.println("</html>");
        
        return true;
    }
}
