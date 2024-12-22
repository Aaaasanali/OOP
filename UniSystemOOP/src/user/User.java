package user;

import communication.*;
import database.*;
import documents.*;
import employees.*;
import Factories.*;
import Factories.NamedRunnable;
import Interfaces.*;
import news.*;
import oop.*;
import research.*;
import students.*;
import user.*;
import utils.InputPrompt;  // Importing the InputPrompt utility class

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public abstract class User implements Serializable {

    private String login;
    private String password;
    private int hashPassword;

    private String id;
    private String name;
    private String surname;
    private String email;
    private Language language;
    private Date birthdate;
    private Sex sex;
    private String phone;
    private Education education;

    public User() {
        this.login = "";           
        this.password = "";        
        this.hashPassword = 0;     
        this.id = "";              
        this.name = "";            
        this.surname = "";         
        this.email = "";           
        this.language = null;      
        this.birthdate = null;     
        this.sex = null;           
        this.phone = "";           
        this.education = null;     
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.hashPassword = password.hashCode();
        this.id = generateId();
    }

    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.hashPassword = password.hashCode();
        this.id = generateId();
        this.name = name;
        this.surname = surname;
    }

    private String generateId() {
        Date d = new Date();
        Random r = new Random();
        return String.valueOf(d.getYear()).substring(1) + "B" + String.valueOf(10000 + r.nextInt(90000));
    }

    public void setAllData() {
        System.out.println("Filling name, email, sex, phone, and other details.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return this.hashPassword;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", language=" + language +
                ", birthdate=" + birthdate +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", education=" + education +
                '}';
    }
    
    
	private void save() throws IOException {
		
		if (InputPrompt.scanner != null) {
			InputPrompt.scanner.close(); // Close the Scanner to avoid resource leakage
	    }
		
		Data.write();
	}
	

    // Method to validate login credentials (check if login exists and password matches)
    public static boolean validateLogin(String login, String password) {
        User user = Data.INSTANCE.findUserByLogin(login);
        if (user == null) {
        	
            System.out.println("User not found with the login: " + login);
            return false;
        }

        if (user.hashPassword == password.hashCode()) {

            System.out.println("Login successful.");
            return true;
        } else {

            System.out.println("Incorrect password.");
            return false;
        }
    }

    // Method to change the user's language
    public void changeLanguage() {
        System.out.println("Type 'quit' at any time to exit");

        String message = "Pick a language to change:\n1 - RU\n2 - EN\n3 - KZ\n";
        int choice = InputPrompt.promptIntInput(message);  

        if (choice == -1) {
            System.out.println("Operation cancelled.");
            return;  
        }

        switch (choice) {
            case 1:
                Data.INSTANCE.setLanguage(Language.RU);
                break;
            case 2:
            	Data.INSTANCE.setLanguage(Language.EN);
                break;
            case 3:
            	Data.INSTANCE.setLanguage(Language.KZ);
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    // Method to change the user's password
    public void changePassword() {
        while (true) {
            System.out.println("Change Password\nType 'quit' to cancel.");

            // Prompt for old password
            String oldPassword = InputPrompt.promptInput("Old Password: ");
            if (oldPassword == null) {
                System.out.println("Password change operation cancelled.");
                return;
            }

            // Check if the old password is correct
            if (this.password.equals(oldPassword)) {
                // Prompt for new password
                String newPassword = InputPrompt.promptInput("New Password: ");
                if (newPassword == null) {
                    System.out.println("Password change operation cancelled.");
                    return;
                }

                // Update the password for the current user
                this.password = newPassword;
                this.hashPassword = newPassword.hashCode();  // Update the hashed password

                System.out.println("Your new password is: " + this.password);

                // Find the user by login in Data.INSTANCE and update the password
                User updatedUser = Data.INSTANCE.findUserByLogin(this.login);
                if (updatedUser != null) {
                    updatedUser.setPassword(newPassword);  // Update the password for the user
                }

                // Now serialize the Data.INSTANCE object to persist the updated state
                try {
                    Data.write();  
                    System.out.println("Password updated successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Failed to save user data.");
                }

                return;  // Exit after updating the password
            } else {
                System.out.println("Incorrect old password. Try again.");
            }
        }
    }

    private void setPassword(String password2) {
        this.password = password2;
        this.hashPassword = password2.hashCode();  // Update the hashed password
    }

    // Method to check news
    public void checkNews() {
        System.out.println("All News:");

        List<News> newsList = Data.INSTANCE.getAllNews();

        if (newsList.isEmpty()) {
            System.out.println("No news available.");
            return;
        }

        // Sort news: pinned first, then by insertion order
        newsList.sort((news1, news2) -> Boolean.compare(news2.isPinned(), news1.isPinned()));
        int i = 1;
        for (News news : newsList) {
            System.out.println(i++ + ". " + news.getTitle() + " - " + news.getContent());
            System.out.println("Comments: " + news.getComments());
            System.out.println("----------------------------------");
        }
    }

    // Exit method to close the application
    public void exit() {
        System.out.println("Exiting the application...");
        
        try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        System.exit(0);
    }

    // Logout method
    public void logout() {
        System.out.println("Logging out...");
    }

    // Mapping of functions to the menu
    public Map<Integer, NamedRunnable> settings() {
    	int startIndex = 0;
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        functions.put(startIndex++, new NamedRunnable(this::changePassword, "Change Password"));
        functions.put(startIndex++, new NamedRunnable(this::changeLanguage, "Change Language"));
        
        tabs(functions);
        return functions;
	}
	
	public void tabs(Map<Integer, NamedRunnable> functions) {
    	while(true) {
        	Runnable pick = Main.pickFunc(functions);
            if(pick == null) return;
            pick.run();
        }
    }
	
	
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex){
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        functions.put(startIndex++, new NamedRunnable(this::settings, "Settings"));
        functions.put(startIndex++, new NamedRunnable(this::checkNews, "Check news"));
//        functions.put(startIndex++, new NamedRunnable(this::logout, "Logout"));
        functions.put(startIndex++, new NamedRunnable(this::exit, "Exit"));
		return functions;
	}
	
	
	
}
