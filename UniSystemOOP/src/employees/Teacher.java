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
import oop.*;
import research.*;
import students.*;
import user.*;
import utils.InputPrompt;

public class Teacher extends Employee implements Serializable {

	private static final long serialVersionUID = -6261577719787557070L;
	
	private Vector<Course> courses;

    private double rating;
    private Vector<Double> ratingMarks = new Vector<>();

    private TeacherTitle teacherType;

    private Set<Document> documents;
    
    	//Constructors
    public Teacher() {  
    	super();
        this.courses = new Vector<>();  
        this.rating = 0.0;  
        this.ratingMarks = new Vector<>();  
        this.documents = new HashSet<>();  
    }
    
    public Teacher(String login, String password) {
        super(login, password);
    }

    public Teacher(String login, String password, String name, String surname) {
        super(login, password, name, surname);
    }
   
    public Teacher(String login, String password, String name, String surname, Vector<Course> courses, double rating, Vector<Double> ratingMarks,
			TeacherTitle teacherType, Set<Document> documents) {
    	super(login, password, name, surname);
		this.courses = courses;
		this.rating = rating;
		this.ratingMarks = ratingMarks;
		this.teacherType = teacherType;
		this.documents = documents;
	}
    
    
    	//Getters and setters
    
    /**
     * Returns the current rating of the teacher.
     * 
     * @return double - The current rating of the teacher.
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * Sets the rating for the teacher.
     * 
     * @param rating - The new rating to set for the teacher.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Adds a new rating to the teacher's list of ratings.
     * 
     * @param rating - The rating to add.
     */
    public void addRating(Double rating) {
        this.ratingMarks.add(rating);
    }

    /**
     * Returns the teacher's title.
     *
     * @return TeacherTitle - The title of the teacher.
     */
    public TeacherTitle getTeacherType() {
        return this.teacherType;
    }

    /**
     * Sets the teacher's title.
     * 
     * @param teacherType - The title to set for the teacher.
     */
    public void setTeacherType(TeacherTitle teacherType) {
        this.teacherType = teacherType;
    }

    /**
     * Returns the set of documents associated with the teacher.
     * 
     * @return Set<Document> - The set of documents.
     */
    public Set<Document> getDocument() {
        if (this.documents == null) {
            this.documents = new HashSet<Document>();
        }
        return this.documents;
    }

    /**
     * Adds a document to the teacher's set of documents.
     * 
     * @param document - The document to add.
     */
    public void addDocument(Document document) {
        this.documents.add(document);
    }

    /**
     * Updates the teacher's average rating based on the given ratings.
     */
    public void updateAverageRating() {
        if (ratingMarks.isEmpty()) {
            rating = 0.0;  
        } else {
            double sum = 0;
            for (Double mark : ratingMarks) {
                sum += mark;
            }
            rating = sum / ratingMarks.size();  
        }
    }

    
    
    
    /**
     * Method to put mark to student for specific course.
     * 
     * <p>This method allows the user to input a student's name, surname, course name, year, and semester. 
     * After identifying the student and the course, it prompts for marks for the first attestation, second attestation, 
     * and final exam, and updates the student's marks for the selected course.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Enter the name of the student: John
     * Enter the surname of the student: Doe
     * Enter the name of the course: OOP
     * Enter the year of the course: 2024
     * Enter the semester of the course (Fall/Spring/Summer): Fall
     * Enter the mark for the first attestation: 8
     * Enter the mark for the second attestation: 7
     * Enter the mark for the final exam: 9
     * Marks updated successfully for student: John Doe
     * </pre>
     */
    public void putMark() {
        System.out.println("Type 'quit' at any time to exit");

        // Step 1: Get student details
        String studentName = InputPrompt.promptInput("Enter the name of the student: ");
        if (studentName == null) return;

        String studentSurname = InputPrompt.promptInput("Enter the surname of the student: ");
        if (studentSurname == null) return;

        // Step 2: Get course details
        String courseName = InputPrompt.promptInput("Enter the name of the course: ");
        if (courseName == null) return;

        int year = InputPrompt.promptIntInput("Enter the year of the course: ");
        if (year == -1) return;

        Semester semester = null;
        boolean validSemester = false;
        while (!validSemester) {
            System.out.print("Enter the semester of the course (Fall/Spring/Summer): ");
            String semesterInput = InputPrompt.promptInput("");
            if (semesterInput == null) return;

            try {
                semester = Semester.valueOf(semesterInput.toUpperCase());
                validSemester = true;  // Valid input, break the loop
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester input. Please enter 'Fall', 'Spring', or 'Summer'.");
            }
        }

        // Step 3: Find the student
        Student targetStudent = null;
        for (User user : Data.INSTANCE.getAllUsers()) {
            if (user instanceof Student) {
                Student student = (Student) user;
                if (student.getName().equalsIgnoreCase(studentName) &&
                    student.getSurname().equalsIgnoreCase(studentSurname)) {
                    targetStudent = student;
                    break;
                }
            }
        }

        if (targetStudent == null) {
            System.out.println("Student not found.");
            return;
        }

        // Step 4: Find the course in Data (instead of Teacher's courses)
        Course targetCourse = null;
        for (Course course : Data.INSTANCE.getAllCourses()) {
            if (course.getName().equalsIgnoreCase(courseName) &&
                course.getYear() == year &&
                course.getSemester() == semester) {
                targetCourse = course;
                break;
            }
        }

        if (targetCourse == null) {
            System.out.println("Course not found.");
            return;
        }

        // Step 5: Ensure the student is registered for the course
        if (!targetStudent.courses.containsKey(targetCourse)) {
            System.out.println("Student is not registered for this course.");
            return;
        }

        // Step 6: Input marks
        Integer firstAttestation = InputPrompt.promptIntInput("Enter the mark for the first attestation: ");
        if (firstAttestation == -1) return;

        Integer secondAttestation = InputPrompt.promptIntInput("Enter the mark for the second attestation: ");
        if (secondAttestation == -1) return;

        Integer finalExam = InputPrompt.promptIntInput("Enter the mark for the final exam: ");
        if (finalExam == -1) return;

        // Step 7: Update the student's marks for the course
        Mark mark = new Mark(firstAttestation, secondAttestation, finalExam);
        targetStudent.addMarkToCourse(targetCourse, mark);

        System.out.println("Marks updated successfully for student: " + studentName + " " + studentSurname);
    }

    /**
     * Displays the list of students enrolled in courses assigned to the teacher.
     * 
     * <p>This method allows the teacher to view information about students enrolled in courses that they are assigned to. 
     * The teacher selects a course, and the method displays the list of students enrolled in that course.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Select a course to view student information:
     * 1. OOP (Year: 2024, Semester: Fall)
     * 2. Data Structures (Year: 2024, Semester: Spring)
     * Enter course number (or 0 to cancel): 1
     * Students enrolled in OOP:
     * John Doe
     * Jane Smith
     * </pre>
     */
    public void viewStudentsInfo() {
        // Fetch the courses assigned to the teacher from Data
        List<Course> teacherCourses = new ArrayList<>();
        for (Course course : Data.INSTANCE.getAllCourses()) {
            if (course.getTeachers().contains(this)) {
                teacherCourses.add(course);
            }
        }

        if (teacherCourses.isEmpty()) {
            System.out.println("You are not assigned to any courses.");
            return;
        }

        System.out.println("Select a course to view student information:");
        for (int i = 0; i < teacherCourses.size(); i++) {
            Course course = teacherCourses.get(i);
            System.out.printf("%d. %s (Year: %d, Semester: %s)\n", i + 1, course.getName(), course.getYear(), course.getSemester());
        }

        int choice = InputPrompt.promptIntInput("Enter course number (or 0 to cancel): ");
        if (choice <= 0 || choice > teacherCourses.size()) {
            System.out.println("Cancelled or invalid choice.");
            return;
        }

        Course selectedCourse = teacherCourses.get(choice - 1);

        System.out.println("Students enrolled in " + selectedCourse.getName() + ":");
        if (selectedCourse.getEnrolledStudents().isEmpty()) {
            System.out.println("No students are enrolled in this course.");
        } else {
            for (Student student : selectedCourse.getEnrolledStudents()) {
                System.out.println(student); // Assuming Student has a meaningful toString() method
            }
        }
    }

    /**
     * Displays the list of courses assigned to the teacher.
     * 
     * <p>This method retrieves and displays all the courses that are registered for the teacher. 
     * If no courses are assigned to the teacher, it will print a message indicating that no courses are registered.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Courses for this teacher:
     * OOP
     * ADS
     * </pre>
     */
    public void viewCourses() {
        if (Data.INSTANCE.getAllCourses().isEmpty()) {
            System.out.println("No courses are registered for this teacher.");
            return;
        }

        // Print courses from Data
        System.out.println("Courses for this teacher:");
        for (Course course : Data.INSTANCE.getAllCourses()) {
            System.out.println(course.getName());  // Assuming Course has a getName() method
        }
    }
    
    /**
     * Allows the user to submit a complaint with an optional urgency level.
     * 
     * <p>This method prompts the user to enter the complaint text and urgency level (LOW, MEDIUM, HIGH). 
     * It then creates a Complaint object and adds it to the Dean's complaints list. If no complaint text is provided, 
     * an error message is displayed, and the complaint is not sent. If an invalid urgency level is entered, 
     * it defaults to LOW.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * Please enter your complaint:
     * Complaint: Course materials are bad working.
     * Set urgency level (LOW, MEDIUM, HIGH):
     * Urgency: HIGH
     * Complaint sent successfully!
     * </pre>
     */
    public void sentComplaint() {
        System.out.println("Please enter your complaint:");
        String complaintText = InputPrompt.promptInput("Complaint: ");  // A method to capture user input
        if (complaintText == null || complaintText.isEmpty()) {
            System.out.println("Complaint not sent. No text provided.");
            return;
        }

        System.out.println("Set urgency level (LOW, MEDIUM, HIGH):");
        String urgencyInput = InputPrompt.promptInput("Urgency: ");
        UrgencyLevel urgencyLevel;
        try {
            urgencyLevel = UrgencyLevel.valueOf(urgencyInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid urgency level. Defaulting to LOW.");
            urgencyLevel = UrgencyLevel.LOW;
        }

        Complaint complaint = new Complaint(this.getName(), complaintText, urgencyLevel);
        Dean.complaints.add(complaint);

        System.out.println("Complaint sent successfully!");
	    String logMessage = "Teacher " + getName() + " " + getSurname() + " sent complaint: " + complaint.toString();
	    Data.INSTANCE.addLog(logMessage);
    }
    
    
    /**
     * Adds a research paper for the teacher.
     * 
     * <p>This method is intended to allow a teacher to add a research paper to their profile. 
     * The functionality is yet to be implemented, and should later include the logic to store and 
     * associate a research paper with the teacher's profile.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * teacher.addResearchPaper();  // Adds a new research paper for the teacher.
     * </pre>
     */
    /**
     * Retrieves the research paper associated with the teacher.
     * 
     * <p>This method is designed to fetch the research paper of the teacher. 
     * It is currently a placeholder method and will return null until implemented.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * ResearchPaper paper = teacher.getresearchPaper();  // Retrieves the teacher's research paper.
     * </pre>
     * 
     * @return the research paper associated with the teacher or null if not available.
     */
 

    /**
     * Calculates the h-index of the teacher based on their research papers.
     * 
     * <p>The h-index is a metric that quantifies the productivity and citation impact of the teacher's publications. 
     * This method is a placeholder and needs to be implemented to calculate the teacher's h-index.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * int hIndex = teacher.calculateHIndex();  // Calculates the teacher's h-index.
     * </pre>
     * 
     * @return the calculated h-index (currently returns 0 as placeholder).
     */

    /**
     * Prints the research papers of the teacher.
     * 
     * <p>This method is intended to display the research papers of the teacher. It is currently a placeholder 
     * method and needs to be implemented to print the details of the teacher's research papers.</p>
     * 
     * <b>Example Usage:</b>
     * <pre>
     * teacher.printResearchPaper();  // Prints the teacher's research paper details.
     * </pre>
     */
    @Override
    public String toString() {
        return "Teacher Name: " + this.getName() + " " + this.getSurname() + ", " +
               "Rating: " + this.rating + ", " +
               "Teacher Type: " + (this.teacherType != null ? this.teacherType.toString() : "Not assigned");
    }
   
    
    /**
     * * The method for registering available actions in the map
     */
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
  
        functions.put(startIndex++, new NamedRunnable(this::viewCourses, "View Courses"));  
        functions.put(startIndex++, new NamedRunnable(this::putMark, "Put mark"));
        functions.put(startIndex++, new NamedRunnable(this::viewStudentsInfo, "View students info"));
        functions.put(startIndex++, new NamedRunnable(this::sentComplaint, "Sent complaint"));
        
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }

}