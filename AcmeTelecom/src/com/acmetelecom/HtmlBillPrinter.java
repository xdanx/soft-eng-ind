package com.acmetelecom;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.joda.time.DateTime;

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
	context.put("formatter", this);
	template.merge(context, writer);  
	return writer.toString();
  }
  
  public String formatMoney(BigDecimal pence) {
  	return MoneyFormatter.penceToPounds(pence);
  }
  
  public String formatDate(DateTime date) {
  	return SimpleDateFormat.getInstance().format(new Date(date.getMillis()));
  }
}
