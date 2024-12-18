package employees;

import user.User;
import user.UserFactory;

import java.util.*;

import Factories.NamedRunnable;
import Interfaces.CreatingUsers;
import database.Data;

public class Admin extends User implements CreatingUsers{
	
	private Scanner n = new Scanner(System.in);
	
	public Admin(String login, String password) {
		super(login, password);
		Data.addUser(this);
	}
    
    public void setUniName(String name) {
    	Data.setUniName(name);
    }
    
    public void createUser() {
    	
    	System.out.println("Enter User Type: ");
    	User current = UserFactory.getUser(n.next(), this);
    	System.out.println("Enter Login: ");
    	String login = n.next();
    	current.setLogin(login);
        
    	System.out.println(current.getClass().getSimpleName() + " has been created\nlogin: " + current.getLogin() + "\npassword: " + current.getPassword());
    }
    
    public void updateUser() {
    	System.out.println("Enter User id: ");
    	String id = n.next();
    	User current = Data.findUserById(id);
    	
    	current.changeData();

    	System.out.println("User " + current.getId() + "has been updated!");
    }
    
    public void deleteUser() {
    	System.out.println("Enter User id: ");
    	String id = n.next();
    	User current = Data.findUserById(id);
    	
    	Data.deleteUser(current);

    	System.out.println("User " + current.getId() + "has been deleted!");
    }
    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        functions.put(startIndex++, new NamedRunnable(this::createUser, "Create User"));
        functions.put(startIndex++, new NamedRunnable(this::updateUser, "Update User"));
        functions.put(startIndex++, new NamedRunnable(this::deleteUser, "Delete User"));
        
        for(Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
        	functions.put(startIndex++, entry.getValue());
        }
        
        return functions;
    }
}
