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
	
	private final Vector<String> functions = new Vector<>(Arrays.asList(
			"Check Salary", "Check Inbox", "Send Message"));

	
	
	

	
	public Employee() {
	}

	public Employee(String login, String password) {

	}
	
	private void checkInfo() {
		
	}
    
    
	private void checkInbox() {

	}
	
	private void sendMessage() {

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

