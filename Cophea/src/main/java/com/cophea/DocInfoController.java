package com.cophea;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DocInfoController implements Initializable {
    
    //doctors name
    @FXML
    Label lblDoctor;

    //conditions the doctor treats
    @FXML
    TextArea txtDescription;

    //list of working hours that doctor is free
    @FXML
    TextArea txtAvailability;

    @FXML
    Button btnGoBack;

    //current doctor
    Employee currDoctor;
    //strings of the available timeslots
    ArrayList<String> availAppts;

    String condString = "Conditions they treat:";
    String avail = "Available Appointments:";

    public void initialize(URL u,ResourceBundle r) {
        currDoctor = StageManager.getInstance().getCurrEmployee();
        try {
            DataManager.updatePerson(currDoctor);
        } catch (FileNotFoundException e) { }
        this.availAppts = new ArrayList<String>();
        //System.out.println(currDoctor.getSlots().size());
        //System.out.println(currDoctor.getConditions().get(1));
        //add ALL WORKSLOTS to the list to write out
        for (int i=0;i<currDoctor.getSlots().size();i++){
            //System.out.println("chaos");
            TimeSlot currTimeSlot = currDoctor.getSlots().get(i);
            for (int q=0;q<currDoctor.getAppointments().size();q++){
                Appointment currAppt = currDoctor.getAppointments().get(q);
                //System.out.println("mayhem");
                //if the timeslots do not overlap/ the doctor is not busy with an appointment, add the timeslot string to the list of avail appts
                if (!currTimeSlot.equals(currAppt.getSlot())){
                    availAppts.add(currTimeSlot.toString());
                }
            }
            
        }
        lblDoctor.setText("Doctor "+currDoctor.getLname());
        //write out the conditions the doc treats
        
        for (int i=0;i<currDoctor.getConditions().size();i++){
            condString+=" "+currDoctor.getConditions().get(i)+",";
        }
        txtDescription.setText(condString.substring(0,condString.length()-1));
       
        for (int i=0;i<availAppts.size();i++){
            avail+="\n"+availAppts.get(i);
        }
        txtAvailability.setText(avail);
        //lblDoctor.setText(Integer.toString(availAppts.size()));
    }

    //TODO if no apps, say u have none
    @FXML
    public void goBack() throws IOException{
       StageManager.getInstance().goToPickDoctor(false);
    }
}
