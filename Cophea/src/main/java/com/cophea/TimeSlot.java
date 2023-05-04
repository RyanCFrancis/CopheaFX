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

	public void setMonday(){
		switch (this.getStart().getDayOfWeek()) {
            case MONDAY:
                
                break;
            case TUESDAY:
                this.setStart(OffsetDateTime.now().minusDays(1));
                
                break;
            case WEDNESDAY:
				this.setStart(OffsetDateTime.now().minusDays(2));
                
                break;
            case THURSDAY:
				this.setStart(OffsetDateTime.now().minusDays(3));
                
                break;
            case FRIDAY:
				this.setStart(OffsetDateTime.now().minusDays(4));
                
                break;
            case SATURDAY:
				this.setStart(OffsetDateTime.now().plusDays(2));
                
                break;
            case SUNDAY:
				this.setStart(OffsetDateTime.now().plusDays(1));
                
                break;
        
            default:
                break;
        }
        this.setStart(this.getStart().withMinute(0));
		this.setStart(this.getStart().withHour(9));
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

	public TimeSlot nextDay(){
		return new TimeSlot(this.start.plusHours(16));
	}
	public TimeSlot nextWeek(){
		return new TimeSlot(this.start.plusDays(7));
	}
	public TimeSlot prevWeek(){
		return new TimeSlot(this.start.minusDays(7));
	}
	
	@Override
	public boolean equals(Object o) {
		TimeSlot b = (TimeSlot) o;
		if (this.start.getHour() != b.getStart().getHour()){return false;}
		if (this.start.getMinute() != b.getStart().getMinute()){return false;}
		if (this.start.getDayOfMonth() != b.getStart().getDayOfMonth()){return false;}
		if (this.start.getMonthValue() != b.getStart().getMonthValue()){return false;}
		
		return true;
	}
	
	public String toString() {
		//temporary
		return this.getStart().getMonthValue()+"/"+this.getStart().getDayOfMonth()+"/"+this.getStart().getYear()+
		" "+this.getStart().getHour()+":00";
	}



	//12am = 0
	//1am = 1
	//2am = 2
	//3am = 3
	//4am = 4
	//5am = 5
	//6am = 6
	//7am = 7
	//8am = 8
	//9am = 9
	//10am = 10
	//11am = 11
	//12pm = 12
	//1pm = 13
	//2pm = 14
	//3pm = 15
	//4ppm = 16
	//5pm = 17
	
}

	