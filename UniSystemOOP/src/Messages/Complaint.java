package Messages;

import database.Data;
import employees.Dean;
import employees.Employee;

public class Complaint extends Message{
	public Complaint() {}
	
	public void send() {
		for(Dean d : Data.getDeans()) {
			if(((Employee) this.getSender()).getDepartment().equals(d.getDepartment())) d.addComplaint(this);
		}
	}
}
