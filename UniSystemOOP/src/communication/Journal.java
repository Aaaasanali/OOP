package communication;

import java.util.HashSet;
import java.util.Set;

import user.User;


public class Journal {
    

    private String name;
    

    private String description;
    

    private Set<User> subscribers;
    

    private Set<User> users;
    
  
    
    
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
    
    
 
    private Set<User> getSubscribers() {
        if (this.subscribers == null) {
            this.subscribers = new HashSet<User>();
        }
        return this.subscribers;
    }
    

    private void addSubscribers(User subscriber) {
        this.subscribers.add(subscriber);
    }
    
    
    

    public Set<User> getUser() {
        if (this.users == null) {
            this.users = new HashSet<User>();
        }
        return this.users;
    }
    

    public void setUser(User user) {
        this.users.add(user);
    }
    
    
    }
    
    
    

    //                          Operations                                  
    
    

