package com.cophea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



//import io.github.cdimascio.dotenv.Dotenv;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConfirmationController implements Initializable {
    
    @FXML
    Button btnSend;

    @FXML
    TextField txtConfirmation;
    @FXML
    TextField txtEmail;

    @FXML
    TextArea txtDescription;

    public void initialize(URL u,ResourceBundle r) {
       Employee Doctor = StageManager.getInstance().getCurrEmployee();
       TimeSlot AppoTime = StageManager.getInstance().getCurrTimeSlot();

       txtConfirmation.setText("Your Appointment has been made!");
       txtDescription.setText("You have an Appointment with "+"Dr:"+Doctor.getFname()+" at "+AppoTime);

    }

    @FXML
    public void sendBtn() throws IOException{
        String emailString = txtEmail.getText();
        System.out.println("Tony Time");
    }

    @FXML
    public void exitBtn() {
        System.exit(0);
    }
}
