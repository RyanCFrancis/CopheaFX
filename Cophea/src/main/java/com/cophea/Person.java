package com.cophea;

import java.util.ArrayList;

public class Person {
	//an id to identify the person
	private String id;
	//UNUSED- the email of the person
	private String email;
	//first and last name of the person
	private String fname,lname;
	//the login username the person uses to log into their account
	private String login;
	//the persons password
	private String password;
	//if true, the person object is a patient, otherwise they are a doctor or surgeon or nurse or etc.
	private boolean isPatient;
	//list of appointments the person has, includes ones that have AND have not occured yet
	private ArrayList<Appointment> appointments;
	public Person(String idnum,String f,String l, String login, String password,boolean isPatient) {
		super();
		this.id = idnum;
		this.fname = f;
		this.lname = l;
		//this.email = em;
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
	
	//adds an appointment to the person's appointment arraylist
	public void addAppointment(Appointment A) {
		//loop through all existing apointments and check if there is a time overlap
		for (int i=0;i<appointments.size();i++) {
			TimeSlot ts = appointments.get(i).getSlot();
			if (A.getSlot().equals(ts)) {
				System.out.println("Error, you are busy during that time with another appt");
				return;
			}
		}
		//actually adds the appointment to the person's list, then sorts it
		appointments.add(A);
		this.sortAppointments();
	}
	
	//remove an appointment that is equavalent to one in the arraylist, if it doesnt exist it prints an error
	public void removeAppointment(Appointment A) {
		

		if (appointments.remove(A)) {
			this.sortAppointments();
			return;
		}
		System.out.println("That Appointment Doesnt Exist");
		
	}
	
	//since the appointment class was made using the COmparable interface, the default sort is used to sort the appointment
	// arraylist from early happening appointments to later occuring ones
	private void sortAppointments() {
		appointments.sort(null);
	}
	
	//returns true if the person object being compared has the same id
	//otherwise false
	@Override
	public boolean equals(Object o) {
		Person p = (Person) o;
		if (this.getId().equals(p.getId())){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return(this.fname+" "+this.lname);
	}
	

}
