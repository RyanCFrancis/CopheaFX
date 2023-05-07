// package pkgMagic;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.lang.ModuleLayer.Controller;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import java.util.Scanner;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.RadioButton;
// import javafx.scene.control.TextField; 
// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.Event;
// import javafx.event.EventHandler;
// import javafx.fxml.FXMLLoader;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.stage.Stage;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Alert.AlertType;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.AnchorPane;


// public class BrokerBuddy extends Application {
// 	Brokerage bb;
// 	Controller screens;
	
// 	public void start(Stage primaryStage) {
// 		try {
			
// 			ft = new FortuneTelling();
// 			bb.loadData();

// 			displaySplash(primaryStage);

			
// 		} 
// 		catch (FileNotFoundException e)
// 		{	System.out.println("Error, File Not Found!");
// 			System.out.println(e.getMessage());	
// 		}
// 		catch (IOException e)
// 		{	System.out.println("Error, Input/Output Exception!");
// 			System.out.println(e.getMessage());	
// 		}
// 		catch (NumberFormatException e)
// 		{	System.out.println("Error, Invalid Number Format!");
// 			System.out.println(e.getMessage());	
// 		}
// 		catch (Exception e)
// 		{	System.out.println("Error, Invalid Data!");
// 			System.out.println(e.getMessage());	
// 		}

// 	}
	
// 	public static void main(String[] args) {
// 		launch(args);
// 	}
		
	
// 	public void displaySplash(Stage stg)
// 	{
// 		try {
	
//    	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scrSplash.fxml"));
//  		Parent root = (Parent) fxmlLoader.load();

//  		stg.setScene(new Scene(root));  
//  		stg.show();
//  		Thread.sleep(5000);
//  		stg.hide();
//  		displayLogin();
   	 		
// 		} catch(Exception e) {
// 		e.printStackTrace();
// 		}
	
// 	}
	
// 	public void displayLogin()
// 	{	
// 		try {
// 			Stage stgLogin = new Stage();
// 			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scrLogin.fxml"));
// 	 		Parent root = (Parent) fxmlLoader.load();
	 		
// 	 		 // Setting title to the Stage   
// 	 		stgLogin .setTitle("Broker Buddy Login"); 
	 		
// 	 		stgLogin.setScene(new Scene(root));  
// 	 		stgLogin.show();
	 		
// 	 		Button btnLogin = (Button)fxmlLoader.getNamespace().get("btnLogin");
// 	 		 // set Action Listener
// 	        btnLogin.setOnAction(new EventHandler() 
// 	        {
// 	            public void handle(Event event) 
// 	            {	int numattempts = 0;
// 	            	boolean isValid = false;
	            
// 	            	TextField txtuser = (TextField)fxmlLoader.getNamespace().get("txtUserID");
// 	            	PasswordField txtpass = (PasswordField)fxmlLoader.getNamespace().get("txtPassword");
// 	            	long user = Long.parseLong(txtuser.getText());
// 	            	String pass = txtpass.getText();
// 	            	// instructions executed when the button is clicked
// 	            	do
// 	            	{	 isValid = bb.login(user,pass);
	            		
// 	            		numattempts++;
// 	            	}while (!isValid && numattempts < 3);
// 	            	if (isValid)
// 	            	{	String username = bb.seekers.get(bb.liu).getfullName();
//             			showAlert(AlertType.INFORMATION, "Login", "Login Successful", "Welcome" + username);
//             			displayMenu();
// 	            	}
//             		else
//             		{	showAlert(AlertType.ERROR, "Login Invalid", "Exit Alert", "Number of attempts exceeded, program terminated!");	
//             			System.exit(0);
//             		}
// 	            }

// 	        });
// 	 		Button btnExit = (Button)fxmlLoader.getNamespace().get("btnExit");
// 	 	// set Action Listener
// 	        btnExit.setOnAction(new EventHandler() {
// 	            public void handle(Event event) {
// 	            	// instructions executed when the button is clicked
// 	            	 showAlert(AlertType.INFORMATION, "Exit", "Exit Alert", "Thank you for using the Broker Buddy System!");
// 	            		System.exit(0);

// 	            }

// 	        });
   	 		
// 		} catch(Exception e) {
// 		e.printStackTrace();
// 		}
	
// 	}
	

// 	public void displayMenu()
// 	{
// 		try {
// 			Stage stgMenu = new Stage();
// 			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scrDisplayMenu.fxml"));
// 	 		Parent root = (Parent) fxmlLoader.load();
	 		
// 	 		 // Setting title to the Stage   
// 	 		stgMenu .setTitle("Fortune Telling Display Menu"); 
// 	 		stgMenu.setScene(new Scene(root));  
// 	 		stgMenu.show();
	 		
// 	 		Button btnSubmit = (Button)fxmlLoader.getNamespace().get("btnSubmit");
// 	 		 // set Action Listener
// 	        btnSubmit.setOnAction(new EventHandler() 
// 	        {
// 	            public void handle(Event event) 
// 	            {	int numattempts = 0;
// 	            	boolean isValid = false;
	            
// 	            	//RadioButton = (RadioButton)fxmlLoader.getNamespace().get("opt");
	            	
	            
// 	            }

// 	        });
// 	 		Button btnExit = (Button)fxmlLoader.getNamespace().get("btnExit");
// 	 	// set Action Listener
// 	        btnExit.setOnAction(new EventHandler() {
// 	            public void handle(Event event) {
// 	            	// instructions executed when the button is clicked
// 	            	 showAlert(AlertType.INFORMATION, "Exit", "Exit Alert", "Thank you for using the Broker Buddy System!");
// 	            		System.exit(0);

// 	            }

// 	        });
   	 		
// 		} catch(Exception e) {
// 		e.printStackTrace();
// 		}
	
// 	}
	
// 	public void displayTrades()
// 	{
// 		try {
// 			Stage stgFortunes = new Stage();
// 			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scrTrades.fxml"));
// 	 		Parent root = (Parent) fxmlLoader.load();
// 	 		stgFortunes.setScene(new Scene(root));  
// 	 		stgFortunes.show();
   	 		
// 		} catch(Exception e) {
// 		e.printStackTrace();
// 		}
	
// 	}
	
	
// 	public void displayClients()
// 	{
// 		try {
// 			Stage stgProcessFortune = new Stage();
// 			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scrClientsfxml"));
// 	 		Parent root = (Parent) fxmlLoader.load();
// 	 		stgProcessFortune.setScene(new Scene(root));  
// 	 		stgProcessFortune.show();
   	 		
// 		} catch(Exception e) {
// 		e.printStackTrace();
// 		}
	
// 	}
	
	
// 	private void showAlert(AlertType type, String title, String header, String message) {
// 		Alert alert = new Alert(type);
// 		alert.setTitle(title);
// 		alert.setHeaderText(header);
// 		alert.setContentText(message);

// 		alert.showAndWait();
// 	}
	
	
// /********************************GET SYSTEM DATE METHOD*******************************/	
// 	String getSystemDate()
// 	{
// 		Calendar calendar = Calendar.getInstance();
// 		String timeStamp= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(calendar.getTime());
// 		return timeStamp;

// 	}
// /********************************END OF GET SYSTEM DATE METHOD**************************/
	
// }