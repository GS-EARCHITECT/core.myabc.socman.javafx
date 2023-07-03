package application.SMSMain;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import application.SMSMain.View.Window;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

public static Connection con=null;
	
	@Override
	public void start(Stage primaryStage) 
	{
		Window window = new Window(primaryStage, con);
		system.out.println("hello");
	}
	
	public static void main(String[] args) 
	{
		/*initializeApp();*/
		launch(args);
	}
	

public static void initializeApp()
	{
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","newadmin");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from ACCOUNTMASTERTB");  
			 ResultSetMetaData metadata = rs.getMetaData();
			    int columnCount = metadata.getColumnCount();
			    System.out.println("Column Count :"+columnCount);
			    int rowcnt=0; 
			    while (rs.next()) {
			        String row = "";
			        rowcnt++;
			        System.out.println("Row Count :"+rowcnt);
			        for (int i = 1; i <= columnCount; i++) {
			            row += rs.getString(i) + ", ";          
			        }
			        System.out.println();			    
			    }
			//step5 close the connection object
			stmt.close();
			con.close();  
			  
			}catch(Exception e)
			{
			System.out.println(e);}  
			  
			}  
		  
	}
/*
//step3 create the statement object  
Statement stmt=con.createStatement();  
  
//step4 execute query  
 ResultSet rs=stmt.executeQuery("select * from SMS_MENU_MANAGER_MASTER");  
 ResultSetMetaData metadata = rs.getMetaData();
    int columnCount = metadata.getColumnCount();
    System.out.println("Column Count :"+columnCount);
    int rowcnt=0; 
    String menuNumber="";
    String menuBarText="";
    String menuIntId="";
    Menu menu=null;
    while (rs.next()) {
        String row = "";
        System.out.println("Row Count :"+rowcnt);
        menu=new Menu();
        for (int i = 1; i <= 3; i++) 
        {
        	if (i==1)
        			{
        		menuNumber=rs.getString(i);
        			}
        	if (i==2)
        			{
        		menuBarText=rs.getString(i);
        		menu.setText(menuBarText);
        			}
        	if (i==3)
			{
        		menuIntId=rs.getString(i);
        		menu.setId(menuIntId);
			}
          }
        System.out.println();			    
    }
step5 close the connection object
stmt.close();
con.close();  
  
}catch(Exception e)
{
System.out.println(e);}		  
}  
}	
*/	