package com.cophea;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

public class ModifyApptController implements Initializable {
    
    //the continue button
    @FXML
    Button btnSelect;

    //toggle button to choose to change the appointment timing
    @FXML
    RadioButton optChange;

    //cancel the appointment entirely
    @FXML
    RadioButton optCancel;

    //appointments the user has
    ArrayList<Appointment> upcomingAppts;
    ArrayList<Appointment> tempAppts;
    ObservableList<String> names;
    boolean hasAppts;

    @FXML
    ListView<String> lstAppts;

    public void initialize(URL u,ResourceBundle r) {
        hasAppts = true;
        //get the doctors form the csv
        try {
            DataManager.loadAppts(StageManager.getInstance().getUser());
            //loop through the database appointments and only add those that have not occured yet
            tempAppts = StageManager.getInstance().getUser().getAppointments();

            for (int p=0;p<tempAppts.size();p++){
                TimeSlot today = new TimeSlot(OffsetDateTime.now());
                if (today.compareTo(tempAppts.get(p).getSlot()) == -1){
                    upcomingAppts.add(tempAppts.get(p));
                }
            }
            //System.out.println(Appts.toString());
        } catch (FileNotFoundException e) {System.out.println(e.getMessage());}
        
        //load the names into an observable list for the listview to access
        ObservableList<String> names = FXCollections.observableArrayList();
        for (int i=0;i<upcomingAppts.size();i++){
            String apptLine = "";
            apptLine = upcomingAppts.get(i).getSlot().toString() +" with Dr."+upcomingAppts.get(i).getProvider().getLname();
            if (apptLine.length()>0){
                names.add(apptLine);
            }
            
        }
        if (names.isEmpty()){
            names.add("You have no Appointments!");
            hasAppts = false;
        }
        lstAppts.setItems(names);
        //System.out.println(names.get(0));
    }

    
    @FXML
    public void continueBtn() throws IOException{
        //error if no appt is chosen
        if (lstAppts.getSelectionModel().getSelectedIndex()==-1){
            //System.out.println("please select an appointment");
            StageManager.getInstance().PopupError("No Appointment", "please select an appointment");
            return;
        }
        if (!optChange.isSelected() && !optCancel.isSelected()){
            //System.out.println("please pick an option to cancel or change your appointment time");
            StageManager.getInstance().PopupError("Pick a Choice", "Please pick an option to cancel or change your appointment time");
            return;
        }

        if (hasAppts){
            int pickedIndex = lstAppts.getSelectionModel().getSelectedIndex();
            StageManager.getInstance().setCurrApp(upcomingAppts.get(pickedIndex));
            DataManager.deleteAppointment(upcomingAppts.get(pickedIndex));
            if (optChange.isSelected()){
                StageManager.getInstance().setCurrEmployee(StageManager.getInstance().getCurrApp().getProvider());
                StageManager.getInstance().goToPickAppt();
            }
            if (optCancel.isSelected()){
                
                //System.out.println("Your Appt was Deleted");
                StageManager.getInstance().PopupInfo("Appointment Cancelled", "Your Appointment was Cancelled!");
                StageManager.getInstance().goToPatientMenu();
            }
        }
        else {
            return;
        }
       
    }

    @FXML
    public void goBack() throws IOException{
        StageManager.getInstance().goToPatientMenu();
    }
}
