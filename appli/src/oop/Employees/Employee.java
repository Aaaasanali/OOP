package oop.Employees;

import oop.User;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {
    
	public String department;
	private List<String> messageInbox;
	
	{
		messageInbox = new ArrayList<String>();
	}
	
    private Employee() {
    	super();
    }
    
    private Employee(String department) {
    	super();
    	this.department = department;
    }
    
    protected String getDepartment() {
    	return department;
    }
    
    protected void setDepartment(String department) {
    	this.department = department;
    }
    
    private void sendMessage(User other, String message) {
    	
    }
    
    
    public String toString() {
    	return "Employee is placed in " + department + " department";
    }
    
}
