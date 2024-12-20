package documents;

import java.util.*;

public class Speciality {

	Scanner inp = new Scanner(System.in);
	
    private String name;
    private String id;
    private String description;
    
    private ArrayList<Triplet<Integer, Semester, ArrayList<Course>>> carriculum;
    private Faculty faculty;
    
    private Speciality(String name, Faculty fac) {
    	this.name = name;
    	this.faculty = fac;
    }
    
    private void addCourseToCarriculum() {
    	System.out.println("Please enter year and Semester for adding courses to the Carriculum");
    	
    	System.out.print("Year:");
    	int year = inp.nextInt();
    	
    	System.out.print("Semester(FALL/SPRING): ");
    	Semester sem = Semester.valueOf(inp.next().toUpperCase());
    	
    	System.out.println("Current Curriculum of " + this.name +" for " + year + " Year, " + sem.toString() + "Semester: ");
    	
    	ArrayList<Course> cs = null;
    	for(Triplet<Integer, Semester, ArrayList<Course>> c : this.carriculum) {
    		if(c.getFirst() == year && c.getSecond().equals(sem)) {
    			cs = c.getThird();
    		}
    	}
    	
    	for(Course c : cs) {
    		System.out.println(c.toString());
    	}
    	
    	while(true) {
    		System.out.println("Enter ID of the Course you want to add ")
    	}
    	
    }
}
