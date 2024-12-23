package user;

import employees.*;
import research.Researcher;
import students.*;

public class UserFactory {
	public static User getUser(String type, User caller) {
		switch(type) {
		case "BACHELOR":
			return new Bachelor();
		case "MASTER":
			return new Master();
		case "PHD":
			return new PhD();
		case "MANAGER":
//			if(caller instanceof Admin || (caller instanceof Manager && ((Manager) caller).getType() == ManagerType.OR);
			return new Manager();
		case "TEACHER":
			return new Teacher();
		case "RESEARCHER":
			return new Researcher();
		default:
			System.out.println("Invalid User Type: " + type);
		}
		return null;
	}
}