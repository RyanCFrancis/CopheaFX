package com.cophea;


import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public class TimeSlot implements Comparable<TimeSlot> {

	private OffsetDateTime start;
	private OffsetDateTime end;
	
	
	//in case we make appointments less than 1 hour we will use the first constructor
	//otherwise the 2nd one will do
	public TimeSlot(int year,int mon,int day,int hstart,int mstart,int hend,int mend) {
		start = OffsetDateTime.of(year,mon,day,hstart,mstart,0,0,ZoneOffset.ofHours(-5));
		end = OffsetDateTime.of(year,mon,day,hend,mend,0,0,ZoneOffset.ofHours(-5));
	}
	
	public TimeSlot(int year,int mon,int day,int hstart) {
		start = OffsetDateTime.of(year,mon,day,hstart,0,0,0,ZoneOffset.ofHours(-5));
		end = OffsetDateTime.of(year,mon,day,hstart+1,0,0,0,ZoneOffset.ofHours(-5));
	}

	public TimeSlot(OffsetDateTime ODT){
		start = ODT;
		end = ODT.plusHours(1);

	}
	
	//returns duration in hours //placeholder
	public int duration() {
		return 1;
	}
	
	
	public OffsetDateTime getStart() {
		return start;
	}
	public void setStart(OffsetDateTime start) {
		this.start = start;
	}
	public OffsetDateTime getEnd() {
		return end;
	}
	public void setEnd(OffsetDateTime end) {
		this.end = end;
	}
	
	//ONLY COMPARES THE START OF THE APPOINTMENT NOT THE ENDS
	public int compareTo(TimeSlot b) {
		boolean val;
		// if = return 0
		if (this.getStart().equals(b.getStart())) {return 0;}
		val = this.getStart().isBefore(b.getStart());
//		System.out.println(this.getStart());
//		System.out.println(b.getStart());
//		System.out.println(val);
		//if the first timeslot occurs BEFORE the 2nd, returns -1
		if (val) {return -1;}
		//if the first timeslot occurs AFTER the 2nd, returns 1
		return 1;
	}

	public TimeSlot incHour(){
		return new TimeSlot(this.start.plusHours(1));
	}

	public TimeSlot incDay(){
		return new TimeSlot(this.start.plusHours(16));
	}
	
	@Override
	public boolean equals(Object o) {
		TimeSlot b = (TimeSlot) o;
		if (this.compareTo(b) == 0) {return true;}
		return false;
	}
	
	public String toString() {
		//temporary
		return this.getStart().toString();
	}
}

	