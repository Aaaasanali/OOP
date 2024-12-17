package employees;

import user.User;

import java.util.*;

import database.Data;

public class Admin extends User {
	
	private static Vector<String> unis = new Vector<>(); 
	
	public Admin(String login, String password) {
		super(login, password);
		Data.addAdmin(this);
	}
    
    public void createStudent() {
    	
    }
}
