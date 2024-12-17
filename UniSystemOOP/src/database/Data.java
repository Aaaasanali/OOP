package database;

import java.util.*;

import documents.Course;
import documents.Mark;
import employees.Admin;
import employees.Teacher;
import students.Student;
import user.Language;
import user.User;


public final class Data {
	
	// Singleton instance
    private static final Data instance = new Data();

    // University name
    private static String universityName;

    // Current language
    public static Language currentLanguage = Language.EN;

    // Users: stores all users (students, admins, etc.)
    private static final Map<String, User> users = new HashMap<>();
    private static final Vector<Admin> admins = new Vector<>();

    // Students
    private static final Map<String, Student> students = new HashMap<>();

    // Courses
    private static final Map<String, Course> courses = new HashMap<>();
    private static final List<Course> allCourses = new ArrayList<>();

    // Marks/Grades for each student per course
    private static final Map<String, List<Mark>> studentMarks = new HashMap<>();

    // Teachers
    private static final Map<String, Teacher> teachers = new HashMap<>();

    // Student Organizations
    private static final Map<String, List<String>> studentOrganizations = new HashMap<>();

    // Logs for auditing purposes
    private static final Stack<String> logs = new Stack<>();	
	
	
	
	
	
	
	
	
	
	
	public static void addUser(User a) {
		users.put(a.getLogin(), a);
	}
	
	public static void addUser(Admin a) {
		admins.add(a);
		users.put(a.getLogin(), a);
	}
	
	public static void setUniName(String name) {
		universityName = name;
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
