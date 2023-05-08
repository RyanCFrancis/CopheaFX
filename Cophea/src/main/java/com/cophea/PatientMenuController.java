package com.cophea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

public class PatientMenuController implements Initializable{
    
    
    

    // public static synchronized PatientMenuController getInstance(){
    //     return instance = new PatientMenuController();
    // }

    public void initialize(URL u, ResourceBundle r){

    }

    @FXML
    RadioButton optScheduleAppt;

    @FXML
    RadioButton optModifyAppt;

    @FXML
    RadioButton optViewDoctors;

    @FXML
    public void continueBtn() throws IOException{
        if (optScheduleAppt.isSelected()){
            //look at list of doctors to pick
            StageManager.getInstance().goToPickDoctor();
            
        }
        if (optModifyAppt.isSelected()) {
            StageManager.getInstance().goToModifyAppts();
        }

        if (optViewDoctors.isSelected()){
            StageManager.getInstance().goToDoctorInfo();
        }
    }

    @FXML
    public void exitBtn() throws IOException{
        System.exit(42);
    }
}
