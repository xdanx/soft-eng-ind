package com.acmetelecom;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class HtmlBillPrinter implements BillPrinter {
	private VelocityEngine templateEngine;
	public HtmlBillPrinter() {
		templateEngine = new VelocityEngine();
	}
  public String printBill(Bill bill) {
	  Template template = templateEngine.getTemplate("templates/HtmlBillTemplate.vm");
	  StringWriter writer = new StringWriter();
  	VelocityContext context = new VelocityContext();
  	context.put("bill", bill);
    template.merge(context, writer);  
    return writer.toString();
  }
}
