package com.acmetelecom.mapreduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class BillingMRJob {
  public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

		@Override
    public void map(LongWritable arg0, Text arg1,
        OutputCollector<Text, IntWritable> arg2, Reporter arg3)
        throws IOException {
	    
    }
  }
  
  public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

		@Override
    public void reduce(Text arg0, Iterator<IntWritable> arg1,
        OutputCollector<Text, IntWritable> arg2, Reporter arg3)
        throws IOException {
	    
    }
  	
  }
}
