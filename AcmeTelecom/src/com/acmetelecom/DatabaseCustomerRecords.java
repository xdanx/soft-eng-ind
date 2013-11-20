package com.acmetelecom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.CustomerDatabase;

public class DatabaseCustomerRecords implements CustomerRecords {

	private Map<String, Customer> customersByNumber;
	
	public DatabaseCustomerRecords(CustomerDatabase database) {
		this.customersByNumber = new HashMap<String, Customer>();
		List<Customer> customers = database.getCustomers();
		for (Customer customer : customers) {
			customersByNumber.put(customer.getPhoneNumber(), customer);
		}
	}
	
  public Customer getCustomer(String number) {
	  return customersByNumber.get(number);
  }

}
