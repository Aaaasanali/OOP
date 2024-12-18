package employees;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Vector;

import database.Data;
import students.Student;

/**
* @generated
*/
public class Manager extends Employee implements Serializable {
    
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
    
    
    
    private void addStudent(String name) {
		System.out.println("Enter name: ");
		Data.INSTANCE.getAllStudents().add(new Student(name));
		System.out.println("Student added! ");
	}
    
    /*
	private void addCourse() {
		System.out.println("Enter name of the course: ");
		Data.INSTANCE.courses.add(new Course(in.next()));
		System.out.println("Course added! ");		
	}
	
	
	private void addCourseToStudent(Student s) {
		int i = in.nextInt()-1;
		Course c = Data.INSTANCE.courses.get(i);
		if(!s.courses.containsKey(c)) {
			s.courses.put(c, new Mark());
			System.out.println("Course "+Data.INSTANCE.courses.get(i) +" added to  "+s.name);	
		}
		else System.out.println("Student " + s.name+ " already registered to "+c);
	}
    */
    
}
