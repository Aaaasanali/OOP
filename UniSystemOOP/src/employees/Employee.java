package employees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Factories.NamedRunnable;
import user.User;

public class Employee extends User implements Serializable{
    
	private static final long serialVersionUID = -4055598320012630398L;
	
	public String department;
	private List<String> messageInbox;
	
	{
		messageInbox = new ArrayList<String>();
	}
	
	
	private final Vector<String> functions = new Vector<>(Arrays.asList("Check Salary", "Check Inbox"));
	
    public Employee(String login, String password) {
    	super(login, password);
    }
    
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
        
        
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }
        
        return functions;
    }
    
    
    
    public String toString() {
    	return "Employee is placed in " + department + " department";
    }
    
}
