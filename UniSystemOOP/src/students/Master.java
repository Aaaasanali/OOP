package students;

import research.Thesis;
import java.util.*;

import factories.NamedRunnable;

public class Master extends GraduateStudent {
    

	public Master() {};
	
    public Master(String login, String password, String name, String surname, int course, int ects, String id) {
		super(login, password, name, surname, course, ects, id);
		// TODO Auto-generated constructor stub
	}
    
    private Thesis thesis;


    private Thesis getThesis() {
        return this.thesis;
    }
    
    private void getString() {
    	System.out.println("AD");
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
}
