package students;

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
 * Represents a student in the system.
 * 
 * <p>The `Student` class provides methods and attributes specific to a student's
 * academic and extracurricular activities, such as course registration, viewing marks,
 * managing organizations, and interacting with the system. Students have unique
 * attributes like admission year, specialty, faculty, and study type.</p>
 * 
 * <b>Main Features:</b>
 * <ul>
 *   <li>Course management: Register, view, and add marks for courses.</li>
 *   <li>Interaction with teachers: View and rate teachers.</li>
 *   <li>Extra: Join, leave, and view student organizations.</li>
 * </ul>
 */
public abstract class Student extends User implements Serializable {

    private int admissionYear;
    private Speciality speciality;
    private String faculty;
    private StudyType studyType;

    private List<Document> documents;
    public Map<Course, Mark> courses;

    private int fails;
    private final int MAXCREDITS = 21;
    	
    	//Constructors
    public Student() {
        super();
        this.documents = new ArrayList<>();
        this.courses = new HashMap<>();
    }

    public Student(String login, String password, String name, String surname) {
        
        this.documents = new ArrayList<>();
        this.courses = new HashMap<>();
    }

    public Student(String login, String password) {
        super(login, password);
        this.documents = new ArrayList<>();
        this.courses = new HashMap<>();
    }
    
    public Student(String login, String password, String name, String surname, int admissionYear, Speciality speciality, String faculty, StudyType studyType,
		List<Document> documents, Map<Course, Mark> courses, int fails) {
		
    	super(login, password, name, surname);
		this.admissionYear = admissionYear;
		this.speciality = speciality;
		this.faculty = faculty;
		this.studyType = studyType;
		this.documents = documents;
		this.courses = courses;
		this.fails = fails;
	}

		//Getters and setters
    
    /**
     * Retrieves the faculty of the student.
     * 
     * @return the faculty name as a string.
     */
    public String getFaculty() {
        return faculty;
    }
   
    /**
     * Sets the faculty of the student.
     * 
     * @param faculty the name of the faculty to set.
     */
    public void setFaculty(String faculty) {
    	
    	
    	this.faculty = faculty;
    }
    
    /**
     * Retrieves the id of the user.
     * 
     * @return the id as integer.
     */
    public String getId() {
        return super.getId();
    }
    
    /**
     * Retrieves the maximum allowed credits for a student.
     * 
     * @return the maximum credit limit a student can take.
     */
    private int getMAXCREDITS() {
        return this.MAXCREDITS;
    }

    /**
     * Retrieves the courses and corresponding marks for the student.
     * 
     * @return a map where the key is the course and the value is the associated mark.
     */
    public Map<Course, Mark> getCourses() {
        return courses;
    }



    
    
    /**
     * Displays a list of courses the student is enrolled in.
     * 
     * <p>If the student is not enrolled in any courses, a message will be displayed.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Enrolled Courses:
     * - OOP
     * - ADS
     * </pre>
     */
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
    
    //Will be changed
    public boolean registerForCourse() {
        System.out.println("Type 'quit' at any time to exit");
        
        while (true) {
            try {
                String courseName = InputPrompt.promptInput("Enter the name of the course you want to register for: ");
                if (courseName == null || courseName.equalsIgnoreCase("quit")) return false;
                
                String yearInput = InputPrompt.promptInput("Enter the year for the course: ");
                if (yearInput == null || yearInput.equalsIgnoreCase("quit")) return false;
                int year = Integer.parseInt(yearInput);

                String semesterInput = InputPrompt.promptInput("Enter the semester for the course (Fall/Spring/Summer): ");
                if (semesterInput == null || semesterInput.equalsIgnoreCase("quit")) return false;
                Semester semester = Semester.valueOf(semesterInput.toUpperCase());

                Data data = Data.INSTANCE;

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

                // Send registration request to manager
                data.addRegistrationRequest(existingCourse, this);
                System.out.println("Registration request for " + courseName + " has been sent to the manager for approval.");
                return true;

            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester value. Please enter Fall, Spring, or Summer.");
            }
        }
    }
        
    /**
     * Displays the teacher information for a specific course based on user input.
     * 
     * <p>This method prompts the user to enter details of a course, including its name, year, 
     * and semester, and then searches for a matching course in the system. If the course 
     * is found, it lists the assigned teachers. If no teachers are assigned or if the course 
     * is not found, appropriate messages are displayed.</p>
     * 
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Enter the course name to view teacher info: Math101
     * Enter the year for the course: 2024
     * Enter the semester for the course (Fall/Spring/Summer): Fall
     * Teachers for OOP: 
     * - Teacher Name: Pakizar Shamoi, Rating: 0.0, Teacher Type: Not assigned
     * - Teacher Name: Alimzhan Amanov, Rating: 0.0, Teacher Type: Not assigned
     * </pre>
     * 
     */
    public void viewTeacherInfo() {
    	System.out.println("Type 'quit' at any time to exit");
        while (true) {
            try {
                String courseName = InputPrompt.promptInput("Enter the course name to view teacher info: ");
                if (courseName == null) return;

                String yearInput = InputPrompt.promptInput("Enter the year for the course: ");
                if (yearInput == null) return;
                int year = Integer.parseInt(yearInput);

                String semesterInput = InputPrompt.promptInput("Enter the semester for the course (Fall/Spring/Summer): ");
                if (semesterInput == null) return;
                Semester semester = Semester.valueOf(semesterInput.toUpperCase());

                for (Course course : courses.keySet()) {
                    if (course.getName().equalsIgnoreCase(courseName) &&
                            course.getYear() == year &&
                            course.getSemester() == semester) {
                        System.out.println("Teachers for " + courseName + ": ");
                        if (course.getTeachers() != null && !course.getTeachers().isEmpty()) {
                            for (Teacher teacher : course.getTeachers()) {
                                System.out.println("- " + teacher);
                            }
                        } else {
                            System.out.println("No teachers assigned to this course.");
                        }
                        return;
                    }
                }
                System.out.println("Course not found!");
                return;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester value. Please enter Fall, Spring, or Summer.");
            }
        }
    }
    
    /**
     * Displays the student's marks for all enrolled courses.
     * 
     * <p>For each course, the first attestation, second attestation, and final exam scores
     * are shown. If no courses are enrolled, a message is displayed.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Course: OOP | First Attestation: 20 | Second Attestation: 25 | Final Exam: 30
     * Course: Data Structures | First Attestation: 18 | Second Attestation: 22 | Final Exam: 28
     * </pre>
     */
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
    
    /**
     * Displays a detailed transcript of the student's academic performance.
     * 
     * <p>Includes course names, ECTS credits, overall scores, letter grades, and GPA.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Course: OOP | ECTS: 5 | Overall score: 75 | Letter grade: B | GPA: 3.0
     * Course: Data Structures | ECTS: 4 | Overall score: 82 | Letter grade: A | GPA: 4.0
     * </pre>
     */
    public void viewTranscript() {

    	if (courses.isEmpty()) {
            System.out.println("No marks to display.");
            return;
        }
        for (Map.Entry<Course, Mark> entry : courses.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            System.out.println("Course: " + course.getName() +
            		" | ECTS: " + course.getCredits() +
                    " | Overall score: " + mark.getScore() + 
                    " | Letter grade: " + mark.calculateLetterGrade() + 
            		" | GPA: " + mark.calculateGrade()
            		
            		);
        }
    }

    /**
     * Allows the student to rate a teacher.
     * 
     * <p>The student inputs the teacher's name, surname, and a rating between 1 and 10.
     * If the teacher is found, the rating is added to their record and their average
     * rating is updated.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Enter the name of the teacher you want to rate: Pakizar
     * Enter the surname of the teacher you want to rate: Shamoi
     * Enter the rating (1-10): 10
     * Rated teacher Pakizar Shamoi a score of 10/10.
     * </pre>
     */
    public void rateTeacher() {
    	System.out.println("Type 'quit' at any time to exit");
        while (true) {
            try {
                String teacherName = InputPrompt.promptInput("Enter the name of the teacher you want to rate: ");
                if (teacherName == null) return;

                String teacherSurName = InputPrompt.promptInput("Enter the surname of the teacher you want to rate: ");
                if (teacherSurName == null) return;

                String ratingInput = InputPrompt.promptInput("Enter the rating (1-10): ");
                if (ratingInput == null) return;
                int rating = Integer.parseInt(ratingInput);

                if (rating < 1 || rating > 10) {
                    System.out.println("Invalid rating. Please enter a rating between 1 and 10.");
                    continue;
                }

                System.out.println("Rated teacher " + teacherName + " " + teacherSurName + " with a score of " + rating + "/10.");

                Teacher teacher = null;
                for (Teacher t : Data.INSTANCE.getAllTeachers()) {
                    if (t.getName().equalsIgnoreCase(teacherName) && t.getSurname().equalsIgnoreCase(teacherSurName)) {
                        teacher = t;
                        break;
                    }
                }

                if (teacher != null) {
                    teacher.addRating((double) rating);
                    teacher.updateAverageRating();
                } else {
                    System.out.println("Teacher not found.");
                }
                return;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter correct values.");
            }
        }
    }
    
    /**
     * Allows the student to join a student organization.
     * 
     * <p>The student enters the name of the organization they wish to join. If the organization exists,
     * the student is added as a member.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Enter the name of the organization you want to join: Coding Club
     * Successfully joined the organization: Coding Club.
     * </pre>
     */
    public void joinOrganization() {
        System.out.println("Type 'quit' at any time to exit.");
        String orgName = InputPrompt.promptInput("Enter the name of the organization you want to join: ");
        if (orgName == null) return;

        Data data = Data.INSTANCE;
        StudentOrganization organization = null;
        for (StudentOrganization org : data.getStudentOrganizations()) {
            if (org.getName().equalsIgnoreCase(orgName)) {
                organization = org;
                break;
            }
        }

        if (organization != null) {
            organization.addMember(this);
            System.out.println("Successfully joined the organization: " + orgName);
        } else {
            System.out.println("Organization not found.");
        }
    }
    
    /**
     * Allows the student to leave a student organization they are part of.
     * 
     * <p>The student enters the name of the organization they wish to leave. If they are a member of
     * the organization, they are removed from its list of members.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Enter the name of the organization you want to leave: Coding Club
     * Successfully left the organization: Coding Club.
     * </pre>
     */
    public void leaveOrganization() {
    	System.out.println("Type 'quit' at any time to exit");
        String orgName = InputPrompt.promptInput("Enter the name of the organization you want to leave: ");
        if (orgName == null) return;

        Data data = Data.INSTANCE;
        StudentOrganization organization = null;
        for (StudentOrganization org : data.getStudentOrganizations()) {
            if (org.getName().equalsIgnoreCase(orgName)) {
                organization = org;
                break;
            }
        }

        if (organization != null && organization.getStudents().contains(this)) {
            organization.removeMember(this);
            System.out.println("Successfully left the organization: " + orgName);
        } else {
            System.out.println("You are not part of this organization.");
        }
    }
    
    /**
     * Displays a list of student organizations the student is a member of.
     * 
     * <p>If the student is not part of any organization, a message is displayed.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Student Organizations:
     * - Coding Club
     * - Robotics Society
     * </pre>
     */
    public void viewStudentOrganizations() {

        Data data = Data.INSTANCE;
        Vector<String> studentOrganizations = new Vector<>();

        for (StudentOrganization org : data.getStudentOrganizations()) {
            if (org.getStudents().contains(this)) {
                studentOrganizations.add(org.getName());
            }
        }

        if (studentOrganizations.isEmpty()) {
            System.out.println("You are not part of any student organizations.");
        } else {
            System.out.println("Student Organizations:");
            for (String orgName : studentOrganizations) {
                System.out.println("- " + orgName);
            }
        }
    }
        
    /**
     * Adds or updates marks for a specific course.
     * 
     * @param - the course for which marks are being added.
     * @param firstAttestation - score for the first attestation.
     * @param secondAttestation - score for the second attestation.
     * @param finalExam - score for the final exam.
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Added mark for course: OOP
     * Updated mark for course: ADS
     * </pre>
     */
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
    
    /**
     * Adds or updates a mark for a specific course.
     * 
     * @param course - the course for which the mark is being added or updated.
     * @param mark - the mark object containing scores for the course.
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Added mark for course: Math101
     * Updated mark for course: Data Structures
     * </pre>
     */
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
    
    /**
     * The method for registering available actions in the map
     */
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Add student-specific actions    
        functions.put(startIndex++, new NamedRunnable(this::viewCourses, "View Courses"));                                                    
        functions.put(startIndex++, new NamedRunnable(this::registerForCourse, "Register for Course"));                                   
        functions.put(startIndex++, new NamedRunnable(this::viewTeacherInfo, "View Teacher Info"));                                        
        functions.put(startIndex++, new NamedRunnable(this::viewMarks, "View Marks"));                                                    
        functions.put(startIndex++, new NamedRunnable(this::viewTranscript, "View Transcript"));                                          
        functions.put(startIndex++, new NamedRunnable(this::rateTeacher, "Rate Teacher"));                                                 
        functions.put(startIndex++, new NamedRunnable(this::viewStudentOrganizations, "View Organizations"));                             
        functions.put(startIndex++, new NamedRunnable(this::joinOrganization, "Join Organization"));                                       
        functions.put(startIndex++, new NamedRunnable(this::leaveOrganization, "Leave Organization"));                                      

        // Add parent class functions
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", Student{" +
                "admissionYear=" + admissionYear +
                ", speciality=" + speciality +
                ", studyType=" + studyType +
                ", faculty='" + faculty + '\'' +
                ", fails=" + fails +
                ", MAXCREDITS=" + MAXCREDITS +
                ", documents=" + documents +
                '}';
    }
}