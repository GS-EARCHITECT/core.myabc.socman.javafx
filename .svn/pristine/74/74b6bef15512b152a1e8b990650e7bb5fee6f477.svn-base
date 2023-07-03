package common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DataAccessController 
{
public Connection commonDataConnect()
	{
	Connection con=null;
	//step1 load the driver class
try {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gaurav","gaurav");  
		}
catch(Exception e)
		{
	System.out.println("Error in DataCon");
		}
return con;
}

public CachedRowSet commonDataFetch(Connection con, String commandString)
{
CachedRowSet rs=null;

try {
	ResultSet rows=null;
	PreparedStatement stmt=con.prepareStatement(commandString,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
	rows=stmt.executeQuery();
	RowSetFactory factory = RowSetProvider.newFactory();
	rs = factory.createCachedRowSet();
	rs.populate(rows);
	}
catch(Exception e)
	{
	System.out.println("Error in Statement");
	}		  
	return rs; 
}


public void commonDataCUD(Connection con, String commandString)
{
try {
	con.setAutoCommit(true);
	System.out.println("Command :"+commandString);			
	PreparedStatement stmt=con.prepareStatement(commandString);
	stmt.executeUpdate();
	}
catch(Exception e)
	{
	e.printStackTrace();
	}	 
}
}

