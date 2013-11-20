package com.acmetelecom.tests.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallEvent;
import com.acmetelecom.CallStart;

public class CallTest {
	public String caleeNumber = "0987654321";
	public Long caleeTime = (long) 1234567;
	public String calerNumber = "0987654322";
	public Long calerTime = (long) 7654321;
	public CallEvent start;
	public CallEvent end; 
	
	@Before
	public void initialize(){
		start = mock(CallStart.class);
		when(start.getCallee()).thenReturn(caleeNumber);
		when(start.time()).thenReturn(caleeTime);
		
		end = mock(CallEnd.class);
		when(end.getCallee()).thenReturn(caleeNumber);
		when(end.time()).thenReturn(calerTime);
	}

	@Test
	public void givenAStartAndAnEndEvent_ACallCanBeCreated() {
		Call call = new Call(start, end);
		assertNotNull(call);
	}
	
	@Test
	public void givenAStartAndAnEndEvent_TheCaleeNumberCanBeRetrived() {
		Call call = new Call(start, end);
		assertEquals(call.callee(), caleeNumber);
	}
	
	@Test
	public void givenAStartAndAnEndEvent_TheDurationOfTheCallCanBeRetrived() {
		Call call = new Call(start, end);
		assertEquals(call.durationSeconds(), (calerTime-caleeTime)/1000);
	}
	
	@Test
	public void givenAStartAndAnEndEvent_TheDateOfTheCallCanBeRetrived() {
		Call call = new Call(start, end);
		String date = SimpleDateFormat.getInstance().format(new Date(start.time()));
		
		assertEquals(call.date(), date);
	}
	
	@Test
	public void givenAStartAndAnEndEvent_TheStartDateOfTheCallCanBeRetrived() {
		Call call = new Call(start, end);
		assertEquals(call.startTime(), new DateTime(start.time()));
	}
	
	@Test
	public void givenAStartAndAnEndEvent_TheEndDateOfTheCallCanBeRetrived() {
		Call call = new Call(start, end);
		assertEquals(call.endTime(), new DateTime(end.time()));
	}	

}
