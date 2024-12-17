package students;

public class StudentsTest {

	public static void main(String[] args) {

        Student student = new Student("studentLogin", "studentPassword123", "John", "Doe", 3, 90, "12345");


        student.setFaculty("Engineering");
        student.setOrganization("Student Organization");

        
        student.registerForCourse("Introduction to Java", 2024);

        
        
        System.out.println(student);
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Thesis thesis = new Thesis("Machine Learning Algorithms", "Prof. John Doe", "2024-05-15");     //no thesis now

        // Create a Master student and initialize it
        Master masterStudent = new Master("john_smith", "password123", "John", "Smith", 2, 60, "2024B12345");
        masterStudent.registerForCourse("Introduction to Java", 2024);

     
        //masterStudent.setThesis(thesis);
        
     
        System.out.println(masterStudent);
        
        // Access and display thesis information
        //System.out.println("Thesis Title: " + masterStudent.getThesis().getTitle());
        //System.out.println("Thesis Supervisor: " + masterStudent.getThesis().getSupervisor());
    }
}
