	package oop;

import Consts.*;
import java.util.Date;
import java.util.Random;

public class User {
	
	private String login;
	private String password;	
    private String id;
    private String name;
    private String surname;

    private String email;


    private Language language;
    private Date birthdate;
    private Sex sex;
    private String phone;
    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return name;
    }
    
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    public String getSurname() {
    	return surname;
    }
    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
    
    
    public User(String login, String password) {
    	this.login = login;
    	this.password = password;
    	this.id = generateId();
    }
    
    public User(String login, String password, String code) {
    	this.login = login;
    	this.password = password;
    	if(code == "001") this.id = "00000";
    	else this.id = generateId();
    }
    
    private String generateId() {
    	Date d = new Date();
    	Random r = new Random();
    	return String.valueOf(d.getYear()).substring(1)+"B"+String.valueOf(10000 + r.nextInt(90000));
    }
    
    public void setAllData() {
    	System.out.println("Filling name, email, sex, phone and etc.");
    }
    
    public String getId() {
    	return this.id;
    }
    
}
