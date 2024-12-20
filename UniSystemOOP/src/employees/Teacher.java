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
import news.*;
import oop.*;
import research.*;
import students.*;
import user.*;
import utils.InputPrompt;

public class Teacher extends Employee implements Researcher, Serializable {

    public Teacher(String login, String password) {
        super(login, password);
        // TODO Auto-generated constructor stub
    }

    public Teacher(String login, String password, String name, String surname) {
        super(login, password, name, surname);
    }

    private Vector<Course> courses;

    private double rating;
    private Vector<Double> ratingMarks = new Vector<>();

    private TeacherTitle teacherType;

    private Set<Document> documents;

    private Vector<Course> getCourses() {
        if (this.courses == null) {
            this.courses = new Vector<Course>();
        }
        return this.courses;
    }

    private void addCourses(Course course) {
        this.courses.add(course);
    }

    private double getRating() {
        return this.rating;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }

    public void addRating(Double rating) {
        this.ratingMarks.add(rating);
    }

    public void updateAverageRating() {
        if (ratingMarks.isEmpty()) {
            rating = 0.0;  // No ratings yet, so the average is 0
        } else {
            double sum = 0;
            for (Double mark : ratingMarks) {
                sum += mark;
            }
            rating = sum / ratingMarks.size();  // Calculate the average rating
        }
    }

    private TeacherTitle getTeacherType() {
        return this.teacherType;
    }

    private void setTeacherType(TeacherTitle teacherType) {
        this.teacherType = teacherType;
    }

    public Set<Document> getDocument() {
        if (this.documents == null) {
            this.documents = new HashSet<Document>();
        }
        return this.documents;
    }

    public void addDocument(Document document) {
        this.documents = documents;
    }

    
    
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

        // Step 4: Find the course
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

    
    
    public void viewStudentsInfo() { 
        //NEED TO REALIZE
    }

    public void sentComplaint() {
        // Functionality yet to be implemented
    }

    @Override
    public void addResearchPaper() {
        // Functionality yet to be implemented
    }

    @Override
    public ResearchPaper getresearchPaper() {
        // Functionality yet to be implemented
        return null;
    }

    @Override
    public int calculateHIndex() {
        // Functionality yet to be implemented
        return 0;
    }

    @Override
    public void printResearchPaper() {
        // Functionality yet to be implemented
    }

    @Override
    public String toString() {
        // Get the teacher's courses as a list of course names (you can modify this to include other details if needed)
        StringBuilder courseNames = new StringBuilder();
        if (this.courses != null && !this.courses.isEmpty()) {
            for (Course course : this.courses) {
                courseNames.append(course.getName()).append(", ");
            }
            // Remove last comma and space
            courseNames.setLength(courseNames.length() - 2);
        } else {
            courseNames.append("No courses assigned");
        }

        // Build the string representation
        return "Teacher Name: " + this.getName() + " " + this.getSurname() + ", " +
               "Rating: " + this.rating + ", " +
               "Teacher Type: " + (this.teacherType != null ? this.teacherType.toString() : "Not assigned") + " ";
    }

    //                          Operations                                  
    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Add student-specific actions    
        functions.put(startIndex++, new NamedRunnable(this::putMark, "Put mark"));
        functions.put(startIndex++, new NamedRunnable(this::printResearchPaper, "Print research paper"));
        functions.put(startIndex++, new NamedRunnable(this::viewStudentsInfo, "View students info"));
        functions.put(startIndex++, new NamedRunnable(this::sentComplaint, "Sent complaint"));
   
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }

}