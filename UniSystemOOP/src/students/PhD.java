package students;

import research.Dissertation;

/**
* @generated
*/
public class PhD extends GraduateStudent {
    

    public PhD(String login, String password, String name, String surname, int course, int ects, String id) {
		super(login, password, name, surname, course, ects, id);
		// TODO Auto-generated constructor stub
	}

	private Dissertation dissertation;


    
    

    private Dissertation getDissertation() {
        return this.dissertation;
    }

    private void setDissertation(Dissertation dissertation) {
        this.dissertation = dissertation;
    }

    
    
    
}
