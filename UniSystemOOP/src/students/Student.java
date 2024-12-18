package students;

import java.io.Serializable;
import java.util.*;

import database.Data;
import documents.Course;
import documents.Document;
import documents.Mark;
import documents.Semester;
import employees.Teacher;
import oop.NamedRunnable;
import user.User;

public class Student extends User implements Serializable {

    private Scanner n = new Scanner(System.in);  // Scanner for user input

    private int admissionYear;
    private Speciality speciality;
    private String faculty;
    private StudyType studyType;

    private List<String> studentOrganizations;
    private List<Document> documents;
    private Map<Course, Mark> courses;

    private int fails;
    private final int MAXCREDITS = 21;

    public Student() {
        super();
        this.studentOrganizations = new ArrayList<>();
        this.documents = new ArrayList<>();
        this.courses = new HashMap<>();
    }

    public Student(String login, String password, String name, String surname, String id) {
        super(login, password, name, surname, id);
        this.studentOrganizations = new ArrayList<>();
        this.documents = new ArrayList<>();
        this.courses = new HashMap<>();
    }

    public Student(String name) {
        super.setName(name);
    }

    // Getter and Setter methods
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<String> getOrganization() {
        return this.studentOrganizations;
    }

    private int getMAXCREDITS() {
        return this.MAXCREDITS;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Student{" +
                "admissionYear=" + admissionYear +
                ", speciality=" + speciality +
                ", studyType=" + studyType +
                ", faculty='" + faculty + '\'' +
                ", studentOrganizations=" + studentOrganizations +
                ", fails=" + fails +
                ", MAXCREDITS=" + MAXCREDITS +
                ", documents=" + documents +
                '}';
    }


    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses registered yet.");
            return;
        }

        System.out.println("Enrolled Courses:");
        for (Course course : courses.keySet()) {
            System.out.println("- " + course.getName());
        }
    }


    public boolean registerForCourse() {
        // Prompt user for course details
        System.out.print("Enter the name of the course you want to register for: ");
        String courseName = n.next();
        System.out.print("Enter the year for the course: ");
        int year = n.nextInt();
        System.out.print("Enter the semester for the course (FALL/SPRING): ");
        Semester semester = Semester.valueOf(n.next().toUpperCase());

        Data data = Data.INSTANCE;

        // Create a temporary course object to search for matches
        Course tempCourse = new Course(courseName, year, semester);
        Course existingCourse = null;

        // Search for an existing course in the system
        for (Course course : data.courses) {
            if (course.equals(tempCourse)) { // Use equals method
                existingCourse = course;
                break;
            }
        }

        // If no existing course is found, create a new one
        if (existingCourse == null) {
            data.courses.add(tempCourse); // Add the new course to the system
            System.out.println("New course added to the system.");
            existingCourse = tempCourse; // Use the newly created course
        } else {
            System.out.println("Course already exists in the system.");
        }

        // Add the course to the student's enrolled courses
        if (!courses.containsKey(existingCourse)) {
            courses.put(existingCourse, new Mark(0, 0, 0)); // Add with a default Mark
            System.out.println("Successfully registered for course: " + courseName);
            return true; // Registration successful
        } else {
            System.out.println("You are already registered for the course: " + courseName);
            return false; // Registration failed
        }
    }    
    
    
    
    

    // Method to view teacher information for a specific course
    public void viewTeacherInfo() {
        // Prompt the user for course details
        System.out.print("Enter the course name to view teacher info: ");
        String courseName = n.next();
        System.out.print("Enter the year for the course: ");
        int year = n.nextInt();
        System.out.print("Enter the semester for the course (FALL/SPRING): ");
        Semester semester = Semester.valueOf(n.next().toUpperCase());

        // Iterate through the enrolled courses
        for (Course course : courses.keySet()) {
            if (course.getName().equalsIgnoreCase(courseName) &&
                course.getYear() == year &&
                course.getSemester() == semester) {
                // Print the teacher information if the course matches
                System.out.println("Teachers for " + courseName + ": ");
                if (course.getTeachers() != null && !course.getTeachers().isEmpty()) {
                    for (Teacher teacher : course.getTeachers()) {
                        System.out.println("- " + teacher);  // Will call Teacher's toString() method
                    }
                } else {
                    System.out.println("No teachers assigned to this course.");
                }
                return;
            }
        }

        // If no course is found, print an error message
        System.out.println("Course not found!");
    }
    
    

    // Method to view marks
    public void viewMarks() {
        if (courses.isEmpty()) {
            System.out.println("No marks to display.");
            return;
        }
        for (Map.Entry<Course, Mark> entry : courses.entrySet()) {
            System.out.println("Course: " + entry.getKey().getName() + " - Mark: " + entry.getValue());
        }
    }

    // Method to join an organization
    public void joinOrganization() {
        System.out.print("Enter the name of the organization you want to join: ");
        String orgName = n.next();
        studentOrganizations.add(orgName);
        System.out.println("Joined the organization: " + orgName);
    }

    // Method to leave an organization
    public void leaveOrganization() {
        System.out.print("Enter the name of the organization you want to leave: ");
        String orgName = n.next();

        if (studentOrganizations.contains(orgName)) {
            studentOrganizations.remove(orgName);
            System.out.println("Left the organization: " + orgName);
        } else {
            System.out.println("You are not part of this organization.");
        }
    }

    
    public void rateTeacher() {
//        System.out.print("Enter the name of the teacher you want to rate: ");
//        String teacherName = n.next();
//        System.out.print("Enter the rating (1-10): ");
//        int rating = n.nextInt();
//        System.out.println("Rated teacher " + teacherName + " with a score of " + rating + "/10.");
    }


    public void viewTranscript() {
        
    }


    public void getTranscript() {
        
    }

    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Add student-specific actions	
        functions.put(startIndex++, new NamedRunnable(this::viewCourses, "View Courses"));													//+
        functions.put(startIndex++, new NamedRunnable(this::registerForCourse, "Register for Course"));										//+
        functions.put(startIndex++, new NamedRunnable(this::viewTeacherInfo, "View Teacher Info"));											//+
        functions.put(startIndex++, new NamedRunnable(this::viewMarks, "View Marks"));														//
        functions.put(startIndex++, new NamedRunnable(this::viewTranscript, "View Transcript"));											//
        functions.put(startIndex++, new NamedRunnable(this::getTranscript, "Get Transcript"));												//
        functions.put(startIndex++, new NamedRunnable(this::rateTeacher, "Rate Teacher"));													//
        functions.put(startIndex++, new NamedRunnable(this::joinOrganization, "Join Organization"));										//
        functions.put(startIndex++, new NamedRunnable(this::leaveOrganization, "Leave Organization"));										//

   
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}