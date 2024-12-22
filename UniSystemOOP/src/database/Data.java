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
	public static Data INSTANCE;																	//Singleton
	
	private static final long serialVersionUID = 123456789L;

	private Vector<User> users = new Vector<User>();
	//Teachers, Students, Admins contains in users, access them through method getAllTeachers
	
    private static String universityName;
    private Language currentLanguage = Language.EN;

    private Vector<Course> courses = new Vector<Course>();
    private Vector<StudentOrganization> studentOrganizations = new Vector<StudentOrganization>();

    public List<News> news = new ArrayList<News>();
    
    private Vector<Request> requests = new Vector<>();


    private Stack<String> logs = new Stack<>();

    
	
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

	public static void write () throws IOException {
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

	public Vector<Student> getAllStudents(){
		Vector v = new Vector<Student>();

		for(User u : users) {
			if (u instanceof Student) {
				v.add(u);
			}
		}

		return v;
	}

	public Vector<Teacher> getAllTeachers(){
		Vector v = new Vector<Teacher>();

		for(User u : users) {
			if (u instanceof Teacher) {
				v.add(u);
			}
		}

		return v;
	}

	public Vector<Admin> getAllAdmins(){
		Vector v = new Vector<Admin>();

		for(User u : users) {
			if (u instanceof Admin) {
				v.add(u);
			}
		}
		return v;
	}


	public Vector<StudentOrganization> getStudentOrganizations() {
		return studentOrganizations;
	}


	public Vector<User> getAllUsers(){
		return users;
	}

	public Vector<Course> getAllCourses(){
		return courses;
	}
	
	public List<News> getAllNews(){
		return news;
	}
	
	public Vector<Request> getRequests() {
	    if (requests == null) {
	        requests = new Vector<>(); // Initialize the requests list if it's null
	    }
	    return requests;
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
	
	public static String getUniName() {
		return universityName;
	}
	
}
