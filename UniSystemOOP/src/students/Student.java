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

//String logMessage = "Student '" + this.getName() + " " + this.getSurname() ;
//Data.INSTANCE.addLog(logMessage);

/**
 * Represents a student in the system.
 * 
 * <p>
 * The `Student` class provides methods and attributes specific to a student's
 * academic and extra activities, such as course registration, viewing marks,
 * managing organizations, and interacting with the system.
 * </p>
 * 
 * <b>Main Features:</b>
 * <ul>
 * <li>Course management: Register, view, and add marks for courses.</li>
 * <li>Interaction with teachers: View and rate teachers.</li>
 * <li>Extra: Join, leave, and view student organizations.</li>
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

	// Constructors
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

	public Student(String login, String password, String name, String surname, int admissionYear, Speciality speciality,
			String faculty, StudyType studyType, List<Document> documents, Map<Course, Mark> courses, int fails) {

		super(login, password, name, surname);
		this.admissionYear = admissionYear;
		this.speciality = speciality;
		this.faculty = faculty;
		this.studyType = studyType;
		this.documents = documents;
		this.courses = courses;
		this.fails = fails;
	}

	// Getters and setters

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
	 * @return a map where the key is the course and the value is the associated
	 *         mark.
	 */
	public Map<Course, Mark> getCourses() {
		return courses;
	}

	/**
	 * Displays a list of courses the student is enrolled in. <b>Example Usage:</b>
	 * 
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

	/**
	 * Method sends registration request to manager.
	 * 
	 * <p>
	 * This method prompts the student to enter details of the course they want to
	 * register for, including name, year, and semester.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Enter the name of the course you want to register for: Data Structures
	 * Enter the year for the course: 2024
	 * Enter the semester for the course (Fall/Spring/Summer): Fall
	 * Registration request for Data Structures has been sent to the manager for approval.
	 * </pre>
	 */
	public boolean registerForCourse() {
		System.out.println("Type 'quit' at any time to exit");

		while (true) {
			try {
				String courseName = InputPrompt.promptInput("Enter the name of the course you want to register for: ");
				if (courseName == null || courseName.equalsIgnoreCase("quit"))
					return false;

				String yearInput = InputPrompt.promptInput("Enter the year for the course: ");
				if (yearInput == null || yearInput.equalsIgnoreCase("quit"))
					return false;
				int year = Integer.parseInt(yearInput);

				String semesterInput = InputPrompt
						.promptInput("Enter the semester for the course (Fall/Spring/Summer): ");
				if (semesterInput == null || semesterInput.equalsIgnoreCase("quit"))
					return false;
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
				System.out.println(
						"Registration request for " + courseName + " has been sent to the manager for approval");
				String logMessage = "Student '" + this.getName() + " " + this.getSurname() + "request registration for "
						+ courseName;
				Data.INSTANCE.addLog(logMessage);

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
	 * <p>
	 * This method prompts the user to enter details of a course, including its
	 * name, year, and semester. And then lists the assigned teachers.
	 * </p>
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Enter the course name to view teacher info: OOP
	 * Enter the year for the course: 2024
	 * Enter the semester for the course (Fall/Spring/Summer): fall
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
				if (courseName == null)
					return;

				String yearInput = InputPrompt.promptInput("Enter the year for the course: ");
				if (yearInput == null)
					return;
				int year = Integer.parseInt(yearInput);

				String semesterInput = InputPrompt
						.promptInput("Enter the semester for the course (Fall/Spring/Summer): ");
				if (semesterInput == null)
					return;
				Semester semester = Semester.valueOf(semesterInput.toUpperCase());

				for (Course course : courses.keySet()) {
					if (course.getName().equalsIgnoreCase(courseName) && course.getYear() == year
							&& course.getSemester() == semester) {
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
	 * <p>
	 * For each course, the first attestation, second attestation, and final exam
	 * scores are shown.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Course: OOP | First Attestation: 20 | Second Attestation: 25 | Final Exam: 30
	 * Course: ADS | First Attestation: 18 | Second Attestation: 22 | Final Exam: 28
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
			System.out.println("Course: " + course.getName() + " | First Attestation: " + mark.getFirstAttestation()
					+ " | Second Attestation: " + mark.getSecondAttestation() + " | Final Exam: "
					+ mark.getFinalExam());
		}
	}

	/**
	 * Displays a detailed transcript of the student's academic performance.
	 * 
	 * <p>
	 * Includes course names, ECTS credits, overall scores, letter grades, and GPA.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Course: OOP | ECTS: 5 | Overall score: 75 | Letter grade: B | GPA: 3.0
	 * Course: ADS | ECTS: 4 | Overall score: 82 | Letter grade: A | GPA: 4.0
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
			System.out.println("Course: " + course.getName() + " | ECTS: " + course.getCredits() + " | Overall score: "
					+ mark.getScore() + " | Letter grade: " + mark.calculateLetterGrade() + " | GPA: "
					+ mark.calculateGrade()

			);
		}
	}

	/**
	 * Allows the student to rate a teacher.
	 * 
	 * <p>
	 * The student inputs the teacher's name, surname, and a rating between 1 and
	 * 10. Then rating adds to teacher and average rating updates.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
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
				if (teacherName == null)
					return;

				String teacherSurName = InputPrompt.promptInput("Enter the surname of the teacher you want to rate: ");
				if (teacherSurName == null)
					return;

				String ratingInput = InputPrompt.promptInput("Enter the rating (1-10): ");
				if (ratingInput == null)
					return;
				int rating = Integer.parseInt(ratingInput);

				if (rating < 1 || rating > 10) {
					System.out.println("Invalid rating. Please enter a rating between 1 and 10.");
					continue;
				}

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

				System.out.println(
						"Rated teacher " + teacherName + " " + teacherSurName + " with a score of " + rating + "/10");

				String logMessage = "Student '" + this.getName() + " " + this.getSurname() + "' rated teacher "
						+ teacherName + " " + teacherSurName + " with a score of " + rating + "/10";
				Data.INSTANCE.addLog(logMessage);

				return;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter correct values.");
			}
		}
	}

	/**
	 * Allows the student to join a student organization.
	 * <p>
	 * The student enters the name of the organization they want to join.
	 * </p>
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Enter the name of the organization you want to join: Faces
	 * Successfully joined the organization: Faces.
	 * </pre>
	 */
	public void joinOrganization() {
		System.out.println("Type 'quit' at any time to exit.");
		String orgName = InputPrompt.promptInput("Enter the name of the organization you want to join: ");
		if (orgName == null)
			return;

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
			String logMessage = "Student '" + this.getName() + " " + this.getSurname() + "' joined "
					+ organization.getName() + " organization";
			Data.INSTANCE.addLog(logMessage);
		} else {
			System.out.println("Organization not found.");
		}
	}

	/**
	 * Allows the student to leave a student organization they are part of.
	 * <p>
	 * The student enters the name of the organization they wish to leave.
	 * </p>
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Enter the name of the organization you want to leave: OSIT
	 * Successfully left the organization: OSIT.
	 * </pre>
	 */
	public void leaveOrganization() {
		System.out.println("Type 'quit' at any time to exit");
		String orgName = InputPrompt.promptInput("Enter the name of the organization you want to leave: ");
		if (orgName == null)
			return;

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
			String logMessage = "Student '" + this.getName() + " " + this.getSurname() + "' left "
					+ organization.getName() + " organization";
			Data.INSTANCE.addLog(logMessage);
		} else {
			System.out.println("You are not part of this organization.");
		}
	}

	/**
	 * Displays a list of student organizations the student is a member of.
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Student Organizations:
	 * - BigCityLights
	 * - Faces
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
	 * Adds or updates a mark for a specific course.
	 * 
	 * @param course - the course for which the mark is being added or updated.
	 * @param mark   - the mark object containing scores for the course.
	 * 
	 *               <b>Example Usage:</b>
	 * 
	 *               <pre>
	 * Added mark for course: OOP
	 * Updated mark for course: ADS
	 *               </pre>
	 */
	public void addMarkToCourse(Course course, Mark mark) {
		// Check if the course is already registered
		if (courses.containsKey(course)) {
			// Update the mark
			courses.put(course, mark);
			System.out.println("Updated mark for course: " + course.getName());

			// Log
			String logMessage = "Student " + getName() + " " + getSurname() + " updated mark for course: "
					+ course.getName() + " with new mark: " + mark.toString();
			Data.INSTANCE.addLog(logMessage);
		} else {

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
		return super.toString() + ", Student{" + "admissionYear=" + admissionYear + ", speciality=" + speciality
				+ ", studyType=" + studyType + ", faculty='" + faculty + '\'' + ", fails=" + fails + ", MAXCREDITS="
				+ MAXCREDITS + ", documents=" + documents + '}';
	}
}