package user;

import employees.*;
import students.*;

public class UserFactory {
	public static User getUser(String type, User caller) {
		switch(type) {
		case "Bachelor":
			return new Bachelor();
		case "Master":
			return new Master();
		case "PhD":
			return new PhD();
		case "Manager":
			if(caller instanceof Admin || (caller instanceof Manager && ((Manager) caller).getType() == ManagerType.OR);
			return new Manager();
		case "Teacher":
			return new Teacher();
		default:
			System.out.println("Invalid User Type: " + type);
		}
	}
}
