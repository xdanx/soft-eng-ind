package com.acmetelecom.tests.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.acmetelecom.BillGenerator;
import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallStart;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.utils.LineItem;

public class BillGeneratorTest {

	private BillGenerator billGenerator;
	private Customer customer;
	private List calls;
	private String totalBill;
	
	@Before
	public void initialize(){
		billGenerator = new BillGenerator();
		customer = mock(Customer.class);
		when(customer.getFullName()).thenReturn("name");
		when(customer.getPhoneNumber()).thenReturn("0987654321");
		when(customer.getPricePlan()).thenReturn("Business");
		
		calls = new LinkedList<LineItem>();
		
		totalBill = "1000";
	}
	@Test
	public void test() {
		assertTrue("bills are always send", billGenerator.send(customer, calls, totalBill));
	}

}
