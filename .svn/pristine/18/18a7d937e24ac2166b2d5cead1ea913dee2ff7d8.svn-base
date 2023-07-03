package resident.services.membershipservices;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Service_Bean implements Serializable {
	     private SimpleStringProperty f_requestorId;
	     private SimpleStringProperty f_servRequestId;
	     private SimpleStringProperty f_rservRequestId;
	     private SimpleStringProperty f_time;
	     private SimpleStringProperty f_name;
	     private SimpleStringProperty f_status;
	     private SimpleStringProperty f_remark;
	     private SimpleStringProperty f_date;	     
	     private SimpleStringProperty  f_servType;
	     private Integer f_servTypeNo;	     
	     private Integer serv_Request_No;
	          
	     public Service_Bean()
	     {}
	 	    
	     public Service_Bean(String b_requestorId,	String b_name,	String b_servRequestId,
	    		 			 String b_date,			String b_time,	String b_refservrequestId,
	    		 			 String b_status, 		String b_remark,	Integer b_sreq_no,
	    		 			 Integer b_servTypeNo,	String b_servType) 
	    		    {
	    			try {
	    				this.f_requestorId = new SimpleStringProperty(b_requestorId);
	    				this.f_servRequestId = new SimpleStringProperty(b_servRequestId);
	    				this.f_rservRequestId = new SimpleStringProperty(b_refservrequestId);
	    				this.f_name = new SimpleStringProperty(b_name);
	    				this.f_status = new SimpleStringProperty(b_status);
	    				this.f_remark = new SimpleStringProperty(b_remark);
	    				this.f_time = new SimpleStringProperty(b_time);
	    				this.f_date = new SimpleStringProperty(b_date);
	    				this.f_servType=new SimpleStringProperty(b_servType);
	       				this.serv_Request_No=b_sreq_no;
	    				this.f_servTypeNo=b_servTypeNo;
	    				
	    			} catch (Exception e) {
	    				// TODO Auto-generated catch block
	    				System.out.println("Here");
	    				e.printStackTrace();
	    			}
	    		    }

//		 Service Type 

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
	     
//		 Service Type No

	     public Integer getservtype_no()
	     { 
    	 return f_servTypeNo; 
    	 }

	     public void setservtype_no(String servtypeno)
	     { 
    	 f_servTypeNo=Integer.valueOf(servtypeno); 
    	 }

//			Key - Service Request Number

	     public Integer getServ_RequestNo() 
	     {
	     return serv_Request_No; 
	     }
	     
	     
//		Requestor ID

	     public void setf_requestorId(String value) 
	     {
	     f_requestorId.set(value); 
	     }
	     
	     public String getf_requestorId()
	     { 
    	 return f_requestorId.get(); 
    	 }
	     
	     public SimpleStringProperty f_requestorIdProperty() 
	     { 
	     return f_requestorId; 
	     }

//			Time

	     public void setf_time(String value) 
	     {
	     f_time.set(value); 
	     }
	     
	     public String getf_time()
	     { 
    	 return f_time.get(); 
    	 }
	     
	     public SimpleStringProperty f_timeProperty() 
	     { 
	     return f_time; 
	     }

	     
	     
//		Service Request ID
 
	     public void setf_servRequestId(String value) 
	     {
	     f_servRequestId.set(value); 
	     }
	     
	     public String getf_servRequestId()
	     { 
    	 return f_servRequestId.get(); 
    	 }
	     
	     public SimpleStringProperty f_servRequestIdProperty() 
	     { 
	     return f_servRequestId; 
	     }

//		Reference Service Request ID
	     
	     public void setf_rservRequestId(String value) 
	     {
	     f_rservRequestId.set(value); 
	     }
	     
	     public String getf_rservRequestId()
	     { 
    	 return f_rservRequestId.get(); 
    	 }
	     
	     public SimpleStringProperty f_rservRequestIdProperty() 
	     { 
	     return f_rservRequestId; 
	     }

//		Name
	     
	     public void setf_name(String value) 
	     {
	     f_name.set(value); 
	     }
	     
	     public String getf_name()
	     { 
    	 return f_name.get(); 
    	 }
	     
	     public SimpleStringProperty f_nameProperty() 
	     { 
	     return f_name; 
	     }
	     
//		Remark
	     
	     public void setf_remark(String value) 
	     {
	     f_remark.set(value); 
	     }
	     
	     public String getf_remark()
	     { 
    	 return f_remark.get(); 
    	 }
	     
	     public SimpleStringProperty f_remarkProperty() 
	     { 
	     return f_remark; 
	     }

//		Status
	     
	     public void setf_status(String value) 
	     {
	     f_status.set(value); 
	     }
	     
	     public String getf_status()
	     { 
    	 return f_status.get(); 
    	 }
	     
	     public SimpleStringProperty f_statusProperty() 
	     { 
	     return f_status; 
	     }

//			Date
	     
	     public void setf_date(String value) 
	     {
	     f_date.set(value); 
	     }
	     
	     public String getf_date()
	     { 
    	 return f_date.get(); 
    	 }
	     
	     public SimpleStringProperty f_dateProperty() 
	     { 
	     return f_date; 
	     }	     
}
