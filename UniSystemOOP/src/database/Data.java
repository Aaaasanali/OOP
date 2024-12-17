package database;

import java.util.*;

import employees.Admin;
import user.Language;
import user.User;


public final class Data {
	
	public static Language currentLanguage = Language.EN;
	
	private static String UniversityName;
	private static final Vector<Admin> admins = new Vector<>();
	
	private static final Map<String, User> users = new HashMap<>();
	
	private static final Stack<String> logs = new Stack<>();
	
	
	public static void addUser(User a) {
		users.put(a.getLogin(), a);
	}
	
	public static void addUser(Admin a) {
		admins.add(a);
		users.put(a.getLogin(), a);
	}
	
	public static void setUniName(String n) {
		UniversityName = n;
	}
	
	public static User findUserByLogin(String login) {
		if(users.containsKey(login)) return users.get(login);
		return null;
	}
	
	public static User findUserById(String id) {
		for(Map.Entry<String, User> entry : users.entrySet()) {
			if(entry.getValue().getId().equals(id)) return entry.getValue();
		}
		return null;
	}
	
	public static boolean deleteUser(User us) {
		for(Map.Entry<String, User> entry : users.entrySet()) {
			if(entry.getValue().equals(us)) {
				users.remove(entry.getKey());
				return true;
			}
		}
		return false;
	}
	
	public static void setLanguage(Language l) {
		currentLanguage = l;
	}
}
