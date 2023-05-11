package com.cophea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;





import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConfirmationController implements Initializable {
    
    //button used to send the email after it is entered
    @FXML
    Button btnSend;

    //title text
    @FXML
    TextField txtConfirmation;
    //text for the email the yser enters
    @FXML
    TextField txtEmail;

    //displays the appointment time and with which doctor
    @FXML
    TextArea txtDescription;

    public void initialize(URL u,ResourceBundle r) {
       Employee Doctor = StageManager.getInstance().getCurrEmployee();
       TimeSlot AppoTime = StageManager.getInstance().getCurrTimeSlot();

       txtConfirmation.setText("Your Appointment has been made!");
       txtDescription.setText("You have an Appointment with "+"Dr:"+Doctor.getLname()+" at "+AppoTime);

    }

    //incomplete, will send out email to the user
    @FXML
    public void sendBtn() throws IOException{
        //As of 5/10/23 the email part of the code was not sent over by Tony
        String emailString = txtEmail.getText();
        //System.out.println("Tony Time");
    }
    //exits the program
    @FXML
    public void exitBtn() {
        System.exit(0);
    }
}
