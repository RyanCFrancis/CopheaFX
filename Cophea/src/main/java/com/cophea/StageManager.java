package com.cophea;

import java.io.IOException;
import java.time.OffsetDateTime;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class StageManager {


    //Using the "singleton" design paradigm, this object is used for 2 reasons.
    //for the different scenes to communicate and transfer data between each other
    //and to actually change the scenes/ switch scenes

    //this class is necessary because we setup each screen to have their own controller
    //an alternative to this design was to make an object for each screen and create it in the main method

    //a private static instance of the class is made so it is essentially "global" to all the screens
    private static StageManager instance = null;
    //syncronized keyword is used to ensure only 1 obj of the class exists
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
    private boolean isPickingAppts;

    public boolean isPickingAppts() {
        return isPickingAppts;
    }
    public void setPickingAppts(boolean isPickingAppts) {
        this.isPickingAppts = isPickingAppts;
    }
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

    //possible implementation to make a fading transition for the splash screen
    //INCOMPLETE
    public void Fade() throws InterruptedException, IOException{




        // FadeTransition introFade = new FadeTransition(Duration.seconds(0.8),StageManager.getInstance().getParent());  
        // introFade.setFromValue(1.0);  
        // introFade.setToValue(0.3); 
        // introFade.setCycleCount(4); 
        // introFade.setAutoReverse(true);
        // introFade.play();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrSplashv1.fxml")));
		StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));


        OffsetDateTime start = OffsetDateTime.now();
        OffsetDateTime timer = OffsetDateTime.now();

        while ((timer.toEpochSecond() - start.toEpochSecond())<2){
            //do nothing lol
            timer = OffsetDateTime.now();
        }
    }

    //goes to the login screen for the user
    public void goToLogin() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrLoginCOPHEA.fxml")));
		StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
		StageManager.getInstance().getStage().setTitle("Cophea  Login");
		StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
		StageManager.getInstance().getStage().show();
    }
    //goes to the main menu the patient sees when they log in
    public void goToPatientMenu() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrMenu.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Main Menu");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }
    //goes to the modify appointments screen
    public void goToModifyAppts() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrModifyAppt.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Cophea");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }
    //go to the doctor info screen to see what conditions the doctor treats
    public void goToDoctorInfo() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrDoctorInfo.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Cophea");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }
    //go to the screen involving changing/editing already created appointments
    public void goToPickAppt() throws IOException{
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrAppts.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Cophea");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }
    //pick a doctor from a list, this screen is used to transition to both the main scheduling screen
    //and the see mroe doctor info screen.
    //if pickingappts is true it takes the user to the main scheduling screen later
    public void goToPickDoctor(boolean pickingappts) throws IOException{
        if (pickingappts){this.isPickingAppts = true;}
        StageManager.getInstance().getStage().hide();
        StageManager.getInstance().setParent(FXMLLoader.load(getClass().getResource("/com/cophea/scrSelectDoctor.fxml")));
        StageManager.getInstance().setScene(new Scene(StageManager.getInstance().getParent()));
        StageManager.getInstance().getStage().setTitle("Cophea");
        StageManager.getInstance().getStage().setScene(StageManager.getInstance().getScene());
        StageManager.getInstance().getStage().show();
    }
    
    //function to streamline making popups on the screen
    public void PopupError(String title,String content){
        Alert a = new Alert(AlertType.ERROR);
        a.setTitle(title);
        a.setContentText(content);
        a.show();

    }
    //function to streamline making popups on the screen    
    public void PopupInfo(String title,String content){
        Alert a = new Alert(AlertType.ERROR);
        a.setTitle(title);
        a.setContentText(content);
        a.show();

    }
  

}
