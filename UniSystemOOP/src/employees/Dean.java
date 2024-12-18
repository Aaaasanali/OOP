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
	    
	    
	    
	    
	    public Map<Integer, NamedRunnable> getFunctions(int startIndex){
	    	Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
	    	functions.put(startIndex++, new NamedRunnable(this::approveRequest,"approveRequest"));
	    	functions.put(startIndex++, new NamedRunnable(this::rejectRequest,"rejectRequest"));
	    	functions.put(startIndex++, new NamedRunnable(this::assignComplaint,"assignComplaint"));
	    	functions.put(startIndex++, new NamedRunnable(this::archiveComplaint,"archiveComplaint"));
	    	
	    	for(Map.Entry<Integer,NameRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
	    		functions.put(startIndex++, entry.getValue());
	    	}
	    	return functions;
	    	
	    }
	}

