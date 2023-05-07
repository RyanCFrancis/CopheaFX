package com.cophea;

import javafx.application.Application;
import javafx.fxml.FXML;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class StageManager {

    private static StageManager instance = null;
    public static synchronized StageManager getInstance(){
        if (instance == null){instance = new StageManager();}
            
  
        return instance;
    }
    private Stage stage;
    private Parent parent;
    private Scene scene;
    public Stage getStage() {
        return stage;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Parent getParent() {
        return parent;
    }
    public void setParent(Parent parent) {
        this.parent = parent;
    }
    public Scene getScene() {
        return scene;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }
  

}
