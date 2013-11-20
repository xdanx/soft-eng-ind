package com.acmetelecom.calls;

public class CallStart extends CallEvent {
    public CallStart(String caller, String callee) {
        super(caller, callee, System.currentTimeMillis());
    }
    
    // Debug constructor, used to override the time a call has been made 
    public CallStart(String caller, String callee, long ts)
    {
    	super(caller, callee, ts);
    }
}
