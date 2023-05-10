package com.cophea;

import javafx.application.Application;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


//import java.io.IOException;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //FXMLLoader loader = new FXMLLoader();
		//Parent parent = FXMLLoader.load(getClass().getResource("/com/cophea/dataTesting.fxml"));
		
		//System.out.println(StageManager.getInstance().getParent());
		
		//Login(stage);
		//f.t1();

	
		//StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrSplashv1.fxml")));


		//manually activate the gotoLogin() function to set the stage object to the StageManager
		StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrLoginCOPHEA.fxml")));

		StageManager.getInstance().setStage(stage);
		StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));

		StageManager.getInstance().getStage().setTitle("Welcome");
		StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
		StageManager.getInstance().getStage().show();
		
		//StageManager.getInstance().Fade();

		StageManager.getInstance().goToLogin();
    }
	public static void main(String[] args) {
        launch(args);
	}

	//TODO fix images and splash screen, and data
	
	
	

	// public void Login(Stage stage) throws IOException{
	// 	FXMLLoader loader = new FXMLLoader();
	// 	Parent parent = loader.load(getClass().getResource("/com/cophea/scrLoginCOPHEA.fxml"));

	// 	TextField txtUser = (TextField) loader.getNamespace().get("txtUser");
	// 	PasswordField txtPass = (PasswordField) loader.getNamespace().get("txtPass");
	// 	Button btnLogin = (Button) loader.getNamespace().get("btnLogin");
	// 	int attempts = 0;

	// 	Scene scene = new Scene(parent);
	// 	stage.setTitle("Cophea");
	// 	stage.setScene(scene);
	// 	stage.show();

	// 	btnLogin.setOnAction(new EventHandler<ActionEvent>() {

	// 		@Override
	// 		public void handle(ActionEvent arg0) {
	// 			String use = txtUser.getText();
	// 			String pw = txtPass.getText();
	// 			String check = "";
	// 			try {check = DataManager.loadPersonLogin(use, pw);}
	// 			catch (Exception e){}
				
	// 			if (attempts>3){System.exit(69);}
	// 			if (check.equals("fail")){
	// 				System.out.println("failed login");
	// 				//attempts++;
	// 			}
	// 			else {
	// 				try {
	// 					PatientMenu(stage);
	// 				} catch (IOException e) {
						
	// 					e.printStackTrace();
	// 				}
	// 			}
			
	// 		}
			
	// 	});
		

	// 	//Parent parent = FXMLLoader.load(getClass().getResource("/com/cophea/scrLoginCOPHEA.fxml"));
		
		

	// }

	// public void PatientMenu(Stage stage) throws IOException{
	// 	stage = new Stage();
	// 	Parent parent = FXMLLoader.load(getClass().getResource("/com/cophea/scrMenu.fxml"));
	// 	Scene scene = new Scene(parent);
	// 	PatientMenuController PMC = PatientMenuController.getInstance();

	// 	stage.setTitle("Main Menu");
	// 	stage.setScene(scene);
	// 	stage.show();
	// }

	//ASK PROF
	//NEED 2 TYPES OF PEOPLE?
	//just 1 login - patient
	//SUBMIT JAR EXE OR NO?
	//jar and zip??



    // SEND AN EMAIL TO CONFIRM APPOINT
	
	//patient menu
	//add appointment -> pick doctor -> pick slot -> confirm -> "hey thanks, email has been sent!"
	//change or cancel appointment -> pick appoint 
	//view doctors
	
	//employee menu
	//view appointments
	//changing schedule (cancelling apointments?)
	//pick weekly schedule not specific dates
	
	//ignore this function, was used for testing purposes before the final product was complete
	public static void fileTesting() throws IOException {
		//System.out.println("here we go!");
		File peepsFile = new File("Cophea/src/main/resources/com/cophea/people.csv");
		Scanner scan = new Scanner(peepsFile);
		//skip the line with the categories
		scan.nextLine();
		String[] lineValues = new String[7];
		String line;
		ArrayList<Patient> sickPeeps = new ArrayList<Patient>();
		ArrayList<Employee> workPeeps = new ArrayList<Employee>();
		while (scan.hasNext()){
			line = scan.nextLine();
			//System.out.println(line);
			lineValues = line.split(",");
			if (Boolean.parseBoolean(lineValues[6])){
				sickPeeps.add(new Patient(lineValues[0], lineValues[1], lineValues[2], lineValues[3],lineValues[4]));
			}
			else {
				//System.out.println("doctor found");
				workPeeps.add(new Employee(lineValues[0], lineValues[1], lineValues[2], lineValues[3],lineValues[4],lineValues[7]));
			}
		}
		scan.close();
		// for (int i=0;i<sickPeeps.size();i++){
		// 	System.out.println(sickPeeps.get(i));
		// }
		// System.out.println("workers below:");
		// for (int i=0;i<workPeeps.size();i++){
		// 	System.out.println(workPeeps.get(i));
		// }

		// LOAD THE WORKSLOTS CSV WITH DATA
		// for (int i=0;i<workPeeps.size();i++){
		// 	String id = workPeeps.get(i).getId();
		// 	String partialPath = "Cophea/src/main/resources/com/cophea/ws/";
		// 	String wsPath = partialPath+id;
		// 	File currFile = new File(wsPath+"_workinghours.csv");
			
			
		// 	//if file doesnt exist, intilize it
		// 	if (!currFile.isFile()){
		// 		System.out.println("NEW FILE BEING MADE");

		// 		currFile.createNewFile();
		// 		FileWriter fw = new FileWriter(currFile,false);
		// 		fw.write("year,month,day,hour");
		// 		//close the writer to "save" the file
		// 		fw.close();
		// 	}
		// 	FileWriter fw = new FileWriter(currFile,true);
		// 	for (int q=4;q<24;q++){
		// 		fw.write("\n");
		// 		fw.write("2023,5,"+String.valueOf(q)+","+String.valueOf((int)(Math.random()*(17-9)+1)+9));
		// 	}
		// 	fw.close();
		// }

		
		
		//LOAD EMP WORKSLOTS ARRAYLIST WITH THE ONES FROM THE FILE
		//LOAD EMPLOYEES WITH APPOINTMENTS
		for (int i=0;i<workPeeps.size();i++){
			Employee currPeep = workPeeps.get(i);
			String id = currPeep.getId();
			String partialPath = "Cophea/src/main/resources/com/cophea/ws/";
			String wsPath = partialPath+id;
			File currFile = new File(wsPath+"_workinghours.csv");
			scan = new Scanner(currFile);
			scan.nextLine();
        	while(scan.hasNext()){
            	lineValues = scan.nextLine().split(",");
            	currPeep.addSlot(new TimeSlot(
                Integer.parseInt(lineValues[0]),
                Integer.parseInt(lineValues[1]),
                Integer.parseInt(lineValues[2]),
                Integer.parseInt(lineValues[3])));
        }
			




			 partialPath = "Cophea/src/main/resources/com/cophea/appt/";
			 wsPath = partialPath+id;
			 currFile = new File(wsPath+"_appts.csv");
			
			
			//if file doesnt exist, intilize it
			if (!currFile.isFile()){
				System.out.println("NEW FILE BEING MADE");

				currFile.createNewFile();
				FileWriter fw = new FileWriter(currFile,false);
				fw.write("emp_id,p_id,year,month,day,hour");
				//close the writer to "save" the file
				fw.close();
			}
			System.out.println(currPeep);
			FileWriter fw = new FileWriter(currFile,true);
			for (int q=0;q<currPeep.getSlots().size();q++){
				System.out.println(q);
				TimeSlot currSlot = currPeep.getSlots().get(q);
				String timing1 = String.valueOf(currSlot.getStart().getYear())+","+String.valueOf(currSlot.getStart().getMonthValue())+",";
				String timing2 = String.valueOf(currSlot.getStart().getDayOfMonth())+","+String.valueOf(currSlot.getStart().getHour());
				fw.write("\n");
				fw.write(currPeep.getId()+","+"0"+","+timing1+timing2);
			}
			fw.close();
		}
		
	}

	//ignore this function, was used for testing purposes before the final product was complete
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
	//ignore this function, was used for testing purposes before the final product was complete
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
	//ignore this function, was used for testing purposes before the final product was complete
	public static void empTesting2() {
		Employee dave = new Employee("dave","silverman","login","pw","Doctor");
		Patient p1 = new Patient("Ryan","F","user","pass");
		TimeSlot t1 = new TimeSlot(2023, 1, 1, 14);
		dave.addAppointment(new Appointment(dave,p1,t1));
		//dave.addAppointment(new Appointment(dave,p1,t1));
		dave.removeAppointment(new Appointment(dave,p1,t1));
		dave.removeAppointment(new Appointment(dave,p1,t1));
	}
	//ignore this function, was used for testing purposes before the final product was complete
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
	//ignore this function, was used for testing purposes before the final product was complete
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
