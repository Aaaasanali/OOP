package Messages;

import database.Data;
import employees.Dean;
import employees.Employee;

import java.util.List;

public class Complaint extends Message {

    public Complaint(Employee sender, String content) {
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

        boolean complaintSent = false;
        for (Dean d : deans) {
            if (sender.getDepartment().equals(d.getDepartment())) {
                d.addComplaint(this);
                complaintSent = true;
                break;
            }
        }

        if (!complaintSent) {
            System.out.println("No dean found for department: " + sender.getDepartment());
        }
    }


    public String getShortInfo() {
    	return "[COMPLAINT]" + super.getShortInfo();
    }


	
}
