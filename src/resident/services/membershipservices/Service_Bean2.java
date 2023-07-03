package resident.services.membershipservices;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Service_Bean2 implements Serializable {
	     private SimpleStringProperty f_requestorId;
	     private SimpleStringProperty f_servRequestId;
	     private SimpleStringProperty f_rservRequestId;
	     private SimpleStringProperty f_time;
	     private SimpleStringProperty f_name;
	     private SimpleStringProperty f_status;
	     private SimpleStringProperty f_remark;
	     private ObjectProperty<LocalDate> f_date;
	     private LocalDate ld;
	     
	     public Service_Bean2(String b_requestorId,String b_name, String b_servRequestId,Date b_date,String b_time,String b_refservrequestId,
			String b_status, String b_remark) 
	    		    {
	    			try {
	    				this.f_requestorId = new SimpleStringProperty(b_requestorId);
	    				this.f_servRequestId = new SimpleStringProperty(b_servRequestId);
	    				this.f_rservRequestId = new SimpleStringProperty(b_refservrequestId);
	    				this.f_name = new SimpleStringProperty(b_name);
	    				this.f_status = new SimpleStringProperty(b_status);
	    				this.f_remark = new SimpleStringProperty(b_remark);
	    				this.f_time = new SimpleStringProperty(b_time);
	    				if(b_date!=null)
	    				ld = b_date.toLocalDate();
	    				this.f_date = new SimpleObjectProperty(ld);	    				
	    			} catch (Exception e) {
	    				// TODO Auto-generated catch block
	    				System.out.println("Here");
	    				e.printStackTrace();
	    			}
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
	     
	     public void setf_date(LocalDate value) 
	     {
	     f_date.set(value); 
	     }
	     
	     public LocalDate f_date()
	     { 
    	 return f_date.get(); 
    	 }
	     
	     public ObjectProperty<LocalDate> f_dateProperty() 
	     { 
	     return f_date; 
	     }

	     
}
