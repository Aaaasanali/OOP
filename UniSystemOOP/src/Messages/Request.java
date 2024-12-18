package Messages;

import database.Data;
import employees.*;

import java.util.List;

public class Request extends Message {

    private boolean signed = false;

    public Request(Employee sender, String content) {
        super(sender, content);
    }

    public boolean isSigned() {
        return signed;
    }

    public void sign() {
        this.signed = true;
    }

    public void unsigned() {
        this.signed = false;
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
    	return "[REQUEST]" + super.getShortInfo();
    }
}
