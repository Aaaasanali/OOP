package documents;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Faculty implements Serializable{
    

    private String name;
    
    private String id;

    private String description;

    private Course courses;

    private Set<String> electiveRules;
    

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
    
    

    private String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }
    
    
    
    

    private String getDescription() {
        return this.description;
    }
    

    private void setDescription(String description) {
        this.description = description;
    }
    
    
 
    private Course getCourses() {
        return this.courses;
    }
    

    private void setCourses(Course courses) {
        this.courses = courses;
    }
    

    private Set<String> getElectiveRules() {
        if (this.electiveRules == null) {
            this.electiveRules = new HashSet<String>();
        }
        return this.electiveRules;
    }
    

    private void addElectiveRule(String electiveRules) {
        this.electiveRules.add(electiveRules);
    }
    
    
    


} 
    
    

    //                          Operations                                  