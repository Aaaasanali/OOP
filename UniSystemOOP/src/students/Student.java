package students;

import java.io.Serializable;
import java.util.*;

import database.Data;
import documents.Course;
import documents.Document;
import documents.Mark;
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

    // Method to view the courses a student is enrolled in
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

    // Method to register for a course
    public void registerForCourse() {
        System.out.print("Enter the name of the course you want to register for: ");
        String courseName = n.next();
        System.out.print("Enter the year for the course: ");
        int year = n.nextInt();

        Course newCourse = new Course(courseName, year);

        if (!courses.containsKey(newCourse)) {
            courses.put(newCourse, new Mark(0, 0, 0)); // Add with a default Mark
            System.out.println("Successfully registered for course: " + courseName);
        } else {
            System.out.println("You are already registered for the course: " + courseName);
        }
    }

    // Method to view teacher information for a specific course
    public void viewTeacherInfo() {
        System.out.print("Enter the course name to view teacher info: ");
        String courseName = n.next();

        for (Course course : courses.keySet()) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                System.out.println("Teacher for " + courseName + ": " + course.getTeachers());
                return;
            }
        }
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
        functions.put(startIndex++, new NamedRunnable(this::viewCourses, "View Courses"));
        functions.put(startIndex++, new NamedRunnable(this::registerForCourse, "Register for Course"));
        functions.put(startIndex++, new NamedRunnable(this::viewTeacherInfo, "View Teacher Info"));
        functions.put(startIndex++, new NamedRunnable(this::viewMarks, "View Marks"));
        functions.put(startIndex++, new NamedRunnable(this::viewTranscript, "View Transcript"));
        functions.put(startIndex++, new NamedRunnable(this::getTranscript, "Get Transcript"));
        functions.put(startIndex++, new NamedRunnable(this::rateTeacher, "Rate Teacher"));
        functions.put(startIndex++, new NamedRunnable(this::joinOrganization, "Join Organization"));
        functions.put(startIndex++, new NamedRunnable(this::leaveOrganization, "Leave Organization"));

   
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}