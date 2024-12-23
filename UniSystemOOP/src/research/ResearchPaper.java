package research;

import java.io.Serializable;
import java.util.*;
import user.User;
import utils.InputPrompt;

public class ResearchPaper implements Serializable, Comparable<ResearchPaper>{
	private String name;
	private Date startDate;
    private ArrayList<String> pages = new ArrayList<>();
    private ResearchProject project;
	public ResearchPaper(String name, ResearchProject pr) {
    	this.name = name;
    	this.project = pr;
    	for(int i=0; i<10; i++) {
    		this.pages.add("");
    	}
    	this.startDate = new Date();
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResearchProject getProject() {
		return project;
	}

	public void setProject(ResearchProject project) {
		this.project = project;
	}

	public void paperManager() {
		int page = 0;
		while(true) {
			System.out.println(this.name + " Page " + page + " - " + (this.pages.size()-1) +"\n\n");
			System.out.println(pages.get(page));
			int input = InputPrompt.promptIntInput("\n0 - Leave\n1 - Previous\n2 - Next\n3 - Find Page\n"
					+ "4 - Insert Page After That\n5 - Insert Page Before That\n6 - Start Editing\n");
			switch(input) {
			case 0:
				return;
			case 1:
				page--;
				if(page < 0) page = pages.size()-1;
				continue;
			case 2:
				page++;
				if(page > pages.size()-1) page=0;
				continue;
			case 3:
				page = InputPrompt.promptIntInput("Enter Page Number");
				continue;
			case 4:
				this.pages.add(page+1, "");
				page++;
				continue;
			case 5:
				this.pages.add(page-1, "");
				page--;
				continue;
			case 6:
				editPage(page);
			default:
				System.out.println("Invalid Input try Again");
			}
		}
		
	}
	
	private void editPage(int page) {
		System.out.println(this.name + "Page" + page+"\n\n");
		System.out.println(pages.get(page));
		System.out.println("Please copy-past Page and continue editing(0 - to leave)");
		
		String resText = "";
		while(true) {
			String text = InputPrompt.promptInput("");
			if(text.equals("0")) break;
			resText+=text+"\n";
		}
		System.out.println("1 - Save Changes\n2 - Discard Changes");
		int choice = Integer.valueOf(InputPrompt.promptInput(""));
		while(true) { 
			if(choice == 1) {
				pages.set(page, resText);
				return;
			}
			else if(choice == 2) return;
			else System.out.println("Invalid Input");
		}
	}

	public void view() {
		int page = 0;
		while(true) {
			System.out.println(this.name + " Page " + page + " - " + (this.pages.size()-1) +"\n\n");
			System.out.println(pages.get(page));
			int input = InputPrompt.promptIntInput("\n0 - Leave\n1 - Previous\n2 - Next\n3 - Find Page\n");
			switch(input) {
			case 0:
				return;
			case 1:
				page--;
				if(page < 0) page = pages.size()-1;
				continue;
			case 2:
				page++;
				if(page > pages.size()-1) page=0;
				continue;
			case 3:
				page = InputPrompt.promptIntInput("Enter Page Number");
				continue;
			default:
				System.out.println("Invalid Input try Again");
			}
		}
	}
	
	public void publish() {
		System.out.println("Are you sure you want to publish that paper?");
		if(InputPrompt.promptInput("").toLowerCase().equals("yes")) {
			this.project.addPublishedPaper(this);
		}
	}
	
	@Override
	public int compareTo(ResearchPaper o) {
		if(this.pages.size() > o.pages.size()) return 1;
		else if(this.pages.size() < o.pages.size()) return -1;
		return 0;
	}
}
