package resident.services.membershipservices;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;

import common.datamanipulation.DataManipulationUtil;
import common.db.DataAccessController;
import common.eventfilters.TabTraversalEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Resident_Services_Membership_Controller implements Initializable {

@FXML private AnchorPane a1;	
@FXML private AnchorPane a2;
@FXML private VBox	buttonpanel;
@FXML private Pane l_pane1;
@FXML private Pane l_pane2;
@FXML private Pane l_pane3;
@FXML private Pane l_pane4;
@FXML private Pane l_pane5;
@FXML private Pane l_pane6;
@FXML private Pane l_pane7;
@FXML private Pane l_pane8;
@FXML private Pane l_pane9;
@FXML private Pane e_pane1;
@FXML private Pane e_pane2;
@FXML private Pane e_pane3;
@FXML private Pane e_pane4;
@FXML private Pane e_pane5;
@FXML private Pane e_pane6;
@FXML private Pane e_pane7;
@FXML private Pane e_pane8;
@FXML private Pane e_pane9;

@FXML private Button request_Worklist;	
@FXML private Button new_Service_Request;
@FXML private Button edit_Service_Request;
@FXML private Button send_Service_Request;
@FXML private Button print_Service_Request;
@FXML private Button delete_Service_Request;
@FXML private Button save_Service_Request;
@FXML private Button search_Service_Request;
@FXML private Button exit;
@FXML private Button first_Record;
@FXML private Button next_Record;
@FXML private Button prev_Record;
@FXML private Button bottom_Record;
@FXML TableView<Service_Bean> request_Table;
@FXML TableColumn<Service_Bean,String> f_requestorId;
@FXML TableColumn<Service_Bean,String> f_name;
@FXML TableColumn<Service_Bean,String> f_servRequestId; 
@FXML TableColumn<Service_Bean,String> f_date;
@FXML TableColumn<Service_Bean,String> f_time;
@FXML TableColumn<Service_Bean,String> f_rservRequestId;
@FXML TableColumn<Service_Bean,String> f_status;
@FXML TableColumn<Service_Bean,String> f_remark;
@FXML TableColumn<Service_Bean,String> f_servType;
@FXML private TextField requestor_Id;
@FXML private Label requestor_Name;
@FXML private TextField serv_request_Id; 
@FXML private Label d_date;
@FXML private Label request_Time;
@FXML private TextField ref_Requestor_Id;
@FXML private TextField serv_Status;
@FXML private TextArea request_Remark;
@FXML private ComboBox<String> serv_type_list;
ObservableList<Service_Bean> tableData= FXCollections.observableArrayList();
ObservableList<ServiceType_Bean> listData= FXCollections.observableArrayList();
ObservableList<String> listStrings= FXCollections.observableArrayList();
private int tableCurrRow=0;
private boolean edit_data=false;
private boolean new_data=false;
private boolean search_data=false;
public DataAccessController doc=new DataAccessController();
public DataManipulationUtil dm=new DataManipulationUtil();
public Resident_Services_DAO rdao=new Resident_Services_DAO();
Connection con=doc.commonDataConnect();
private String userId=null;
private String requestorStr=null;

public void initScreen(String loginId) 
{
this.userId=loginId;
}

	@FXML
	private void handleWorklistButtonAction(ActionEvent event) 
	{}

	@FXML
	private void handleRequestorIdKeyAction(ActionEvent event) 
	{
	if(!search_data)
	{	
	clearFields();
	requestor_Id.setEditable(true);	
	requestor_Id.setPromptText("Search Text");
	request_Table.getSelectionModel().clearSelection(tableCurrRow);
	request_Table.setFocusTraversable(false);
	tableCurrRow= -1;
	search_data=true;
	}
	}

	@FXML
	private void handleRequestorIdSearchAction(KeyEvent event) 
	{
	if(search_data)
	{	
	requestorStr=requestor_Id.getText();	
	this.searchTable(requestorStr);	
	}
	}
	
	@FXML
	private void handleRequestorIdAction(ActionEvent event) 
	{
	if(search_data)
	{	
	search_data=false;
	makeUIUneditable();
	search_Service_Request.requestFocus();
	requestor_Id.setPromptText("");
	request_Table.setFocusTraversable(true);
	}
	}
		
	@FXML
	private void handleNewButtonAction(ActionEvent event) 
	{
	new_data=true;
	edit_data=false;	
	search_data=false;	
	makeUIEditable();
	clearFields();
	disableButtonPanel();	
	requestor_Id.requestFocus();
	}

	@FXML
	private void handleSaveButtonAction(ActionEvent event) 
	{
		Service_Bean forDao=null;
		int servreqno=0;
				
		if(edit_data || new_data)
		{
			String d_requestor_Id=requestor_Id.getText();
			String d_requestor_Name=requestor_Name.getText();
			String d_serv_request_Id=serv_request_Id.getText();
			String d_serv_date=null;
			String d_request_Time=null;
			String d_ref_Requestor_Id=ref_Requestor_Id.getText();
			String d_serv_Status=serv_Status.getText();
			String d_request_Remark=request_Remark.getText();
			Integer d_servtypeno=getServTypeNo(serv_type_list.getSelectionModel().getSelectedIndex());
			String d_servtype=getServType(serv_type_list.getSelectionModel().getSelectedIndex(),listData,false);
					
			if(new_data)
			{	
			Date dt=new Date(); 	
			d_serv_date=dm.getDateAsString(dt);			
			d_request_Time=dm.getTimeAsString(dt);			
			forDao = new Service_Bean(d_requestor_Id,d_requestor_Name,d_serv_request_Id,d_serv_date,d_request_Time,d_ref_Requestor_Id,d_serv_Status,d_request_Remark,Integer.valueOf(0),d_servtypeno,d_servtype);
			rdao.insertData(con,forDao);						
			}
			
			if(edit_data & tableCurrRow>=0)
			{
			Service_Bean sbEdit = new Service_Bean(); 
			sbEdit=tableData.get(tableCurrRow);			
			forDao = new Service_Bean(d_requestor_Id,d_requestor_Name,d_serv_request_Id,"","",d_ref_Requestor_Id,d_serv_Status,d_request_Remark,sbEdit.getServ_RequestNo(),d_servtypeno,d_servtype);
			servreqno=sbEdit.getServ_RequestNo();
			rdao.updateData(con,forDao);
			}
			new_data=false;
			edit_data=false;
		}
		makeUIUneditable();
		clearFields();
		initData();
		if(tableData.size()>0 && servreqno>0)
		{
		for(int i=0; i<tableData.size()-1;i++)
		{
		if(tableData.get(i).getServ_RequestNo().intValue()==servreqno)
		{
		tableCurrRow=i;
		break;
		}
		}
		}
		else
		{
		tableCurrRow=tableData.size()-1;
		}
		selectSpecificTableItem();
		tableDataButtonPanelSynch();
		request_Table.requestFocus();				
		request_Table.getSelectionModel().select(tableCurrRow);
		request_Table.getFocusModel().focus(tableCurrRow);
		request_Table.scrollTo(tableCurrRow);
	}
	
	@FXML
	private void serv_request_checkout_event(ActionEvent event)
	{}
	
	@FXML
	private void serv_request_checkout_keyevent(KeyEvent event)
	{}
	
	@FXML
	private void ref_Requestor_checkout_event(ActionEvent event)
	{}
	
	@FXML
	private void ref_Requestor_checkout_keyevent(KeyEvent event)
	{}
	
	@FXML
	private void serv_Status_checkout_event(ActionEvent event)
	{}	
	
	@FXML
	private void serv_Status_checkout_keyevent(KeyEvent event)
	{}
	
	
	@FXML
	private void handleListItemKeyList(KeyEvent event)
	{}
	
		
	@FXML
	private void remark_checkout_event(KeyEvent event)
	{   	    
	}
	
	@FXML
	private void handleEditButtonAction(ActionEvent event) 
	{
		if(tableData.size()>0 && tableCurrRow>=0)
		{
		request_Table.editableProperty().set(false);				
		makeUIEditable();
		disableButtonPanel();
		serv_request_Id.requestFocus();
		edit_data=true;
		new_data=false;
		search_data=false;
		}
		else
		{
		makeUIUneditable();		
		}
		requestor_Id.requestFocus();
	}

	@FXML
	private void handleExitButtonAction(ActionEvent event) 
	{
		try {
			if(!con.isClosed() || con!=null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Stage stage = (Stage) ((Node)event.getTarget()).getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void handleSendButtonAction(ActionEvent event) 
	{
	DataManipulationUtil dm=new DataManipulationUtil();
	dm.sendServiceRequest(null);
	}

	@FXML
	private void handlePrintButtonAction(ActionEvent event) 
	{
	DataManipulationUtil dm=new DataManipulationUtil();
	dm.printServiceRequest(null);
	}

	@FXML
	private void handleCancelAction(ActionEvent event) 
	{
		if(edit_data || new_data || search_data)
		{		
		edit_data=false;
		new_data=false;
		search_data=false;
		tableCurrRow=0;
		tableDataButtonPanelSynch();		
		makeUIUneditable();	
		clearFields();
		if(tableData.size()>0)
		{
		selectSpecificTableItem();	
		request_Table.requestFocus();
		request_Table.getSelectionModel().select(tableCurrRow);
		request_Table.getFocusModel().focus(tableCurrRow);
		request_Table.scrollTo(tableCurrRow);
		}
		}
		else
		{
		if(tableData.size()>0)
		{		
		selectSpecificTableItem();		
		request_Table.requestFocus();
		request_Table.getSelectionModel().select(tableCurrRow);
		request_Table.getFocusModel().focus(tableCurrRow);
		request_Table.scrollTo(tableCurrRow);
		}
		}
	
	}
	
	@FXML
	private void handleDeleteButtonAction(ActionEvent event) 
	{
	clearFields();
	if(request_Table.getSelectionModel().getSelectedIndex()>=0)
	{
	tableCurrRow=request_Table.getSelectionModel().getSelectedIndex();	
	}
	else
	{
	tableCurrRow=tableData.size()-1;	
	}
	rdao.deleteData(con,tableData.get(tableCurrRow).getServ_RequestNo().intValue());
	initData();	
	edit_data=false;
	new_data=false;
	search_data=false;
	tableCurrRow=tableData.size()-1;
	makeUIUneditable();
	clearFields();
	tableDataButtonPanelSynch();
	if(tableData.size()>0)
	{	
	selectSpecificTableItem();
	request_Table.requestFocus();
	request_Table.getSelectionModel().select(tableCurrRow);
	request_Table.getFocusModel().focus(tableCurrRow);
	request_Table.scrollTo(tableCurrRow);		
	}
	}
	
@Override
public void initialize(URL arg0, ResourceBundle arg1) 
	{
	// TODO Auto-generated method stub	
/*	initUInterface();
	initListData();
	initData();	
	tableDataButtonPanelSynch();		
	makeUIUneditable();	
	clearFields();
	if(tableData.size()>0)
	{
	selectSpecificTableItem();	
	request_Table.requestFocus();
	request_Table.getSelectionModel().select(tableCurrRow);
	request_Table.getFocusModel().focus(tableCurrRow);
	}
	}

public void initUInterface() 
{
a1.getStyleClass().add("anchor_paneleft");
a2.getStyleClass().add("anchor_paneright");
l_pane1.getStyleClass().add("lpane");
l_pane2.getStyleClass().add("lpane");
l_pane3.getStyleClass().add("lpane");
l_pane4.getStyleClass().add("lpane");
l_pane5.getStyleClass().add("lpane");
l_pane6.getStyleClass().add("lpane");
l_pane7.getStyleClass().add("lpane");
l_pane8.getStyleClass().add("lpane");
l_pane9.getStyleClass().add("lpane");
e_pane1.getStyleClass().add("epane");
e_pane2.getStyleClass().add("epane");
e_pane3.getStyleClass().add("epane");
e_pane4.getStyleClass().add("epane");
e_pane5.getStyleClass().add("epane");
e_pane6.getStyleClass().add("epane");
e_pane7.getStyleClass().add("epane");
e_pane8.getStyleClass().add("epane");
e_pane9.getStyleClass().add("epane");
request_Remark.addEventFilter(KeyEvent.KEY_PRESSED, new TabTraversalEventHandler());
setTableData(null);*/
}

/* Select Table Row - Key Press */
@FXML
private void handleRequestorIDKeyReleaseAction(KeyEvent event) 
{
	try {
		if (event.getCode()==KeyCode.UP)
		{			
			if(tableCurrRow>0)
			{
				tableCurrRow--;
				makeUIUneditable();	
				request_Table.requestFocus();
				request_Table.getSelectionModel().select(tableCurrRow);
				request_Table.getFocusModel().focus(tableCurrRow);
				clearFields();
				selectSpecificTableItem();
			}
			}
		if (event.getCode()==KeyCode.DOWN)
		{
			if(tableCurrRow<tableData.size()-1)
			{
				tableCurrRow++;
				makeUIUneditable();
				clearFields();
				selectSpecificTableItem();
				request_Table.requestFocus();
				request_Table.getSelectionModel().select(tableCurrRow);
				request_Table.getFocusModel().focus(tableCurrRow);
			}
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/* Select List Item */
@FXML
private void handleListItemSelection(ActionEvent event) 
{}


/* Select Table Row - Mouse Movement */
@FXML
private void handleTableItemMouseClicked(MouseEvent event) 
{
	if(!new_data && !edit_data && !search_data)
	{
	if(request_Table.getSelectionModel().getSelectedIndex()>=0)
	{
	tableCurrRow=request_Table.getSelectionModel().getSelectedIndex();	
	makeUIUneditable();	
	selectDirectTableItem();	
	}
	}
	
	if(search_data)
	{		
	if(tableCurrRow==request_Table.getSelectionModel().getSelectedIndex())
	{		
	request_Table.getSelectionModel().select(tableCurrRow);
	request_Table.getFocusModel().focus(tableCurrRow);
	request_Table.scrollTo(tableCurrRow);	
	}	
	else	
	{	
	request_Table.getSelectionModel().clearSelection(request_Table.getSelectionModel().getSelectedIndex());
	if(tableCurrRow>=0)
	{	
	request_Table.getSelectionModel().select(tableCurrRow);
	request_Table.getFocusModel().focus(tableCurrRow);
	request_Table.scrollTo(tableCurrRow);
	}
	}
	}
}

/* Select Top Button */
@FXML
private void handleFirstRecordMouseClicked(ActionEvent event) 
{
if(tableData.size()>0 && tableCurrRow>0)
{	
try {
	tableCurrRow=0;
	clearFields();	
	request_Table.scrollTo(0);
	request_Table.requestFocus();
	request_Table.getSelectionModel().select(0);
	request_Table.getFocusModel().focus(0);
	selectSpecificTableItem();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}

/* Select Bottom Button */
@FXML
private void handleBottomRecordMouseClicked(ActionEvent event) 
{
if(tableCurrRow!=tableData.size()-1)
{	
tableCurrRow=tableData.size()-1;
clearFields();
request_Table.scrollTo(tableCurrRow);
request_Table.requestFocus();
request_Table.getSelectionModel().select(tableCurrRow);
request_Table.getFocusModel().focus(tableCurrRow);
selectSpecificTableItem();
}	
}

/* Select Next Button */
@FXML
private void handleNextRecordMouseClicked(ActionEvent event) 
{
if(tableCurrRow<tableData.size()-1)
{
	tableCurrRow++;
	makeUIUneditable();	
	clearFields();
	request_Table.scrollTo(tableCurrRow);
	request_Table.requestFocus();
	request_Table.getSelectionModel().select(tableCurrRow);
	request_Table.getFocusModel().focus(tableCurrRow);
	selectSpecificTableItem();
}
}

/* Select Prev Button */
@FXML
private void handlePrevRecordMouseClicked(ActionEvent event) 
{
if(tableCurrRow>0)
{
	tableCurrRow--;
	makeUIUneditable();	
	clearFields();
	request_Table.scrollTo(tableCurrRow);
	request_Table.requestFocus();
	request_Table.getSelectionModel().select(tableCurrRow);
	request_Table.getFocusModel().focus(tableCurrRow);
	selectSpecificTableItem();
}
}

/* Initialize Tables For View */
public void initData() 
{
CachedRowSet rs=null;

		try {		
			tableData.clear();
			rs=rdao.tableDataFetch(con,tableData);
			while(rs.next())
			{
			String d_Requestor_Id=rs.getString("Requestor_Id");
			String d_name = rs.getString("name");
			String d_Serv_RequestId=rs.getString("Serv_RequestId");
			SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");  
			String d_serv_date=dtf.format(rs.getDate("Req_Date")).toString();
			String d_Req_Time=rs.getString("Req_Time");
			String d_ref_ServRequestID=rs.getString("ref_ServRequestID");
			String d_status=rs.getString("status");
			String d_remark=rs.getString("remark");
			Integer d_serv_request_no=Integer.valueOf(rs.getInt("serv_request_no"));
			Integer d_servType_no=Integer.valueOf(rs.getInt("servtype_no"));
			String d_servType=getServType(d_servType_no.intValue(),listData,true);
			tableData.add(new Service_Bean(d_Requestor_Id,d_name,d_Serv_RequestId,d_serv_date,d_Req_Time,d_ref_ServRequestID,d_status,d_remark,d_serv_request_no,d_servType_no,d_servType));
			}		
			request_Table.setItems(tableData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		}

/* Initialize List For View */

public void initListData() 
{
		try {		
			listData.clear();
			rdao.listDataFetch(con,listData);
			for(int i=0;i<listData.size();i++)
			{				
			listStrings.add(listData.get(i).getf_servType());
			}
			serv_type_list.setItems(listStrings);					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		}


public void setTableData(String s) 
{
try {
	f_requestorId.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_requestorId"));
	f_name.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_name"));
	f_servRequestId.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_servRequestId"));
	f_date.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_date"));
	f_status.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_status"));
	f_remark.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_remark"));
	f_time.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_time"));
	f_rservRequestId.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_rservRequestId"));
	f_servType.setCellValueFactory(new PropertyValueFactory<Service_Bean,String>("f_servType"));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

private void selectSpecificTableItem()
{
	
Service_Bean tableRow = request_Table.getItems().get(tableCurrRow);
selectTableItem(tableRow);
}

private void selectDirectTableItem()
{
Service_Bean serv = request_Table.getSelectionModel().getSelectedItem();
selectTableItem(serv);
}

private void selectTableItem(Service_Bean serv)
{	
if(tableData.size()>0)
{
if(!search_data)
requestor_Id.setText(serv.getf_requestorId());
requestor_Name.setText(serv.getf_name());
serv_request_Id.setText(serv.getf_servRequestId());
if(serv.getf_date()!=null)
{
d_date.setText(serv.getf_date());
}
request_Time.setText(serv.getf_time());
ref_Requestor_Id.setText(serv.getf_rservRequestId());
serv_Status.setText(serv.getf_status());
request_Remark.setText(serv.getf_remark());
int serv_type_index=getservindex(serv,listData);
if(serv_type_index>=0)
{
serv_type_list.getSelectionModel().select(serv_type_index);
}
}
}

private void makeUIUneditable()
{
if(!search_data)	
requestor_Id.setEditable(false);
serv_request_Id.setEditable(false);
ref_Requestor_Id.setEditable(false);
serv_Status.setEditable(false);
request_Remark.setEditable(false);
serv_type_list.setDisable(true);
}

private void makeUIEditable()
{
requestor_Id.setEditable(true);
serv_request_Id.setEditable(true);
ref_Requestor_Id.setEditable(true);
serv_Status.setEditable(true);
request_Remark.setEditable(true);
serv_type_list.setDisable(false);
}

private void clearFields()
{
if(!search_data)	
requestor_Id.clear();
requestor_Id.setPromptText("");
requestor_Name.setText("");
serv_request_Id.clear();
request_Time.setText("");
ref_Requestor_Id.clear();
serv_Status.clear();
request_Remark.clear();
d_date.setText("");
}

private void disableButtonPanel()
{
request_Table.setDisable(true);	
request_Worklist.setDisable(true);	
new_Service_Request.setDisable(true);
edit_Service_Request.setDisable(true);
send_Service_Request.setDisable(true);
print_Service_Request.setDisable(true);
delete_Service_Request.setDisable(true);
save_Service_Request.setDisable(false);
search_Service_Request.setDisable(true);
first_Record.setDisable(true);
next_Record.setDisable(true);
prev_Record.setDisable(true);
bottom_Record.setDisable(true);
}

private void enableButtonPanel()
{
request_Table.setDisable(false);
request_Table.setEditable(false);
request_Worklist.setDisable(false);	
new_Service_Request.setDisable(false);
edit_Service_Request.setDisable(false);
send_Service_Request.setDisable(false);
print_Service_Request.setDisable(false);
delete_Service_Request.setDisable(false);
save_Service_Request.setDisable(false);
first_Record.setDisable(false);
next_Record.setDisable(false);
prev_Record.setDisable(false);
bottom_Record.setDisable(false);
search_Service_Request.setDisable(false);
}

public void tableDataButtonPanelSynch()
{
if(tableData.size()<=0)
{
request_Table.setDisable(true);
request_Table.setEditable(false);
edit_Service_Request.setDisable(true);
print_Service_Request.setDisable(true);
delete_Service_Request.setDisable(true);
send_Service_Request.setDisable(true);
save_Service_Request.setDisable(true);
request_Worklist.setDisable(true);
first_Record.setDisable(true);
next_Record.setDisable(true);
prev_Record.setDisable(true);
bottom_Record.setDisable(true);
search_Service_Request.setDisable(true);
new_Service_Request.setDisable(false);
exit.setDisable(false);
}
	
if(tableData.size()==1)
{
request_Table.setDisable(false);
request_Table.setEditable(false);
new_Service_Request.setDisable(false);
edit_Service_Request.setDisable(false);
print_Service_Request.setDisable(false);
delete_Service_Request.setDisable(false);
request_Worklist.setDisable(false);
send_Service_Request.setDisable(false);
exit.setDisable(false);
first_Record.setDisable(true);
next_Record.setDisable(true);
prev_Record.setDisable(true);
bottom_Record.setDisable(true);
save_Service_Request.setDisable(true);
search_Service_Request.setDisable(true);
if(tableCurrRow>=0)
{
int serv_type_index=getservindex(tableData.get(tableCurrRow),listData);	
serv_type_list.getSelectionModel().select(serv_type_index);
}
}

if(tableData.size()>1)
{
request_Table.setDisable(false);
request_Table.setEditable(false);
first_Record.setDisable(false);
next_Record.setDisable(false);
prev_Record.setDisable(false);
bottom_Record.setDisable(false);
new_Service_Request.setDisable(false);
edit_Service_Request.setDisable(false);
print_Service_Request.setDisable(false);
delete_Service_Request.setDisable(false);
request_Worklist.setDisable(false);
send_Service_Request.setDisable(false);
search_Service_Request.setDisable(false);
exit.setDisable(false);
save_Service_Request.setDisable(true);
}
if(tableCurrRow>=0)
{
int serv_type_index=getservindex(tableData.get(tableCurrRow),listData);	
serv_type_list.getSelectionModel().select(serv_type_index);
}
}

private void searchTable(String requestorStr)
{
boolean found_flag=false;	
clearFields();

if(requestorStr.trim().length()>0)
{
/* Search for Exact Match */

for(int i=0; i<tableData.size();i++)
{
if(tableData.get(i).getf_requestorId()!=null && requestorStr!=null)
{
if(tableData.get(i).getf_requestorId().trim().equals(requestorStr.trim()))
{	
tableCurrRow=i;
selectSpecificTableItem();
request_Table.getSelectionModel().select(tableCurrRow);
request_Table.getFocusModel().focus(tableCurrRow);
request_Table.scrollTo(tableCurrRow);
found_flag=true;
break;	
}
else
{
continue;
}
}
}

/* Search for Like */
if(!found_flag)
{	
for(int i=0; i<tableData.size();i++)
{
if(tableData.get(i).getf_requestorId()!=null && requestorStr!=null)
{
if(tableData.get(i).getf_requestorId().trim().contains(requestorStr.trim()))
{	
tableCurrRow=i;
selectSpecificTableItem();
request_Table.getSelectionModel().select(tableCurrRow);
request_Table.getFocusModel().focus(tableCurrRow);
request_Table.scrollTo(tableCurrRow);
found_flag=true;
break;
}
}
else
{
continue;
}
}
}

if(!found_flag)
{	
request_Table.getSelectionModel().clearSelection(tableCurrRow);
tableCurrRow= -1;
}
}
else
{
if(!found_flag)
{	
request_Table.getSelectionModel().clearSelection(tableCurrRow);
tableCurrRow= -1;
}
}	
}

private Integer getServTypeNo(int servtypeindex)
{
Integer servtypeno=null;
servtypeno=listData.get(servtypeindex).getf_serv_type_No();
return servtypeno;	
}

private String getServType(int no, ObservableList<ServiceType_Bean> sbList, boolean searchflag)
{
String servtype=null;

/* Search by Service Type Number */
if(searchflag)
{
for(int i=0;i<sbList.size();i++)
{
if(sbList.get(i).getf_serv_type_No()==no)
{
servtype=sbList.get(i).getf_servType();
break;
}	
}
}

/* Search by Index */
if(!searchflag)
{
if(sbList.get(no).getf_serv_type_No()>=0)
{
servtype=sbList.get(no).getf_servType();
}
}
return servtype;	
}

private int getservindex(Service_Bean sb, ObservableList<ServiceType_Bean> sbList)
{
int indexValue= -1;
Integer servtypeno=sb.getservtype_no();

for(int i=0;i<sbList.size();i++)
{
if(sbList.get(i).getf_serv_type_No()==servtypeno)
{
indexValue=i;
break;
}	
}
return indexValue; 	
}
}