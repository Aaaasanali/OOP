package oop;

import java.util.HashMap;
import java.util.Map;

import oop.Employees.Admin;

/**
* @generated
*/
public class Data {
	private String UniversityName;
	private Admin admin;
	
	private final Map<String, User> users = new HashMap<>();

    public Data(String uniName, Admin admin) {
    	this.UniversityName = uniName;
    	this.admin = admin;
    }
    
}
