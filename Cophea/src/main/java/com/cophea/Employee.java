package com.cophea;

import java.util.ArrayList;

public class Employee extends Person {
	//examples are "Doctor","Nurse","Surgeon"
	//TODO CONDITIONS PROPERLY IMPLEMENTED 
	private String role;
	//coniditions they treat
	private ArrayList<String> conditions;
	//all timeslots the employee is working, whether they are occupied by an appointment or not
	private ArrayList<TimeSlot> workSlots;
	
	public Employee(String f,String l, String login, String password,  String role) {
		super("0",f,l, login, password, false);
		this.workSlots = new ArrayList<TimeSlot>();
		this.conditions = new ArrayList<String>();
		this.role = role;
	}

	public Employee(String i,String f,String l, String login, String password,  String role) {
		super(i,f,l, login, password, false);
		this.workSlots = new ArrayList<TimeSlot>();
		this.conditions = new ArrayList<String>();
		this.role = role;
	}
	public Employee(String i,String f,String l, String login, String password,  String role,String[] con) {
		super(i,f,l, login, password, false);
		this.workSlots = new ArrayList<TimeSlot>();
		this.conditions = new ArrayList<String>();
		this.role = role;
		for (int w = 0;w<con.length;w++){
			this.conditions.add(con[w]);
		}
	}
	public void addCondition(String c){
		this.conditions.add(c);
	}
	public ArrayList<String> getConditions(){
		return this.conditions;
	}

	public void addSlot(TimeSlot ts) {
		//change the return to throwing an error or something later
		if (workSlots.contains(ts)) {
			System.out.println("Error the person has this slot already");
			return;
		}
		workSlots.add(ts);
	}
	public void removeSlot(TimeSlot ts) {
		if (workSlots.contains(ts)) {workSlots.remove(ts);return;}
		
		//spit out an error or something
		System.out.println("Error that timeslot doesnt exist");
	}

	public ArrayList<TimeSlot> getSlots(){
		return workSlots;
	}
	
	public String getRole(){
		return this.role;
	}

	public void setRole(String r){
		this.role = r;
	}
	
	
	

}
