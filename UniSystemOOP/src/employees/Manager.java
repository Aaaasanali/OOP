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

//    public Manager() {
//		super();
//	}

	public Manager(String login, String password) {
		super(login, password);
	}

	public static List<Request> getManagerRequests() {
		return managerRequests;
	}

	/**
	 * Adds a new student to the system.
	 * 
	 * <p>
	 * This method prompts the user to enter details for a new student, including
	 * their first name, last name, login, and password.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Type 'quit' at any time to exit
	 * Enter student's first name: John
	 * Enter student's last name: Doe
	 * Enter student's login: stud
	 * Enter student's password: pswrd
	 * Student added successfully!
	 * </pre>
	 */
	public void addStudent() {
		System.out.println("Type 'quit' at any time to exit");

		String firstName = InputPrompt.promptInput("Enter student's first name: ");
		if (firstName == null)
			return;

		String lastName = InputPrompt.promptInput("Enter student's last name: ");
		if (lastName == null)
			return;

		String login = InputPrompt.promptInput("Enter student's login: ");
		if (login == null)
			return;

		String password = InputPrompt.promptInput("Enter student's password: ");
		if (password == null)
			return;

		Student newStudent = new Bachelor(login, password, firstName, lastName);
		Data.INSTANCE.addUser(newStudent);

		System.out.println("Student added successfully!");
		// Log
		String logMessage = "New student added: " + firstName + " " + lastName + " (Login: " + login + ") by "
				+ this.getName() + " " + this.getSurname();
		Data.INSTANCE.addLog(logMessage);
	}

	/**
	 * Adds a new course to the system.
	 * 
	 * <p>
	 * This method prompts the user to enter details for a new course: the course
	 * name, year, semester, and the number of teachers for the course. Then add new
	 * course to the system
	 * </p>
	 * 
	 * <p>
	 * If all details are provided correctly, the course is added to the system, and
	 * a log entry is created to record the action.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Type 'quit' at any time to exit
	 * Enter course name: OOP
	 * Enter year: 2024
	 * Enter semester (Spring, Fall, Summer): fall
	 * Enter the number of teachers for this course: 2
	 * Enter the login of teacher 1: teacher1
	 * Enter the login of teacher 2: teacher2
	 * Course added successfully!
	 * </pre>
	 */
	public void addCourse() {
		System.out.println("Type 'quit' at any time to exit");

		String courseName = InputPrompt.promptInput("Enter course name: ");
		if (courseName == null)
			return;

		int year = InputPrompt.promptIntInput("Enter year: ");
		if (year == -1)
			return;

		// Ask for semester as a string (e.g., Spring, Fall, Summer)
		String semesterInput = InputPrompt.promptInput("Enter semester (Spring, Fall, Summer): ");
		if (semesterInput == null)
			return;

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
		if (numberOfTeachers == -1)
			return;

		Vector<Teacher> courseTeachers = new Vector<>();
		for (int i = 0; i < numberOfTeachers; i++) {
			String teacherLogin = InputPrompt.promptInput("Enter the login of teacher " + (i + 1) + ": ");
			if (teacherLogin == null)
				return;

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

		// Log
		String logMessage = "New course added: " + courseName + " (" + year + " " + semester + "). Teachers: "
				+ courseTeachers + " by " + this.getName() + " " + this.getSurname();
		Data.INSTANCE.addLog(logMessage);
	}

	/**
	 * Creates and adds a new news to the system.
	 * 
	 * <p>
	 * This method allows to input the title and content of a news item, and choose
	 * to pin the news. It prompts the user for necessary information, creates a new
	 * object, and adds it to the system.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Type 'quit' at any time to exit
	 * Enter news title: New Semester Courses Available
	 * Enter news content: The courses for the upcoming semester are now available for registration.
	 * Pin this news? (yes/no): yes
	 * News created and added successfully!
	 * </pre>
	 */
	public void createNews() {
		System.out.println("Type 'quit' at any time to exit");

		String title = InputPrompt.promptInput("Enter news title: ");
		if (title == null)
			return;

		String content = InputPrompt.promptInput("Enter news content: ");
		if (content == null)
			return;

		String pinInput = InputPrompt.promptInput("Pin this news? (yes/no): ");
		if (pinInput == null)
			return;
		boolean isPinned = pinInput.equalsIgnoreCase("yes");

		News news = new News(title, content, isPinned, new ArrayList<>());
		Data.INSTANCE.news.add(news);

		System.out.println("News created and added successfully!");

		// Log
		String logMessage = "New news created: " + title + ". Pinned: " + isPinned + " by " + this.getName() + " "
				+ this.getSurname();
		Data.INSTANCE.addLog(logMessage);
	}

	/**
	 * Helper function to handle exception of approveStudentRegistration()
	 */
	public void someOtherMethod() {
		try {
			approveStudentRegistration(); // Call the method that throws IOException
		} catch (IOException e) {
			System.out.println("An error occurred while processing the registration.");
			e.printStackTrace();
		}
	}

	/**
	 * Handles the process of approving student course registrations.
	 * 
	 * <p>
	 * This method retrieves all pending student registration requests for courses
	 * and displays them to the manager.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Displaying all course registration requests...
	 * Course: OOP (Year: 2024, Semester: Fall)
	 * 1. John Doe
	 * 2. Jane Smith
	 * Enter the number of the registration request to approve/reject, or 'quit' to exit: 1
	 * Approve or Reject the registration of John Doe for course OOP? (approve/reject): approve
	 * Student registration approved: John Doe for course: OOP by [Manager Name] [Manager Surname]
	 * </pre>
	 */
	public void approveStudentRegistration() throws IOException {
		System.out.println("Displaying all course registration requests...");

		Map<Course, Vector<Student>> courseRegistrations = Data.INSTANCE.getCourseRegistrations();
		int counter = 1;
		boolean hasRequests = false;

		// Iterate through all courses and registration
		for (Map.Entry<Course, Vector<Student>> entry : courseRegistrations.entrySet()) {
			Course course = entry.getKey();
			Vector<Student> students = entry.getValue();

			if (!students.isEmpty()) {
				System.out.println(
						"\nCourse: " + course.getName() + " (" + course.getYear() + " " + course.getSemester() + ")");
				for (Student student : students) {
					System.out.println(counter++ + ". " + student.getName() + " " + student.getSurname());
				}
				hasRequests = true;
			}
		}

		if (!hasRequests) {
			System.out.println("No registration requests available.");
			return; // No pending requests, exit the method
		}

		// Prompt manager to choose a request to approve/reject
		String choiceInput = InputPrompt
				.promptInput("\nEnter the number of the registration request to approve/reject, or 'quit' to exit: ");
		if (choiceInput == null || choiceInput.equalsIgnoreCase("quit")) {
			return; // Exit if user chooses 'quit'
		}

		try {
			int choice = Integer.parseInt(choiceInput);
			if (choice < 1) {
				System.out.println("Invalid choice. Please select a valid number.");
				return;
			}

			// Find the course and student based on the manager's choice
			counter = 1;
			boolean found = false;
			for (Map.Entry<Course, Vector<Student>> entry : courseRegistrations.entrySet()) {
				Course course = entry.getKey();
				Vector<Student> students = entry.getValue();

				for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
					Student student = iterator.next();

					if (counter == choice) {
						found = true;
						// Ask to approve or reject
						String action = InputPrompt.promptInput("Approve or Reject the registration of "
								+ student.getName() + " for course " + course.getName() + "? (approve/reject): ");
						if ("approve".equalsIgnoreCase(action)) {
							Data.INSTANCE.approveRegistration(course, student);
							iterator.remove();

							// Log the approval action
							String logMessage = "Student registration approved: " + student.getName() + " "
									+ student.getSurname() + " for course: " + course.getName() + " by "
									+ this.getName() + " " + this.getSurname();
							Data.INSTANCE.addLog(logMessage);

							Data.write(); // Write the changes

						} else if ("reject".equalsIgnoreCase(action)) {
							Data.INSTANCE.rejectRegistration(course, student);
							iterator.remove();

							// Log the rejection action
							String logMessage = "Student registration rejected: " + student.getName() + " "
									+ student.getSurname() + " for course: " + course.getName() + " by "
									+ this.getName() + " " + this.getSurname();
							Data.INSTANCE.addLog(logMessage);

							Data.write(); // Write the changes
						} else {
							System.out.println("Invalid action. Please choose 'approve' or 'reject'.");
						}
						break;
					}
					counter++;
				}
				if (found)
					break;
			}

			if (!found) {
				System.out.println("Invalid number. No registration found for that number.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid number.");
		} catch (IOException e) {
			System.out.println("Failed to save changes. Please try again.");
			e.printStackTrace(); // Optionally log the stack trace for debugging
		}
	}

	/**
	 * Not finished function
	 */
	public void registerStudentForCourse() {
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * // Ask the user to input student ID
		 * System.out.print("Enter the student ID: "); int studentId =
		 * scanner.nextInt();
		 * 
		 * // Find the student by ID Student student = findStudentById(studentId); if
		 * (student == null) { System.out.println("Student with ID " + studentId +
		 * " not found."); return; // Exit the method if the student is not found }
		 * 
		 * // Ask the user to select a course
		 * System.out.println("Select a course by entering the course index (0 to " +
		 * (courses.size() - 1) + "): "); int courseIndex = scanner.nextInt(); if
		 * (courseIndex < 0 || courseIndex >= courses.size()) {
		 * System.out.println("Invalid course selection."); return; // Exit if the
		 * course selection is invalid } Course course = courses.get(courseIndex);
		 * 
		 * // Check if the student is already registered for the course if
		 * (student.getCourses().containsKey(course)) {
		 * System.out.println("The student is already registered for the course: " +
		 * course.getName()); } else { // Register the student for the course if
		 * (student.registerForCourse(course)) {
		 * System.out.println("Successfully registered for the course: " +
		 * course.getName()); } else { System.out.println("Registration failed."); } }
		 */
	}

	/**
	 * Assigns a teacher to a specific course.
	 * 
	 * <p>
	 * This method allows a manager to assign a teacher to a course by prompting the
	 * user for the course details (name, year, and semester) and the teacher's
	 * name.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Enter the name of the course you want to assign a teacher to: Data Structures
	 * Enter the year for the course: 2024
	 * Enter the semester for the course (Fall/Spring/Summer): Fall
	 * Enter the first name of the teacher you want to assign: John
	 * Enter the surname of the teacher you want to assign: Doe
	 * Successfully assigned John Doe to the course: Data Structures
	 * </pre>
	 */
	public boolean assignTeacherToCourse() {
		System.out.println("Type 'quit' at any time to exit");
		while (true) {
			try {
				// Prompt for the course name
				String courseName = InputPrompt
						.promptInput("Enter the name of the course you want to assign a teacher to: ");
				if (courseName == null)
					return false;

				// Prompt for the course year
				String yearInput = InputPrompt.promptInput("Enter the year for the course: ");
				if (yearInput == null)
					return false;
				int year = Integer.parseInt(yearInput);

				// Prompt for the semester
				String semesterInput = InputPrompt
						.promptInput("Enter the semester for the course (Fall/Spring/Summer): ");
				if (semesterInput == null)
					return false;
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
				if (firstName == null)
					return false;

				// Prompt for the teacher's surname
				String lastName = InputPrompt.promptInput("Enter the surname of the teacher you want to assign: ");
				if (lastName == null)
					return false;

				// Search for the teacher in the system
				Teacher foundTeacher = null;
				for (Teacher teacher : data.getAllTeachers()) {
					if (teacher.getName().equalsIgnoreCase(firstName)
							&& teacher.getSurname().equalsIgnoreCase(lastName)) {
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
				System.out.println("Successfully assigned " + foundTeacher.getName() + " " + foundTeacher.getSurname()
						+ " to the course: " + courseName);

				String logMessage = "Teacher " + foundTeacher.getName() + " " + foundTeacher.getSurname()
						+ " assigned to course: " + courseName + " by " + this.getName() + " " + this.getSurname();
				Data.INSTANCE.addLog(logMessage);

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

	/**
	 * Approves a received request.
	 * 
	 * <p>
	 * This method handles the logic for approving a request.
	 * </p>
	 * 
	 * @param request The request to be approved.
	 * 
	 *                <b>Example Usage:</b>
	 * 
	 *                <pre>
	 * Request approved: Register student John Doe in Data Structures
	 *                </pre>
	 */
	private void approveRequest(Request request) {
		// Logic for approving a request (e.g., register a student, add course, etc.)
		System.out.println("Request approved: " + request.toString());
		managerRequests.remove(request);

		// Log
		String logMessage = "Request approved: " + request.toString() + " by " + this.getName() + " "
				+ this.getSurname();
		Data.INSTANCE.addLog(logMessage);
	}

	/**
	 * Rejects a received request.
	 * 
	 * <p>
	 * This method handles the logic for rejecting a request.
	 * </p>
	 * 
	 * @param request The request to be rejected.
	 * 
	 *                <b>Example Usage:</b>
	 * 
	 *                <pre>
	 * Request rejected: Register student Jane Smith in OOP
	 *                </pre>
	 */
	private void rejectRequest(Request request) {
		// Logic for rejecting a request
		System.out.println("Request rejected: " + request.toString());
		managerRequests.remove(request);

		// Log
		String logMessage = "Request rejected: " + request.toString() + " by " + this.getName() + " "
				+ this.getSurname();
		Data.INSTANCE.addLog(logMessage);
	}

	/**
	 * Method to receive a new request.
	 * 
	 * <p>
	 * This static method is used to receive a new request and add it to the list of
	 * requests to be handled.
	 * </p>
	 * 
	 * @param request The new request to be added to the list.
	 * 
	 *                <b>Example Usage:</b>
	 * 
	 *                <pre>
	 * New request received: Register student John Doe in Data Structures
	 *                </pre>
	 */
	public static void receiveRequest(Request request) {
		managerRequests.add(request);

		String logMessage = "New request received: " + request.toString();
		Data.INSTANCE.addLog(logMessage);
	}

	/**
	 * Handles a request - approve or reject it.
	 * 
	 * <p>
	 * This method displays the available requests to the user, prompting them to
	 * select a request and either approve or reject it.
	 * </p>
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Available requests:
	 * 1. Register student John Doe in Data Structures
	 * 2. Register student Jane Smith in OOP
	 * Enter your choice (1 or 2): 1
	 * Do you want to approve or reject this request? (approve/reject): approve
	 * Request approved: Register student John Doe in Data Structures
	 * </pre>
	 */
	public void handleRequest() {
		if (managerRequests.isEmpty()) {
			System.out.println("No requests available.");
			return;
		}

		System.out.println("Available requests:");
		for (int i = 0; i < managerRequests.size(); i++) {
			System.out.println(i + 1 + ". " + managerRequests.get(i).toString());
		}

		int requestIndex = InputPrompt
				.promptIntInput("Select a request to handle (1 to " + managerRequests.size() + "): ");
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

	/**
	 * The method for registering available actions in the map
	 */
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		// Manager-specific actions
		functions.put(startIndex++, new NamedRunnable(this::addStudent, "Add student"));
		functions.put(startIndex++, new NamedRunnable(this::createNews, "Create news"));
		functions.put(startIndex++, new NamedRunnable(this::addCourse, "Add new course"));
		functions.put(startIndex++, new NamedRunnable(this::someOtherMethod, "Approve student registration"));
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