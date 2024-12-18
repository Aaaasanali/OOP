package students;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import Factories.NamedRunnable;
import research.ResearchProject;
import research.Researcher;
/**
* @generated
*/
public class GraduateStudent extends Student implements Serializable{
    
	private Set<ResearchProject> projects;
    private Researcher supervisor;
    
	
	public GraduateStudent() {};

    public GraduateStudent(String login, String password, String name, String surname) {
		super(login, password, name, surname);
		// TODO Auto-generated constructor stub
	}


	
   
    
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
    
    public void assignSupervisor() {
    	
    }
    
    
    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex){
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		
		functions.put(startIndex++, new NamedRunnable(this::assignSupervisor, "Assign supervisor"));
		
		for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }
		
		return functions;
	}
    
    
}
