package com.cophea;

import java.util.ArrayList;

public class Appointment implements Comparable<Appointment> {
	private String id;
	//MAKING JUST 1 DOCTOR PER APPOINTMENT
	private Employee provider;
	private Patient patient;
	private TimeSlot slot;
	
	
	
	public Appointment() {
		//blank constructor
		//providers = new ArrayList<Employee>();
	}
	
	public Appointment(Employee e,Patient p,TimeSlot ts) {
		//this.providers = new ArrayList<Employee>();
		//this.providers.add(e);
		this.provider=e;
		this.patient = p;
		this.slot = ts;
		
	}
	

	
	public Employee getProvider() {
		return provider;
	}
	public void addProvider(Employee e) {
		//providers.add(e);
		this.provider  =e;
	}
	// public void removeProvider(Employee e) {
	// 	providers.remove(e);
	// }
	public void setPatient(Patient p) {
		patient = p;
	}
	public Patient getPatient() {
		return patient;
	}



	public TimeSlot getSlot() {
		return slot;
	}
	public void setSlot(TimeSlot slot) {
		this.slot = slot;
	}

	//simply compares the appointment timing and if the patient is the same
	//TODO SET UP PROPER SORTING?
	public int compareTo(Appointment b) {
		int timeVal = this.getSlot().compareTo(b.getSlot());
		boolean patVal = this.getPatient().equals(b.getPatient());
		if (patVal) {
			if (timeVal == 0) {
				return 0;
			}
		}
		return timeVal;
	}
	
	@Override
	public boolean equals(Object o) {
		Appointment b = (Appointment) o;
		int timeVal = this.getSlot().compareTo(b.getSlot());
		boolean patVal = this.getPatient().equals(b.getPatient());
		boolean empVal = this.getProvider().equals(b.getProvider());
		
		if (patVal && timeVal == 0) {return true;}
		return false;
	}

	public String toString(){
		return(this.patient.getFname()+" "+this.slot);
	}

	public String write(){
		return this.provider.getId()+","+this.getPatient().getId()+","+this.getSlot().write();
	}
	
}
