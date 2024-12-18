package students;

import research.Thesis;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;

public class Master extends GraduateStudent implements Serializable {
    

	public Master() {};
	
    public Master(String login, String password, String name, String surname) {
		super(login, password, name, surname);
		// TODO Auto-generated constructor stub
	}
    
    private Thesis thesis;


    private void getThesis() {											// void/Thesis?    return thesis or just print it?
    	System.out.println(this.thesis);
    }
    
    private void getString() {
    	System.out.println(this);
    }
    
    private void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
    
    
    
    
    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        functions.put(startIndex++, new NamedRunnable(this::getThesis, "Get Thesis"));
        functions.put(startIndex++, new NamedRunnable(this::getString, "Get String"));
        return functions;
    }
    
    
    
    
    
    public String toString() {
        return super.toString() + ", Thesis: " + (thesis != null ? thesis.toString() : "No thesis assigned");
    }
}
