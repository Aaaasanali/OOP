package students;

import research.Researcher;
import research.Thesis;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;

public class Master extends GraduateStudent implements Serializable {
    

	private Thesis thesis;
	
	
	public Master() {
		super.researcherStatus(true);
	}
	
    public Master(String login, String password, String name, String surname) {
		super(login, password, name, surname);
		super.researcherStatus(true);
		this.setResearcherAccount(new Researcher(login, password, name, surname));
	}
   
    
    


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
        //functions.put(startIndex++, new NamedRunnable(this::getString, "Get String"));
        
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }
        
        return functions;
    }
    
    
    
    
    
    public String toString() {
        return super.toString() + ", Thesis: " + (thesis != null ? thesis.toString() : "No thesis assigned");
    }
}
