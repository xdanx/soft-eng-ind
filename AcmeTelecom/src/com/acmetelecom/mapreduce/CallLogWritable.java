package com.acmetelecom.mapreduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class CallLogWritable implements Writable {
    // Some data     
    public String caller;
    public String callee;
    public String date;
    public String callStage;
		@Override
    public void readFields(DataInput input) throws IOException {
	    String line = input.readLine();
	    String[] elements = line.split(" ");
	    caller = elements[0];
	    caller = elements[0];
    }
		@Override
    public void write(DataOutput output) throws IOException {
	    output.writeBytes( String.format("%s %s %s %s\n", caller, callee, date, callStage));
    }
 
}
