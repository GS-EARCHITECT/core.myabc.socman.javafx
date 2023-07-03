package application.login.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

import org.apache.commons.collections4.CollectionUtils;

import application.login.DTO.Login_DTO;

public class Login_Action 
{
public Login_DTO passwordFetch(Connection con, String userId)
	{
	Login_DTO dto=null;

	try {
		ResultSet rows=null;
		PreparedStatement stmt=con.prepareStatement("select * from USER_SECURITY_MASTER where login_id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
		System.out.println("checked out");
		stmt.setString(1,userId);
		rows=stmt.executeQuery();
		if(rows.first()) {
			dto=new Login_DTO();		    
		    dto.setPassword(rows.getString("password"));
		}
	}
	catch(Exception e)
		{
		System.out.println("Error in Statement");
		}
	return dto;
	}

public Login_DTO roleFetch(Connection con, String userId)
{
Login_DTO dto=null;

try {
	ResultSet rows=null;
	PreparedStatement stmt=con.prepareStatement("select * from USER_SECURITY_MASTER where login_id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
	stmt.setString(1,userId);
	rows=stmt.executeQuery();
	if(rows.first()) {
		dto=new Login_DTO();
		String roleNo=
	    dto.setRoleNo(rows.getString("ROLENO"));
	}
}
catch(Exception e)
	{
	System.out.println("Error in Statement");
	}
return dto;
}



public Login_DTO menuBarFetch(Connection con, String userId)
{
Login_DTO dto=null;

try {
	ResultSet rows=null;
	
	
	PreparedStatement stmt=con.prepareStatement("select * from USER_SECURITY_ACL where login_id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
	stmt.setString(1,userId);
	rows=stmt.executeQuery();
	if(rows.first()) {
		dto=new Login_DTO();		    
	    dto.setPassword(rows.getString("password"));
	}
}
catch(Exception e)
	{
	System.out.println("Error in Statement");
	}
return dto;
}


}

