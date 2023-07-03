package common.windows;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*	Node n = (Node)event.getSource();
String id = n.getId();
System.out.println("hello"+id);*/

/*MenuItem menuItem = (MenuItem)event.getTarget();
String menuId=menuItem.getId();*/

public class CreateNewWindow {
	public void CommonWindowHandler(Event event, String title,Parent root, String cssName)
	{
		Stage newWindow = new Stage();
		Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
		newWindow.initOwner(stage);
		Scene scene = new Scene(root);
		if(cssName!=null)
		{
		if(cssName.trim().length()>0)
		{			
		scene.getStylesheets().add(cssName);	
		}
		}
		else
		{
		System.out.println("Not Found");	
		}
		newWindow.setScene(scene);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.setX(stage.getX());
		newWindow.setY(stage.getY());
		newWindow.setTitle(title);
		newWindow.setResizable(false);
		newWindow.show();		
	}

	public void commonMenuHandler2(FXMLLoader loader, Stage stage,String title,Parent root,String cssName)
	{
		Stage newWindow = new Stage();
		newWindow.initOwner(stage);
	    		
		Scene scene = new Scene(root);
		if(cssName!=null)
		{
		if(cssName.trim().length()>0)
		{
		scene.getStylesheets().add(cssName);	
		}
		}			
		else
		{
		System.out.println("Not Found");	
		}
		newWindow.setScene(scene);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.setX(stage.getX());
		newWindow.setY(stage.getY());
		newWindow.setTitle(title);
		newWindow.setResizable(false);
		newWindow.show();		
	}
		
	public void commonMenuHandler(MenuItem menuItem, Stage stage,String title,String fxmlFile,String cssName)
	{
		Stage newWindow = new Stage();
		String css=null;
		newWindow.initOwner(stage);
	    Parent root;
		
		try {
			root = FXMLLoader.load(getClass().getResource(fxmlFile));			
			Scene scene = new Scene(root);
			if(cssName!=null)
			{
			if(cssName.trim().length()>0)
			{
			scene.getStylesheets().add(cssName);	
			}
			}			
			else
			{
			System.out.println("Not Found");	
			}
			newWindow.setScene(scene);
			newWindow.initModality(Modality.WINDOW_MODAL);
			newWindow.setX(stage.getX());
			newWindow.setY(stage.getY());
			newWindow.setTitle(title);
			newWindow.setResizable(false);
			newWindow.show();
		} catch (IOException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

@FXML
private void handleRequestorIDKeyReleaseAction(KeyEvent event) 
	{
		if (!event.getCode().isDigitKey())
			System.out.println(event.getText());
		}

}
