package com.cophea;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManager {

    private static StageManager instance = null;
    public static synchronized StageManager getInstance(){
        if (instance == null){instance = new StageManager();}
        return instance;
    }
    private Stage stage;
    private Parent parent;
    private Scene scene;
    private Person User;
    private Employee currEmployee;
    private TimeSlot currTimeSlot;
    private Appointment currApp;

    public Appointment getCurrApp() {
        return currApp;
    }
    public void setCurrApp(Appointment currAppo) {
        this.currApp = currAppo;
    }
    public TimeSlot getCurrTimeSlot() {
        return currTimeSlot;
    }
    public void setCurrTimeSlot(TimeSlot currTimeSlot) {
        this.currTimeSlot = currTimeSlot;
    }
    public Person getUser() {
        return User;
    }
    public void setUser(Person user) {
        User = user;
    }
    public Employee getCurrEmployee() {
        return currEmployee;
    }
    public void setCurrEmployee(Employee currEmployee) {
        this.currEmployee = currEmployee;
    }
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
