package com.acmetelecom.tests;

import java.util.ArrayList;

import com.acmetelecom.TimeProvider;
public class ScheduledTimeProvider extends TimeProvider {
	private ArrayList<Long> times;
	int currentTimeIndex = 0;
	public void addTime(long millis) {
		times.add(millis);
	}
	@Override
	public long getMillis() {
		if (currentTimeIndex >= times.size()) return -1; //nothing available
		return times.get(currentTimeIndex++);
	}
}
