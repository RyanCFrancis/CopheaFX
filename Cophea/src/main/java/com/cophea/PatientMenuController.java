package com.cophea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    public void continueBtn() throws IOException{
        if (optScheduleAppt.isSelected()){
            //look at list of doctors to pick
            StageManager.getInstance().getStage().hide();
            StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrSelectDoctor.fxml")));
            StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
		    StageManager.getInstance().getStage().setTitle("Cophea");
		    StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
		    StageManager.getInstance().getStage().show();
        }
    }

    @FXML
    public void backBtn(){

        
    }
}
