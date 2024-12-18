package Messages;

import java.util.*;
import user.User;



public abstract class Message {
	private User sender;
	private Date date;
	private String content;

	public Message(User sender, String content) {
		this.sender = sender;
		this.content = content;
		this.date = new Date();
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message from " + sender.getName() + " at " + date + ": " + content;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Message message = (Message) o;
		return Objects.equals(sender, message.sender) &&
				Objects.equals(date, message.date) &&
				Objects.equals(content, message.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sender, date, content);
	}

	public String getShortInfo() {
		return this.sender + " " + this.content.substring(0, 30) + "... " + this.date;
	}

	public void messageUsing() {
		System.out.println( this.sender + " " +"\n " + 
				this.date +  " \n" + 
				this.content + "\n" +
				"\n1 - approve\n" +
		           "2 - not approve\n" +
		           "0 - back");
		Scanner scanner = new Scanner(System.in);
		
		 while (true) {
		        System.out.print("Choose an action: ");
		        String input = scanner.nextLine();
		        switch (input) {
		            case "1": // Approve
		                approveMessage();
		                return; 
		            case "2": 
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

	private void approveMessage() {
	    if (this instanceof Request) {
	        Request request = (Request) this;
	        if (request.getStatus() == RequestStatus.WAITING) {
	            request.setStatus(RequestStatus.APPROVED);
	            System.out.println("Message approved: " + request.getContent());
	        } else {
	            System.out.println("This request has already been processed.");
	        }
	    }
	}


	private void notApproveMessage() {
	    if (this instanceof Request) {
	        Request request = (Request) this;
	        if (request.getStatus() == RequestStatus.WAITING) {
	            request.setStatus(RequestStatus.NOTAPPROVED);
	            System.out.println("Message not approved: " + request.getContent());
	        } else {
	            System.out.println("This request has already been processed.");
	        }
	    }
	
}}