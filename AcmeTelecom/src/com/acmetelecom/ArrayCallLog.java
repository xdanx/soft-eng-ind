package com.acmetelecom;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ArrayCallLog implements CallLog {

	List<CallEvent> callEvents;
	
	public ArrayCallLog() {
		callEvents = new ArrayList<CallEvent>();
	}
	
	@Override
  public Iterator<CallEvent> iterator() {
		return callEvents.iterator();
  }

	@Override
  public void logCallStart(String caller, String callee, long timestamp) {
		callEvents.add(new CallEvent(caller, callee, timestamp, CallEvent.Stage.START));
	  
  }

	@Override
  public void logCallEnd(String caller, String callee, long timestamp) {
		callEvents.add(new CallEvent(caller, callee, timestamp, CallEvent.Stage.END));
  }

}
