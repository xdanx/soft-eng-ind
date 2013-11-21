package com.acmetelecom.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import com.acmetelecom.ArrayCallLog;
import com.acmetelecom.BillCreator;
import com.acmetelecom.BillingSystem;
import com.acmetelecom.DaytimePeakPeriod;
import com.acmetelecom.HtmlBillPrinter;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.CustomerDatabase;
import com.acmetelecom.customer.TariffLibrary;
import com.acmetelecom.customer.Tariff;

import cucumber.api.DataTable;
import cucumber.api.Format;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.mockito.*;



public class BillingSystemAcceptanceTest {
  private final CustomerDatabase customersDatabase = Mockito.mock(CustomerDatabase.class);
  private final TariffLibrary tariffsLibrary = Mockito.mock(TariffLibrary.class);

  private final BillingSystem billingSystem = 
  		new BillingSystem(new ArrayCallLog(), customersDatabase, tariffsLibrary,
  								new BillCreator(new HtmlBillPrinter()));

	@Given("With the customer database")
	void makeCustomerDatabaseAndTarrifLibrary(DataTable table) {
      List<Customer> customers = new ArrayList<Customer>(); 
      for (Map<String, String> row : table.asMaps()) {
      	String phoneNumber = row.get("phone_number");
        String pricePlan = row.get("price_plan");
        Customer customer = new Customer(row.get("full_name"), phoneNumber, pricePlan);
        customers.add(customer); 
        Mockito.when(tariffsLibrary.tarriffFor(Mockito.argThat(new CustomerMatcher(customer)))).thenReturn(Tariff.valueOf(pricePlan));
			}
 
     Mockito.stub(customersDatabase.getCustomers()).toReturn(customers);	
	}
	
	
  @When("customer with number \\s calls customer with number \\s at \"(.*)\"")
  public void startCall(String caller, String callee, @Format("dd-MM-yyyy, HH:mm") Date date) {
  	billingSystem.callInitiated(caller, callee, date);
  }
  
  @And("customer with number \\s ends call with customer with number \\s at \"(.*)\"")
  public void endCall(String caller, String callee, @Format("dd-MM-yyyy, HH:mm") Date date) {
    billingSystem.callCompleted(caller, callee, date);
  }

  @Then("The bills printed on the screen should be: \\s")
  public void outputBills(String allBills) {
  	ByteArrayOutputStream baos = new ByteArrayOutputStream();
  	PrintStream ps = new PrintStream(baos);
  	
  	System.setOut(ps);
  	billingSystem.createCustomerBills();
  	String outputBills = baos.toString();
  	Assert.assertEquals(allBills, outputBills);
  }
	
  private class CustomerMatcher extends ArgumentMatcher<Customer> {
  	private Customer customer;
  	
	public CustomerMatcher(Customer customer) {
		this.customer = customer;
	}
  	
  	@Override
  	public boolean matches(Object obj) {
  		if (customer == obj) return true;
  		if (!(obj instanceof Customer) || obj == null) return false;
  		Customer otherCustomer = (Customer)(obj);
  		return customer.getPhoneNumber().equals(otherCustomer.getPhoneNumber());
  	}
  }

}		

