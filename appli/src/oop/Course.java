package oop;


/**
* @generated
*/
public class Course {
    private String name;
    private Course prereq;
    private int ects;
    public String getName() {
        return this.name;
    }
    public String setName(String name) {
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
    public int setEcts(Integer ects) {
        this.ects = ects;
    }
    
    
    
    
}
