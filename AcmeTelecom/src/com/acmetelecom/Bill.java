package com.acmetelecom;

import java.math.BigDecimal;
import java.util.List;

import com.acmetelecom.customer.Customer;

public class Bill {
	Customer customer;
	BigDecimal totalCost;
	List<Call> calls;
	/*
  printer.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());
  for (BillingSystem.LineItem call : calls) {
      printer.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
      gag
  }*/
	
	public Bill(Customer customer, List<Call> calls, BigDecimal totalCost) {
		this.customer = customer;
		this.calls = calls;
		this.totalCost = totalCost;
	}
	public BigDecimal getCost() {
		return totalCost;
	}
	public Customer getCustomer() {
		return customer;
	}
	public List<Call> getCalls() {
		return calls;
	}
}
