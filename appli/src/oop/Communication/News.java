package oop;


/**
* @generated
*/
public class News {
    
    /**
    * @generated
    */
    private String title;
    
    /**
    * @generated
    */
    private String content;
    
    /**
    * @generated
    */
    private boolean isPinned;
    
    /**
    * @generated
    */
    private Set<String> comments;
    
    
    /**
    * @generated
    */
    private User user;
    
    /**
    * @generated
    */
    private Set<User> user;
    
    

    /**
    * @generated
    */
    private String getTitle() {
        return this.title;
    }
    
    /**
    * @generated
    */
    private String setTitle(String title) {
        this.title = title;
    }
    
    
    /**
    * @generated
    */
    private String getContent() {
        return this.content;
    }
    
    /**
    * @generated
    */
    private String setContent(String content) {
        this.content = content;
    }
    
    
    /**
    * @generated
    */
    private boolean getIsPinned() {
        return this.isPinned;
    }
    
    /**
    * @generated
    */
    private boolean setIsPinned(Boolean isPinned) {
        this.isPinned = isPinned;
    }
    
    
    /**
    * @generated
    */
    private Set<String> getComments() {
        if (this.comments == null) {
            this.comments = new HashSet<String>();
        }
        return this.comments;
    }
    
    /**
    * @generated
    */
    private Set<String> setComments(String comments) {
        this.comments = comments;
    }
    
    
    
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
    public User getUser() {
        return this.user;
    }
    
    /**
    * @generated
    */
    public User setUser(User user) {
        this.user = user;
    }
    
    
    
}
