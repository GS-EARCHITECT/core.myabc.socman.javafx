package manager.menus;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MaintenanceManager_MenuController implements Initializable {
@FXML MenuBar myMenuBar;

private Stage myStage;
public void setStage(Stage stage) {
     myStage = stage;
}

@FXML
	private void handleMenuAction(ActionEvent event) {
	System.out.println("hello");
	/*BorderPane root = new BorderPane();*/
    // New window (Stage)
    Stage newWindow = new Stage();

    // Specifies the owner Window (parent) for new window
    /*Node node = (Node) event.getSource();
    Stage stage = (Stage) node.getScene().getWindow();*/
    Stage stage = (Stage) myMenuBar.getScene().getWindow();
    newWindow.initOwner(stage);
	Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource("/owner/services/OWNER_SERVICES_PROPERTY_WINDOW.fxml"));
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

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}
}
