package com.cophea;

import java.util.ArrayList;

public class Patient extends Person {
	private ArrayList<String> diag;
	

	public Patient(String f,String l, String login, String password) {
		super("0",f,l, login, password,"go@gmail.com", true);
		this.diag = new ArrayList<String>();
	}
	
	public void addDiag(String d) {
		diag.add(d);
	}
	
	public void removeDiag(String d) {
		diag.remove(d);
	}
	
	

}
