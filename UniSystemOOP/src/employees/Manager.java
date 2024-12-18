package employees;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class Manager extends Employee {

	private final Vector<String> functions = new Vector<>(Arrays.asList(
			"View Info", "View Courses",
			"View Requests", "Manage News",
			"Find Student", "Set Registration",
			"Add Courses", "Assign Course"));

	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex){
		
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		
		functions.put(startIndex++, new NamedRunnable(this::viewInfo, "View Info"));
		functions.put(startIndex++, new NamedRunnable(this::viewCourses, "View Courses"));
		functions.put(startIndex++, new NamedRunnable(this::viewRequests, "View Requests"));
		functions.put(startIndex++, new NamedRunnable(this::manageNews, "Manage News"));
		functions.put(startIndex++, new NamedRunnable(this::findStudent, "Find Student"));
		functions.put(startIndex++, new NamedRunnable(this::setRegistration, "Set Registration"));
		functions.put(startIndex++, new NamedRunnable(this::addCourses, "Add Courses"));
		functions.put(startIndex++, new NamedRunnable(this::assignCourse, "AssignCourse"));
		
		for(Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}
		
		return functions;
	}
	
	public Manager() {
		
	}
	
	public Manager(String login, String password) {
		
	}
	
	public void viewInfo() {
		
	}
	
	public void viewCourses() {
		
	}
	
	public void viewRequests() {
		
	}
	
	public void manageNews() {
		
	}
	
	public void findStudent() {
		
	}
	
	public Boolean setRegistration() {
		return null;
	}
	
	public void addCourses() {
		
	}
	
	public void assignCourse() {
		
	}
	
	public String getFunctions() {
		return "";
	}
	
}