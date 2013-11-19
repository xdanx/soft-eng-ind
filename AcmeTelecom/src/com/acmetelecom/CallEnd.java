package com.acmetelecom;

public class CallEnd extends CallEvent {
    public CallEnd(String caller, String callee) {
        super(caller, callee, System.currentTimeMillis());
    }
    // Debug constructor, used to override the time a call has been made 
    public CallEnd(String caller, String callee, long ts)
    {
    	super(caller, callee, ts);
    }
}
