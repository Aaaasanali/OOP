package students;

import java.io.Serializable;

public class Speciality implements Serializable{

    private String name;
    
    private String id;

    private String description;
    
    private String carriculum;
    

    
    
    

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
    
    

    private String getCarriculum() {
        return this.carriculum;
    }
    

    private void setCarriculum(String carriculum) {
        this.carriculum = carriculum;
    }
    
    

    
    
    
    
}
