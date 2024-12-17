package students;

import research.Thesis;

public class Master extends GraduateStudent {
    

    public Master(String login, String password, String name, String surname, int course, int ects, String id) {
		super(login, password, name, surname, course, ects, id);
		// TODO Auto-generated constructor stub
	}

	
    
    private Thesis thesis;
    

    
    


    

    
    

    private Thesis getThesis() {
        return this.thesis;
    }
    
 
    private void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
    
    
    
    
    
    
}
