package com.cophea;

import java.util.ArrayList;

public class Appointment implements Comparable<Appointment> {
	private String id;
	private ArrayList<Employee> providers;
	private Patient patient;
	private TimeSlot slot;
	
	
	
	public Appointment() {
		//blank constructor
		providers = new ArrayList<Employee>();
	}
	
	public Appointment(Employee e,Patient p,TimeSlot ts) {
		this.providers = new ArrayList<Employee>();
		this.providers.add(e);
		this.patient = p;
		this.slot = ts;
		
	}
	

	
	public ArrayList<Employee> getProviders() {
		return providers;
	}
	public void addProvider(Employee e) {
		providers.add(e);
	}
	public void removeProvider(Employee e) {
		providers.remove(e);
	}
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
		
		if (patVal && timeVal == 0) {return true;}
		return false;
	}

	public String toString(){
		return(this.patient.getFname()+" "+this.slot);
	}
	
}
