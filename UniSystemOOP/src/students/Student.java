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

    
    private List<Document> documents;
    public Map<Course, Mark> courses;

    private int fails;
    private final int MAXCREDITS = 21;

    public Student() {
        super();
        this.documents = new ArrayList<>();
        this.courses = new HashMap<>();
    }

    public Student(String login, String password, String name, String surname) {
        super(login, password, name, surname);
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
//                ", studentOrganizations=" + studentOrganizations +
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
            if (course.equals(tempCourse)) { // Use equals method to compare courses
                existingCourse = course;
                break;
            }
        }

        // Check if the course is found in the system
        if (existingCourse == null) {
            System.out.println("No such course found in the system.");
            return false; // Return false as course is not found
        } else {
            System.out.println("Course already exists in the system.");
        }

        // Add the course to the student's enrolled courses if not already enrolled
        if (!courses.containsKey(existingCourse)) {
            courses.put(existingCourse, new Mark(0, 0, 0)); // Add with a default Mark
            System.out.println("Successfully registered for course: " + courseName);
            return true; // Registration successful
        } else {
            System.out.println("You are already registered for the course: " + courseName);
            return false; // Registration failed as the student is already registered
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
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            System.out.println("Course: " + course.getName() +
                    " | First Attestation: " + mark.getFirstAttestation() +
                    " | Second Attestation: " + mark.getSecondAttestation() +
                    " | Final Exam: " + mark.getFinalExam());
        }     
    }

    // Method to join an organization
    public void joinOrganization() {
        System.out.print("Enter the name of the organization you want to join: ");
        String orgName = n.next();

        // Fetch the list of organizations from Data
        Data data = Data.INSTANCE;

        // Look for the organization in the Data class
        StudentOrganization organization = null;
        for (StudentOrganization org : data.getStudentOrganizations()) { // Assuming getStudentOrganizations() returns a list of organizations
            if (org.getName().equalsIgnoreCase(orgName)) {
                organization = org;
                break;
            }
        }

        // If the organization exists, add the student to it using addMember()
        if (organization != null) {
            organization.addMember(this);  // Add the current student using the addMember method
            System.out.println("Successfully joined the organization: " + orgName);
        } else {
            // If the organization doesn't exist, print an error message
            System.out.println("Organization not found.");
        }
    }

    
    
    // Method to leave an organization
    public void leaveOrganization() {
        System.out.print("Enter the name of the organization you want to leave: ");
        String orgName = n.next();

        // Fetch the list of organizations from Data
        Data data = Data.INSTANCE;

        // Look for the organization in the Data class
        StudentOrganization organization = null;
        for (StudentOrganization org : data.getStudentOrganizations()) { // Using getStudentOrganizations to get the Vector
            if (org.getName().equalsIgnoreCase(orgName)) {
                organization = org;
                break;
            }
        }

        // If the organization exists, remove the student from it
        if (organization != null && organization.getStudents().contains(this)) {
            organization.removeMember(this);  // Assuming you have a method to remove a member in StudentOrganization
            System.out.println("Successfully left the organization: " + orgName);
        } else {
            System.out.println("You are not part of this organization.");
        }
    }
    
    
    public void viewStudentOrganizations() {
        // Fetch all organizations and check which ones this student is part of
        Data data = Data.INSTANCE;
        Vector<String> studentOrganizations = new Vector<>();

        // Iterate over all organizations
        for (StudentOrganization org : data.getStudentOrganizations()) {
            if (org.getStudents().contains(this)) {  // Check if this student is in the organization
                studentOrganizations.add(org.getName());  // Add organization name to the list
            }
        }

        // Display the organizations
        if (studentOrganizations.isEmpty()) {
            System.out.println("You are not part of any student organizations.");
        } else {
            System.out.println("Student Organizations:");
            for (String orgName : studentOrganizations) {
                System.out.println("- " + orgName);
            }
        }
    }    
    
    
    
    
    
    public void rateTeacher() {
        System.out.print("Enter the name of the teacher you want to rate: ");
        String teacherName = n.next();
        
        System.out.print("Enter the surname of the teacher you want to rate: ");
        String teacherSurName = n.next();
        
        System.out.print("Enter the rating (1-10): ");
        int rating = n.nextInt();
        
        // Validate rating
        if (rating < 1 || rating > 10) {
            System.out.println("Invalid rating. Please enter a rating between 1 and 10.");
            return;
        }

        System.out.println("Rated teacher " + teacherName + " " + teacherSurName + " with a score of " + rating + "/10.");

        // Find the teacher in the list of all teachers
        Teacher teacher = null;
        for (Teacher t : Data.INSTANCE.getAllTeachers()) {
            if (t.getName().equalsIgnoreCase(teacherName) && t.getSurname().equalsIgnoreCase(teacherSurName)) {
                teacher = t;
                break;
            }
        }

        if (teacher != null) {
            // Add the rating and update the average
            teacher.addRating((double) rating);
            teacher.updateAverageRating();
        } else {
            System.out.println("Teacher not found.");
        }
    }

    public void viewTranscript() {
        
    }


    public void getTranscript() {
        
    }
    
    
    
    
    
    
    
    public void addMarkToCourse(Course course, int firstAttestation, int secondAttestation, int finalExam) {
        // Create a new Mark object
        Mark mark = new Mark(firstAttestation, secondAttestation, finalExam);

        // Check if the course is already in the student's courses map
        if (courses.containsKey(course)) {
            // Update the mark if the course is already present
            courses.put(course, mark);
            System.out.println("Updated mark for course: " + course.getName());
        } else {
            // Add the course and the new mark if the course is not already in the map
            courses.put(course, mark);
            System.out.println("Added mark for course: " + course.getName());
        }
    } 
    public void addMarkToCourse(Course course, Mark mark) {
        // Check if the course is already in the student's courses map
        if (courses.containsKey(course)) {
            // Update the mark if the course is already present
            courses.put(course, mark);
            System.out.println("Updated mark for course: " + course.getName());
        } else {
            // Print an error message if the student is not registered for the course
            System.out.println("You are not registered for this course: " + course.getName());
        }
    }


    
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Add student-specific actions	
        functions.put(startIndex++, new NamedRunnable(this::viewCourses, "View Courses"));													//+
        functions.put(startIndex++, new NamedRunnable(this::registerForCourse, "Register for Course"));										//+
        functions.put(startIndex++, new NamedRunnable(this::viewTeacherInfo, "View Teacher Info"));											//+
        functions.put(startIndex++, new NamedRunnable(this::viewMarks, "View Marks"));														//+
        functions.put(startIndex++, new NamedRunnable(this::viewTranscript, "View Transcript"));											//
        functions.put(startIndex++, new NamedRunnable(this::getTranscript, "Get Transcript"));												//
        functions.put(startIndex++, new NamedRunnable(this::rateTeacher, "Rate Teacher"));													//+
        functions.put(startIndex++, new NamedRunnable(this::viewStudentOrganizations, "View Organizations"));								//+
        functions.put(startIndex++, new NamedRunnable(this::joinOrganization, "Join Organization"));										//+
        functions.put(startIndex++, new NamedRunnable(this::leaveOrganization, "Leave Organization"));										//+

   
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}