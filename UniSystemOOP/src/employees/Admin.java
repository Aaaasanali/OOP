package employees;

import user.User;
import user.UserFactory;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import Interfaces.CreatingUsers;
import database.Data;

public class Admin extends User implements CreatingUsers, Serializable {

    private Scanner n = new Scanner(System.in);

    public Admin(String login, String password) {
        super(login, password);
        Data.addUser(this);
    }

    public void setUniName(String name) {
        Data.setUniName(name);
    }

    public void createUser() {
        System.out.println("Type 'quit' at any time to exit");
        
        System.out.println("Enter User Type: ");
        String userType = null;
        while (userType == null) {
            userType = n.nextLine().toUpperCase();
            if (userType.equals("QUIT")) {
                System.out.println("Operation cancelled.");
                return; // Exit the method
            }

            if (userType.isEmpty()) {
                System.out.println("User type cannot be empty. Please enter a valid user type.");
                userType = null; // Reset to prompt again
            }
        }
        
        User current = UserFactory.getUser(userType, this);
        System.out.println("Enter Login: ");
        String login = n.nextLine();
        current.setLogin(login);

        System.out.println(current.getClass().getSimpleName() + " has been created\nlogin: " + current.getLogin() + "\npassword: " + current.getPassword());
    }

    public void updateUser() {
        System.out.println("Type 'quit' at any time to exit");
        
        String id = null;
        while (id == null) {
            System.out.println("Enter User id: ");
            id = n.nextLine();
            if (id.equals("quit")) {
                System.out.println("Operation cancelled.");
                return; // Exit the method
            }

            if (id.isEmpty()) {
                System.out.println("User ID cannot be empty. Please enter a valid User ID.");
                id = null; // Reset to prompt again
            }
        }

        User current = Data.findUserById(id);
        if (current == null) {
            System.out.println("User not found with the ID: " + id);
            return; // Exit if user not found
        }

        current.changeData();
        System.out.println("User " + current.getId() + " has been updated!");
    }

    public void deleteUser() {
        System.out.println("Type 'quit' at any time to exit");
        
        String id = null;
        while (id == null) {
            System.out.println("Enter User id: ");
            id = n.nextLine();
            if (id.equals("quit")) {
                System.out.println("Operation cancelled.");
                return; // Exit the method
            }

            if (id.isEmpty()) {
                System.out.println("User ID cannot be empty. Please enter a valid User ID.");
                id = null; // Reset to prompt again
            }
        }

        User current = Data.findUserById(id);
        if (current == null) {
            System.out.println("User not found with the ID: " + id);
            return; // Exit if user not found
        }

        Data.deleteUser(current);
        System.out.println("User " + current.getId() + " has been deleted!");
    }

    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        functions.put(startIndex++, new NamedRunnable(this::createUser, "Create User"));
        functions.put(startIndex++, new NamedRunnable(this::updateUser, "Update User"));
        functions.put(startIndex++, new NamedRunnable(this::deleteUser, "Delete User"));
        
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }
        
        return functions;
    }
}