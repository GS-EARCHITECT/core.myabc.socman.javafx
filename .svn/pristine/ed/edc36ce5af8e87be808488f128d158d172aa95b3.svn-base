package resident.services.helpdesk;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class ServiceType_Bean implements Serializable {
	     private SimpleStringProperty f_servtypeId;
	     private SimpleStringProperty f_servType;
	     private Integer f_serv_type_No;
	     	     
	     public ServiceType_Bean()
	     {}
	 	    
	     public ServiceType_Bean(String b_servtypeId,String b_servType,Integer b_serv_type_no) 
	    		    {
	    			try {
	    				this.f_servtypeId = new SimpleStringProperty(b_servtypeId);
	    				this.f_servType = new SimpleStringProperty(b_servType);
	    				this.f_serv_type_No=b_serv_type_no;
	    			} catch (Exception e) {
	    				// TODO Auto-generated catch block
	    				System.out.println("Here");
	    				e.printStackTrace();
	    			}
	    		    }

//		Key - Service Type Number

	     public Integer getf_serv_type_No() 
	     {
	     return f_serv_type_No; 
	     }
	     
	     
//		Service Type ID

	     public void setf_servtypeId(String value) 
	     {
	     f_servtypeId.set(value); 
	     }
	     
	     public String getf_servtypeId()
	     { 
    	 return f_servtypeId.get(); 
    	 }
	     
	     public SimpleStringProperty f_servtypeIdProperty() 
	     { 
	     return f_servtypeId; 
	     }
	     
//			Service Type 

	     public void setf_servType(String value) 
	     {
	     f_servType.set(value); 
	     }
	     
	     public String getf_servType()
	     { 
    	 return f_servType.get(); 
    	 }
	     
	     public SimpleStringProperty f_servTypeProperty() 
	     { 
	     return f_servType; 
	     }


}
