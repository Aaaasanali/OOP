package employees;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import database.Data;
import documents.Course;
import news.News;
import students.Student;

/**
* @generated
*/
public class Manager extends Employee implements Serializable {
	
	Scanner scanner = new Scanner(System.in);
	
	private final Vector<String> functions = new Vector<>(Arrays.asList("Create Student", "Create Someone", "Find Student"));
	
    public Manager(String login, String password) {
    	super(login, password);
    }
    
    public String getFunc() {
    	String res = "";
    	for(String i : functions) {
    		res += i + "\n";
    	}
    	res += super.getFunc();
    	return res;
    }
    
    
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter student's first name: ");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter student's last name: ");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter student's login: ");
        String login = scanner.nextLine();
        
        System.out.println("Enter student's password: ");
        String password = scanner.nextLine();
        

        Student newStudent = new Student(login, password, firstName, lastName);
        

        Data.INSTANCE.addUser(newStudent);
        

        System.out.println("Student added successfully!");
    }
    
    public void approveStudentRegistration() {
    	
    }
    
    
    
	private void addCourse() {
		
	}
	
	
	private void registerStudentToCourse(Student s) {
		
	}
    
    
    
    
    public void createNews() {

        System.out.print("Enter news title: ");
        String title = scanner.nextLine();

        System.out.print("Enter news content: ");
        String content = scanner.nextLine();

        System.out.print("Pin this news? (yes/no): ");
        String pinInput = scanner.nextLine();
        boolean isPinned = pinInput.equalsIgnoreCase("yes");


        News news = new News(title, content, isPinned, new ArrayList<>());

        Data.news.add(news);

        System.out.println("News created and added successfully!");
    }    
    
    
    
    
    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Add student-specific actions	
        functions.put(startIndex++, new NamedRunnable(this::addStudent, "Add student"));
        functions.put(startIndex++, new NamedRunnable(this::createNews, "Create news"));												
        functions.put(startIndex++, new NamedRunnable(this::approveStudentRegistration, "Approve student registration"));
        functions.put(startIndex++, new NamedRunnable(this::approveStudentRegistration, "Add new course"));
        functions.put(startIndex++, new NamedRunnable(this::approveStudentRegistration, "Register student to course"));
   
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}
