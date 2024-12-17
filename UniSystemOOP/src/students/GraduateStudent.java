package students;

import java.util.Set;

import research.ResearchProject;
import research.Researcher;
/**
* @generated
*/
public class GraduateStudent extends Student {
    
	public GraduateStudent() {};

    public GraduateStudent(String login, String password, String name, String surname, int course, int ects,
			String id) {
		super(login, password, name, surname, course, ects, id);
		// TODO Auto-generated constructor stub
	}


	private Set<ResearchProject> projects;

    private Researcher supervisor;
    


    
   
    
    
    private Set<ResearchProject> getProjects() {
        return this.projects;
    }
    

    private void addProjects(ResearchProject project) {
        this.projects.add(project);
    }
    

    
    

    private Researcher getSupervisor() {
        return this.supervisor;
    }
    

    private void setSupervisor(Researcher supervisor) {
        this.supervisor = supervisor;
    }
    

    

    
    
    

    //                          Operations                                  
    
    
}
