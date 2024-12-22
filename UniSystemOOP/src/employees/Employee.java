package employees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Factories.NamedRunnable;
import database.Data;
import documents.Request;
import user.User;
import utils.InputPrompt;

public class Employee extends User implements Serializable{
    
	private static final long serialVersionUID = -4055598320012630398L;
	
	public String department;
	private List<String> messageInbox = new ArrayList<>();
	
	
//	private final Vector<String> functions = new Vector<>(Arrays.asList("Check Salary", "Check Inbox"));
	
    public Employee(String login, String password) {
    	super(login, password);
    }
    
    public Employee() {}
    
    public Employee(String login, String password, String name, String surname) {
    	super(login, password, name, surname);
	}

	protected String getDepartment() {
    	return department;
    }
    
    protected void setDepartment(String department) {
    	this.department = department;
    }
    
    private void sendMessage() {
    	//User other, String message
    	System.out.println("In process......");
    	
    }
    
    public List<Request> getRequests() {
        if (Data.INSTANCE == null) {
            System.out.println("Data object is null");
            return null; // or return an empty list
        }
        Vector<Request> requests = Data.INSTANCE.getRequests();
        if (requests == null) {
            System.out.println("Requests list is null");
            return null; // or return an empty list
        }
        return requests;
    }
    
    
    
    public void sendRequest() {
        System.out.println("Type 'quit' at any time to exit.");

        while (true) {
            String content = InputPrompt.promptInput("Enter the request content: ");
            if (content == null) {
                // User chose to quit
                return;
            }

            if (content.trim().isEmpty()) {
                System.out.println("Request content cannot be empty. Please try again.");
                continue;
            }

            // Collect sender's name and surname
            String senderName = this.getName(); // Assuming Employee has a `getName` method
            String senderSurname = this.getSurname(); // Assuming Employee has a `getSurname` method

            // Create a new request and add it to the Data
            Request request = new Request(content, senderName, senderSurname);
            Data.INSTANCE.addRequest(request); // This adds the request to the data's list
            System.out.println("Request sent successfully: " + content);
            break; // Exit after a successful request
        }
    }
    
//    public String getFunc() {
//    	String res = "";
//    	for(String i : functions) {
//    		res += i + "\n";
//    	}
//    	res += super.getFunc();
//    	return res;
//    }
//    
    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        functions.put(startIndex++, new NamedRunnable(this::sendMessage, "Send message"));
        functions.put(startIndex++, new NamedRunnable(this::sendRequest, "Send request"));
        
        
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }
        
        return functions;
    }
    
    
    
    public String toString() {
    	return "Employee is placed in " + department + " department";
    }
    
}
