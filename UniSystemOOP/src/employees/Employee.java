package employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Factories.NamedRunnable;
import Utils.Message;
import user.User;

public class Employee extends User {

	
	public Employee() {
	}

	public Employee(String login, String password) {

	}
	
	private void checkInfo() {
		
	}
    
    
	private void checkInbox() {

	}
	
	private void sendMessage() {
		// which type of message you want to send??
		// 1 - Simple 2 - Request 3 - Complaint
		// message = MessageFactory.getMessage("Simple", this)
		
		//message.setReceiver()
		//enter content of the message
		// message.send()
	}
	
	
	
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex){
		
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		
		functions.put(startIndex++, new NamedRunnable(this::checkInfo, "Check Info"));
		functions.put(startIndex++, new NamedRunnable(this::checkInbox, "Check Inbox"));
		functions.put(startIndex++, new NamedRunnable(this::sendMessage, "Send Message"));
		
		for(Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}
		
		return functions;
	}

}

