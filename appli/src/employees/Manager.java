package employees;

import java.util.Arrays;
import java.util.Vector;

/**
* @generated
*/
public class Manager extends Employee {
    
	private final Vector<String> functions = new Vector<>(Arrays.asList("Create Student", "Create Someone", "Find Student"));
	
    public Manager(String login, String password) {
    	super(login, password);
    }
    
    public String getFunc() {
    	String res = "";
    	for(String i : functions) {
    		res += i + "\n";
    	}
    	res += super.getFunc();
    	return res;
    }
    
}
