package resident.menus;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import common.windows.CreateNewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import resident.services.helpdesk.Resident_Services_HelpDesk_Controller;
import resident.services.membershipservices.Resident_Services_Membership_Controller;
import resident.services.propertyinformation.Resident_Services_Property_Controller;

public class ResidentMenuBarController implements Initializable {
@FXML MenuBar myMenuBar;

/* Owner Services Event Handlers */

@FXML
private void handleOwnerServicesPropertyMenuAction(ActionEvent event) {
	
	}

@FXML
private void handleOwnerServicesHelpdeskMenuAction(ActionEvent event) {

	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	try {
		CreateNewWindow win = new CreateNewWindow();	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/resident/services/helpdesk/RESIDENT_SERVICES_HELPDESK_WINDOW.fxml"));
		Resident_Services_HelpDesk_Controller controller = new Resident_Services_HelpDesk_Controller();
		controller.initScreen("Hello");   					
     	loader.setController(controller);
    	Parent root= loader.load();
		win.commonMenuHandler2(loader,stage,"RESIDENT SERVICES",root,"/resident/services/helpdesk/Resident_Services_Helpdesk.css");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

@FXML
private void handleOwnerServicesMembershipMenuAction(ActionEvent event) {

	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	try {
		CreateNewWindow win = new CreateNewWindow();	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/resident/services/membershipservices/RESIDENT_SERVICES_MEMBERSHIP_WINDOW.fxml"));
		Resident_Services_Membership_Controller controller = new Resident_Services_Membership_Controller();
		controller.initScreen("Hello");   					
     	loader.setController(controller);
    	Parent root= loader.load();
		win.commonMenuHandler2(loader,stage,"MEMBERSHIP SERVICES",root,"/resident/services/membershipservices/Resident_Services_Membership.css");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


/* Owner Utilities Event Handlers */

@FXML
private void handleOwnerUtilitiesElectricityInfoMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
    CreateNewWindow win = new CreateNewWindow();
  //  win.commonMenuHandler(null,stage,"ELECTRICITY SERVICES INFO","/owner/utilities/OWNER_UTILITIES_ELECTRICITY_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesElectricityRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"ELECTRICITY SERVICES REQUEST","/owner/utilities/OWNER_UTILITIES_ELECTRICITY_REQUEST_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesWaterInfoMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"WATER SERVICES INFO","/owner/utilities/OWNER_UTILITIES_WATER_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesWaterRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"WATER SERVICES REQUEST","/owner/utilities/OWNER_UTILITIES_WATER_REQUEST_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesGasInfoMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"GAS SERVICES INFO","/owner/utilities/OWNER_UTILITIES_GAS_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesGasRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"GAS SERVICES REQUEST","/owner/utilities/OWNER_UTILITIES_GAS_REQUEST_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesHousekeepingInfoMenuAction(ActionEvent event) {
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"HOUSEKEEPING SERVICES INFO","/owner/utilities/OWNER_UTILITIES_HOUSEKEEPING_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesHousekeepingRequestMenuAction(ActionEvent event) {
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"HOUSEKEEPING SERVICES REQUEST","/owner/utilities/OWNER_UTILITIES_GAS_HOUSEKEEPING_REQUEST_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesSecurityInfoMenuAction(ActionEvent event) {
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"SECURITY SERVICES INFO","/owner/utilities/OWNER_UTILITIES_SECURITY_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerUtilitiesSecurityRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/utilities/OWNER_UTILITIES_GAS_SECURITY_REQUEST_WINDOW.fxml");
	}

/* Owner Facilities Event Handlers */

@FXML
private void handleOwnerFacilitiesGymInfoMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_GYM_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesGymRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_GYM_REQUEST_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesClubInfoMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_CLUB_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesClubRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_CLUB_REQUEST_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesRestInfoMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_REST_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesRestRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_REST_REQUEST_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesSpaInfoMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_SPA_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesSpaRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_SPA_REQUEST_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesEntInfoMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_ENT_INFO_WINDOW.fxml");
	}

@FXML
private void handleOwnerFacilitiesEntRequestMenuAction(ActionEvent event) {
			
	Stage stage = (Stage) myMenuBar.getScene().getWindow();
	
	/*MenuItem menuItem = (MenuItem)event.getTarget();
	String menuId=menuItem.getId();*/
	System.out.println("Property Services");
    CreateNewWindow win = new CreateNewWindow();
    //win.commonMenuHandler(null,stage,"OWNER SERVICES","/owner/facilities/OWNER_FACILITIES_ENT_REQUEST_WINDOW.fxml");
	}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}

}
