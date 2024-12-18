package employees;

import java.util.*;

import Factories.NamedRunnable;
import Messages.*;

public class Dean extends Employee{
	 private final List<Request> requests = Collections.synchronizedList(new ArrayList<>());
	 private final List<Complaint> complaints = Collections.synchronizedList(new ArrayList<>());

	
	
	 public Dean(String name, String department) {
	        super(name, department);
	    }
	
	public void addRequest(Request r) {
		this.requests.add(r);
	}
	public void addComplaint(Complaint c) {
		this.complaints.add(c);
	}
	  public List<Request> getRequests() {
	        return Collections.unmodifiableList(requests);
	    }

	    public List<Complaint> getComplaints() {
	        return Collections.unmodifiableList(complaints);
	    }
	    
	    public String toString() {
	        return "Dean: " + this.getName() + ", Department: " + this.getDepartment();
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Dean dean = (Dean) obj;
	        return Objects.equals(this.getName(), dean.getName()) &&
	               Objects.equals(this.getDepartment(), dean.getDepartment());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(this.getName(), this.getDepartment());
	    }
	    
	
	    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex){
	    	Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
	    	functions.put(startIndex++, new NamedRunnable(this::approveRequest,"approveRequest"));
	    	functions.put(startIndex++, new NamedRunnable(this::rejectRequest,"rejectRequest"));
	    	functions.put(startIndex++, new NamedRunnable(this::assignComplaint,"assignComplaint"));
	    	functions.put(startIndex++, new NamedRunnable(this::archiveComplaint,"archiveComplaint"));
	    	functions.put(startIndex++, new NamedRunnable(this::checkInbox,"checkInbox"));
	    	
	    	for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
	    	    functions.put(startIndex++, entry.getValue());
	    	}

	    	return functions;
	    	
	    }
	    public void approveRequest() {
	        if (!requests.isEmpty()) {
	            Request r = requests.get(0); 
	            r.setSignedStatus(true);
	            System.out.println("Request approved: " + r.getContent());
	        } else {
	            System.out.println("No requests to approve.");
	        }
	    }
	    public void rejectRequest() {
	        if (!requests.isEmpty()) {
	            Request r = requests.remove(0); 
	            System.out.println("Request rejected: " + r.getContent());
	        } else {
	            System.out.println("No requests to reject.");
	        }
	    }
	    public void assignComplaint() {
	        if (!complaints.isEmpty()) {
	            Complaint c = complaints.get(0); 
	            System.out.println("Complaint assigned: " + c.getContent());
	            
	        } else {
	            System.out.println("No complaints to assign.");
	        }
	    }
	    public void archiveComplaint() {
	        if (!complaints.isEmpty()) {
	            Complaint c = complaints.remove(0); 
	            System.out.println("Complaint archived: " + c.getContent());
	        } else {
	            System.out.println("No complaints to archive.");
	        }
	    }
	    public void checkInbox() {
	        System.out.println("Inbox - Requests:");
	        for (Request r : requests) {
	            System.out.println("- " + r.getContent());
	        }
	        System.out.println("Inbox - Complaints:");
	        for (Complaint c : complaints) {
	            System.out.println("- " + c.getContent());
	        }
	    }

	}

