package employees;

import java.util.Arrays;
import java.util.Vector;

/**
* @generated
*/
public class Manager extends Employee {
    
	private final Vector<String> functions = new Vector<>(Arrays.asList("Settings", "Change Login", "Change Password", "Check Info"));
	
    public Manager(String login, String password) {
    	super(login, password);
    }
    
}
