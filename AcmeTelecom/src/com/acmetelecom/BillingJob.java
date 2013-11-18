package com.acmetelecom;

/* resembles the structure of a mpa-reduce job
	if one chooses to implement log processing distributely
	it can call agreggateCalls in the map stage
	and createBill in the reduce stage.
*/
public class BillingJob {
	public Map<String, List<CallEvent>> aggregateCalls(Iterable<CallEvent> callEvents) {
		for (CallEvent callEvent : callEvents) {
			
		}
	}
	
	public Bill createBill(String caller, List<CallEvent> callEvents) {
		
	}
	
	public List<Call> getCalls(List<CallEvent> callEvents) {
		return null;
	}
}
