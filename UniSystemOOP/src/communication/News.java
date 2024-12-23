package communication;

import java.io.Serializable;
import java.util.*;



public class News implements Serializable{
    

    private String title;
    
    private String content;
    
    private boolean isPinned = false;
    
    private List<String> comments;

    
    
    
    public News() {
    	this.title = "";
    	this.content = "";
    }

    public News(String title, String content, boolean isPinned, List<String> comments) {
		this.title = title;
		this.content = content;
		this.isPinned = isPinned;
		this.comments = comments;
	}

    
	public String getTitle() {
        return this.title;
    }
    
    private void setTitle(String title) {
        this.title = title;
    }
    
    
    

    public String getContent() {
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
    
    
    public boolean isPinned() {
    	return isPinned;
    }


    public List<String> getComments() {
        return this.comments;
    }
    
    public void addComment(String comment) {
        this.comments.add(comment);
    }
    
    
    
   
    
    
    
}
