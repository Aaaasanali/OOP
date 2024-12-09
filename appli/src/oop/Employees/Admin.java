package oop.Employees;

import oop.Data;
import oop.User;

/**
* @generated
*/
public class Admin extends User {
	
	private Data data;
	
    public Admin(String login, String password, String uniName) {
		super(login, password, "001");
		this.data = new Data(uniName, this);
	}
    
    public void createStudent() {
    	
    }
}
