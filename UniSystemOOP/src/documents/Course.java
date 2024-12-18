package documents;

import java.io.Serializable;
import java.util.*;

import employees.Teacher;

public class Course implements Serializable {
    
    private String id;
    private String name;
    private Integer credits;
    private Vector<Lesson> lessons;
    private Semester semester;
    private String formula;
    private Integer year;
    private Vector<Teacher> teachers;
    private CourseType type;
    private String description;
    private Vector<Course> prerequisites;

    public Course() {
    	
    }
    
    public Course(String name, int year, Semester semester) {
    	this.name = name;
    	this.year = year;
    	this.semester = semester;
    }
    

    
    public Course(String id, String name, int credits, String formula, int year, CourseType type, String description, Semester semester) {
		  this.id = id;
		  this.name = name;
		  this.credits = credits;
		  this.formula = formula;
		  this.year = year;
		  this.type = type;
		//  this.schedule = schedule;
		  this.description = description;
		  this.semester = semester;

    }
    
    public Course(String id, String name, int credits, Vector<Lesson> lessons, 
    	Semester semester, String formula, int year, 
    	Vector<Teacher> teachers, CourseType type, 
        String description, Vector<Course> prerequisites) {
    		
    	this(name, year, semester);
    	
		this.id = id;
		this.credits = credits;
		this.lessons = (lessons != null) ? lessons : new Vector<>();
		this.formula = formula;
		this.teachers = (teachers != null) ? teachers : new Vector<>();
		this.type = type;
		this.description = description;
		this.prerequisites = (prerequisites != null) ? prerequisites : new Vector<>();
	}
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Vector<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Vector<Teacher> teachers) {
        this.teachers = teachers;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }
    
    public void setSemester(Semester semester) {
    	this.semester = semester;
    }
    
    public Semester getSemester() {
    	return this.semester;
    }

//    public List<Lesson> getSchedule() {
//        return schedule;
//    }
//
//    public void setSchedule(List<Lesson> schedule) {
//        this.schedule = schedule;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(Vector<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", lessons=" + lessons +
                ", formula='" + formula + '\'' +
                ", year=" + year +
                ", teachers=" + teachers +
                ", type=" + type +
//                ", schedule=" + schedule +
                ", description='" + description + '\'' +
                ", prerequisites=" + prerequisites +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        
        return year.equals(course.year) && name.equals(course.name) && semester.equals(this.semester);  
    }
}