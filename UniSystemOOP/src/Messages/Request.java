package Messages;

import database.Data;
import employees.*;

public class Request extends Message{
	public Request() {};
	
	private boolean signed = false;
	
	public boolean isSigned() {
		return signed;
	}
	public void setSignedStatus(boolean b) {
		this.signed = b;
	}
	
	public void send() {
		for(Dean d : Data.getDeans()) {
			if(((Employee) this.getSender()).getDepartment().equals(d.getDepartment())) d.addRequest(this);
		}
	}

}
