package students;

import java.util.*;

import java.util.List;

import database.Data;
import documents.Course;
import documents.Document;
import documents.Mark;
import user.User;

 

 public class Student extends User  {

    private int course;
    private int ects;
    private int admissionYear;
    private Speciality speciality;
    private String faculty;
    private StudyType studytype;
    
    private List<Course> enrolledCourses = new ArrayList<>();
    private List<String> studentOrganizations = new ArrayList<>();
    private List<Document> documents = new ArrayList<>();
    private Map<Course, Mark> transcript = new HashMap<>();
    
    private int fails;
    private int MAXCREDITS = 21; 
    
    public Student() {
    	
    	
    };
    
    public Student(String login, String password, String name, String surname, int course, int ects, String id) {
        super(login, password, name, surname, id);
        this.course = course;
        this.ects = ects;
        
        Data.addUser(this);
    }
    
    
 
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
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


	public void setOrganization(String organization) {
		this.organizations = organization;
	}
	
	
	private int getMAXCREDITS() {
		return this.MAXCREDITS;
	}

    


    @Override
    public String toString() {
        return super.toString() +
               ", Student{" +
               "course=" + course +
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Course> viewCourse() {											//показать список курсов
        return enrolledCourses;
    }
    
    
    
    public Course viewCourse(String courseName) {									// списки по нвз-ния курса
        for (Course course : enrolledCourses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null; 																				//если нет курсов
    }
    
    
    
    
    
    public void registerForCourse(String courseName, int year) { 									//регистрация на курс
        enrolledCourses.add(new Course(courseName, year));
        System.out.println("Successfully registered for course: " + courseName);
    }

    
    
    
    
    
    public String viewTeacherInfo(String courseName) {										// инфо про препода
        for (Course course : enrolledCourses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return "Teacher for " + courseName + ": " + course.getTeachers();
            }
        }
        return "Course not found!";
    }
    
    
  //  public String viewMarks() {
  //      return transcript.getGrades();
  //  }'
  //  public String getTranscript() {
  //      return transcript.getGrades();
  //  }
    public void rateTeacher(String teacherName, Integer rating) {
        System.out.println("Rated teacher " + teacherName + " with a score of " + rating + "/10.");
    }	
    
    
    
    
 }
	
 
 
 

