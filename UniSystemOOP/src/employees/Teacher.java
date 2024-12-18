package employees;

import java.util.HashSet;
import java.util.Set;

import documents.Document;
import documents.Lesson;
import research.ResearchPaper;
import research.Researcher;
import documents.Course;
import students.Student;

public class Teacher extends Employee implements Researcher {
    

    public Teacher(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}


	private Set<Course> courses;
    

    private double rating;
    

    private Set<Lesson> lessons;
    

    private TeacherTitle teacherType;
    

    private Set<Document> documents;
    

    //private Set<Student> students;				not in UML
    
    


    private Set<Course> getCourses() {
        if (this.courses == null) {
            this.courses = new HashSet<Course>();
        }
        return this.courses;
    }
    

    private void addCourses(Course course) {
        this.courses.add(course);
    }
    
    
    
    
    
    

    private double getRating() {
        return this.rating;
    }
    
    private void setRating(double rating) {
        this.rating = rating;
    }
    
    
    
    
    
    

    private Set<Lesson> getLessons() {
        if (this.lessons == null) {
            this.lessons = new HashSet<Lesson>();
        }
        return this.lessons;
    }
    

    private void setLessons(Lesson lesson) {
        this.lessons.add(lesson);
    }
    
    
    
    
    
    

    private TeacherTitle getTeacherType() {
        return this.teacherType;
    }
    
 
    private void setTeacherType(TeacherTitle teacherType) {
        this.teacherType = teacherType;
    }
    
    

    
    
    
    public Set<Document> getDocument() {
        if (this.documents == null) {
            this.documents = new HashSet<Document>();
        }
        return this.documents;
    }
    
 
    public void addDocument(Document document) {
        this.documents = documents;
    }

    
    
    
    
    
    
    
    

	@Override
	public void addResearchPaper() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ResearchPaper getresearchPaper() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void printResearchPaper() {
		// TODO Auto-generated method stub
		
	}
    
    
    
/*
    public Set<Student> getStudent() {
        if (this.student == null) {
            this.student = new HashSet<Student>();
        }
        return this.student;
    }
    
   
    public Set<Student> setStudent(Student student) {
        this.student = student;
    }
    */
    
}
    

