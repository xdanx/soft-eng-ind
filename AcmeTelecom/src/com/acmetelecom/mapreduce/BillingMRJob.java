package com.acmetelecom.mapreduce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import com.acmetelecom.Bill;
import com.acmetelecom.BillingJob;
import com.acmetelecom.CallEvent;
import com.acmetelecom.CallEvent.Stage;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.CustomerDatabase;
import com.acmetelecom.customer.Tariff;
import com.acmetelecom.customer.TariffLibrary;

public class BillingMRJob {
	
  public static class Map extends MapReduceBase implements Mapper<LongWritable, CallLogWritable, Text, CallLogWritable> {

		@Override
    public void map(LongWritable arg0, CallLogWritable logWritable,
        OutputCollector<Text, CallLogWritable> output, Reporter arg3)
        throws IOException {
	    output.collect(new Text(logWritable.caller), logWritable);
    }
  }
  
  public static class Reduce extends MapReduceBase implements Reducer<Text, CallLogWritable, Text, BillWritable> {

  	CustomerDatabase customerDB;
  	TariffLibrary tariffLibrary;
  	private HashMap<String, Customer> customers;
  	
    @Override
    public void configure(JobConf job) {
    	
    	/* the way the database is accessed is inefficient.
    	 * one should be able to query the database by caller number
    	 * this is a change required in the dependency code*/
      customerDB = CentralCustomerDatabase.getInstance();
      for (Customer customer : customerDB.getCustomers()) {
      	customers.put(customer.getPhoneNumber(), customer);
      }
      
      tariffLibrary = CentralTariffDatabase.getInstance();
    }
    
    private Customer getCustomer(String number) {
    	return customers.get(number);
    }
    
    private Tariff getTarrif(Customer customer) {
    	return tariffLibrary.tarriffFor(customer);
    }

		@Override
    public void reduce(Text caller, Iterator<CallLogWritable> logIter,
        OutputCollector<Text, BillWritable> output, Reporter arg3)
        throws IOException {
	    String callerStr = caller.toString();
	    BillingJob job = new BillingJob();
	    List<CallEvent> callEvents = new ArrayList<CallEvent>();
	    
	    while (logIter.hasNext()) {
	    	CallLogWritable logWritable = logIter.next();
	    	callEvents.add(new CallEvent(logWritable.caller, logWritable.callee,
	    											Long.parseLong(logWritable.date), CallEvent.Stage.valueOf(logWritable.callStage)));
	    }
	    Customer customer = getCustomer(callerStr);
	    
	    Bill bill = job.createBill(customer, getTarrif(customer), callEvents);
	    output.collect(caller, new BillWritable(bill));
    }
  }
  
  public static void main(String[] args) throws Exception {
  	JobConf conf = new JobConf(BillingMRJob.class);
    conf.setJobName("Billing Job");
    conf.setOutputKeyClass(Text.class);
    conf.setOutputValueClass(CallLogWritable.class);

    conf.setMapperClass(Map.class);
    conf.setReducerClass(Reduce.class);	
    conf.setInputFormat(TextInputFormat.class);
    conf.setOutputFormat(TextOutputFormat.class);

    FileInputFormat.setInputPaths(conf, new Path(args[0]));
    FileOutputFormat.setOutputPath(conf, new Path(args[1]));
	
    JobClient.runJob(conf);
  }
  
}
