package com.acmetelecom.mapreduce;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.hadoop.io.Writable;

import com.acmetelecom.Bill;

public class BillWritable implements Writable {

	Bill bill;
	String billBytes;
	
	public BillWritable(Bill bill) {

		this.bill = bill;
		
  
	}
	@Override
  public void readFields(DataInput input) throws IOException {
		String line = input.readLine();
	  ByteArrayInputStream bis = new ByteArrayInputStream(line.getBytes());
    ObjectInputStream oInputStream = new ObjectInputStream(bis);
    try {
	    bill = (Bill)oInputStream.readObject();
    } catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
  }

	@Override
  public void write(DataOutput out) throws IOException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream os;
    try {
	    os = new ObjectOutputStream(bos);
	    os.writeObject(bill);
	    billBytes = bos.toString();
	    os.close();
    } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
	  out.writeChars(billBytes);
  }

}
