package employees;

import java.io.Serializable;
import java.util.*;

import communication.*;
import database.*;
import documents.*;
import employees.*;
import Factories.*;
import Factories.NamedRunnable;
import Interfaces.*;
import news.*;
import oop.*;
import research.*;
import students.*;
import user.*;
import utils.InputPrompt; 

/**
 * @generated
 */
public class Manager extends Employee implements Serializable {

    private transient final Scanner n = new Scanner(System.in);
    private final Vector<String> functions = new Vector<>(Arrays.asList("Create Student", "Create Someone", "Find Student"));

    public Manager(String login, String password) {
        super(login, password);
    }

    public String getFunc() {
        String res = "";
        for (String i : functions) {
            res += i + "\n";
        }
        res += super.getFunc();
        return res;
    }

    // Add a new student
    public void addStudent() {
        System.out.println("Type 'quit' at any time to exit");

        String firstName = InputPrompt.promptInput("Enter student's first name: ");
        if (firstName == null) return;

        String lastName = InputPrompt.promptInput("Enter student's last name: ");
        if (lastName == null) return;

        String login = InputPrompt.promptInput("Enter student's login: ");
        if (login == null) return;

        String password = InputPrompt.promptInput("Enter student's password: ");
        if (password == null) return;

        Student newStudent = new Student(login, password, firstName, lastName);
        Data.INSTANCE.addUser(newStudent);

        System.out.println("Student added successfully!");
    }

    // Add a new course
    public void addCourse() {
        System.out.println("Type 'quit' at any time to exit");

        String courseName = InputPrompt.promptInput("Enter course name: ");
        if (courseName == null) return;

        int year = InputPrompt.promptIntInput("Enter year: ");
        if (year == -1) return;

        // Ask for semester as a string (e.g., Spring, Fall, Summer)
        String semesterInput = InputPrompt.promptInput("Enter semester (Spring, Fall, Summer): ");
        if (semesterInput == null) return;

        // Convert to uppercase for uniformity
        String semesterStr = semesterInput.toUpperCase();
        Semester semester = null;

        switch (semesterStr) {
            case "SPRING":
                semester = Semester.SPRING;
                break;
            case "FALL":
                semester = Semester.FALL;
                break;
            case "SUMMER":
                semester = Semester.SUMMER;
                break;
            default:
                System.out.println("Invalid semester choice.");
                return;
        }

        int numberOfTeachers = InputPrompt.promptIntInput("Enter the number of teachers for this course: ");
        if (numberOfTeachers == -1) return;

        Vector<Teacher> courseTeachers = new Vector<>();
        for (int i = 0; i < numberOfTeachers; i++) {
            String teacherLogin = InputPrompt.promptInput("Enter the login of teacher " + (i + 1) + ": ");
            if (teacherLogin == null) return;

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

    // Create news
    public void createNews() {
        System.out.println("Type 'quit' at any time to exit");

        String title = InputPrompt.promptInput("Enter news title: ");
        if (title == null) return;

        String content = InputPrompt.promptInput("Enter news content: ");
        if (content == null) return;

        String pinInput = InputPrompt.promptInput("Pin this news? (yes/no): ");
        if (pinInput == null) return;
        boolean isPinned = pinInput.equalsIgnoreCase("yes");

        News news = new News(title, content, isPinned, new ArrayList<>());
        Data.INSTANCE.news.add(news);

        System.out.println("News created and added successfully!");
    }
    
    
    
    
    public void approveStudentRegistration() {
        
    }
    
    
    
    public void registerStudentForCourse() {
    	/*
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
        */
    }
    
    

    // Function map for the Manager
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Add manager-specific actions
        functions.put(startIndex++, new NamedRunnable(this::addStudent, "Add student"));
        functions.put(startIndex++, new NamedRunnable(this::createNews, "Create news"));
        functions.put(startIndex++, new NamedRunnable(this::addCourse, "Add new course"));
//      functions.put(startIndex++, new NamedRunnable(this::approveStudentRegistration, "Approve student registration"));
//      functions.put(startIndex++, new NamedRunnable(this::registerStudentToCourse, "Register student to course"));

        // Add parent class functions
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}