package database;

import java.io.*;
import java.util.*;

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


public final class Data implements Serializable{

	public static Vector<User> users = new Vector<User>();
	//Teachers, Students, Admins contains in users, access them through method getAllTeachers


	// University name
	private static String universityName;

	// Current language
	public static Language currentLanguage = Language.RU;

	// Courses
	public static Vector<Course> courses = new Vector<Course>();
	public static Vector<StudentOrganization> studentOrganizations = new Vector<StudentOrganization>();

	public static List<News> news = new ArrayList<News>();

	Stack<String> logs = new Stack<>();	



	public static Data INSTANCE;																	//Singleton
	
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

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public static void addStudentOrganization(StudentOrganization studOrg) {
		studentOrganizations.add(studOrg);
	}

	public static void setUniName(String name) {
		universityName = name;
	}


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


	public static Vector<StudentOrganization> getStudentOrganizations() {
		return studentOrganizations;
	}


	public static Vector<User> getAllUsers(){
		return users;
	}

	public static Vector<Course> getAllCourses(){
		return courses;
	}
	
	public static List<News> getAllNews(){
		return news;
	}



	public static User findUserByLogin(String login) {    
		for (User user : users) {
			if (user.getLogin().equals(login)) {
				return user; 
			}
		}
		return null; 
	}

	public static User findUserById(String id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}






}
