package oop.Employees;


/**
* @generated
*/
public class Admin extends Employee {
    
    
    /**
    * @generated
    */
    private Set<Course> course;
    
    /**
    * @generated
    */
    private Data data;
    
    /**
    * @generated
    */
    private Set<User> user;
    
    

    
    /**
    * @generated
    */
    public Set<User> getUser() {
        if (this.user == null) {
            this.user = new HashSet<User>();
        }
        return this.user;
    }
    
    /**
    * @generated
    */
    public Set<User> setUser(User user) {
        this.user = user;
    }
    
    
    /**
    * @generated
    */
    public Data getData() {
        return this.data;
    }
    
    /**
    * @generated
    */
    public Data setData(Data data) {
        this.data = data;
    }
    
    
    /**
    * @generated
    */
    public Set<Course> getCourse() {
        if (this.course == null) {
            this.course = new HashSet<Course>();
        }
        return this.course;
    }
    
    /**
    * @generated
    */
    public Set<Course> setCourse(Course course) {
        this.course = course;
    }
    
    
    

    //                          Operations                                  
    
    
}
