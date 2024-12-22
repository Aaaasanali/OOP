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
import utils.InputPrompt; // Importing the InputPrompt utility class

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * The User class is main for this system and it represents a user in the
 * system. It allows for managing user details like login, changing password,
 * language preferences, and viewing news.
 * 
 * <p>
 * The class also allows interacting with user data by checking news, updating
 * password, and exiting the application.
 * </p>
 */
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
	private boolean isResearcher;
	private Researcher researcherAcc = null;

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

	/**
	 * Generates a unique user ID based on the current year and a random number.
	 * 
	 * @return The generated unique user ID.
	 */
	private String generateId() {
		Date d = new Date();
		Random r = new Random();
		return String.valueOf(d.getYear()).substring(1) + "B" + String.valueOf(10000 + r.nextInt(90000));
	}

	public void setAllData() {
		System.out.println("Filling name, email, sex, phone, and other details.");
	}

	/**
	 * Sets the user's first name.
	 * 
	 * @param name The first name to set for the user.
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setName(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	/**
	 * Gets the user's first name.
	 * 
	 * @return The first name of the user, or "Unknown" if not set.
	 */
	public String getName() {
		return this.name != null ? this.name : "Unknown";
	}

	/**
	 * Sets the user's surname.
	 * 
	 * @param surname The surname to set for the user.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the user's surname.
	 * 
	 * @return The surname of the user.
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Gets the user's login name.
	 * 
	 * @return The login name of the user.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the user's login name.
	 * 
	 * @param login The login name to set for the user.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Sets the user's email address.
	 * 
	 * @param email The email address to set for the user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the user's phone number.
	 * 
	 * @param phone The phone number to set for the user.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the hashed version of the user's password.
	 * 
	 * @return The hashed password of the user.
	 */
	public int getPassword() {
		return this.hashPassword;
	}

	/**
	 * Gets the user's unique ID.
	 * 
	 * @return The unique ID of the user.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Saves the current user data to the database
	 */
	private void save() throws IOException {

		if (InputPrompt.scanner != null) {
			InputPrompt.scanner.close(); // close the scanner
		}

		Data.write();
	}

	/**
	 * Validates the user's login credentials by checking if the login exists and
	 * the password matches.
	 * 
	 * @param login    The login name to validate.
	 * @param password The password to validate.
	 * @return True if the login is valid and the password matches, false otherwise.
	 */
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

	/**
	 * Changes the user's system language by prompting the user to select a
	 * language.
	 * <p>
	 * The available languages are: Russian, English, and Kazakh
	 * </p>
	 */
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

	/**
	 * function replaces old password with new entered one
	 * 
	 * @param password2 new password
	 */
	private void setPassword(String password2) {
		this.password = password2;
		this.hashPassword = password2.hashCode(); // Update the hashed password
	}

	/**
	 * Changes the user's password by prompting the user to input the old password
	 * and then setting a new password
	 */
	public void changePassword() {
	    while (true) {
	        System.out.println("Change Password\nType 'quit' to cancel.");
	        
	        // Prompt 1
	        String oldPassword = InputPrompt.promptInput("Old Password: ");
	        if (oldPassword == null) {
	            System.out.println("Password change operation cancelled.");
	            return;
	        }

	        // Check old password
	        if (this.password.equals(oldPassword)) {

	            // Prompt 2
	            String newPassword = InputPrompt.promptInput("New Password: ");
	            if (newPassword == null) {
	                System.out.println("Password change operation cancelled.");
	                return;
	            }

	            // Update password
	            this.password = newPassword;
	            this.hashPassword = newPassword.hashCode(); // Update hashed password

	            // Log password change to Data
	            String logMessage = "User " + this.getName() + " " + this.getSurname() + " changed their password.";
	            Data.INSTANCE.addLog(logMessage);
	            System.out.println("Log: Password change logged successfully.");

	            // Save updated user data
	            User updatedUser = Data.INSTANCE.findUserByLogin(this.login);
	            if (updatedUser != null) {
	                updatedUser.setPassword(newPassword); // Update password
	            }

	            // Try to save data to persistent storage
	            try {
	                Data.write();
	                System.out.println("Password updated successfully.");
	            } catch (IOException e) {
	                e.printStackTrace();
	                System.out.println("Failed to save user data.");
	            }

	            return;
	        } else {
	            System.out.println("Incorrect old password. Try again.");
	        }
	    }
	}

	/**
	 * Updates a specific field for the user.
	 * 
	 * @param fieldName The name of the field to update
	 * @param newValue  The new value to set for the field
	 */
	public void updateField(String fieldName, String newValue) {
		switch (fieldName) {
		case "name":
			this.setName(newValue);
			break;
		case "surname":
			this.setSurname(newValue);
			break;
		case "email":
			this.setEmail(newValue);
			break;
		case "phone":
			this.setPhone(newValue);
			break;
		default:
			System.out.println("Unknown field: " + fieldName);
		}
	}

	/**
	 * Checks and displays the latest news.
	 * <p>
	 * This method sorts the news by pinned status and then by the order of
	 * insertion. It displays news details like title, content, and comments.
	 * </p>
	 */
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

	/**
	 * Exits the application by saving user data and closing the program.
	 */
	public void exit() {
		System.out.println("Exiting the application...");

		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.exit(0);
	}

	/**
	 * Method to log out from current users account
	 */
	public void logout() {
		System.out.println("Logging out...");
	}

	/**
	 * Sets up user settings options like changing password and language.
	 * 
	 * @return A map of user settings options.
	 */
	public Map<Integer, NamedRunnable> settings() {
		int startIndex = 0;
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		functions.put(startIndex++, new NamedRunnable(this::changePassword, "Change Password"));
		functions.put(startIndex++, new NamedRunnable(this::changeLanguage, "Change Language"));

		tabs(functions);
		return functions;
	}

	/**
	 * Displays the options and runs the selected action.
	 * 
	 * @param functions A map of available user actions.
	 */
	public void tabs(Map<Integer, NamedRunnable> functions) {
		while (true) {
			Runnable pick = Main.pickFunc(functions);
			if (pick == null)
				return;
			pick.run();
		}
	}

	/**
	 * Creates and returns the main menu options for the user.
	 * 
	 * @param startIndex The starting index for the map.
	 * @return A map of main menu actions.
	 */
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		functions.put(startIndex++, new NamedRunnable(this::settings, "Settings"));
		functions.put(startIndex++, new NamedRunnable(this::checkNews, "Check news"));
//        functions.put(startIndex++, new NamedRunnable(this::logout, "Logout"));
		functions.put(startIndex++, new NamedRunnable(this::exit, "Exit"));
		return functions;
	}

	public String toString() {
		return "User{" + "login='" + login + '\'' + ", id='" + id + '\'' + ", name='" + name + '\'' + ", surname='"
				+ surname + '\'' + ", email='" + email + '\'' + ", language=" + language + ", birthdate=" + birthdate
				+ ", sex=" + sex + ", phone='" + phone + '\'' + ", education=" + education + '}';
	}

	
	public void researcherStatus(boolean b) {
		this.isResearcher = b;
	}

	public boolean getResearcherStatus() {
		return this.isResearcher;
	}

	public void setResearcherAccount(Researcher r) {
		this.researcherAcc = r;
	}
	public Researcher getResearcherAccount() {
		return this.researcherAcc;
	}
	public void researcherCheck() {
		if(this.isResearcher) {
			this.researcherAcc = new Researcher(this.login, this.password, this.name, this.surname);
		}
	}
}
