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
	
	
	public void checkNews() {
		System.out.println("All News:");

        List<News> newsList = Data.getAllNews();

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
	
	
	
	
	public void exit() {
		System.exit(0);
	}
	
	public void logout() {
		System.out.println("Logging out...");
	}
	
	public void settings() {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		int startIndex = 0;
		functions.put(startIndex++, new NamedRunnable(this::changePassword, "Change Password"));
        functions.put(startIndex++, new NamedRunnable(this::changeLanguage, "Change Language"));
        
        tabs(functions);
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
