package oop.Employees;

import oop.Data;
import oop.User;
import java.util.*;

public class Admin extends User {
	
    public Admin(String login, String password) {
		super(login, password);
		Data.addAdmin(this);
	}
    
    public void createStudent() {
    	
    }
}
