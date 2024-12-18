package database;

import java.io.*;
import java.util.*;

import documents.Course;
import documents.Mark;
import employees.Admin;
import employees.Teacher;
import students.Student;
import user.Language;
import user.User;


public final class Data implements Serializable{
    
     public static Vector<User> users = new Vector<User>();
    
    
    // University name
    private static String universityName;

    // Current language
    public static Language currentLanguage = Language.RU;


    // Courses
     Map<String, Course> courses = new HashMap<>();
     List<Course> allCourses = new ArrayList<>();


    																								//Teachers, Students, Admins contains in users, access them through method getAllTeachers

    // Student Organizations
     Map<String, List<String>> studentOrganizations = new HashMap<>();

    
    
    // Logs for auditing purposes
     Stack<String> logs = new Stack<>();	
	
	
	
    public static Data INSTANCE;
	static {
		if(new File("data").exists()) {
			try {
				INSTANCE = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else INSTANCE = new Data();
	}
	private Data() {

	}	
	
	public static Data read() throws IOException, ClassNotFoundException {
	    try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream("data"))) {
	        return (Data) oin.readObject();
	    }
	}

	public static void write() throws IOException {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data"))) {
	        oos.writeObject(INSTANCE);
	    }
	}
	
	
	
	
	
	
	
	
	
	
	public static void addUser(User a) {
		users.add(a);
	}
	
	
	public static void setUniName(String name) {
		universityName = name;
	}
	
	
	
	
	
	/*
	public static User findUserByLogin(String login) {
		if(users.contains(login)) return //;
		return null;
	}
	
	public static User findUserById(String id) {
		for(Map.Entry<String, User> entry : users.entrySet()) {
			if(entry.getValue().getId().equals(id)) return entry.getValue();
		}
		return null;
	}
	*/
	
	
	
	
	
	public static void setLanguage(Language l) {
		currentLanguage = l;
	}
	
	
	
	
	
	
	
	public static Vector<Student> getAllStudents(){
		Vector v = new Vector<Student>();
		
		for(User u : users) {
			if (u instanceof Student) {
				v.add(u);
			}
		}
		
		return v;
	}
	
	public static Vector<Teacher> getAllTeachers(){
		Vector v = new Vector<Teacher>();
		
		for(User u : users) {
			if (u instanceof Teacher) {
				v.add(u);
			}
		}
		
		return v;
	}
	
	public static Vector<Admin> getAllAdmins(){
		Vector v = new Vector<Admin>();
		
		for(User u : users) {
			if (u instanceof Admin) {
				v.add(u);
			}
		}
		
		return v;
	}

	public static User findUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
