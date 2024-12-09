package employees;

import oop.Data;
import oop.User;
import java.util.*;

public class Admin extends User {
	
	private static Vector<String> unis = new Vector<>(); 
	private Data data;
	
    public Admin(String login, String password, String uniName) {
		super(login, password, "001");
		if(!unis.contains(uniName)) {
			System.out.println("University " + uniName + " server has been created.");
			this.data = new Data(uniName, this);
			unis.add(uniName);
		}
		else System.out.println(uniName + " already exists.");
	}
    
    public void createStudent() {
    	
    }
}
