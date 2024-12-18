package employees;

import java.io.Serializable;
import java.util.*;

import documents.Document;
import documents.Lesson;
import research.ResearchPaper;
import research.Researcher;
import documents.Course;
import students.Student;

public class Teacher extends Employee implements Researcher, Serializable {
    

    public Teacher(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}


	private Vector<Course> courses;
    

    private double rating;
    private Vector<Double> ratingMraks;
    

    //private Set<Lesson> lessons; lessons are contains in courses
    

    private TeacherTitle teacherType;
    

    private Set<Document> documents;
    
    
    


    private Vector<Course> getCourses() {
        if (this.courses == null) {
            this.courses = new Vector<Course>();
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
    
    
    
    
    
    

//    private Set<Lesson> getLessons() {						change, get lessons from courses
//        if (this.lessons == null) {
//            this.lessons = new HashSet<Lesson>();
//        }
//        return this.lessons;
//    }
//    
//
//    private void setLessons(Lesson lesson) {
//        this.lessons.add(lesson);
//    }
    
    
    
    
    
    

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
    


	@Override
	public String toString() {
	    // Get the teacher's courses as a list of course names (you can modify this to include other details if needed)
	    StringBuilder courseNames = new StringBuilder();
	    if (this.courses != null && !this.courses.isEmpty()) {
	        for (Course course : this.courses) {
	            courseNames.append(course.getName()).append(", ");
	        }
	        // Remove last comma and space
	        courseNames.setLength(courseNames.length() - 2);
	    } else {
	        courseNames.append("No courses assigned");
	    }

	    // Build the string representation
	    return "Teacher Login: " + this.getLogin() + " " +
	           "Rating: " + this.rating + " " +
	           "Courses: " + courseNames.toString() + " " +
	           "Teacher Type: " + (this.teacherType != null ? this.teacherType.toString() : "Not assigned") + " ";
	}
    
	
	
    

}
    
    
    

    //                          Operations                                  
    
    

