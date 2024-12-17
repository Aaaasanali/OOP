package students;

import java.util.HashSet;
import java.util.Set;


public class StudentOrganization {
    

    private String name;

    private String description;
    

    private Set<Student> students;
    
    


    private String getName() {
        return this.name;
    }
    

    private void setName(String name) {
        this.name = name;
    }
    

    private String getDescription() {
        return this.description;
    }
    

    private void setDescription(String description) {
        this.description = description;
    }
    
    
    
    public Set<Student> getStudent() {
        if (this.students == null) {
            this.students = new HashSet<Student>();
        }
        return this.students;
    }
    


    
    
    

    //                          Operations   
    
    
    public void addMember(Student student) {
        this.students.add(student);
    }
    
    public void removeMember(Student student) {
    	this.students.remove(student);
    }
    
    
    
    public void assignhead(Student student) {
    	
    }
    
    

    
}
