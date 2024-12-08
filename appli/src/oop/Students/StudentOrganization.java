package oop;


/**
* @generated
*/
public class StudentOrganization {
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private String description;
    
    
    /**
    * @generated
    */
    private Set<Student> student;
    
    

    /**
    * @generated
    */
    private String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    private String setName(String name) {
        this.name = name;
    }
    
    
    /**
    * @generated
    */
    private String getDescription() {
        return this.description;
    }
    
    /**
    * @generated
    */
    private String setDescription(String description) {
        this.description = description;
    }
    
    
    
    /**
    * @generated
    */
    public Set<Student> getStudent() {
        if (this.student == null) {
            this.student = new HashSet<Student>();
        }
        return this.student;
    }
    
    /**
    * @generated
    */
    public Set<Student> setStudent(Student student) {
        this.student = student;
    }
    
    
    

    //                          Operations                                  
    
    
}
