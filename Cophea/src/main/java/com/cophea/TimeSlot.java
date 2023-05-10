package com.cophea;


import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public class TimeSlot implements Comparable<TimeSlot> {

	//when intiailly designing the project, we intended to allow variable duration appointments (such as 15 minute or 30 minute ones)
	//but rendering this graphically on the scheduling screen would have been too time consuming
	// for the current iteration of the project only the start object is used because all appointments are 1 hour in duration

	// each offsetdatetime obj was to be used as  start and stop time for the appointment


	//each contains the date (month year day) and hour and minute time and even timezone of the appointment
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

	//this constructor was used for when we had to quickjly create new timeslot obj's
	//for the scheduling screen such as when the current week was incremented or we wanted to go to the next
	//appointment time within operating hours
	public TimeSlot(OffsetDateTime ODT){
		start = ODT;
		end = ODT.plusHours(1);

	}
	
	//returns duration in hours //placeholder
	//UNUSED
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
	//returns 0 if they are both at the same time
	//returns -1 if this timeslot occurs before the parameter timeslot
	//returns +1 if this timeslot occurs affter the parameter timeslot
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

	//returns an equavalent timeslot object that is simply 1 hour ahead in time
	//so if you had a timeslot on 5/10/23 at 2:00pm, this function would return one with the same date at 3pm
	public TimeSlot incHour(){
		return new TimeSlot(this.start.plusHours(1));
	}

	//returns a timeslot that is 16 hours ahead of the current one
	//this func is used for the last timeslot of a workday to quickly 
	// obtain a timeslot of the first working hour of the next work day
	public TimeSlot nextDay(){
		return new TimeSlot(this.start.plusHours(16));
	}

	//returns a tiomeslot that is 1 week ahead
	//used to generate the schedule screen
	public TimeSlot nextWeek(){
		return new TimeSlot(this.start.plusDays(7));
	}
	//returns a timeslot that is 1 week prior
	//used o generate the schedule screen
	public TimeSlot prevWeek(){
		return new TimeSlot(this.start.minusDays(7));
	}
	
	//used to check if 2 timeslots have the same day,month,year and hourly value
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
	//this func is used for "writing" the timeslot to the database files
	public String write(){
		String y = Integer.toString(this.start.getYear());
		String m = Integer.toString(this.start.getMonthValue());
		String d = Integer.toString(this.start.getDayOfMonth());
		String h = Integer.toString(this.start.getHour());

		return y+","+m+","+d+","+h;
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

	