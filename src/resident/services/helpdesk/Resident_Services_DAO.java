package resident.services.helpdesk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import common.datamanipulation.DataManipulationUtil;
import javafx.collections.ObservableList;

public class Resident_Services_DAO 
{
	
public CachedRowSet tableDataFetch(Connection con, ObservableList<Service_Bean> dataList)
	{
	CachedRowSet rs=null;

	try {
		ResultSet rows=null;
		PreparedStatement stmt=con.prepareStatement("select * from SERVICE_MASTER order by SERV_REQUEST_NO",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
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
	
public void listDataFetch(Connection con, ObservableList<ServiceType_Bean> dataList)
{
CachedRowSet rs=null;

try {
	ResultSet rows=null;
	PreparedStatement stmt=con.prepareStatement("select * from SERVICE_TYPE_MASTER",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
	rows=stmt.executeQuery();
	RowSetFactory factory = RowSetProvider.newFactory();
	rs = factory.createCachedRowSet();
	rs.populate(rows);
	
	while(rs.next())
	{
	String d_servtype_Id=rs.getString("servtype_Id");
	String d_servtype = rs.getString("serv_type");
	Integer d_serv_request_no=Integer.valueOf(rs.getInt("servtype_no"));
	dataList.add(new ServiceType_Bean(d_servtype_Id,d_servtype,d_serv_request_no));
	}		
	}
catch(Exception e)
	{
	System.out.println("Error in Statement");
	}
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

public void insertData(Connection con, Service_Bean sb)
{
try {
	String d_requestor_Id=sb.getf_requestorId();
	String d_requestor_Name=sb.getf_name();
	String d_serv_request_Id=sb.getf_servRequestId();
	DataManipulationUtil dm=new DataManipulationUtil(); 
	java.sql.Date d_dt1=dm.getDBDatefromString(sb.getf_date());			
	String d_request_Time=sb.getf_time();
	String d_ref_Requestor_Id=sb.getf_rservRequestId();
	String d_serv_Status=sb.getf_status();
	String d_request_Remark=sb.getf_remark();
	Integer d_servtype_no=sb.getservtype_no();
		
	String stmt_Str="INSERT INTO SERVICE_MASTER"+" (SERV_REQUEST_NO,REQUESTOR_ID,REQ_TIME,SERV_REQUESTID,REQ_DATE,REF_SERVREQUESTID,NAME,STATUS,REMARK,SERVTYPE_NO) VALUES"+"(SERVICE_MASTER_REQUESTID.nextval,?,?,?,?,?,?,?,?,?)";
	PreparedStatement ps =con.prepareStatement(stmt_Str);
	
	ps.setString(1,d_requestor_Id);
	ps.setString(2,d_request_Time);
	ps.setString(3,d_serv_request_Id);
	ps.setDate(4,d_dt1);
	ps.setString(5,d_ref_Requestor_Id);
	ps.setString(6,d_requestor_Name);
	ps.setString(7,d_serv_Status);
	ps.setString(8,d_request_Remark);	
	ps.setInt(9,d_servtype_no.intValue());
	ps.executeUpdate();	
	ps.close();
	}
catch(Exception e)
	{
	e.printStackTrace();
	}	 
}

public void updateData(Connection con, Service_Bean sb)
{
try {
	String d_requestor_Id=sb.getf_requestorId();
	String d_requestor_Name=sb.getf_name();
	String d_serv_request_Id=sb.getf_servRequestId();	
	String d_ref_Requestor_Id=sb.getf_rservRequestId();
	String d_serv_Status=sb.getf_status();
	String d_request_Remark=sb.getf_remark();
	Integer d_servtype_no=sb.getservtype_no();
		
	String stmt_Str="update SERVICE_MASTER set REQUESTOR_ID=?,SERV_REQUESTID=?,REF_SERVREQUESTID=?,NAME=?,STATUS=?,REMARK=?,SERVTYPE_NO=? where serv_request_no=?";
	PreparedStatement ps =con.prepareStatement(stmt_Str);
	ps.setString(1,d_requestor_Id);
	ps.setString(2,d_serv_request_Id);
	ps.setString(3,d_ref_Requestor_Id);
	ps.setString(4,d_requestor_Name);
	ps.setString(5,d_serv_Status);
	ps.setString(6,d_request_Remark);
	ps.setInt(7,d_servtype_no.intValue());
	ps.setInt(8,sb.getServ_RequestNo().intValue());
	ps.executeUpdate();	
	ps.close();
	}
catch(Exception e)
	{
	e.printStackTrace();
	}	 
}

public void deleteData(Connection con, int serv_req_no)
{
try {
	String stmt_Str="delete from SERVICE_MASTER where serv_request_no=?";
	PreparedStatement ps =con.prepareStatement(stmt_Str);
	ps.setInt(1,serv_req_no);
	ps.executeUpdate();
	ps.close();
	}
catch(Exception e)
	{
	e.printStackTrace();
	}	 
}


}

