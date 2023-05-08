package com.cophea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    
    private int attempts;

    @FXML
    TextField txtUser;

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
        String check = DataManager.loadPersonLogin(use, pw);
        if (attempts>2){System.exit(69);}
        if (check.equals("fail")){
            System.out.println("failed login");
            
            
        }
        else {
            //go to the menu
            //TODO CHANGE TO ACCOMODATE BOTH LOGINS
            Patient pat = DataManager.getPatient(check);
            DataManager.loadAppts(pat);
            
            //System.out.println("here");
            StageManager.getInstance().setUser(pat);
            StageManager.getInstance().goToPatientMenu();
            
        }
    }

    @FXML
    public void exitBtn(){
        System.exit(420);
    }
}
