package com.cophea;

import java.util.ArrayList;

public class Person {
	private String id;
	private String email;
	private String fname,lname;
	private String login;
	private String password;
	private boolean isPatient;
	//private a-list appointments;
	private ArrayList<Appointment> appointments;
	public Person(String idnum,String f,String l, String login, String password, String em,boolean isPatient) {
		super();
		this.id = idnum;
		this.fname = f;
		this.lname = l;
		this.email = em;
		this.login = login;
		this.password = password;
		this.isPatient = isPatient;
		appointments = new ArrayList<Appointment>();
	}
	
	public String getEmail(){
		return this.email;
	}

	public void setEmail(String em){
		this.email = em;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String i){
		this.id = i;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPatient() {
		return isPatient;
	}
	public ArrayList<Appointment> getAppointments(){
		return appointments;
	}
	
	
	public void addAppointment(Appointment A) {
		for (int i=0;i<appointments.size();i++) {
			TimeSlot ts = appointments.get(i).getSlot();
			if (A.getSlot().equals(ts)) {
				System.out.println("Error, you are busy during that time with another appt");
				return;
			}
		}
		
		appointments.add(A);
		this.sortAppointments();
	}
	
	public void removeAppointment(Appointment A) {
	
		if (appointments.remove(A)) {
			this.sortAppointments();
			return;
		}
		System.out.println("That Appointment Doesnt Exist");
		
	}
	
	private void sortAppointments() {
		appointments.sort(null);
	}
	
	@Override
	public boolean equals(Object o) {
		Person p = (Person) o;
		if (!this.getFname().equalsIgnoreCase(p.getFname())) {return false;}
		if (!this.getLname().equalsIgnoreCase(p.getLname())) {return false;}
		return (this.isPatient()&& p.isPatient());

	}
	
	

}
