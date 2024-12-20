package employees;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import database.Data;
import documents.Document;
import documents.Lesson;
import documents.Mark;
import documents.Semester;
import research.ResearchPaper;
import research.Researcher;
import documents.Course;
import students.Student;
import user.User;

public class Teacher extends Employee implements  Serializable {
    

    public Teacher(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}
    
    public Teacher(String login, String password, String name, String surname) {
		super(login, password, name, surname);

	}


    
	private Vector<Course> courses;
    

    private double rating;
    private Vector<Double> ratingMarks = new Vector<>();;
    
    //private Set<Lesson> lessons; lessons are contains in courses
    
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
    
    
    
    

//    private getLessons() {						change, get lessons from courses
//        
//    }
//    
//
//    private void setLessons(Lesson lesson) {
//        
//    }
    
    
    
    
    
    

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
        Scanner n = new Scanner(System.in);

        // Step 1: Get student details
        System.out.print("Enter the name of the student: ");
        String studentName = n.next();
        System.out.print("Enter the surname of the student: ");
        String studentSurname = n.next();

        // Step 2: Get course details
        System.out.print("Enter the name of the course: ");
        String courseName = n.next();
        System.out.print("Enter the year of the course: ");
        int year = n.nextInt();
        System.out.print("Enter the semester of the course (FALL/SPRING): ");
        Semester semester = Semester.valueOf(n.next().toUpperCase());

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
        System.out.print("Enter the mark for the first attestation: ");
        int firstAttestation = n.nextInt();
        System.out.print("Enter the mark for the second attestation: ");
        int secondAttestation = n.nextInt();
        System.out.print("Enter the mark for the final exam: ");
        int finalExam = n.nextInt();

        // Step 7: Update the student's marks for the course
        Mark mark = new Mark(firstAttestation, secondAttestation, finalExam);
        targetStudent.addMarkToCourse(targetCourse, mark);

        System.out.println("Marks updated successfully for student: " + studentName + " " + studentSurname);
    }
    
    	
    public void viewStudentsInfo() {																				//NEED TO REALIZE
    	
    }
    
    public void sentComplaint() {
    	
    }
    	
//    public void takeAttandance() {													//Ne dumayu chto eto obyazatelno
//    	
//    }
    
    
    
    

	@Override
	public void addResearchPaper() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ResearchPaper getresearchPaper() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void printResearchPaper() {
		// TODO Auto-generated method stub
		
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
	    return "Teacher Login: " + this.getLogin() + " " +
	           "Rating: " + this.rating + " " +
	           "Courses: " + courseNames.toString() + " " +
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
//        functions.put(startIndex++, new NamedRunnable(this::takeAttandance, "Take attendance"));							//Ne znayu obyazatelno li eto (mnogo zaparivatsya)
   
        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
    
}
