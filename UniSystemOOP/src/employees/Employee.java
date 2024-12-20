package employees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import Messages.Message;
import user.User;

<<<<<<< HEAD
public class Employee extends User implements Serializable{
    
=======
public class Employee extends User {

>>>>>>> refs/remotes/origin/Alkash
	public String department;
	private List<Message> messageInbox;

	{
		messageInbox = new ArrayList<Message>();
	}
<<<<<<< HEAD
	
	
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
    
=======

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

	private void checkInbox() {

	}

	public String toString() {
		return "Employee is placed in " + department + " department";
	}

>>>>>>> refs/remotes/origin/Alkash
}
