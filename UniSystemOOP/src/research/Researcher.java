package research;

import employees.Employee;
import utils.InputPrompt;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;

public class Researcher extends Employee implements Serializable{
	
	private final ArrayList<ResearchProject> projects = new ArrayList<>();
	private final ArrayList<ResearchProject> invitations = new ArrayList<>();
	
	public Researcher(String login, String password, String name, String surname) {
		super(login, password, name, surname);
	}
	
	public Researcher() {
	}
	
	public void startNewResearchProject() {
		String name = InputPrompt.promptInput("Project Name: ");
		System.out.println("Project discription: ");
		this.projects.add(new ResearchProject(name, InputPrompt.promptInput(""), this));
		System.out.println("Project " + name + " has been created");
	}
	
	public void manageProjects() {
		if(this.projects.isEmpty()) {
			System.out.println("You don't have any projects yet");
			return;
		}
		
		int i=1;
		for(ResearchProject rp : this.projects) {
			System.out.println(i++ + " - " + rp.toString());
		}
		int pick = Integer.valueOf(InputPrompt.promptInput(""));
		if(pick == 0) return;
		ResearchProject choice = this.projects.get(pick-1);
		choice.manageProject();
	}
	
	public String getInfo() {
		return "[RESEARCHER] " + super.getName() + " " + super.getSurname() + ", h-index " + this.getHindex();
	}
	
	public void addInvitation(ResearchProject pr) {
		this.invitations.add(pr);
	}
	
	public void checkInvitations() {
		int i=1;
		for(ResearchProject rp : this.invitations) {
			System.out.println(i++ + " - " + rp.toString());
		}
		ResearchProject choice = this.invitations.get(InputPrompt.promptIntInput("")-1);
		
		System.out.println(choice.projectDemo());
		
		System.out.println("\n1 - accept invitation\n2 - decline invitation\n\n0 - leave");
		while(true) {
			switch(InputPrompt.promptIntInput("")) {
			case 1:
				choice.addAuthor(this);
				this.invitations.remove(choice);
				this.projects.add(choice);
				return;
			case 2:
				System.out.println("Declined");
				this.invitations.remove(choice);
				return;
			case 0:
				return;
			default:
				System.out.println("Invalid Input");
			}
		}
	}
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		functions.put(startIndex++, new NamedRunnable(this::startNewResearchProject, "Start New Project"));
		functions.put(startIndex++, new NamedRunnable(this::manageProjects, "My Projects"));
		functions.put(startIndex++, new NamedRunnable(this::checkInvitations, "Invitations\n"));
		for(Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}
	public int getHindex() {
		int hIndex=0;
		for(ResearchProject p : this.projects) {
			hIndex += p.getCitations().size();
		}
		return hIndex;
	}
}
