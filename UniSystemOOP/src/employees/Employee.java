package employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Utils.Message;

public class Employee extends User {

	private final Vector<String> functions = new Vector<>(Arrays.asList(
			"Check Salary", "Check Inbox", "Send Message"));

	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex){
		
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		
		functions.put(startIndex++, new NamedRunnable(this::checkSalary, "Check Salary"));
		functions.put(startIndex++, new NamedRunnable(this::checkInbox, "Check Inbox"));
		functions.put(startIndex++, new NamedRunnable(this::sendMessage, "Send Message"));
		
		for(Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}
		
		return functions;
	}

	public Employee() {

	}

	public Employee(String login, String password) {

	}
	
	private void checkSalary() {
		
	}
	
	private void checkInbox() {

	}
	
	private void sendMessage() {

	}
	
	public String getFunctions() {
		return "";
	}

}

