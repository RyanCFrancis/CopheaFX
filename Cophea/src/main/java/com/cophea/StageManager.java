package com.cophea;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
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

    public void goToLogin() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrLoginCOPHEA.fxml")));
		StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
		StageManager.getInstance().getStage().setTitle("Cophea  Login");
		StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
		StageManager.getInstance().getStage().show();
    }

    public void goToPatientMenu() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrMenu.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Main Menu");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }

    public void goToModifyAppts() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrModifyAppt.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Cophea");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }

    public void goToDoctorInfo() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrDoctorInfo.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Cophea");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }

    public void goToPickAppt() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrAppts.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Cophea");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }

    public void goToPickDoctor() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrSelectDoctor.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Cophea");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }

  

}
