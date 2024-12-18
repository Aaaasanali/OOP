package employees;

import java.util.HashSet;
import java.util.Set;

import documents.Document;
import documents.Lesson;
import research.ResearchPaper;
import research.Researcher;
import documents.Course;
import students.Student;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class Teacher extends Employee implements Researcher {

	private final Vector<String> functions = new Vector<>(Arrays.asList(
			"View Courses", "Manage Courses",
			"View Students Information", "Put Marks",
			"Send Complaint", "Take Attendance"));

	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex){
		
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		
		functions.put(startIndex++, new NamedRunnable(this::viewCourses, "View Courses"));
		functions.put(startIndex++, new NamedRunnable(this::manageCourses, "Manage Courses"));
		functions.put(startIndex++, new NamedRunnable(this::viewStudentsInfo, "View Students Info"));
		functions.put(startIndex++, new NamedRunnable(this::putMarks, "Put Marks"));
		functions.put(startIndex++, new NamedRunnable(this::sendComplaint, "Send Complaint"));
		functions.put(startIndex++, new NamedRunnable(this::takeAttendance, "Take Attendance"));

		for(Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}

	public Teacher() {

	}

	public Teacher(String login, String password) {

	}

	private void viewCourses() {

	}

	private void manageCourses() {

	}

	private void viewStudentsInfo() {

	}

	private void putMarks() {

	}

	private void sendComplaint() {

	}

	private void takeAttendance() {

	}
	
	public String getFunctions() {
		return "";
	}


}

