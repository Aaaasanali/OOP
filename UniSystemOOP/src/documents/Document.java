package documents;

import java.io.Serializable;

import employees.Teacher;
import students.Student;

public class Document implements Serializable{

    private String name;
    
    private String link;

    private String getName() {
        return this.name;
    }
    

    private void setName(String name) {
        this.name = name;
    }
    
    
    private String getLink() {
        return this.link;
    }
    

    private void setLink(String link) {
        this.link = link;
    }
    
    
    
    
}
