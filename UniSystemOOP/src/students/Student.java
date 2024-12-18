package students;

import java.util.*;

import java.util.List;

import database.Data;
import documents.Course;
import documents.Document;
import documents.Mark;
import user.User;

 

 public class Student extends User  {

    
    private int ects;
    private int admissionYear;
    private Speciality speciality;
    private String faculty;
    private StudyType studytype;
     
    private List<String> studentOrganizations;
    private List<Document> documents;
    private Map<Course, Mark> courses;						// Хранит все курсы и оценки по ним
    
    private int fails;
    private int MAXCREDITS = 21; 
    
    public Student() {
    	super();
    	this.studentOrganizations = new ArrayList<>();
    	this.documents = new ArrayList<>();
    	this.courses = new HashMap<>();
    };
    
    public Student(String login, String password, String name, String surname, int ects, String id) {
    	super(login, password, name, surname, id);
    	
    	
    	this.studentOrganizations = new ArrayList<>();
    	this.documents = new ArrayList<>();
    	this.courses = new HashMap<>();
        
        
        this.ects = ects;
        
        Data.addUser(this);
    }
    
    

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    /*											id уже есть у каждого usera
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    */
    
    
    public String getFaculty() {
		return faculty;
	}


	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public List<String> getOrganization() {
		return this.studentOrganizations;
	}
	
	
	private int getMAXCREDITS() {
		return this.MAXCREDITS;
	}

    


    @Override
    public String toString() {
        return super.toString() +
               ", Student{" +
               ", ects=" + ects +
               ", admissionYear=" + admissionYear +
               ", speciality=" + speciality +
               ", studytype=" + studytype +
               ", faculty='" + faculty + '\'' +
               ", studentOrganizations=" + studentOrganizations +
               ", fails=" + fails +
               ", MAXCREDITS=" + MAXCREDITS +
               ", documents=" + documents +
               ", enrolledCourses=" + enrolledCourses +
               '}';
    }    
    
    
    
    
    
    
    
    
    public void viewMarks() {
        for (Map.Entry<Course, Mark> entry : transcript.entrySet()) {
            System.out.println("Course: " + entry.getKey().getName() + " - " + entry.getValue());
        }
    }
    
    
    
    
    public static Student findStudentByLogin(String login) {
        User user = Data.findUserByLogin(login);
        if (user instanceof Student) {
            return (Student) user;
        }
        return null;
    }
    
    public static Student findStudentById(String id) {
        User user = Data.findUserById(id);
        if (user instanceof Student) {
            return (Student) user;
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void viewCourses() { // показать список курсов
        if (courses.isEmpty()) {
            System.out.println("No courses registered yet.");
            return;
        }

        System.out.println("Enrolled Courses:");
        for (Course course : courses.keySet()) {
            System.out.println("- " + course.getName());
        }
    }        
    
    
    
    public void registerForCourse(String courseName, int year) { // Регистрация на курс
        Course newCourse = new Course(courseName, year);

        if (!courses.containsKey(newCourse)) { // Check if the course is already registered
            courses.put(newCourse, new Mark(0, 0, 0)); // Add to map with a default Mark
            System.out.println("Successfully registered for course: " + courseName);
        } else {
            System.out.println("You are already registered for the course: " + courseName);
        }
    }
    
    
    
    /*
    
    public String viewTeacherInfo(String courseName) {										// инфо про препода
        for (Course course : enrolledCourses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return "Teacher for " + courseName + ": " + course.getTeachers();
            }
        }
        return "Course not found!";
    }
    */
    
  //  public String viewMarks() {
  //      return transcript.getGrades();
  //  }'
  //  public String getTranscript() {
  //      return transcript.getGrades();
  //  }
    
    
    
    
    public void rateTeacher(String teacherName, Integer rating) {
        System.out.println("Rated teacher " + teacherName + " with a score of " + rating + "/10.");
    }	
    
    
    
    
    
    
    public void joinOrganization() {
    	
    }
    
    
    
    
    
    
 }
	
 
 
 

