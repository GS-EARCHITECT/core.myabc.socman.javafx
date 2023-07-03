package application.SMSMain.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import common.windows.CreateNewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MenuController implements Initializable {
@FXML MenuBar myMenuBar;

@FXML
	private void handleMenuAction(ActionEvent event) {

/*	Node n = (Node)event.getSource();
	String id = n.getId();
	System.out.println("hello"+id);*/
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
    CreateNewWindow win = new CreateNewWindow();
    win.commonMenuHandler(null,stage,"OWNER SERVICES","/application/menus/resident/OWNER_SERVICES_PROPERTY_WINDOW.fxml",null);
	}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}

/*private void commonWindowHandler(Stage stage, String fxmlFile)
{
	Stage newWindow = new Stage();
    newWindow.initOwner(stage);
	Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource(fxmlFile));
		Scene scene = new Scene(root);
		newWindow.setScene(scene);
		newWindow.initModality(Modality.WINDOW_MODAL);
		newWindow.setX(stage.getX() + 200);
		newWindow.setY(stage.getY() + 100);
		newWindow.setTitle("Second Stage");
		newWindow.show();
	} catch (IOException e) {	
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}*/
}
