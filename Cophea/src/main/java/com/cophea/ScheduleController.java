package com.cophea;

//import javafx.application.Application;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ScheduleController implements Initializable {

        
        @FXML
        ToggleGroup timeSlots;

        @FXML
		RadioButton btnMon9AM;
        @FXML
		RadioButton btnMon10AM;
        @FXML
		RadioButton btnMon11AM;
        @FXML
		RadioButton btnMon12PM;
        @FXML
		RadioButton btnMon1PM;
        @FXML
		RadioButton btnMon2PM;
        @FXML
		RadioButton btnMon3PM;
        @FXML
		RadioButton btnMon4PM;
        @FXML
		RadioButton btnMon5PM;

        @FXML
		RadioButton btnTues9AM;
        @FXML
		RadioButton btnTues10AM;
        @FXML
		RadioButton btnTues11AM;
        @FXML
		RadioButton btnTues12PM;
        @FXML
		RadioButton btnTues1PM;
        @FXML
		RadioButton btnTues2PM;
        @FXML
		RadioButton btnTues3PM;
        @FXML
		RadioButton btnTues4PM;
        @FXML
		RadioButton btnTues5PM;

        @FXML
		RadioButton btnWed9AM;
        @FXML
		RadioButton btnWed10AM;
        @FXML
		RadioButton btnWed11AM;
        @FXML
		RadioButton btnWed12PM;
        @FXML
		RadioButton btnWed1PM;
        @FXML
		RadioButton btnWed2PM;
        @FXML
		RadioButton btnWed3PM;
        @FXML
		RadioButton btnWed4PM;
        @FXML
		RadioButton btnWed5PM;

        @FXML
		RadioButton btnThurs9AM;
        @FXML
		RadioButton btnThurs10AM;
        @FXML
		RadioButton btnThurs11AM;
        @FXML
		RadioButton btnThurs12PM;
        @FXML
		RadioButton btnThurs1PM;
        @FXML
		RadioButton btnThurs2PM;
        @FXML
		RadioButton btnThurs3PM;
        @FXML
		RadioButton btnThurs4PM;
        @FXML
		RadioButton btnThurs5PM;

        @FXML
		RadioButton btnFri9AM;
        @FXML
		RadioButton btnFri10AM;
        @FXML
		RadioButton btnFri11AM;
        @FXML
		RadioButton btnFri12PM;
        @FXML
		RadioButton btnFri1PM;
        @FXML
		RadioButton btnFri2PM;
        @FXML
		RadioButton btnFri3PM;
        @FXML
		RadioButton btnFri4PM;
        @FXML
		RadioButton btnFri5PM;
    
 

        @FXML
        Button btnContinue;

        RadioButton[] buttons;

        @FXML
        public void initialize(URL l, ResourceBundle r){
            
        }

        @FXML
        public void testy(ActionEvent e){
            btnMon9AM.setText("lol");
            //this.buttons[10].setText("10");
            
        }
        
        
        

        //timeslot should be a monday at 9am
        public void updateSchedule(Employee e,TimeSlot tempTS) {
           System.out.println();
           System.out.println("is this printing");
           //btnMon9AM.setText("lol");
           //buttons[0].setText("xd");
           //System.out.println(btnMon9AM.getText());
           
            //System.out.println("hmm");
            if (tempTS.getStart().getDayOfWeek() != DayOfWeek.MONDAY){
                System.out.println("NOT A MONDAY");System.exit(59);
            }
            ArrayList<Appointment> activeApps = e.getAppointments();
            ArrayList<TimeSlot> workingHours = e.getSlots();
            
            int i=0;
            while (i<46){
                for (int q=0;q<workingHours.size();q++){
                    if (tempTS.equals(workingHours.get(q))){
                        //System.out.println("lol");
                        //buttons[i].setText("wow");
                    }
                }
                if (i % 9 ==0){
                    tempTS = tempTS.incDay();
                }
                else {
                    tempTS = tempTS.incHour();
                }
                i++;
            }
            

        }
		
		public ScheduleController(){
            buttons = new RadioButton[90];
            for (int i=0;i<timeSlots.getToggles().toArray().length;i++){
                buttons[i] = (RadioButton) timeSlots.getToggles().toArray()[i];
            } 

            // RadioButton[] buttons = {
            //     btnMon9AM,btnMon10AM,btnMon11AM,btnMon12PM,btnMon1PM,btnMon2PM,btnMon3PM,btnMon4PM,btnMon5PM,
            //     btnTues9AM,btnTues10AM,btnTues11AM,btnTues12PM,btnTues1PM,btnTues2PM,btnTues3PM,btnTues4PM,btnTues5PM,
            //     btnWed9AM,btnWed10AM,btnWed11AM,btnWed12PM,btnWed1PM,btnWed2PM,btnWed3PM,btnWed4PM,btnWed5PM,
            //     btnThurs9AM,btnThurs10AM,btnThurs11AM,btnThurs12PM,btnThurs1PM,btnThurs2PM,btnThurs3PM,btnThurs4PM,btnThurs5PM,
            //     btnFri9AM,btnFri10AM,btnFri11AM,btnFri12PM,btnFri1PM,btnFri2PM,btnFri3PM,btnFri4PM,btnFri5PM
            // };
            
        }
    
}