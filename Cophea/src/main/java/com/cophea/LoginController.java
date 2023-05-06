package com.cophea;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    private static LoginController instance;

    public static synchronized LoginController getInstance(){
        return instance = new LoginController();
    }

   

    @FXML
    TextField txtUser;

    @FXML
    PasswordField txtPass;



    public void initialize(URL u,ResourceBundle r) {

    }

    @FXML
    public void loginCheck() throws FileNotFoundException{
        String use = txtUser.getText();
        String pw = txtPass.getText();
        String check = DataManager.loadPersonLogin(use, pw);
        if (check.equals("fail")){
            System.out.println("failed login");
        }
        else {
            //go to the menu
        }
    }
}
