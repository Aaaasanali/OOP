package students;

import java.util.*;

import database.Data;
import documents.Course;
import documents.CourseType;
import documents.Lesson;
import documents.Mark;
import documents.Semester;
import employees.Teacher;

public class StudentsTest {

	private static void printList(List list) {
		for(int i=0; i<list.size(); i++)
			System.out.println(i+1+ ")" +list.get(i));
	}

	public static void main(String[] args) {

        Student student1 = new Student("studentLogin", "studentPassword123", "Ben", "Doe");
        Student student2 = new Student("john_doe", "password", "John", "Doe");
        Master student3 = new Master("john_smith", "password123", "Alex", "Smith");

        Teacher teacher1 = new Teacher("teacher1_login", "teacher1_password", "Pakizar", "Shamoi");
        Teacher teacher2 = new Teacher("teacher2_login", "teacher2_password", "Alimzhan", "Amanov");
        Teacher teacher3 = new Teacher("teacher3_login", "teacher3_password", "Suhrab", "Yoldash");
        
        Vector<Teacher> teachers = new Vector<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);    
        
        
        Course ads = new Course("ADS", 2024, Semester.FALL);
        ads.setTeachers(teachers);  
        
        Course oop = new Course("OOP", 2024, Semester.FALL);
        oop.setTeachers(teachers);       
        
        Mark mark75 = new Mark(30,30,15);
        Mark mark85 = new Mark(30,30,25);
        Mark mark95 = new Mark(30,30,35);
        Mark mark100 = new Mark(30,30,40);
        
        StudentOrganization bigCityLights = new StudentOrganization("BigCityLights", "A club for city dwellers and enthusiasts of urban culture.");
        StudentOrganization osit = new StudentOrganization("OSIT", "A student organization for open source and IT enthusiasts.");
        StudentOrganization faces = new StudentOrganization("Faces", "A student group for those interested in arts, creativity, and expression.");

        bigCityLights.addMember(student1);
        osit.addMember(student2);
        faces.addMember(student3);
        
        bigCityLights.addMember(student2);
        osit.addMember(student3);
        faces.addMember(student1);
        
        
        
        Data.INSTANCE.addUser(student3);
        Data.INSTANCE.addUser(student1);
        Data.INSTANCE.addCourse(oop);
        Data.INSTANCE.addCourse(ads);
        
        Data.INSTANCE.addStudentOrganization(faces);
        Data.INSTANCE.addStudentOrganization(osit);
        Data.INSTANCE.addStudentOrganization(bigCityLights);
        
        Data.INSTANCE.addUser(teacher1);
        Data.INSTANCE.addUser(teacher2);
        Data.INSTANCE.addUser(teacher3);
        
    
        
              
        
        
        
        
//        student2.registerForCourse();												//Registration works
//        student2.registerForCourse();
//        student2.viewCourses();														//View courses works
//        student2.viewTeacherInfo();
        
//        
//        System.out.println(course3.getTeachers());
        
        											
        
//        student2.addMarkToCourse(ads, mark100);
        //student2.addMarkToCourse(oop, mark85);
        

//        student2.viewMarks();														//View marks works
        

        
//        System.out.println(Data.INSTANCE.studentOrganizations);
//        
//        
//      System.out.println("");
//      System.out.println("");
//      System.out.println("");
//      
//      	student1.viewStudentOrganizations();
        
        
        
        
        
        
        student1.rateTeacher();
//        student2.rateTeacher();
//        student3.rateTeacher();


        
        
        
    }
}
