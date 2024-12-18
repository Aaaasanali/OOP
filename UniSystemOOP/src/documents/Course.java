package documents;

import java.io.Serializable;
import java.util.List;

import employees.Teacher;

public class Course implements Serializable {
    
    private String id;
    private String name;
    private Integer credits;
    private List<Lesson> lessons;
    private Semester semester;
    private String formula;
    private Integer year;
    private List<Teacher> teachers;
    private CourseType type;
//    private List<Lesson> schedule;
    private String description;
    private List<Course> prerequisites;

    
    
    
    
    public Course() {
    	this.id = "";
        this.name = "";
        this.credits = 0;
        this.lessons = null;
        this.formula = "";
        this.year = 0;
        this.teachers = null;
        this.type = null;
//        this.schedule = null;
        this.description = "";
        this.prerequisites = null;
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
    
    public Course(String id, String name, Integer credits, List<Lesson> lessons, String formula, 
                  Integer year, List<Teacher> teachers, CourseType type, 
                  List<Lesson> schedule, String description, List<Course> prerequisites) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.lessons = lessons;
        this.formula = formula;
        this.year = year;
        this.teachers = teachers;
        this.type = type;
//        this.schedule = schedule;
        this.description = description;
        this.prerequisites = prerequisites;
    }

    // 
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

    public void setLessons(List<Lesson> lessons) {
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

    public void setTeachers(List<Teacher> teachers) {
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

    public void setPrerequisites(List<Course> prerequisites) {
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