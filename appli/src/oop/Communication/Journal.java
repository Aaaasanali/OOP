package oop;


/**
* @generated
*/
public class Journal {
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private String description;
    
    /**
    * @generated
    */
    private Set<User> subscribers;
    
    
    /**
    * @generated
    */
    private Set<User> user;
    
    /**
    * @generated
    */
    private Set<User> user;
    
    

    /**
    * @generated
    */
    private String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    private String setName(String name) {
        this.name = name;
    }
    
    
    /**
    * @generated
    */
    private String getDescription() {
        return this.description;
    }
    
    /**
    * @generated
    */
    private String setDescription(String description) {
        this.description = description;
    }
    
    
    /**
    * @generated
    */
    private Set<User> getSubscribers() {
        if (this.subscribers == null) {
            this.subscribers = new HashSet<User>();
        }
        return this.subscribers;
    }
    
    /**
    * @generated
    */
    private Set<User> setSubscribers(User subscribers) {
        this.subscribers = subscribers;
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
    
    
    

    //                          Operations                                  
    
    
}
