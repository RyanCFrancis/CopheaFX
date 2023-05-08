package com.cophea;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class DocInfoController implements Initializable {
    
    @FXML
    Label lblDoctor;

    @FXML
    TextArea txtDescription;

    @FXML
    TextArea txtAvailability;

    @FXML
    Button btnGoBack;

    

    public void initialize(URL u,ResourceBundle r) {
       
    }

    //TODO if no apps, say u have none
    @FXML
    public void goBack() throws IOException{
       StageManager.getInstance().goToPatientMenu();
    }
}
