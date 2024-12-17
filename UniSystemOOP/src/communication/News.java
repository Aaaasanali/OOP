package communication;

import java.util.HashSet;
import java.util.Set;


public class News {
    

    private String title;
    

    private String content;
    

    private boolean isPinned;
    

    private Set<String> comments;

    
    


    private String getTitle() {
        return this.title;
    }
    
    private void setTitle(String title) {
        this.title = title;
    }
    
    
    

    private String getContent() {
        return this.content;
    }

    private void setContent(String content) {
        this.content = content;
    }
    
    

    
    private boolean getPinStatus() {
        return this.isPinned;
    }
    
    private void setPinStatus(Boolean isPinned) {
        this.isPinned = isPinned;
    }
    
    
 

    private Set<String> getComments() {
        if (this.comments == null) {
            this.comments = new HashSet<String>();
        }
        return this.comments;
    }
    
    private void addComment(String comment) {
        this.comments.add(comment);
    }
    
    
    
   
    
    
    
}
