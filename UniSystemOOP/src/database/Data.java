package database;

import java.util.*;

import employees.Admin;
import user.User;


public final class Data {
	
	private static String UniversityName;
	private static final Vector<Admin> admins = new Vector<>();
	
	private static final Map<String, User> users = new HashMap<>();
	
	public static void addAdmin(Admin a) {
		admins.add(a);
		users.put(a.getLogin(), a);
	}
	
	public static void addUser(User a) {
		users.put(a.getLogin(), a);
	}
	
	public static void setUniName(String n) {
		UniversityName = n;
	}
	
	public static User findUser(String login) {
		if(users.containsKey(login)) return users.get(login);
		return null;
	}
}
