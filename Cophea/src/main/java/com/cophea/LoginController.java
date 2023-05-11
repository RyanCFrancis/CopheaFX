package com.cophea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    //number of attempts the user has tried ot login
    private int attempts;

    //username field
    @FXML
    TextField txtUser;

    //password field
    @FXML
    PasswordField txtPass;

    public void initialize(URL u,ResourceBundle r) {
        attempts = 0;
    }

    @FXML
    public void loginCheck() throws IOException{
        attempts++;
        String use = txtUser.getText();
        String pw = txtPass.getText();
        String userID = DataManager.loadPersonLogin(use, pw);
        if (attempts>2){System.exit(69);}


        if (userID.equals("fail")){
            StageManager.getInstance().PopupInfo("Login Failed", "Your password and username do not match, try again");

        }
        else if (userID.equals("emp")){
            StageManager.getInstance().PopupError("Sorry", "Employee Logins are not supported at this time");
        }
        else {
            //go to the menu
            //check if hte logged in user is a employee or patient and reject them if they are a employee

            //load in the user data from the database files
            Patient pat = DataManager.getPatient(userID);
            DataManager.loadAppts(pat);
            
            //set the current user to the patient
            StageManager.getInstance().setUser(pat);
            StageManager.getInstance().goToPatientMenu();
            
        }
    }

    @FXML
    public void exitBtn(){
        System.exit(420);
    }
}
