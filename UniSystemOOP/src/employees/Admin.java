package employees;

import user.User;
import user.UserFactory;
import utils.InputPrompt;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import Interfaces.CreatingUsers;
import database.Data;
import oop.Main;

public class Admin extends User implements CreatingUsers, Serializable {

    private transient Scanner n = new Scanner(System.in);
    private static final long serialVersionUID = 1067496602760879814L;


    public Admin(String login, String password) {
        super(login, password);
    }

    
    /**
     * Sets new university name 
     * @param new name of the university
     */
    public void setUniName(String name) {
    	Data.INSTANCE.setUniName(name);
    }
    
	/**
	 * Sets a new name for the university.
	 * 
	 * <p>This method allows the user to set a new name for the university.</p>
	 * 
	 * <b>Example Usage:</b>
	 * <pre>
	 * setUniName();  // Sets the new university name.
	 * </pre>
	 */
	public void setUniName() {
		System.out.println("New University Name: ");
	    String newUniName = n.nextLine();  // Get the new university name from input
	    Data.INSTANCE.setUniName(newUniName);			
		
	    //Log
		String userName = this.getName();  // Assuming `this.getName()` returns the name of the user making the change
	    String logMessage = "University name changed to: " + newUniName + " by: " + userName;
	    Data.INSTANCE.addLog(logMessage);
	}
    
	
	
    /**
     * Creates a new user based on the provided user type and login details.
     * 
     * <p>This method prompts the user to enter a user type and a login. It uses the UserFactory 
     * to create an appropriate user object. The user is then assigned 
     * a login, and a default password is generated.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * createUser();  // Creates a new user after inputting the user type and login.
     * </pre>
     */
    public void createUser() {
        System.out.println("Type 'quit' at any time to exit");
        
        System.out.println("Enter User Type: ");
        String userType = null;
        while (userType == null) {
            userType = n.nextLine().toUpperCase();
            if (userType.equals("QUIT")) {
                System.out.println("Operation cancelled.");
                return; // Exit the method
            }

            if (userType.isEmpty()) {
                System.out.println("User type cannot be empty. Please enter a valid user type.");
                userType = null; 
            }
        }
        
        User current = UserFactory.getUser(userType, this);
        System.out.println("Enter Login: ");
        String login = n.nextLine();
        current.setLogin(login);

        System.out.println(current.getClass().getSimpleName() + " has been created\nlogin: " + current.getLogin() + "\npassword: " + current.getPassword());
        	
        	//Log
        String logMessage = current.getClass().getSimpleName() + " created. Login: " + current.getLogin() + ", Password: " + current.getPassword() 
        + " by " + this.getName() + " " + this.getSurname() + ".";
        Data.INSTANCE.addLog(logMessage);
    }

    /**
     * Updates an existing user's data based on their ID.
     * 
     * <p>This method prompts the user to enter the ID of the user to be updated. Once the user is found 
     * in the system, it allows for modifications of the user's details.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * updateUser();  // Updates an existing user after inputting their ID.
     * </pre>
     */
    public void updateUser() {
        System.out.println("Type 'quit' at any time to exit");
        
        String id = null;
        while (id == null) {
            System.out.println("Enter User id: ");
            id = n.nextLine();
            if (id.equals("quit")) {
                System.out.println("Operation cancelled.");
                return; // Exit the method
            }
            if (id.isEmpty()) {
                System.out.println("User ID cannot be empty. Please enter a valid User ID.");
                id = null; // Reset to prompt again
            }
        }
        

        User current = Data.INSTANCE.findUserById(id);
        if (current == null) {
            System.out.println("User not found with the ID: " + id);
            return; // Exit if user not found
        }

        current.changeData();
        System.out.println("User " + current.getId() + " has been updated!");
        
        	//Log
        String logMessage = "User with ID: " + current.getId() + " has been updated by: " + this.getName() + " " + this.getSurname();
        Data.INSTANCE.addLog(logMessage);
    }

    /**
     * Deletes an existing user based on their ID.
     * 
     * <p>This method prompts the user to enter the ID of the user to be deleted.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * deleteUser();  // Deletes a user after inputting their ID.
     * </pre>
     */
    public void deleteUser() {
        System.out.println("Type 'quit' at any time to exit");
        
        String id = null;
        while (id == null) {
            System.out.println("Enter User id: ");
            id = n.nextLine();
            if (id.equals("quit")) {
                System.out.println("Operation cancelled.");
                return; // Exit the method
            }
        }

        User current = Data.INSTANCE.findUserById(id);
        if (current == null) {
            System.out.println("User not found with the ID: " + id);
            return; // Exit if user not found
        }

        Data.INSTANCE.deleteUser(current);
        System.out.println("User " + current.getId() + " has been deleted!");
        
        	//Log
        String logMessage = "User " + current.getId() + " has been deleted by " + this.getName() + " " + this.getSurname();
        Data.INSTANCE.addLog(logMessage);
    }
    
    /**
     * Provides a menu for managing user-related settings.
     * 
     * <p>This method presents a list of options for creating, updating, or deleting users.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * usersSettings();  // Opens the user settings menu.
     * </pre>
     */
	public void usersSettings() {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		int startIndex = 0;
		functions.put(startIndex++, new NamedRunnable(this::createUser, "Create User"));
		functions.put(startIndex++, new NamedRunnable(this::updateUser, "Update User"));
		functions.put(startIndex++, new NamedRunnable(this::deleteUser, "Delete User"));
		tabs(functions);
	}

	/**
	 * Provides a menu for university-related settings.
	 * 
	 * <p>This method shows the current university name and allows the user to create new courses, faculties, 
	 * and specialties.</p>
	 * 
	 * <b>Example Usage:</b>
	 * <pre>
	 * uniSettings();  // Opens the university settings menu.
	 * </pre>
	 */
	public void uniSettings() {
		System.out.println(Data.INSTANCE.getUniName());
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		int startIndex=0;
		functions.put(startIndex++, new NamedRunnable(this::setUniName, "Set New University Name"));
		functions.put(startIndex++, new NamedRunnable(this::setUniName, "Create New Course"));
		functions.put(startIndex++, new NamedRunnable(this::setUniName, "Create New Faculty"));
		functions.put(startIndex++, new NamedRunnable(this::setUniName, "Create New Speciality"));
		tabs(functions);
	}

	/**
	 * DOCUMENTATION
	 */
	public void createCourse() {
		System.out.println("In process...");
		
	    //Log
		String logMessage = "";
		Data.INSTANCE.addLog(logMessage);
	}
	
	/**
	 * DOCUMENTATION
	 */
	public void createFaculty() {
		System.out.println("In process...");
		
	    //Log
		String logMessage = "";
		Data.INSTANCE.addLog(logMessage);
		
	}
	
	/**
	 * DOCUMENTATION
	 */
	public void createSpeciality() {
		System.out.println("In process...");
		
	    //Log
		String logMessage = "";
		Data.INSTANCE.addLog(logMessage);
	}
	
	/**
	 * Displays logs in a paginated format based on user input for page number and page size.
	 * 
	 * <p>This method prompts the user to enter a page number and the number of logs to display per page. 
	 * It retrieves the logs from the data source and displays the logs for the specified page. 
	 * 
	 * <b>Example Usage:</b>
	 * <pre>
	 * Enter the page number to view logs (or 0 to quit): 1
	 * Enter the number of logs per page: 10
	 * Displaying logs (page 1):
	 * - Log 1
	 * - Log 2
	 * - Log 3
	 * </pre>
	 */
	public void viewLogs() {
	    
	    int pageNumber = InputPrompt.promptIntInput("Enter the page number to view logs (or 0 to quit): ");
	    if (pageNumber == -1) {
	        return; 
	    }

	    
	    int pageSize = InputPrompt.promptIntInput("Enter the number of logs per page: ");
	    if (pageSize == -1) {
	        return; 
	    }

	    // Retrieve logs and display them in pages
	    List<String> logs = Data.INSTANCE.getLogs();
	    int totalLogs = logs.size();
	    int start = Math.max(0, (pageNumber - 1) * pageSize);
	    int end = Math.min(start + pageSize, totalLogs);

	    if (start >= totalLogs) {
	        System.out.println("No more logs to display.");
	        return;
	    }

	    System.out.println("Displaying logs (page " + pageNumber + "):");
	    for (int i = start; i < end; i++) {
	        System.out.println(logs.get(i));
	    }
	}
	
	 /**
     * The method for registering available actions in the map
     */
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		functions.put(startIndex++, new NamedRunnable(this::usersSettings, "Users"));
		functions.put(startIndex++, new NamedRunnable(this::uniSettings, "University"));
		functions.put(startIndex++, new NamedRunnable(this::viewLogs, "View Logs"));
		for(Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}
}

