package employees;

import oop.Data;
import oop.User;
import java.util.*;

public class Admin extends User {
	
	private static Vector<String> unis = new Vector<>(); 
	
	public Admin(String login, String password) {
		super(login, password);
		Data.addAdmin(this);
	}
    
    public void createStudent() {
    	
    }
}
