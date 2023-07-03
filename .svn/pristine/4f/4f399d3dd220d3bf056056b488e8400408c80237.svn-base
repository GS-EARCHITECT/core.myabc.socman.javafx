package resident.services.propertyinformation;

import java.net.URL;
import java.util.ResourceBundle;

import common.windows.CreateNewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import resident.services.helpdesk.Resident_Services_HelpDesk_Controller;

public class Resident_Services_Property_Controller implements Initializable {

@FXML public TextField property_id;
	
@FXML
private void handleNewButtonAction(ActionEvent event) 
{
		try 
		{
		CreateNewWindow win = new CreateNewWindow();	
       	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/resident/services/helpdesk/RESIDENT_SERVICES_HELPDESK_WINDOW.fxml"));
		Resident_Services_HelpDesk_Controller controller = new Resident_Services_HelpDesk_Controller();
    	controller.initScreen("Hello");   					
     	loader.setController(controller);
    	Parent root= loader.load();
    	win.CommonWindowHandler(event,"NEW SERVICE REQUEST",root,"/resident/services/helpdesk/Resident_Services_Helpdesk.css");		       	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
}

@FXML
private void handleEditButtonAction(ActionEvent event) 
{
	CreateNewWindow win = new CreateNewWindow();
	//win.commonWindowHandler(event,"EDIT SERVICE REQUEST","/owner/services/OWNER_SERVICES_HELPDESK_WINDOW.fxml",);
}

@FXML
private void handleSendButtonAction(ActionEvent event) 
{
	CreateNewWindow win = new CreateNewWindow();
    //win.commonWindowHandler(event,"SEND SERVICE REQUEST","/owner/services/OWNER_SERVICES_HELPDESK_WINDOW.fxml");
}

@FXML
private void handlePrintButtonAction(ActionEvent event) 
{
	CreateNewWindow win = new CreateNewWindow();
    //win.commonWindowHandler(event,"PRINT SERVICE REQUEST","/owner/services/OWNER_SERVICES_HELPDESK_WINDOW.fxml");
}

@FXML
private void handleDeleteButtonAction(ActionEvent event) 
{
	CreateNewWindow win = new CreateNewWindow();
    //win.commonWindowHandler(event,"DELETE SERVICE REQUEST","/owner/services/OWNER_SERVICES_HELPDESK_WINDOW.fxml");
}

@FXML
private void handleExitButtonAction(ActionEvent event) 
{
	Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
    stage.close();
}

@FXML
private void handleRequestorIDKeyReleaseAction(KeyEvent event) 
{
	if (!event.getCode().isDigitKey())
		System.out.println(event.getText());
	}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	}
}
