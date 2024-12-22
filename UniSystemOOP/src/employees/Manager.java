package employees;

import java.io.IOException;
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
	
	private static final long serialVersionUID = 9134543246365552631L;
    
    private static List<Request> managerRequests = new ArrayList<>();


    public Manager(String login, String password) {
        super(login, password);
    }
//    public Manager() {
//		super();
//	}
    
    
    public static List<Request> getManagerRequests() {
        return managerRequests;
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

        Student newStudent = new Bachelor(login, password, firstName, lastName);
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
        System.out.println("Displaying all course registration requests...");

        // List all course registration requests
        Map<Course, Vector<Student>> courseRegistrations = Data.INSTANCE.getCourseRegistrations();
        int counter = 1;  // Start numbering from 1
        boolean hasRequests = false;  // Flag to check if there are any requests

        // Iterate through all courses and their corresponding registration requests
        for (Map.Entry<Course, Vector<Student>> entry : courseRegistrations.entrySet()) {
            Course course = entry.getKey();
            Vector<Student> students = entry.getValue();

            if (!students.isEmpty()) {
                System.out.println("\nCourse: " + course.getName() + " (" + course.getYear() + " " + course.getSemester() + ")");
                for (Student student : students) {
                    System.out.println(counter++ + ". " + student.getName() + " " + student.getSurname());
                }
                hasRequests = true;
            }
        }

        if (!hasRequests) {
            System.out.println("No registration requests available.");
            return;  // No pending requests, exit the method
        }

        // Prompt manager to choose a request to approve/reject
        String choiceInput = InputPrompt.promptInput("\nEnter the number of the registration request to approve/reject, or 'quit' to exit: ");
        if (choiceInput == null || choiceInput.equalsIgnoreCase("quit")) {
            return;  // Exit if user chooses 'quit'
        }

        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice < 1) {
                System.out.println("Invalid choice. Please select a valid number.");
                return;
            }

            // Find the course and student based on the manager's choice
            counter = 1;  // Reset counter for a second pass
            boolean found = false;
            for (Map.Entry<Course, Vector<Student>> entry : courseRegistrations.entrySet()) {
                Course course = entry.getKey();
                Vector<Student> students = entry.getValue();

                for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
                    Student student = iterator.next();

                    if (counter == choice) {
                        found = true;
                        // Ask manager to approve or reject
                        String action = InputPrompt.promptInput("Approve or Reject the registration of " + student.getName() + " for course " + course.getName() + "? (approve/reject): ");
                        if ("approve".equalsIgnoreCase(action)) {
                            Data.INSTANCE.approveRegistration(course, student);
                            iterator.remove();  // Remove the student from the registration list after approval
                        } else if ("reject".equalsIgnoreCase(action)) {
                            Data.INSTANCE.rejectRegistration(course, student);
                            iterator.remove();  // Optionally remove the student if rejected (or leave it for future reference)
                        } else {
                            System.out.println("Invalid action. Please choose 'approve' or 'reject'.");
                        }
                        break;
                    }
                    counter++;
                }
                if (found) break;
            }

            if (!found) {
                System.out.println("Invalid number. No registration found for that number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
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
    
    
   
    public boolean assignTeacherToCourse() {
        System.out.println("Type 'quit' at any time to exit");
        while (true) {
            try {
                // Prompt for the course name
                String courseName = InputPrompt.promptInput("Enter the name of the course you want to assign a teacher to: ");
                if (courseName == null) return false;

                // Prompt for the course year
                String yearInput = InputPrompt.promptInput("Enter the year for the course: ");
                if (yearInput == null) return false;
                int year = Integer.parseInt(yearInput);

                // Prompt for the semester
                String semesterInput = InputPrompt.promptInput("Enter the semester for the course (Fall/Spring/Summer): ");
                if (semesterInput == null) return false;
                Semester semester = Semester.valueOf(semesterInput.toUpperCase());

                // Fetch all available courses from Data
                Data data = Data.INSTANCE;

                // Search for the matching course
                Course tempCourse = new Course(courseName, year, semester);
                Course existingCourse = null;

                for (Course course : data.getAllCourses()) {
                    if (course.equals(tempCourse)) {
                        existingCourse = course;
                        break;
                    }
                }

                if (existingCourse == null) {
                    System.out.println("No such course found in the system.");
                    return false;
                }

                // Prompt for the teacher's first name
                String firstName = InputPrompt.promptInput("Enter the first name of the teacher you want to assign: ");
                if (firstName == null) return false;

                // Prompt for the teacher's surname
                String lastName = InputPrompt.promptInput("Enter the surname of the teacher you want to assign: ");
                if (lastName == null) return false;

                // Search for the teacher in the system
                Teacher foundTeacher = null;
                for (Teacher teacher : data.getAllTeachers()) {
                    if (teacher.getName().equalsIgnoreCase(firstName) && teacher.getSurname().equalsIgnoreCase(lastName)) {
                        foundTeacher = teacher;
                        break;
                    }
                }

                if (foundTeacher == null) {
                    System.out.println("No such teacher found in the system.");
                    return false;
                }

                // Check if the teacher is already assigned to this course
                if (existingCourse.getTeachers().contains(foundTeacher)) {
                    System.out.println("Teacher is already assigned to this course.");
                    return false;
                }

                // Assign the teacher to the course
                existingCourse.getTeachers().add(foundTeacher);

                // Print debug information
                System.out.println("Course's teachers after assignment: " + existingCourse.getTeachers());
                System.out.println("Successfully assigned " + foundTeacher.getName() + " " + foundTeacher.getSurname() + " to the course: " + courseName);

                // Save changes to data
                Data.write();
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester value. Please enter Fall, Spring, or Summer.");
            } catch (IOException e) {
                System.out.println("Failed to save changes. Try again.");
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    private void approveRequest(Request request) {
        // Logic for approving a request (e.g., register a student, add course, etc.)
        System.out.println("Request approved: " + request.toString());
        managerRequests.remove(request);
    }
    
    // Reject request method
    private void rejectRequest(Request request) {
        // Logic for rejecting a request
        System.out.println("Request rejected: " + request.toString());					
        managerRequests.remove(request);
    }

    // Receive a new request
    public static void receiveRequest(Request request) {
        managerRequests.add(request);
        
        //System.out.println("Request received: " + request.toString());				//TO LOGS
    }
    
    
    
    public void handleRequest() {
        if (managerRequests.isEmpty()) {
            System.out.println("No requests available.");
            return;
        }
        
        System.out.println("Available requests:");
        for (int i = 0; i < managerRequests.size(); i++) {
            System.out.println(i + 1 + ". " + managerRequests.get(i).toString());
        }

        int requestIndex = InputPrompt.promptIntInput("Select a request to handle (1 to " + managerRequests.size() + "): ");
        if (requestIndex < 1 || requestIndex > managerRequests.size()) {
            System.out.println("Invalid request selection.");
            return;
        }

        Request selectedRequest = managerRequests.get(requestIndex - 1);
        String action = InputPrompt.promptInput("Do you want to approve or reject this request? (approve/reject): ");
        
        if ("approve".equalsIgnoreCase(action)) {
            approveRequest(selectedRequest);
        } else if ("reject".equalsIgnoreCase(action)) {
            rejectRequest(selectedRequest);
        } else {
            System.out.println("Invalid action.");
        }
    }
    
    
    
    

    // Function map for the Manager
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Add manager-specific actions
        functions.put(startIndex++, new NamedRunnable(this::addStudent, "Add student"));
        functions.put(startIndex++, new NamedRunnable(this::createNews, "Create news"));
        functions.put(startIndex++, new NamedRunnable(this::addCourse, "Add new course"));
        functions.put(startIndex++, new NamedRunnable(this::approveStudentRegistration, "Approve student registration"));
//      functions.put(startIndex++, new NamedRunnable(this::registerStudentToCourse, "Register student to course"));
        functions.put(startIndex++, new NamedRunnable(this::assignTeacherToCourse, "Assign teacher to course"));
        functions.put(startIndex++, new NamedRunnable(this::handleRequest, "Handle requests"));
        
        
        // Add parent class functions
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}