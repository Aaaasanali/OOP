package research;

import java.util.Scanner;

public class Section {
	private Scanner inp = new Scanner(System.in);
	private String name;
	private String content;
	private String number;
	public Section(String name) {
		this.name = name;
		
	}
	public void editContent() {
		System.out.println(number + ". " + this.name);
		System.out.println(this.content + "\nPlease copy that and continue working on content");
		System.out.println("Enter 0 to leave");
		String resText = "";
		while(true) {
			String text = inp.nextLine();
			resText+=text+"\n";
			if(text.equals("0")) break;
		}
		System.out.println("1 - Save Changes\n2 - Discard Changes");
		int choice = inp.nextInt();
		while(true) { 
			if(choice == 1) {
				this.content = resText;
				return;
			}
			else if(choice == 2) return;
			else System.out.println("Invalid Input");
		}
	}
}
