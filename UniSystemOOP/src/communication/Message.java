package communication;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import user.User;


public class Message {
    

    private User senderrr;

    private User recipient;

    private String content;
    
    private Set<User> users;
    
    


    private User getSender() {
        return this.sender;
    }

    private void setSender(User sender) {
        this.sender = sender;
    }
    
    

    
    private User getRecipient() {
        return this.recipient;
    }

    private void setRecipient(User recipient) {
        this.recipient = recipient;
    }
    
    

    
    private String getContent() {
        return this.content;
    }
    


    private void setContent(String content) {
        this.content = content;
    }
    
    
    
    public Set<User> getUser() {
        if (this.users == null) {
            this.users = new HashSet<User>();
        }
        return this.users;
    }
    
    /**
    * @generated
    */
    public void addUser(User user) {
        this.users.add(user);
    }
    
    
    
}






/*public class Message {
	private User sender;
    private User recipient;
    private String content;
    private LocalDateTime timestamp;

    public Message(User sender, User recipient, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = timestamp;
    }
 */