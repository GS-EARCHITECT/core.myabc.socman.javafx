package manager.services;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MaintenanceManager_Services_HelpDesk_Tickets_Controller implements Initializable {
/*@FXML Label myOwnerServicesProperty;*/

	
	
@FXML
	private void handleWindowAction(ActionEvent event) {
	System.out.println("hello NORMAL");
    Stage newWindow = new Stage();

    // Specifies the owner Window (parent) for new window
    /*Node node = (Node) event.getSource();
    Stage stage = (Stage) node.getScene().getWindow();*/
    /*Stage stage = (Stage) myMenuBar.getScene().getWindow();*/
    Node source = (Node) event.getSource();
    Stage stage = (Stage)source.getScene().getWindow();
    newWindow.initOwner(stage);
	Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource("OWNER_SERVICES_PROPERTY.fxml"));
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

	
}

@FXML
private void handleButtonAction(ActionEvent event) {
System.out.println("hello button");

}

@FXML
private void handleEditAction(ActionEvent event) {
System.out.println("hello edit");

}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}
}
