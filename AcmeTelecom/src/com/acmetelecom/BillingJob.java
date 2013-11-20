package com.acmetelecom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.acmetelecom.customer.Customer;

/* resembles the structure of a map-reduce job
	if one chooses to implement log processing distributely
	it can call agreggateCalls in the map stage
	and createBill in the reduce stage.
*/
public class BillingJob {
	public Map<String, List<CallEvent>> aggregateCalls(Iterable<CallEvent> callEvents) {
		Map<String, List<CallEvent>> aggregated = new HashMap<String, List<CallEvent>>(); 
		for (CallEvent callEvent : callEvents) {
			String caller = callEvent.getCaller();
			if (!aggregated.containsKey(caller)) {
				List<CallEvent> events = new ArrayList<CallEvent>();
				events.add(callEvent);
				aggregated.put(caller, events);
			} else {
				List<CallEvent> events = aggregated.get(caller);
				events.add(callEvent);
			}
		}
		return aggregated;
	}
	
	public Bill createBill(Customer customer, List<CallEvent> callEvents) {
		/*TODO: put bill creation logic here. what dan and razvan implemented */
		return null;
	}
	
	public List<Call> getCalls(List<CallEvent> callEvents) {
		return null;
	}
}
