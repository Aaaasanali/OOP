package employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import user.User;

public class Employee extends User {
    
	public String department;
	private List<String> messageInbox;
	
	{
		messageInbox = new ArrayList<String>();
	}
	
	private final Vector<String> functions = new Vector<>(Arrays.asList("Check Salary", "Check Inbox"));
	
    public Employee(String login, String password) {
    	super(login, password);
    }
    
    public String getDepartment() {
    	return department;
    }
    
    protected void setDepartment(String department) {
    	this.department = department;
    }
    
    private void sendMessage(User other, String message) {
    	
    }
    
    public String getFunc() {
    	String res = "";
    	for(String i : functions) {
    		res += i + "\n";
    	}
    	res += super.getFunc();
    	return res;
    }
    
    public String toString() {
    	return "Employee is placed in " + department + " department";
    }
    
}
