package students;

import java.io.Serializable;
import java.util.*;


import Factories.NamedRunnable;
import research.Dissertation;

/**
* @generated
*/
public class PhD extends GraduateStudent implements Serializable {
	
    private Dissertation dissertation;

    
    
    
    
    public PhD(String login, String password, String name, String surname) {
		super(login, password, name, surname);
		// TODO Auto-generated constructor stub
	}
    

	


    public PhD() {
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
        functions.put(startIndex++, new NamedRunnable(this::getDissertation, "Get Dissertation"));
        functions.put(startIndex++, new NamedRunnable(this::getString, "Get String"));
        
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }
        
        return functions;
    }
    
}
