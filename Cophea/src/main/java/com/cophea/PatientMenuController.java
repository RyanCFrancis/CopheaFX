package com.cophea;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

public class PatientMenuController implements Initializable{
    
    
    private static PatientMenuController instance;

    public static synchronized PatientMenuController getInstance(){
        return instance = new PatientMenuController();
    }

    public void initialize(URL u, ResourceBundle r){

    }

    @FXML
    RadioButton optScheduleAppt;

    @FXML
    RadioButton optModifyAppt;

    @FXML
    RadioButton optViewDoctors;

    @FXML
    public void continueBtn(){
        
    }

    @FXML
    public void backBtn(){

        
    }
}
