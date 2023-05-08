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
import javafx.scene.control.RadioButton;

public class ModifyApptController implements Initializable {
    
    @FXML
    Button btnSelect;

    @FXML
    RadioButton optChange;

    @FXML
    RadioButton optCancel;

    ArrayList<Appointment> Appts;
    ObservableList<String> names;

    @FXML
    ListView<String> lstAppts;

    public void initialize(URL u,ResourceBundle r) {
        //get the doctors form the csv
        try {
            DataManager.loadAppts(StageManager.getInstance().getUser());
            System.out.println(StageManager.getInstance().getUser().getAppointments());
            Appts = StageManager.getInstance().getUser().getAppointments();
            System.out.println(Appts.toString());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //load the names into an observable list for the listview to access
        ObservableList<String> names = FXCollections.observableArrayList();
        for (int i=0;i<Appts.size();i++){
            String apptLine = "";
            apptLine = Appts.get(i).getSlot().toString() +" with Dr."+Appts.get(i).getProvider().getLname();
            names.add(apptLine);
        }
        lstAppts.setItems(names);
        //System.out.println(names.get(0));
    }

    //TODO if no apps, say u have none
    @FXML
    public void continueBtn() throws IOException{
        int pickedIndex = lstAppts.getSelectionModel().getSelectedIndex();
        StageManager.getInstance().setCurrApp(Appts.get(pickedIndex));
        DataManager.deleteAppointment(Appts.get(pickedIndex));
        if (optChange.isSelected()){
            StageManager.getInstance().setCurrEmployee(StageManager.getInstance().getCurrApp().getProvider());
            StageManager.getInstance().getStage().hide();
            StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrAppts.fxml")));
            StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
            StageManager.getInstance().getStage().setTitle("Cophea");
            StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
            StageManager.getInstance().getStage().show();
        }
        if (optCancel.isSelected()){
            //TODO IDK MAKE A POPUP?
            System.out.println("Your Appt was Deleted");
        }

        
    }
}
