package com.cophea;

import java.util.ArrayList;

public class Patient extends Person {

	//UNUSUED
	//list of diagnosis the patient has
	private ArrayList<String> diag;
	

	public Patient(String f,String l, String login, String password) {
		super("0",f,l, login, password, true);
		this.diag = new ArrayList<String>();
	}

	public Patient(String i,String f,String l, String login, String password) {
		super(i,f,l, login, password, true);
		this.diag = new ArrayList<String>();
	}
	
	public void addDiag(String d) {
		diag.add(d);
	}
	
	public void removeDiag(String d) {
		diag.remove(d);
	}
	
	

}
