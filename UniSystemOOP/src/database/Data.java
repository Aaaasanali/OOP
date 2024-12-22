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

public final class Data implements Serializable {
	public static Data INSTANCE; // Singleton

	private static final long serialVersionUID = 123456789L;

	private Vector<User> users = new Vector<User>();
	// Teachers, Students, Admins contains in users, access them through method
	// getAllTeachers

	private static String universityName;
	private Language currentLanguage = Language.EN;

	private Map<Course, Vector<Student>> courseRegistrations;

	private Vector<Course> courses = new Vector<Course>();
	private Vector<StudentOrganization> studentOrganizations = new Vector<StudentOrganization>();

	public List<News> news = new ArrayList<News>();

	private Vector<Request> requests = new Vector<>();

	private List<String> logs = new ArrayList<>();

	static {
		INSTANCE = getInstance();
	}

	private Data() {

	}

	public static Data getInstance() {
		if (INSTANCE == null) {
			synchronized (Data.class) {
				if (INSTANCE == null) {
					try {
						INSTANCE = read();
					} catch (Exception e) {
						e.printStackTrace();
						INSTANCE = new Data(); // Default if reading fails
					}
				}
			}
		}
		return INSTANCE;
	}

	public static Data read() {
		File dataFile = new File("data");
		if (!dataFile.exists()) {
			System.out.println("Data file not found. Initializing new Data instance.");
			return new Data(); // Return a new instance if the file doesn't exist
		}

		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(dataFile))) {
			System.out.println("Reading data from file...");
			Data instance = (Data) oin.readObject();
			System.out.println("Data successfully read.");
			return instance;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return new Data(); // Default to a new instance in case of an error
		}
	}

	public static void write() throws IOException {
		File dataFile = new File("data"); // Creates file in the working directory
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
			System.out.println("Writing data to file...");
			oos.writeObject(INSTANCE);
			System.out.println("Data file successfully created: " + dataFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Error writing file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param course
	 * @param student
	 */
	public void addRegistrationRequest(Course course, Student student) {
		// Initialize courseRegistrations if it's null
		if (courseRegistrations == null) {
			courseRegistrations = new HashMap<>();
		}

		if (course == null || student == null) {
			System.out.println("Invalid course or student");
			return; // Handle invalid data gracefully
		}

		courseRegistrations.computeIfAbsent(course, k -> new Vector<>()).add(student);
	}

	public void approveRegistration(Course course, Student student) {
		// Logic to approve registration
		System.out.println("Registration for " + student.getName() + " " + student.getSurname() + " in course "
				+ course.getName() + " has been approved.");
	}

	public void rejectRegistration(Course course, Student student) {
		// Logic to reject registration
		System.out.println("Registration for " + student.getName() + " " + student.getSurname() + " in course "
				+ course.getName() + " has been rejected.");
	}

	public void addUser(User a) {
		users.add(a);
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void addStudentOrganization(StudentOrganization studOrg) {
		studentOrganizations.add(studOrg);
	}

	public void setUniName(String name) {
		universityName = name;
	}

	public void setLanguage(Language l) {
		currentLanguage = l;
	}

	public void addRequest(Request request) {
		requests.add(request);
	}

	public Vector<Researcher> getAllResearchers(){
		Vector v = new Vector<Student>();

		for(User u : users) {
			if (u instanceof Researcher) {
				v.add(u);
			}
		}

		return v;
	}
	
	public Vector<Student> getAllStudents(){
		Vector v = new Vector<Student>();

		for (User u : users) {
			if (u instanceof Student) {
				v.add(u);
			}
		}

		return v;
	}

	public Vector<Teacher> getAllTeachers() {
		Vector v = new Vector<Teacher>();

		for (User u : users) {
			if (u instanceof Teacher) {
				v.add(u);
			}
		}

		return v;
	}

	public Vector<Admin> getAllAdmins() {
		Vector v = new Vector<Admin>();

		for (User u : users) {
			if (u instanceof Admin) {
				v.add(u);
			}
		}
		return v;
	}

	public String getUniName() {
		return universityName;
	}

	public Vector<StudentOrganization> getStudentOrganizations() {
		return studentOrganizations;
	}

	public Vector<User> getAllUsers() {
		return users;
	}

	public Vector<Course> getAllCourses() {
		return courses;
	}

	public List<News> getAllNews() {
		return news;
	}

	public Vector<Request> getRequests() {
		if (requests == null) {
			requests = new Vector<>(); // Initialize the requests list if it's null
		}
		return requests;
	}

	public Map<Course, Vector<Student>> getCourseRegistrations() {
		return courseRegistrations;
	}

	public List<String> getLogs() {
		return logs; // return the entire log list
	}

	public User findUserByLogin(String login) {
		for (User user : users) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
		return null;
	}

	public User findUserById(String id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public User findUserByNameAndSurname(String name, String surname) {
		for (User user : users) {
			if (user.getName().equalsIgnoreCase(name) && user.getSurname().equalsIgnoreCase(surname)) {
				return user;
			}
		}
		return null;
	}

	public void addLog(String logMessage) {
		logs.add(logMessage); // Assuming logs is a Stack<String>
	}

	public void deleteUser(User current) {

		if (users.contains(current)) {
			users.remove(current);
			System.out.println("User " + current.getName() + " " + current.getSurname() + " has been deleted.");

			// Log
			String logMessage = "User deleted: " + current.toString();
			addLog(logMessage);

			try {
				write();
			} catch (IOException e) {
				System.out.println("Failed to save changes after deleting the user.");
				e.printStackTrace();
			}
		} else {
			System.out.println("User not found in the system.");
		}
	}
	
}
