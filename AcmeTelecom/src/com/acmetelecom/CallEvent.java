package com.acmetelecom;

public class CallEvent {
    private String caller;
    private String callee;
    private long time;
    private Stage stage;
    
    public static enum Stage {
    	START,
    	END
    }

    public CallEvent(String caller, String callee, long timeStamp, Stage stage) {
        this.caller = caller;
        this.callee = callee;
        this.time = timeStamp;
        this.stage = stage;
    }

    public String getCaller() {
        return caller;
    }

    public String getCallee() {
        return callee;
    }

    public long time() {
        return time;
    }
    public Stage getStage() {
    	return stage;
    }

}
