package research;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import database.Data;
import oop.Main;
import students.GraduateStudent;
import utils.InputPrompt;

public class ResearchProject implements Serializable{
	
    private String name;
    private String discription;
    private Date startDate;
    private ResearchStatus status;
    private final ArrayList<ResearchPaper> papers = new ArrayList<>();
    private final ArrayList<ResearchPaper> publishedPapers = new ArrayList<>();
    private final ArrayList<String> keywords = new ArrayList<>();
    private String projectAbstract;
    private Date publicationDate;
    private final ArrayList<Section> sections = new ArrayList<>();
    private final ArrayList<Researcher> authors = new ArrayList<>();
    private final ArrayList<ResearchProject> citations = new ArrayList<>();
    private final ArrayList<ResearchProject> references = new ArrayList<>();
    private Researcher lead;
    
    public ResearchProject(){}
    
    public ResearchProject(String name, String discription, Researcher r) {
    	this.name = name;
    	this.discription = discription;
    	this.startDate = new Date();
    	this.status = ResearchStatus.IN_PROGRESS;
    	this.lead = r;
    }
    
    public void startResearchPaper() {}
    
    public void createSection() {
    	String name = InputPrompt.promptInput("Enter name of the section");
    	if(name.equals("0")) return;
    	Section newSection = new Section(name, this);
    	this.sections.add(newSection);
    	newSection.editContent();
    }
    
    public void manageSections() {
    	Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		int startIndex = 0;
		functions.put(startIndex++, new NamedRunnable(this::createSection, "Create New Section"));
		functions.put(startIndex++, new NamedRunnable(this::editSection, "Edit Section"));
		functions.put(startIndex++, new NamedRunnable(this::manageSections, "Sections"));
		
		Runnable func = Main.pickFunc(functions);
		func.run();
    }
    
    public void deleteSection() {
    	int i=1;
    	for(Section s : this.sections) {
    		System.out.println(i++ + " - " + s.getName());
    	}
    	int pick = InputPrompt.promptIntInput("");
    	if(pick == 0) return;
    	Section choice = this.sections.get(pick-1);
    	System.out.println("Are you sure to delete section " + choice.getName() + "? (Yes/No)");
    	String s = InputPrompt.promptInput("").toLowerCase();
    	if(s.equals("yes")) this.sections.remove(choice);
    }
    
    public void editSection() {
    	int i=1;
    	for(Section s : this.sections) {
    		System.out.println(i++ + " - " + s.getName());
    	}
    	int pick = InputPrompt.promptIntInput("");
    	if(pick == 0) return;
    	Section choice = this.sections.get(pick-1);
    	choice.editContent();
    }
    
    public void addAuthor(Researcher r) {
    	this.authors.add(r);
    }
    
    public void inviteResearcher() {
    	
    	Vector<Researcher> researchers = Data.INSTANCE.getAllResearchers(); 
    	for(int i=0;  i<researchers.size(); i++) {
    		System.out.println(i+1 + researchers.get(i).getInfo());
    	}
    	int pick = InputPrompt.promptIntInput("");
    	if(pick == 0) return;
    	Researcher choice = researchers.get(pick-1);
    	choice.addInvitation(this);
    	System.out.println("Invitation for colaborating in project " + this.name + "has been sent to " + choice.getName() + " " + choice.getSurname());
    }
    
    public void getFullProject() {
    	String authors = "";
    	for(Researcher a : this.authors) authors += a.getFullName() +", "; 
    	if(this.publicationDate == null) this.publicationDate = new Date();
    	while(true) {
    	System.out.println(this.name + "\n\n" + this.discription + "\n\n" + "Abstract: \n" 
    + this.projectAbstract + "\n\nPublished in" + this.publicationDate.getYear() 
    + this.publicationDate.getMonth() + this.publicationDate.getDay() + "\n\n" 
    + "Authors: " + authors);
    	System.out.println("\n\n0 - Back\n1 - Sections\n2 - Papers");
    	int pick = InputPrompt.promptIntInput("");
    	if(pick == 0) break;
    	else if(pick == 1) this.sectionNavigation();
    	else if(pick == 2) this.papersNavigation();
    	else System.out.println("Invalid Input Try again");
    	}
    	this.publicationDate = null;
    }
    
    private void papersNavigation() {
    	int i=1;
    	for(ResearchPaper s : this.publishedPapers) {
    		System.out.println(i++ + " - " + s.getName());
    	}
    	int pick = InputPrompt.promptIntInput("");
    	if(pick == 0) return;
    	ResearchPaper choice = this.publishedPapers.get(pick-1);
    	choice.view();
    }
    
    private void sectionNavigation() {
    	while(true) {
    		int i=0;
        	for(Section s : this.sections) {
        		System.out.println(i++ + " - " + s.getName());
        	}
        	int pick = InputPrompt.promptIntInput("");
        	if(pick == 0) return;
        	Section choice = this.sections.get(pick-1);
        	choice.view();
    	}
    }
    
    public String projectDemo() {
    	return this.startDate + "\n" + this.name + "\n" + this.projectAbstract + "\n\n\n" + this.discription;
    }
    
    public void rename() {
    	String newName = InputPrompt.promptInput(this.name + "\nNew Name: ");
    	if(newName.equals("0")) return;
    	this.name = newName;
    }
    
    public void editDiscr() {
    	String newDiscr = InputPrompt.promptInput(this.name + "\nNew Discription: ");
    	if(newDiscr.equals("0")) return;
    	this.name = newDiscr;
    }
    
    public void editAbstract() {
    	String newAbstract = InputPrompt.promptInput(this.name + "\nNew Discription: ");
    	if(newAbstract.equals("0")) return;
    	this.name = newAbstract;
    }
    
    public void settings() {
    	Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		int startIndex = 0;
		functions.put(startIndex++, new NamedRunnable(this::rename, "Rename Project"));
		functions.put(startIndex++, new NamedRunnable(this::editDiscr, "Edit Discription"));
		
		Runnable func = Main.pickFunc(functions);
		func.run();
    }
    
    public void managePapers() {
    	Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		int startIndex = 0;
		functions.put(startIndex++, new NamedRunnable(this::startPaper, "Start Paper"));
		functions.put(startIndex++, new NamedRunnable(this::editPapers, "Edit Papers"));
		functions.put(startIndex++, new NamedRunnable(this::editAbstract, "Publish Paper"));
		
		while(true) {
			Runnable func =  Main.pickFunc(functions);
			if(func == null) break;
			func.run();
		}
    }
    
    public void startPaper() {
    	String name = InputPrompt.promptInput("Enter Name of the Paper");
    	if(name.equals("0")) return;
    	this.papers.add(new ResearchPaper(name, this));
    }
    
    public void editPapers() {
    	int i=1;
    	for(ResearchPaper s : this.papers) {
    		System.out.println(i++ + " - " + s.getName());
    	}
    	int pick = InputPrompt.promptIntInput("");
    	if(pick == 0) return;
    	ResearchPaper choice = this.papers.get(pick-1);
    	choice.paperManager();
    }
    
    public void publishPaper() {
    	int i=1;
    	for(ResearchPaper s : this.papers) {
    		System.out.println(i++ + " - " + s.getName());
    	}
    	int pick = InputPrompt.promptIntInput("");
    	if(pick == 0) return;
    	ResearchPaper choice = this.papers.get(pick-1);
    	choice.publish();
    }
    
    public void addPublishedPaper(ResearchPaper p) {
    	this.publishedPapers.add(p);
    }
    
    public void manageProject() {
    	Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		int startIndex = 0;
		functions.put(startIndex++, new NamedRunnable(this::getFullProject, "View Project"));
		functions.put(startIndex++, new NamedRunnable(this::inviteResearcher, "Invite Research Colaborator\n"));
		functions.put(startIndex++, new NamedRunnable(this::editAbstract, "Abstract"));
		functions.put(startIndex++, new NamedRunnable(this::manageSections, "Sections"));
		functions.put(startIndex++, new NamedRunnable(this::managePapers, "Papers"));
		functions.put(startIndex++, new NamedRunnable(this::manageSections, "Settings"));
		while(true) {
			Runnable func =  Main.pickFunc(functions);
			if(func == null) break;
			func.run();
		}
    }
    
    public ArrayList<Section> getSections(){
    	return this.sections;
    }
    
    public String toString() {
    	return "Project " + this.name + ", Collaborators " + this.authors.size();
    }
    
    public void addReference() {
    	int i=0;
    	for(ResearchProject p : Data.INSTANCE.getPublishedResearches()) {
    		System.out.println(++i + " - " + p.toString());
    	}
    	int pick = InputPrompt.promptIntInput("");
    	if(pick == 0) return;
    	ResearchProject choice = Data.INSTANCE.getPublishedResearches().get(pick-1);
    	this.references.add(choice);
		choice.citations.add(this);
    }
    
    public ArrayList<ResearchProject> getCitations() {
    	return this.citations;
    }
    
    public void publishProject() {
    	this.status = ResearchStatus.PUBLISHED;
    	Data.INSTANCE.publishResearch(this);
    	this.publicationDate = new Date();
    	System.out.println("This Project " + this.name + " has been published!!");
    }
}
