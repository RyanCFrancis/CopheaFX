package com.cophea;

public class Appointment implements Comparable<Appointment> {
	//the doctor obj helping the patient
	private Employee provider;
	//the patient obj being treated
	private Patient patient;
	//the time the appointment is happening
	private TimeSlot slot;
	
	
	//UNUSED IN ACTUAL PRODUCTION
	public Appointment() {
		//blank constructor
		//providers = new ArrayList<Employee>();
	}
	
	public Appointment(Employee e,Patient p,TimeSlot ts) {
		//this.providers = new ArrayList<Employee>();
		//this.providers.add(e);
		this.provider = e;
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

	//UNUSED?
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
	//used to see if appointments already exist
	@Override
	public boolean equals(Object o) {
		Appointment b = (Appointment) o;
		int timeVal = this.getSlot().compareTo(b.getSlot());
		boolean patVal = this.getPatient().equals(b.getPatient());
		boolean empVal = this.getProvider().equals(b.getProvider());
		
		// System.out.println(timeVal);
		// System.out.println(patVal);
		// System.out.println(empVal);

		if (patVal && empVal && timeVal == 0) {return true;}
		return false;
	}

	public String toString(){
		return(this.patient.getFname()+" "+this.slot);
	}
	//used to "write" the necessary appt data to the database files so it can be accessed later
	public String write(){
		return this.provider.getId()+","+this.getPatient().getId()+","+this.getSlot().write();
	}
	
}
