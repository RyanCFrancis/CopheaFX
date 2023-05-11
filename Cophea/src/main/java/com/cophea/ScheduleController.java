package com.cophea;

//import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
//import javafx.scene.control.Toggle;
//import javafx.scene.control.ToggleGroup;

//import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
//import java.util.List;
import java.time.DayOfWeek;
import java.net.URL;
import java.util.ResourceBundle;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;

import java.io.IOException;

public class ScheduleController implements Initializable {

    Employee currEmployee;
    TimeSlot nearestMonday; 
    TimeSlot today;
    
    @FXML
    Label lblWeek;
    @FXML
    Label lblTitle;
    @FXML
    Button btnPrevWeek;
    @FXML
    Button btnNextWeek;


    @FXML
    RadioButton optMon9AM;
    @FXML
    RadioButton optMon10AM;
    @FXML
    RadioButton optMon11AM;
    @FXML
    RadioButton optMon12PM;
    @FXML
    RadioButton optMon1PM;
    @FXML
    RadioButton optMon2PM;
    @FXML
    RadioButton optMon3PM;
    @FXML
    RadioButton optMon4PM;
    @FXML
    RadioButton optMon5PM;

    @FXML
    RadioButton optTues9AM;
    @FXML
    RadioButton optTues10AM;
    @FXML
    RadioButton optTues11AM;
    @FXML
    RadioButton optTues12PM;
    @FXML
    RadioButton optTues1PM;
    @FXML
    RadioButton optTues2PM;
    @FXML
    RadioButton optTues3PM;
    @FXML
    RadioButton optTues4PM;
    @FXML
    RadioButton optTues5PM;

    @FXML
    RadioButton optWed9AM;
    @FXML
    RadioButton optWed10AM;
    @FXML
    RadioButton optWed11AM;
    @FXML
    RadioButton optWed12PM;
    @FXML
    RadioButton optWed1PM;
    @FXML
    RadioButton optWed2PM;
    @FXML
    RadioButton optWed3PM;
    @FXML
    RadioButton optWed4PM;
    @FXML
    RadioButton optWed5PM;

    @FXML
    RadioButton optThurs9AM;
    @FXML
    RadioButton optThurs10AM;
    @FXML
    RadioButton optThurs11AM;
    @FXML
    RadioButton optThurs12PM;
    @FXML
    RadioButton optThurs1PM;
    @FXML
    RadioButton optThurs2PM;
    @FXML
    RadioButton optThurs3PM;
    @FXML
    RadioButton optThurs4PM;
    @FXML
    RadioButton optThurs5PM;

    @FXML
    RadioButton optFri9AM;
    @FXML
    RadioButton optFri10AM;
    @FXML
    RadioButton optFri11AM;
    @FXML
    RadioButton optFri12PM;
    @FXML
    RadioButton optFri1PM;
    @FXML
    RadioButton optFri2PM;
    @FXML
    RadioButton optFri3PM;
    @FXML
    RadioButton optFri4PM;
    @FXML
    RadioButton optFri5PM;



    @FXML
    Button btnContinue;

    
    
    
    private RadioButton[] buttons;
    private TimeSlot[] currentSlots;
    
    
    // private static ScheduleController instance;

    // public static synchronized ScheduleController getInstance(){
    //     return instance = new ScheduleController();
    // }

    @FXML
    public void initialize(URL u, ResourceBundle r){
        //System.out.println("uhhh");
        // RadioButton[] buttons = new RadioButton[]{
        // optMon9AM,optMon10AM,optMon11AM,optMon12PM,optMon1PM,optMon2PM,optMon3PM,optMon4PM,optMon5PM,
        // optTues9AM,optTues10AM,optTues11AM,optTues12PM,optTues1PM,optTues2PM,optTues3PM,optTues4PM,optTues5PM,
        // optWed9AM,optWed10AM,optWed11AM,optWed12PM,optWed1PM,optWed2PM,optWed3PM,optWed4PM,optWed5PM,
        // optThurs9AM,optThurs10AM,optThurs11AM,optThurs12PM,optThurs1PM,optThurs2PM,optThurs3PM,optThurs4PM,optThurs5PM,
        // optFri9AM,optFri10AM,optFri11AM,optFri12PM,optFri1PM,optFri2PM,optFri3PM,optFri4PM,optFri5PM,
        // };

        today = new TimeSlot(OffsetDateTime.now());
        
        nearestMonday = new TimeSlot(OffsetDateTime.now());
        nearestMonday.setMonday();
        

        try {
            loadData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        //System.out.println(buttons[10]);
        // Employee dave = new Employee("dave","Silverman","login","pw","Doctor");
        // currEmployee = dave;
		// Patient p1 = new Patient("Ryan","F","user","pass");
		// for (int i=1;i<20;i++){
		// 	TimeSlot t = new TimeSlot(2023, 5, i, 9);
            
		// 	//if (t.getStart().getDayOfWeek() != DayOfWeek.SATURDAY && t.getStart().getDayOfWeek() != DayOfWeek.SUNDAY){
		// 		dave.addSlot(t);
        //         TimeSlot t2 = new TimeSlot(2023, 5, i, 11);
        //         dave.addSlot(t2);
		// 	//}
		// }
		// for (int i = 0; i < dave.getSlots().size(); i++) {
		// 	//if (i%2==0){
		// 		dave.addAppointment(new Appointment(dave, p1, dave.getSlots().get(i)));
                
		// 	//}
		// }
        
    }
    public void loadData() throws IOException {
        // File testpeeps = new File("Cophea/src/main/resources/com/cophea/test.csv");
        // Scanner scan = new Scanner(testpeeps);

        // //load timeslots into java memory
        // scan.nextLine();
        // scan.nextLine();
        // scan.nextLine();
		// String[] lineValues = new String[8];
		// String line = scan.nextLine();
        // lineValues = line.split(",");
        // currEmployee = new Employee(lineValues[0], lineValues[1], lineValues[2], lineValues[3],lineValues[4],lineValues[7]);
        
        currEmployee = StageManager.getInstance().getCurrEmployee();
        DataManager.loadAppts(currEmployee);
        DataManager.loadWorkSlots(currEmployee);
        //scan.close();
        
        //load appts to java memory
        //System.out.println( currEmployee.getSlots());
        //System.out.println( currEmployee.getSlots());
        this.updateSchedule(nearestMonday);
        
    }

    @FXML
    public void testy(){
        

        //System.out.println(optMon9AM.getText());
        //optMon9AM.setText("lol");
        //buttons[10].setText("hmm");

        Employee dave = new Employee("dave","silverman","login","pw","Doctor");
		Patient p1 = new Patient("Ryan","F","user","pass");
		for (int i=1;i<8;i++){
			TimeSlot t = new TimeSlot(2023, 5, i, 15);
            
			//if (t.getStart().getDayOfWeek() != DayOfWeek.SATURDAY && t.getStart().getDayOfWeek() != DayOfWeek.SUNDAY){
				dave.addSlot(t);
                TimeSlot t2 = new TimeSlot(2023, 5, i, 16);
                dave.addSlot(t2);
			//}
		}
		for (int i = 0; i < dave.getSlots().size(); i++) {
			if (i%2==0){
				dave.addAppointment(new Appointment(dave, p1, dave.getSlots().get(i)));
                
			}
		}
        
		this.updateSchedule( new TimeSlot(2023, 1, 2, 9));
    }

    @FXML
    public void continuebtn() throws IOException{
   
        for (int z=0;z<buttons.length;z++){
           // System.out.println(z+" "+buttons[z].isSelected());
            if(buttons[z].isSelected()){
                TimeSlot pickedSlot = currentSlots[z];
                Appointment added = new Appointment(currEmployee,(Patient) StageManager.getInstance().getUser(), pickedSlot);
                DataManager.writeAppointment(currEmployee, added);

                StageManager.getInstance().setCurrTimeSlot(pickedSlot);

                StageManager.getInstance().getStage().hide();
                StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrConfirmation.fxml")));
                StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
                StageManager.getInstance().getStage().setTitle("Cophea");
                StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
                StageManager.getInstance().getStage().show();
            }
        }
        
    }
    @FXML
    public void nextWeekBtn(){
        nearestMonday = nearestMonday.nextWeek();
        this.updateSchedule(nearestMonday);
    }
    @FXML
    public void prevWeekBtn(){
        nearestMonday = nearestMonday.prevWeek();
        this.updateSchedule(nearestMonday);
    }

    @FXML
    public void goBack() throws IOException{
        StageManager.getInstance().goToPickDoctor(true);
    }
    
    

    //timeslot should be a monday at 9am
    public void updateSchedule(TimeSlot TS) {
    //System.out.println(TS);
      
        buttons = new RadioButton[]{
            optMon9AM,optMon10AM,optMon11AM,optMon12PM,optMon1PM,optMon2PM,optMon3PM,optMon4PM,optMon5PM,
            optTues9AM,optTues10AM,optTues11AM,optTues12PM,optTues1PM,optTues2PM,optTues3PM,optTues4PM,optTues5PM,
            optWed9AM,optWed10AM,optWed11AM,optWed12PM,optWed1PM,optWed2PM,optWed3PM,optWed4PM,optWed5PM,
            optThurs9AM,optThurs10AM,optThurs11AM,optThurs12PM,optThurs1PM,optThurs2PM,optThurs3PM,optThurs4PM,optThurs5PM,
            optFri9AM,optFri10AM,optFri11AM,optFri12PM,optFri1PM,optFri2PM,optFri3PM,optFri4PM,optFri5PM,
            };

        

        lblWeek.setText("Week of "+TS.getStart().getMonthValue()+"/"+TS.getStart().getDayOfMonth()+"/"+TS.getStart().getYear());
        lblTitle.setText("Showing Appointments for Dr."+currEmployee.getLname());
        //System.out.println("Week of "+TS.getStart().getMonthValue()+"/"+TS.getStart().getDayOfMonth()+"/"+TS.getStart().getYear());

        //fill the array with possible slots
        currentSlots = new TimeSlot[45];
        TimeSlot temp = new TimeSlot(TS.getStart());
        for (int i=0;i<currentSlots.length;i++){
            
            currentSlots[i] = temp;

            if (temp.getStart().getHour() == 17){
                temp = temp.nextDay();
                //System.out.println("day inc");
            }
            else {
                temp = temp.incHour();
                //System.out.println("hour inc");
            }

            //reset buttons to default text and state
            //unselect any buttons if they are selected already
            //this is necessary when changing the week you are viewing
            buttons[i].setSelected(false);
            buttons[i].setText("BUSY1");
            buttons[i].setDisable(true);
        }

        

        //System.out.println("hmm");
        if (TS.getStart().getDayOfWeek() != DayOfWeek.MONDAY){
            System.out.println("ERROR:NOT A MONDAY");
            System.out.print(TS);
            System.exit(69);
        }
        if (TS.getStart().getHour() != 9 && TS.getStart().getMinute() != 0){
            System.out.println("ERROR: NOT A 9AM");
            System.out.print(TS);
            System.exit(69);
        }
        ArrayList<Appointment> activeApps = currEmployee.getAppointments();
        //ArrayList<TimeSlot> workingHours = e.getSlots();
        //System.out.println(workingHours);

        //loop through the visible slots/possible buttons
        int i=0;
        while (i<45){ 

            

           //loop through working hours of the employee
           
            for (int q=0;q<currEmployee.getSlots().size();q++){
                // System.out.println();
                //System.out.println(TS);
                //System.out.println(currEmployee.getSlots().get(q));
                // System.out.println("---");

                //if the employee is working that hour, make the appointment available
                if (TS.equals(currEmployee.getSlots().get(q))){
                    buttons[i].setText("Available");
                    buttons[i].setDisable(false);
                }
                
                //System.out.println(workingHours.get(q));
            }

            //loop through busy appointments and disable the busy buttons
            for (int q=0;q<activeApps.size();q++){
                //System.out.println();
                //System.out.print(activeApps.get(q).getSlot()+" "+TS.toString());
                if (activeApps.get(q).getSlot().equals(TS)){
                   //System.out.println("true");
                   buttons[i].setText("BUSY");
                   buttons[i].setDisable(true);
                }
            }


            //disable the current button if that appointment has already passed in time
            if (today.compareTo(TS) == 1){
                buttons[i].setText("PASSED");
                buttons[i].setDisable(true);
            }
            //go to the "next" occuring timeslot
            // if it the end of a workday go the next date at 9am
            //otherwise just increment to the next hour
            if (TS.getStart().getHour() == 17){
                TS = TS.nextDay();
                //System.out.println("day inc");
            }
            else {
                TS = TS.incHour();
                //System.out.println("hour inc");
            }
            // System.out.println("temp ts value:");
            // System.out.println(tempTS);
            i++;
           
        }
        //System.out.println(currentSlots[9]);

    }
    
		
}