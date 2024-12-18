package employees;

import java.util.*;

import Messages.*;

public class Dean extends Employee{
	
	private final Vector<Request> requests = new Vector<>();
	private final Vector<Complaint> complaints = new Vector<>();
	
	public Dean() {
		
	}
	
	public void addRequest(Request r) {
		this.requests.add(r);
	}
	public void addComplaint(Complaint c) {
		this.complaints.add(c);
	}
}
