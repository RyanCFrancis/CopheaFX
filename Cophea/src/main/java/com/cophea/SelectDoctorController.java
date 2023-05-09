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
import javafx.scene.control.ListView;

public class SelectDoctorController implements Initializable {
    
    @FXML
    Button btnSelect;

    ArrayList<Employee> emps;
    ObservableList<String> names;

    @FXML
    ListView<String> lstDoctors;

    boolean isPickingAppts;

    public void initialize(URL u,ResourceBundle r) {
        //get the doctors form the csv
        try {
            emps = DataManager.getAllEmployees();
        } catch (FileNotFoundException e) {
            StageManager.getInstance().PopupError("System Error",e.getMessage());
        }
        //load the names into an observable list for the listview to access
        ObservableList<String> names = FXCollections.observableArrayList();
        for (int i=0;i<emps.size();i++){
            names.add(emps.get(i).getLname());
        }
        lstDoctors.setItems(names);
    }

    @FXML
    public void selectBtn() throws IOException{
        int pickedIndex = lstDoctors.getSelectionModel().getSelectedIndex();
        if (pickedIndex == -1){
            StageManager.getInstance().PopupError("Please Pick a Doctor", "You did not pick a doctor");
            return;
        }
        StageManager.getInstance().setCurrEmployee(emps.get(pickedIndex));
        if (StageManager.getInstance().isPickingAppts()){
            StageManager.getInstance().goToPickAppt();
        }
        else {
            StageManager.getInstance().goToDoctorInfo();
        }
    }

    @FXML
    public void goBack() throws IOException{
        
        if (StageManager.getInstance().isPickingAppts()){
            StageManager.getInstance().goToPatientMenu();
        }
        else {
            StageManager.getInstance().goToPatientMenu();
        }
    }
}
