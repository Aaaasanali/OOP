package research;

import java.io.Serializable;
import java.util.Scanner;

import utils.InputPrompt;

public class Section implements Serializable{
	private String name;
	private String content = "";
	private int number;
	private ResearchProject project;
	public Section(String name, ResearchProject project) {
		this.name = name;
		this.project = project;
		this.number = this.project.getSections().size()+1;
	}
	public void editContent() {
		System.out.println(number + ". " + this.name);
		System.out.println(this.content + "\nPlease copy your saved content and continue working on");
		System.out.println("Enter 0 to leave");
		String resText = "";
		while(true) {
			String text = InputPrompt.promptInput("");
			resText+=text+"\n";
			if(text.equals("0")) break;
		}
		System.out.println("1 - Save Changes\n2 - Discard Changes");
		int choice = Integer.valueOf(InputPrompt.promptInput(""));
		while(true) { 
			if(choice == 1) {
				this.content = resText;
				return;
			}
			else if(choice == 2) return;
			else System.out.println("Invalid Input");
		}
	}
	
	public void view() {
		System.out.println(this.number + ". " + this.name + "Any Key to Go Back\n");
		System.out.println(this.content);
		InputPrompt.promptInput("");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
