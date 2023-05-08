package com.cophea;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class SelectDoctorController implements Initializable {
    
    @FXML
    Button btnSelect;

    ArrayList<Employee> emps;
    ObservableList<String> names;

    @FXML
    ListView<String> lstDoctors;

    public void initialize(URL u,ResourceBundle r) {
        //get the doctors form the csv
        try {
            emps = DataManager.getAllEmployees();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
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
        StageManager.getInstance().setCurrEmployee(emps.get(pickedIndex));

        StageManager.getInstance().goToPickAppt();
    }

    @FXML
    public void goBack() throws IOException{
        StageManager.getInstance().goToPatientMenu();
    }
}
