package research;

import java.util.*;
import user.User;
import Factories.NamedRunnable;

public class researchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Researcher r = new Researcher();
		User current = r;
		Scanner inp = new Scanner(System.in);
		while (true) {
			System.out.println("");

			Map<Integer, NamedRunnable> functionsMap = current.getFunctionsMap(0);
			int i = 0;

			for (Map.Entry<Integer, NamedRunnable> entry : functionsMap.entrySet()) {
				System.out.println((++i) + " - " + entry.getValue().getName());
			}

			System.out.println((i + 1) + " - Logout"); 										//Logout for every type of user

			int choice = inp.nextInt() - 1;

			if (choice == i) {
				current.logout();
				current = null; 
				break;
			}

			Runnable function = functionsMap.get(choice);
			if (function != null) {
				function.run();
			} else {
				System.out.println("Invalid input. This function does not exist.");
			}
		}
	}

}
