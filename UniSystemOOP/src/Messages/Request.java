	package Messages;
	
	import database.Data;
	import employees.*;

	import java.util.List;
	
	public class Request extends Message {
	
	    private boolean signed = false;
	    private RequestStatus status = RequestStatus.WAITING;
	    public Request(Employee sender, String content) {
	        super(sender, content);
	    }
	
	
	
	
	    public void send() {
	        if (!(this.getSender() instanceof Employee)) {
	            throw new IllegalArgumentException("Sender must be an Employee");
	        }
	
	        Employee sender = (Employee) this.getSender();
	        List<Dean> deans = Data.getDeans();
	
	        if (deans == null || deans.isEmpty()) {
	            System.out.println("No deans available in the system");
	            return;
	        }
	
	        boolean requestSent = false;
	        for (Dean d : deans) {
	            if (sender.getDepartment().equals(d.getDepartment())) {
	                d.addRequest(this);
	                requestSent = true;
	                break; // Прекращаем поиск после добавления запроса
	            }
	        }
	
	        if (!requestSent) {
	            System.out.println("No dean found for department: " + sender.getDepartment());
	        }
	    }
	
		
	
		public void setSignedStatus(boolean b) {
			// TODO Auto-generated method stub
			
		}
		
		public String getShortInfo() {
	        return "[REQUEST] " + super.getShortInfo() + " | Status: " + status;
	    }
		  public void approve() {
		        if (status == RequestStatus.WAITING) {
		            setStatus(RequestStatus.APPROVED);
		            System.out.println("Request approved: " + getContent());
		        } else {
		            System.out.println("Request already processed: " + getContent());
		        }
		    }
	
		public RequestStatus getStatus() {
			return status;
		}
	
		public void setStatus(RequestStatus status) {
			this.status = status;
			
		}
		}
	
