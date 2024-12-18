package students;

import java.io.Serializable;
import java.util.Set;

import research.ResearchProject;
import research.Researcher;
/**
* @generated
*/
public class GraduateStudent extends Student implements Serializable{
    
	public GraduateStudent() {};

    public GraduateStudent(String login, String password, String name, String surname, String id) {
		super(login, password, name, surname, id);
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
    

    

    
    public String toString() {
        return super.toString() + 
               ", GraduateStudent{" +
               "projects=" + (projects != null ? projects.toString() : "No projects") +
               ", supervisor=" + (supervisor != null ? supervisor.toString() : "No supervisor") +
               '}';
    }
    

    //                          Operations                                  
    
    public void assignSupervisor(String name) {
    	
    }
}
