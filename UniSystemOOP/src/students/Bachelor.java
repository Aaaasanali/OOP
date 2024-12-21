package students;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import Factories.NamedRunnable;
import documents.DiplomaWork;

public class Bachelor extends Student implements Serializable{
    
	private DiplomaWork diplomaWork;
	
	
	
	
	public Bachelor(String login, String password, String name, String surname) {
		super(login, password, name, surname);

	}
	
	
	
	
	
    public DiplomaWork getDiplomaWork() {
		return diplomaWork;
	}


	public void setDiplomaWork(DiplomaWork diplomaWork) {
		this.diplomaWork = diplomaWork;
	}


	


    


   
    
    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        functions.put(startIndex++, new NamedRunnable(this::getDiplomaWork, "Get Thesis"));
        //functions.put(startIndex++, new NamedRunnable(this::getString, "Get String"));
        
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }
        
        return functions;
    }





	@Override
	public String toString() {
		return super.toString() + ", Thesis: " + (diplomaWork != null ? diplomaWork.toString() : "No thesis assigned");
	}

    
    
    
    
}
