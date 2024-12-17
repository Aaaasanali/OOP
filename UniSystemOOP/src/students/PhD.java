package students;

import java.util.*;


import oop.NamedRunnable;
import research.Dissertation;

/**
* @generated
*/
public class PhD extends GraduateStudent {
	
    private Dissertation dissertation;

    
    
    
    
    public PhD(String login, String password, String name, String surname, int course, int ects, String id) {
		super(login, password, name, surname, course, ects, id);
		// TODO Auto-generated constructor stub
	}

	


    private Dissertation getDissertation() {
        return this.dissertation;
    }

    private void setDissertation(Dissertation dissertation) {
        this.dissertation = dissertation;
    }
    
    
    
    
    private String getString() {
    	return this.toString();
    }
    
    
    
    
    public String toString() {
        return super.toString() + 
               ", PhD{" +
               "dissertation=" + (dissertation != null ? dissertation.toString() : "No dissertation") +
               '}';
    }    
    
    
    
    
    
    
    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        functions.put(startIndex++, new NamedRunnable(this::getDissertation, "Get Thesis"));
        functions.put(startIndex++, new NamedRunnable(this::getString, "Get String"));
        return functions;
    }
    
}
