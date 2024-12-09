package oop;


/**
* @generated
*/
public class Course {
    private String name;
    private Course prereq;
    private int ects;
    public Course(String courseName, String string) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
    * @generated
    */
    public Course getPrereq() {
        return this.prereq;
    }
    
    /**
    * @generated
    */
    public Course setPrereq(Course prereq) {
        this.prereq = prereq;
    }
    
    
    /**
    * @generated
    */
    public int getEcts() {
        return this.ects;
    }
    
    /**
    * @generated
    */
    public void setEcts(Integer ects) {
         this.ects = ects;
    }
	public String getCourseName() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

    
    
    
    
}
