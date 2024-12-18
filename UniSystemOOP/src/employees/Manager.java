package employees;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import database.Data;
import documents.Course;
import documents.Mark;
import documents.Semester;
import news.News;
import students.Student;

/**
* @generated
*/
public class Manager extends Employee implements Serializable {
	
	Scanner n = new Scanner(System.in);
	
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
        
        
        System.out.println("Enter student's first name: ");
        String firstName = n.nextLine();
        
        System.out.println("Enter student's last name: ");
        String lastName = n.nextLine();
        
        System.out.println("Enter student's login: ");
        String login = n.nextLine();
        
        System.out.println("Enter student's password: ");
        String password = n.nextLine();
        

        Student newStudent = new Student(login, password, firstName, lastName);
        

        Data.INSTANCE.addUser(newStudent);
        

        System.out.println("Student added successfully!");
    }
    /*
    public void registerStudentForCourse() {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input student ID
        System.out.print("Enter the student ID: ");
        int studentId = scanner.nextInt();

        // Find the student by ID
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return; // Exit the method if the student is not found
        }

        // Ask the user to select a course
        System.out.println("Select a course by entering the course index (0 to " + (courses.size() - 1) + "): ");
        int courseIndex = scanner.nextInt();
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course selection.");
            return; // Exit if the course selection is invalid
        }
        Course course = courses.get(courseIndex);

        // Check if the student is already registered for the course
        if (student.getCourses().containsKey(course)) {
            System.out.println("The student is already registered for the course: " + course.getName());
        } else {
            // Register the student for the course
            if (student.registerForCourse(course)) {
                System.out.println("Successfully registered for the course: " + course.getName());
            } else {
                System.out.println("Registration failed.");
            }
        }
    }*/
    
    private Student findStudentById(String studentId) {
        for (Student student : Data.INSTANCE.getAllStudents()) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null; // Student not found
    }
    
    
    public void addCourse() {

        

        System.out.println("Enter course name: ");
        String courseName = n.nextLine();

        System.out.println("Enter year: ");
        int year = n.nextInt();

        //Choose semester
        System.out.println("Enter semester (1 for Spring, 2 for Fall, 3 for Summer): ");
        int semesterChoice = n.nextInt();
        Semester semester = null;
        
        switch(semesterChoice) {
            case 1:
                semester = Semester.SPRING;
                break;
            case 2:
                semester = Semester.FALL;
                break;
            case 3:
                semester = Semester.SUMMER;
                break;
            default:
                System.out.println("Invalid semester choice.");
                return; 
        }
        
        System.out.println("Enter the number of teachers for this course: ");
        int numberOfTeachers = n.nextInt();
        n.nextLine(); 

        Vector<Teacher> courseTeachers = new Vector<>();
        
        for (int i = 0; i < numberOfTeachers; i++) {
            System.out.println("Enter the login of teacher " + (i + 1) + ": ");
            String teacherLogin = n.nextLine();
            

            Teacher teacher = null;
            for (Teacher t : Data.INSTANCE.getAllTeachers()) {
                if (t.getLogin().equals(teacherLogin)) {
                    teacher = t;
                    break;
                }
            }

            if (teacher != null) {
                courseTeachers.add(teacher);
            } else {
                System.out.println("Teacher not found: " + teacherLogin);
            }
        }

        Course newCourse = new Course(courseName, year, semester);
        newCourse.setTeachers(courseTeachers);
        Data.INSTANCE.addCourse(newCourse);
        System.out.println("Course added successfully!");
    }	
	
    public void registerStudentForCourse() {
        
    }
    
    
    
    
    public void createNews() {

        System.out.print("Enter news title: ");
        String title = n.nextLine();

        System.out.print("Enter news content: ");
        String content = n.nextLine();

        System.out.print("Pin this news? (yes/no): ");
        String pinInput = n.nextLine();
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
        functions.put(startIndex++, new NamedRunnable(this::addCourse, "Add new course"));
        functions.put(startIndex++, new NamedRunnable(this::registerStudentToCourse, "Register student to course"));
   
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}
