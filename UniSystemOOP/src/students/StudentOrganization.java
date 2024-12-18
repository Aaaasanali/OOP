package students;

import java.util.*;
import java.util.Set;


public class StudentOrganization {
    

    private String name;

    private String description;
    

    private Vector<Student> students;
    
    
    
    public StudentOrganization(String name, String description) {
        this.name = name;
        this.description = description;
        this.students = new Vector<Student>(); 
    }


    public String getName() {
        return this.name;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    

    public String getDescription() {
        return this.description;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    public Vector<Student> getStudent() {
        if (this.students == null) {
            this.students = new Vector<Student>();
        }
        return this.students;
    }
    
    public Vector<Student> getStudents() {
    	return students;
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
    
    
    public Vector<String> getStudentsNames() {
    	Vector<String> res = new Vector<>();
    	
    	for (Student student : students) {
    		res.add(student.getName());
    	}
    	
    	
    	return res;
    }
    
    public String toString() {
        return "Organization Name: " + name + ", Description: '" + description + "', Members: " + this.getStudentsNames();
    }
    
}
