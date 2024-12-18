package employees;

import java.util.Arrays;
import java.util.Vector;


public class Manager extends Employee {
    
	private final Vector<String> functions = new Vector<>(Arrays.asList("Create Student", "Create Someone", "Find Student"));
	
    public Manager(String login, String password) {
    	super(login, password);
    }
    
    
    public void createStudent(String name) {
        System.out.println("Student " + name + " has been created.");
    }

    public void findStudent(String name) {
        System.out.println("Searching for student: " + name);
    }
    public void addFunction(String func) {
        if (!functions.contains(func)) {
            functions.add(func);
        }
    }

    public void removeFunction(String func) {
        functions.remove(func);
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
