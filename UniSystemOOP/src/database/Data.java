package database;

import java.io.*;
import java.util.*;

import documents.Course;
import documents.Mark;
import employees.Admin;
<<<<<<< HEAD
import employees.Teacher;
import students.Student;
import students.StudentOrganization;
=======
import employees.Dean;
>>>>>>> refs/remotes/origin/Alkash
import user.Language;
import user.User;


<<<<<<< HEAD
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


	Stack<String> logs = new Stack<>();	



	public static Data INSTANCE;																	//Singleton 
	static {
		if(new File("data").exists()) {
			try {
				INSTANCE = read();
			} catch (Exception e) {
				e.printStackTrace();
=======
public final class Data {
	
	public static Language currentLanguage = Language.EN;
	
	private static String UniversityName;
	private static final Vector<Admin> admins = new Vector<>();
	
	private static final Map<String, User> users = new HashMap<>();
	private static List<Dean> deans = new ArrayList<>();

	
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
>>>>>>> refs/remotes/origin/Alkash
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

<<<<<<< HEAD






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






=======
	public static List<Dean> getDeans() {
	    return deans;
	}
>>>>>>> refs/remotes/origin/Alkash
}
