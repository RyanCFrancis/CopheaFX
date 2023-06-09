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
            StageManager.getInstance().goToPickDoctor(true);
        }
        else if (optModifyAppt.isSelected()) {
            StageManager.getInstance().goToModifyAppts();
        }

        else if (optViewDoctors.isSelected()){
            StageManager.getInstance().goToPickDoctor(false);
        }
        else {
            StageManager.getInstance().PopupError("No Choice Picked", "Make sure to pick an option");
        }
        
    }

    @FXML
    public void exitBtn() throws IOException{
        System.exit(42);
    }
}
