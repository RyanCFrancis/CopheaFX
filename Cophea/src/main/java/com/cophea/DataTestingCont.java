package com.cophea;

//import javafx.application.Application;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

import java.io.File;
import java.util.Scanner; 
import java.io.FileNotFoundException;
import java.io.IOException;
public class DataTestingCont implements Initializable{

    Employee currEmployee;

    @FXML 
    Button v1;
    @FXML 
    Button v2;
    @FXML 
    Button v3;

    @FXML
    public  void initialize(URL u,ResourceBundle r) {
        try {
            currEmployee = DataManager.loadEmployee("2");
            DataManager.loadAppts(currEmployee);
            DataManager.loadWorkSlots(currEmployee);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @FXML
    public void v1func() throws IOException{
        System.out.println("v1 going");
        DataManager.writeWorkSlot(currEmployee, new TimeSlot(2023, 5, 9, 9));

    }

    @FXML
    public void v2func() throws FileNotFoundException, IOException{
        System.out.println("v2 going");
        DataManager.writeAppointment(currEmployee, new Appointment(currEmployee, DataManager.loadPatient("0"), new TimeSlot(2023, 5, 9, 9)));
    }

    @FXML
    public void v3func() throws FileNotFoundException, IOException{
        System.out.println("v3 going");
        DataManager.deleteAppointment(new Appointment(currEmployee, DataManager.loadPatient("0"), new TimeSlot(2023, 5, 9, 9)));
        DataManager.deleteWorkSlot(currEmployee, new TimeSlot(2023, 5, 9, 9));
    }
    
}