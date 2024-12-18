	package Messages;
	
	import database.Data;
	import employees.*;

	import java.util.List;
import java.util.Scanner;
	
	public class Request extends Message {
	
	 
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
	                break; 
	        }
	
	        if (!requestSent) {
	            System.out.println("No dean found for department: " + sender.getDepartment());
	        }
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
		@Override
		 public void messageUsing() {
		        System.out.println(this.getSender() + "\n" +
		                this.getDate() + "\n" +
		                this.getContent() + "\n" +
		                "\n1 - approve\n" +
		                "2 - not approve\n" +
		                "0 - back");

		        try (Scanner scanner = new Scanner(System.in)) {
		            while (true) {
		                System.out.print("Choose an action: ");
		                String input = scanner.nextLine();
		                switch (input) {
		                    case "1": // Approve
		                        approveMessage();
		                        return;

		                    case "2": // Not approve
		                        notApproveMessage();
		                        return;

		                    case "0":
		                        System.out.println("Returning to the previous menu...");
		                        return;

		                    default:
		                        System.out.println("Invalid choice. Please try again.");
		                }
		            }
		        }
		    }

		    private void approveMessage() {
		        if (this.getStatus() == RequestStatus.WAITING) {
		            this.setStatus(RequestStatus.APPROVED);
		            System.out.println("Request approved: " + this.getContent());
		        } else {
		            System.out.println("This request has already been processed.");
		        }
		    }

		    private void notApproveMessage() {
		        if (this.getStatus() == RequestStatus.WAITING) {
		            this.setStatus(RequestStatus.NOTAPPROVED);
		            System.out.println("Request not approved: " + this.getContent());
		        } else {
		            System.out.println("This request has already been processed.");
		        }
		    }
		}
	
