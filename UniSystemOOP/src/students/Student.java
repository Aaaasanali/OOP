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

public abstract class Student extends User implements Serializable {

    private transient Scanner n = new Scanner(System.in);  // Scanner for user input

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

    public Student(String login, String password) {
        super(login, password);
        this.documents = new ArrayList<>();
        this.courses = new HashMap<>();
    }

    // Getter and Setter methods
    public String getFaculty() {
        return faculty;
    }

    public String getId() {
        return super.getId();
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    private int getMAXCREDITS() {
        return this.MAXCREDITS;
    }

    public Map<Course, Mark> getCourses() {
        return courses;
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

    // Method to display the quit message
    private String promptInput(String message) {
        return InputPrompt.promptInput(message);  // Use the InputPrompt utility class
    }

    // Function where you want to print the "quit" message once
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
    	System.out.println("Type 'quit' at any time to exit");
        while (true) {
            try {
                String courseName = promptInput("Enter the name of the course you want to register for: ");
                if (courseName == null) return false;

                String yearInput = promptInput("Enter the year for the course: ");
                if (yearInput == null) return false;
                int year = Integer.parseInt(yearInput);

                String semesterInput = promptInput("Enter the semester for the course (Fall/Spring/Summer): ");
                if (semesterInput == null) return false;
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

                if (!courses.containsKey(existingCourse)) {
                    courses.put(existingCourse, new Mark(0, 0, 0));
                    System.out.println("Successfully registered for course: " + courseName);
                    return true;
                } else {
                    System.out.println("You are already registered for the course: " + courseName);
                    return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester value. Please enter Fall, Spring, or Summer.");
            }
        }
    }

    public void viewTeacherInfo() {
    	System.out.println("Type 'quit' at any time to exit");
        while (true) {
            try {
                String courseName = promptInput("Enter the course name to view teacher info: ");
                if (courseName == null) return;

                String yearInput = promptInput("Enter the year for the course: ");
                if (yearInput == null) return;
                int year = Integer.parseInt(yearInput);

                String semesterInput = promptInput("Enter the semester for the course (Fall/Spring/Summer): ");
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

    public void getTranscript() {

        // Assuming you have some implementation for this
    }

    public void rateTeacher() {
    	System.out.println("Type 'quit' at any time to exit");
        while (true) {
            try {
                String teacherName = promptInput("Enter the name of the teacher you want to rate: ");
                if (teacherName == null) return;

                String teacherSurName = promptInput("Enter the surname of the teacher you want to rate: ");
                if (teacherSurName == null) return;

                String ratingInput = promptInput("Enter the rating (1-10): ");
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
                n.nextLine();
            }
        }
    }

    public void joinOrganization() {
        System.out.println("Type 'quit' at any time to exit.");
        String orgName = promptInput("Enter the name of the organization you want to join: ");
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

    public void leaveOrganization() {
    	System.out.println("Type 'quit' at any time to exit");
        String orgName = promptInput("Enter the name of the organization you want to leave: ");
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
    
    
    

    // The method for registering available actions in the map
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Add student-specific actions    
        functions.put(startIndex++, new NamedRunnable(this::viewCourses, "View Courses"));                                                    //+
        functions.put(startIndex++, new NamedRunnable(this::registerForCourse, "Register for Course"));                                     //+
        functions.put(startIndex++, new NamedRunnable(this::viewTeacherInfo, "View Teacher Info"));                                          //+
        functions.put(startIndex++, new NamedRunnable(this::viewMarks, "View Marks"));                                                     //+
        functions.put(startIndex++, new NamedRunnable(this::viewTranscript, "View Transcript"));                                           //
        functions.put(startIndex++, new NamedRunnable(this::getTranscript, "Get Transcript"));                                             //
        functions.put(startIndex++, new NamedRunnable(this::rateTeacher, "Rate Teacher"));                                                 //+
        functions.put(startIndex++, new NamedRunnable(this::viewStudentOrganizations, "View Organizations"));                              //+
        functions.put(startIndex++, new NamedRunnable(this::joinOrganization, "Join Organization"));                                       //+
        functions.put(startIndex++, new NamedRunnable(this::leaveOrganization, "Leave Organization"));                                      //+

        // Add parent class functions
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}