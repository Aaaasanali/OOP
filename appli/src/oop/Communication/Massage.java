package oop;


/**
* @generated
*/
public class Massage {
    
    /**
    * @generated
    */
    private User sender;
    
    /**
    * @generated
    */
    private User recipient;
    
    /**
    * @generated
    */
    private String content;
    
    
    /**
    * @generated
    */
    private Set<User> user;
    
    

    /**
    * @generated
    */
    private User getSender() {
        return this.sender;
    }
    
    /**
    * @generated
    */
    private User setSender(User sender) {
        this.sender = sender;
    }
    
    
    /**
    * @generated
    */
    private User getRecipient() {
        return this.recipient;
    }
    
    /**
    * @generated
    */
    private User setRecipient(User recipient) {
        this.recipient = recipient;
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
    
    
    
}
