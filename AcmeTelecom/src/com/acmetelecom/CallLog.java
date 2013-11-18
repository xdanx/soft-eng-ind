package com.acmetelecom;

public interface CallLog extends Iterable<CallEvent> {
	void logCallStart(String caller, String callee, long timestamp);
	void logCallEnd(String caller, String callee, long timestamp);
}
