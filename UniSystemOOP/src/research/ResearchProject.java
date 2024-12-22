package research;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import database.Data;
import students.GraduateStudent;

public class ResearchProject implements Serializable{
	private Scanner inp = new Scanner(System.in);
	
    private String name;
    private String discription;
    private Date startDate;
    private ResearchStatus status;
    private final ArrayList<ResearchPaper> paper = new ArrayList<>();
    private final ArrayList<String> keywords = new ArrayList<>();
    private final ArrayList<String> references = new ArrayList<>();
    private String projectAbstract;
    private Date publicationDate;
    private final ArrayList<Section> sections = new ArrayList<>();
    private final ArrayList<Researcher> authors = new ArrayList<>();
    private Researcher headResearcher;
    
    public ResearchProject(){}
    
    public ResearchProject(String name, String discription) {
    	this.name = name;
    	this.discription = discription;
    	this.startDate = new Date();
    	this.status = ResearchStatus.IN_PROGRESS;
    }
    
    public void startResearchPaper() {}
    
    public void createSection() {
    	System.out.println("Enter name of the section");
    	Section newSection = new Section(inp.nextLine());
    	this.sections.add(newSection);
    	newSection.editContent();
    }
    
    public void manageSections() {
    	
    }
    
    public void addAuthor(Researcher r) {
    	this.authors.add(r);
    }
    
    public void inviteResearcher() {
    	Vector<Researcher> researchers = Data.INSTANCE.getAllResearchers(); 
    	for(int i=0;  i<researchers.size(); i++) {
    		System.out.println(i+1 + researchers.get(i).getInfo());
    	}
    	Researcher choice = researchers.get(inp.nextInt()-1);
    	
    	System.out.println("Invitation for colaborating in project " + this.name + "has been sent to " + choice.getName() + " " + choice.getSurname());
    }
    
    public String getFullProject() {
    	return "In process...";
    }
    
    public String projectDemo() {
    	return this.startDate + "\n" + this.name + "\n" + this.projectAbstract + "\n\n\n" + this.discription;
    }
    
    public void projectSettings() {
    	
    }
    
    public void 
    
    public void manageProject() {
    	Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		int startIndex = 0;
		functions.put(startIndex++, new NamedRunnable(this:getFullProject, "View Project"));
		functions.put(startIndex++, new NamedRunnable(this::updateUser, "Update User"));
		functions.put(startIndex++, new NamedRunnable(this::deleteUser, "Delete User"));
    }
    
    public String toString() {
    	return "Project " + this.name + ", Collaborators " + this.authors.size();
    }	
}
