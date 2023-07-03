package application.login.Controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.SMSMain.View.Window;
import application.login.Action.Login_Action;
import application.login.DTO.Login_DTO;
import common.datamanipulation.DataManipulationUtil;
import common.db.DataAccessController;
import common.eventfilters.EnterKeyButtonTraversalEventHandler;
import common.eventfilters.EnterKeyTextFieldTraversalEventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {
@FXML
private JFXTextField userid;
@FXML
private JFXPasswordField password;
@FXML
private Button loginbutton;
@FXML
private Button cancelbutton;

public Window objct=null;

public DataAccessController doc=new DataAccessController();
public DataManipulationUtil dm=new DataManipulationUtil();
public Login_Action ldao=new Login_Action();
Connection con=doc.commonDataConnect();
boolean validuser=false;

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
userid.addEventFilter(KeyEvent.KEY_PRESSED, new EnterKeyTextFieldTraversalEventHandler());
password.addEventFilter(KeyEvent.KEY_PRESSED, new EnterKeyTextFieldTraversalEventHandler());
loginbutton.addEventFilter(KeyEvent.KEY_PRESSED, new EnterKeyButtonTraversalEventHandler());
cancelbutton.addEventFilter(KeyEvent.KEY_PRESSED, new EnterKeyButtonTraversalEventHandler());
}

public boolean isUserValid()
{
return validuser;
}

@FXML
void cancel(ActionEvent event) {

}

@FXML
void securitycheck(ActionEvent event) {
	Login_DTO ldto=ldao.passwordFetch(con, userid.getText());
	if(ldto!=null)	
	{
	if(ldto.getPassword().trim().equals(password.getText().trim()))
	{
	System.out.println("OK");
	objct.valid=true;
	Stage stage = (Stage) loginbutton.getScene().getWindow();
    stage.close(); // closes window
	}
	else
	{
	System.out.println("false");
	objct.valid=false;
	}
	}		
}

@FXML
void us(ActionEvent event) {

}
}