package students;

import java.util.ArrayList;

import java.util.List;

import documents.Course;
import user.User;

 

 public class Student extends User  {

    private int course;
    private int ects;
    private String id;
    private String faculty;
    private List<Course> enrolledCourses = new ArrayList<>();
    private String organization = null;
    private int MAXCREDITS = 21; 
    
    
    public Student(String login, String password, String name, String surname, int course, int ects, String id) {
        super(login, password, name, surname);
        this.course = course;
        this.ects = ects;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getFaculty() {
		return faculty;
	}


	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
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
                ", id=" + id +
                '}';
    }

    public List<Course> viewCourse() {//показать список курсов
        return enrolledCourses;
    }
    
    
    
    public Course viewCourse(String courseName) {// списки по нвз-ния курса
        for (Course course : enrolledCourses) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null; //если нет курсов
    }
    public void registerForCourse(String courseName) { //регистрация на курс
        enrolledCourses.add(new Course(courseName, "Unknown Teacher"));
        System.out.println("Successfully registered for course: " + courseName);
    }

    public String viewTeacherInfo(String courseName) {// инфо про препода
        for (Course course : enrolledCourses) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                return "Teacher for " + courseName + ": " + course.getTeacher();
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
	
 
 
 

