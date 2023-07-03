package application.SMSMain.View;

import java.io.IOException;
import java.sql.Connection;

import application.SMSMain.Controller.SMSMainController;
import application.login.Controller.LoginController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Window
{
	public Boolean valid=false;
	public String fxmlFile="";
	
/*	List<Menu> menus = new ArrayList<>();*/
	public Window(Stage primaryStage, Connection con)
	{
		String str=null;
		String windowTitle="SMS Ver 1.0";

		FXMLLoader loader = new FXMLLoader();
		Stage stage = new Stage();		
		loader.setLocation(getClass().getResource("/application/login/Login.fxml"));
		Parent root=null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root, 700, 450);
		scene.getStylesheets().add(this.getClass().getResource("/application/login/login.css").toExternalForm());
		LoginController lc=(LoginController)loader.getController();
		lc.objct=this;
		stage.sizeToScene();		
		stage.setScene(scene);
		stage.setTitle(windowTitle);
		
		stage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() 
		{
	    public void handle(WindowEvent we) {	           
	            }
	        });
		
		stage.showAndWait();
		
		if(valid)
		{	
		try {
			FXMLLoader loader2 = new FXMLLoader();
			loader2.setLocation(getClass().getResource("/application/SMSMain.fxml"));	    	
	    	Parent rootMain= loader2.load();
	    	Scene sceneMain = new Scene(rootMain, 700, 450);
			scene.getStylesheets().add(this.getClass().getResource("/application/application.css").toExternalForm());
			SMSMainController sc=(SMSMainController)loader2.getController();
			primaryStage.sizeToScene();		
			primaryStage.setScene(sceneMain);
			primaryStage.setTitle(windowTitle);
			primaryStage.show();			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}	
		else
			System.out.print("not valid");
}
}