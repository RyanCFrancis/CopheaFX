package com.cophea;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;



import java.time.DayOfWeek;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //FXMLLoader loader = new FXMLLoader();
        Parent parent = FXMLLoader.load(getClass().getResource("/com/cophea/scrAppts.fxml"));
		Scene scene = new Scene(parent);
		stage.setTitle("test");
		stage.setScene(scene);
		stage.show();


    }

    // SEND AN EMAIL TO CONFIRM APPOINT
	
	//patient menu
	//add appointment
	//change or cancel appointment
	//view doctors

	//employee menu
	//view appointments
	//changing schedule (cancelling apointments?)
	//pick weekly schedule not specific dates
	public static void main(String[] args) {
        //scheduleTesting();
        launch(args);
		
	}

	public static void scheduleTesting(){
		Employee dave = new Employee("dave","silverman","login","pw","Doctor");
		Patient p1 = new Patient("Ryan","F","user","pass");
		for (int i=1;i<20;i++){
			TimeSlot t = new TimeSlot(2023, 1, i, 14);
			if (t.getStart().getDayOfWeek() != DayOfWeek.SATURDAY && t.getStart().getDayOfWeek() != DayOfWeek.SUNDAY){
				dave.addSlot(t);
			}
		}
		for (int i = 0; i < dave.getSlots().size(); i++) {
			dave.addAppointment(new Appointment(dave, p1, dave.getSlots().get(i)));
		}
		System.out.println(dave.getAppointments());
		
	}
	
	public static void empTesting1() {
		Employee dave = new Employee("dave","silverman","login","pw","Doctor");
		//Employee dave2 = new Employee("dave2","silverman","login","pw","Doctor");
		
		TimeSlot t1 = new TimeSlot(2023, 1, 1, 14);
		dave.addSlot(t1);
		dave.addSlot(new TimeSlot(2023, 1, 1, 14));
		dave.removeSlot(t1);
		dave.addSlot(t1);
		dave.removeSlot(t1);
		dave.removeSlot(t1);
	}
	public static void empTesting2() {
		Employee dave = new Employee("dave","silverman","login","pw","Doctor");
		Patient p1 = new Patient("Ryan","F","user","pass");
		TimeSlot t1 = new TimeSlot(2023, 1, 1, 14);
		dave.addAppointment(new Appointment(dave,p1,t1));
		//dave.addAppointment(new Appointment(dave,p1,t1));
		dave.removeAppointment(new Appointment(dave,p1,t1));
		dave.removeAppointment(new Appointment(dave,p1,t1));
	}
	
	public static void appoTesting() {
		Appointment a = new Appointment();
		Patient p1 = new Patient("Ryan","F","user","pass");
		Patient p2 = new Patient("yan","F","user","pass");
		
		a.setPatient(p1);
		Appointment b = new Appointment();
		b.setPatient(p2);
		a.setSlot(new TimeSlot(2023, 1, 1, 14));
		b.setSlot(new TimeSlot(2023, 1, 1, 14));
		
		System.out.println(a.compareTo(b));
		System.out.println(a.equals(b));
		
	}
	public static void tsTesting() {
		
				TimeSlot t1 = new TimeSlot(2023, 1, 1, 14);
				TimeSlot t2 = new TimeSlot(2023, 1, 1, 12);
				System.out.println(t1.compareTo(t2));
				
				ArrayList<TimeSlot> tstest = new ArrayList<TimeSlot>();
				//fill up tstest with data in reverse order
				for (int i = 22;i>0;i--) {
					tstest.add(new TimeSlot(2023,1,1,i));
				}
				//test sorting by time, earlier timeslots go first in the arraylist
				System.out.println(tstest);
				System.out.println("woosh");
				tstest.sort(null);
				System.out.println(tstest);
		
	}

}
