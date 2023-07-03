package common.datamanipulation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.collections.ObservableList;

public class DataManipulationUtil {
public void printServiceRequest(Object o){}
public void sendServiceRequest(Object o){}

public java.sql.Date getDBDatefromString(String dt)
{
SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
java.util.Date date=null;
java.sql.Date sqlDate=null;
try {
	date = sdf1.parse(dt);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
sqlDate = new java.sql.Date(date.getTime()); 	
return sqlDate;
}

public String getDBDateAsString(java.sql.Date dt)
{
SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
String sqlDateStr=null;
sqlDateStr = sdf1.format(dt);
return sqlDateStr;
}

public String getDateAsString(java.util.Date dt)
{
SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
String utilDateStr=null;
utilDateStr = sdf1.format(dt);
return utilDateStr;
}

public String getTimeAsString(java.util.Date dt)
{
SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
String utilTimeStr=null;
utilTimeStr = sdf1.format(dt);
return utilTimeStr;
}
}
