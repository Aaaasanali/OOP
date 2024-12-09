package oop;

import Consts.*;
import java.util.*;

public abstract class User {
	
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
    
    Vector<Integer> v = new Vector<>(3, 2);
    private final Vector<String> functions = new Vector<>(Arrays.asList("Settings", "Change Login", "Change Password", "Check Info"));
    
    public User(String login, String password) {
    	this.login = login;
    	this.password = password;
    	this.hashPassword = password.hashCode();
    	this.id = generateId();
    }
    
    private String generateId() {
    	Date d = new Date();
    	Random r = new Random();
    	return String.valueOf(d.getYear()).substring(1)+"B"+String.valueOf(10000 + r.nextInt(90000));
    }
    
    public void setAllData() {
    	System.out.println("Filling name, email, sex, phone and etc.");
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
    	return this.id;
    }
    
}
