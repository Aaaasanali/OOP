package documents;

import java.util.*;

import database.Data;

public class Speciality {

	Scanner inp = new Scanner(System.in);
	
    private String name;
    private String id;
    private String discription;
    
    private ArrayList<Triplet<Integer, Semester, ArrayList<Course>>> carriculum;
    private Faculty faculty;
    
    public Speciality(String name, Faculty fac) {
    	this.name = name;
    	this.faculty = fac;
    	this.carriculum = new ArrayList<Triplet<Integer, Semester, ArrayList<Course>>>();
    	this.emptyCarriculum();
    }
    
    public Speciality(String name, Faculty fac, Boolean test) {
    	this.name = name;
    	this.faculty = fac;
    	this.carriculum = new ArrayList<Triplet<Integer, Semester, ArrayList<Course>>>();
    	if(test) this.generateStandardCurriculum();
    }
    
    private void emptyCarriculum() {
    	for(int i=1; i<=4; i++) {
    		this.carriculum.add(new Triplet<>(i, Semester.FALL, new ArrayList<Course>()));
    		this.carriculum.add(new Triplet<>(i, Semester.SPRING, new ArrayList<Course>()));
    	}
    }
    
    public void addCourseToCarriculum() {
    	System.out.println("Please enter year and Semester for adding courses to the Carriculum");
    	
    	System.out.print("Year: ");
    	int year = inp.nextInt();
    	
    	System.out.print("Semester(FALL/SPRING): ");
    	Semester sem = Semester.valueOf(inp.next().toUpperCase());
    	
    	
    	
    	ArrayList<Course> cs = null;
    	for(Triplet<Integer, Semester, ArrayList<Course>> c : this.carriculum) {
    		if(c.getFirst() == year && c.getSecond().equals(sem)) {
    			cs = c.getThird();
    		}
    	}
    	
    	while(true) {
    		System.out.println("Current Curriculum of " + this.name +" for " + year + " Year, " + sem.toString() + " Semester: ");
    		for(Course c : cs) {
        		System.out.println(c.getName());
        	}
    		System.out.println("\nEnter ID of the Course you want to add (0 to leave)");
    		String ID = inp.next();
    		if(ID.equals("0")) return;
    		for(Course c : Data.INSTANCE.getAllCourses()) {
    			if(c.getId().equals(ID)) cs.add(c);
    		}
    		
    		System.out.println("Course Has Been Added!\n");
    	}
    	
    }
    
    public void viewCarriculum() {
    	
    	while(true) {
    		System.out.println("0 to leave");
        	System.out.print("Year: ");
        	int year = inp.nextInt();
    		ArrayList<Course> cs = null;
        	for(Triplet<Integer, Semester, ArrayList<Course>> c : this.carriculum) {
        		if(c.getFirst() == year) {
        			if(c.getSecond() == Semester.FALL) {
        				System.out.println("Fall Semester");
                		System.out.println("----------------------------------");
                		for(Course course : c.getThird()) {
                    		System.out.println(course.getName());
                    	}
                		continue;
        			}
            		System.out.println("\nSpring Semester");
            		System.out.println("----------------------------------");
            		for(Course course : c.getThird()) {
                		System.out.println(course.getName());
                	}
            		break;
        		}
        	}
        	System.out.println("\nAny Key to Leave");
        	inp.next();
    	}
    	
    	
    }
    
    private void generateStandardCurriculum() {
        // Generate curriculum for each year and semester
        for (int year = 1; year <= 4; year++) {
            for (Semester semester : Semester.values()) {
                ArrayList<Course> courses = generateCoursesForSemester(year, semester);
                carriculum.add(new Triplet<>(year, semester, courses));
            }
        }
    }

    private ArrayList<Course> generateCoursesForSemester(int year, Semester semester) {
        ArrayList<Course> courses = new ArrayList<>();

        switch (year) {
            case 1:
                if (semester == Semester.FALL) {
                    courses.add(new Course("Introduction to Programming", "CSE101", 2024, Semester.FALL));
                    courses.add(new Course("Discrete Mathematics", "MATH101", 2024, Semester.FALL));
                    courses.add(new Course("Introduction to CS", "CSE102", 2024, Semester.FALL));
                } else {
                    courses.add(new Course("Data Structures", "CSE103", 2024, Semester.SPRING));
                    courses.add(new Course("Linear Algebra", "MATH102", 2024, Semester.SPRING));
                    courses.add(new Course("Computer Organization", "CSE104", 2024, Semester.SPRING));
                }
                break;
            case 2:
                if (semester == Semester.FALL) {
                    courses.add(new Course("Algorithms", "CSE201", 2025, Semester.FALL));
                    courses.add(new Course("Probability and Statistics", "MATH201", 2025, Semester.FALL));
                    courses.add(new Course("Database Systems", "CSE202", 2025, Semester.FALL));
                } else {
                    courses.add(new Course("Operating Systems", "CSE203", 2025, Semester.SPRING));
                    courses.add(new Course("Software Engineering", "CSE204", 2025, Semester.SPRING));
                    courses.add(new Course("Artificial Intelligence", "CSE205", 2025, Semester.SPRING));
                }
                break;
            case 3:
                if (semester == Semester.FALL) {
                    courses.add(new Course("Machine Learning", "CSE301", 2026, Semester.FALL));
                    courses.add(new Course("Computer Networks", "CSE302", 2026, Semester.FALL));
                    courses.add(new Course("Cybersecurity", "CSE303", 2026, Semester.FALL));
                } else {
                    courses.add(new Course("Web Development", "CSE304", 2026, Semester.SPRING));
                    courses.add(new Course("Mobile App Development", "CSE305", 2026, Semester.SPRING));
                    courses.add(new Course("Cloud Computing", "CSE306", 2026, Semester.SPRING));
                }
                break;
            case 4:
                if (semester == Semester.FALL) {
                    courses.add(new Course("Advanced Algorithms", "CSE401", 2027, Semester.FALL));
                    courses.add(new Course("Big Data Analytics", "CSE402", 2027, Semester.FALL));
                    courses.add(new Course("Blockchain Technology", "CSE403", 2027, Semester.FALL));
                } else {
                    courses.add(new Course("Capstone Project", "CSE404", 2027, Semester.SPRING));
                    courses.add(new Course("Quantum Computing", "CSE405", 2027, Semester.SPRING));
                    courses.add(new Course("Robotics", "CSE406", 2027, Semester.SPRING));
                }
                break;
        }

        return courses;
    }
}
