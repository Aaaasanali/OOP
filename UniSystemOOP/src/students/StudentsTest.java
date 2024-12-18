package students;

import java.util.*;

import database.Data;
import documents.Course;
import documents.CourseType;
import documents.Lesson;
import documents.Semester;
import employees.Teacher;

public class StudentsTest {

	private static void printList(List list) {
		for(int i=0; i<list.size(); i++)
			System.out.println(i+1+ ")" +list.get(i));
	}

	public static void main(String[] args) {

        Student student = new Student("studentLogin", "studentPassword123", "John", "Doe", "12345");


        //student.setFaculty("Engineering");
        

        
        //student.registerForCourse("Introduction to Java", 2024);

        
        
        //System.out.println(student);
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Thesis thesis = new Thesis("Machine Learning Algorithms", "Prof. John Doe", "2024-05-15");     //no thesis now

        // Create a Master student and initialize it
        Master masterStudent = new Master("john_smith", "password123", "John", "Smith", "2024B12345");
        //masterStudent.registerForCourse("Introduction to Java", 2024);

     
        //masterStudent.setThesis(thesis);
        
     
        //System.out.println(masterStudent);
        
        // Access and display thesis information
        //System.out.println("Thesis Title: " + masterStudent.getThesis().getTitle());
        //System.out.println("Thesis Supervisor: " + masterStudent.getThesis().getSupervisor());
        
        
        
        
        
        Data.INSTANCE.addUser(masterStudent);
        Data.INSTANCE.addUser(student);
        
        
        //printList(Data.INSTANCE.users);
        Student student2 = new Student("john_doe", "password", "John", "Doe", "12345");
        
        
        Data.INSTANCE.addCourse(new Course("OOP", 2024, Semester.FALL));
        
        
        
        Teacher teacher1 = new Teacher("teacher1_login", "teacher1_password");
        Teacher teacher2 = new Teacher("teacher2_login", "teacher2_password");
        Teacher teacher3 = new Teacher("teacher3_login", "teacher3_password");
        
        
        Vector<Teacher> teachers = new Vector<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);        
        
        Course course3 = new Course("ADS", 2024, Semester.FALL);
        course3.setTeachers(teachers);        
        Data.INSTANCE.addCourse(course3);
        
        
        
        student2.registerForCourse();
//        student2.viewTeacherInfo();
//        
//        System.out.println(course3.getTeachers());
        
        student2.viewCourses();
        
    }
}
