package user;


import database.Data;
import students.*;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;

public abstract class User implements Serializable{
	
	Scanner inp = new Scanner(System.in);

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
    
    
    public User() {};
    
    public User(String login, String password) {
    	this.login = login;
    	this.password = password;
    	this.hashPassword = password.hashCode();
    	this.id = generateId();
    	//Data.addUser(this);
    }
    
    public User(String login, String password, String name, String surname, String id) {
    	this.login = login;
    	this.password = password;
    	this.hashPassword = password.hashCode();
    	this.id = generateId();
    	//Data.addUser(this);
    	
    	this.name = name;
    	this.surname = surname;
    }
    
    private String generateId() {
    	Date d = new Date();
    	Random r = new Random();
    	return String.valueOf(d.getYear()).substring(1)+"B"+String.valueOf(10000 + r.nextInt(90000));
    }
    
    public void setAllData() {
    	System.out.println("Filling name, email, sex, phone and etc.");
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
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
	
	
	
	
    
	public void changeLanguage() {
		// выберите язык - Data.changeLanguage(Choice);
		System.out.println("Pick Language to Change\n1 - RU\n2 - EN\n3 - KZ");
		switch(inp.nextInt()) {
		case 0:
			Data.setLanguage(Language.RU);
		case 1:
			Data.setLanguage(Language.EN);
		case 2:
			Data.setLanguage(Language.KZ);
		}
	}
	
	public void changePassword() {
		while(true) {
			System.out.println("Change Password\n0 - Back");
			
			System.out.println("Old Password: ");
			String oldPassword = inp.next();
			
			if(oldPassword.equals(String.valueOf(0))) return;
			
			if(this.password.equals(oldPassword)) {
				System.out.println("New Password: ");
				this.password = inp.next();
				System.out.println("Your New Password is: " + this.password);
				return;
			}
			System.out.println("Incorrect Old Password");
		}
	}
	
	public void logOut() {
		System.exit(0);
	}
	
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex){
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		functions.put(startIndex++, new NamedRunnable(this::changePassword, "Change Password"));
        functions.put(startIndex++, new NamedRunnable(this::changeLanguage, "Change Language"));
        functions.put(startIndex++, new NamedRunnable(this::logOut, "Logout"));
		return functions;
	}
	
}
