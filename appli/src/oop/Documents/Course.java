package oop.Documents;



public class Course {
  
	   private String courseName;
	    private String teacher;

	    public Course(String courseName, String teacher) {
	        this.courseName = courseName;
	        this.teacher = teacher;
	    }

	    public String getCourseName() {
	        return courseName;
	    }

	    public String getTeacher() {
	        return teacher;
	    }

	    @Override
	    public String toString() {
	        return "Course{" +
	                "courseName='" + courseName + '\'' +
	                ", teacher='" + teacher + '\'' +
	                '}';
	    }
	}