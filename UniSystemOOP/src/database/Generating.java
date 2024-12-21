package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Factories.NamedRunnable;
import documents.Course;
import documents.Mark;
import documents.Semester;
import employees.Admin;
import employees.Manager;
import employees.Teacher;
import news.News;
import students.Master;
import students.Student;
import students.StudentOrganization;
import user.User;

public class Generating {
	
public static void main(String[] args) {
		
//		System.out.println("Working Directory: " + new File(".").getAbsolutePath());
//		Data.INSTANCE.write();
		
		User admin = new Admin("popa1", "popapassword");
		
		Manager manager = new Manager("mngr", "mngr");
		
		
		

        Student student1 = new Student("stud", "pswrd", "Ben", "Doe");
        Student student2 = new Student("stud2", "parol", "John", "Chan");
        Master student3 = new Master("stud3", "log", "Alex", "Smith");

        Teacher teacher1 = new Teacher("tchr", "tchr", "Pakizar", "Shamoi");
        Teacher teacher2 = new Teacher("tchr2", "tchr2", "Alimzhan", "Amanov");
        Teacher teacher3 = new Teacher("indus", "indus", "Suhrab", "Yoldash");

        Vector<Teacher> teachers = new Vector<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        Course ads = new Course("ADS", 2024, Semester.FALL);
        ads.setTeachers(teachers);

        Course oop = new Course("OOP", 2024, Semester.FALL);
        oop.setTeachers(teachers);

        Course cmp = new Course("CMP", 2024, Semester.FALL);
        cmp.setTeachers(teachers);

        Mark mark75 = new Mark(30, 30, 15);
        Mark mark85 = new Mark(30, 30, 25);
        Mark mark95 = new Mark(30, 30, 35);
        Mark mark100 = new Mark(30, 30, 40);

        StudentOrganization bigCityLights = new StudentOrganization("BigCityLights", "A club for city dwellers and enthusiasts of urban culture.");
        StudentOrganization osit = new StudentOrganization("OSIT", "A student organization for open source and IT enthusiasts.");
        StudentOrganization faces = new StudentOrganization("Faces", "A student group for those interested in arts, creativity, and expression.");

        List<String> comments = new ArrayList<>();
        comments.add("123");
        comments.add("123213");

        News news1 = new News("News1", "New news about news", false, comments);
        News news2 = new News("News2", "New news about news2", false, comments);

        // Adding users and data to the system
        Data.INSTANCE.addUser(admin);
        Data.INSTANCE.addUser(manager);
        Data.INSTANCE.addUser(student1);
        Data.INSTANCE.addUser(student2);
        Data.INSTANCE.addUser(student3);
        Data.INSTANCE.addUser(teacher1);
        Data.INSTANCE.addUser(teacher2);
        Data.INSTANCE.addUser(teacher3);

        Data.INSTANCE.addCourse(oop);
        Data.INSTANCE.addCourse(ads);
        Data.INSTANCE.addCourse(cmp);

        Data.INSTANCE.addStudentOrganization(faces);
        Data.INSTANCE.addStudentOrganization(osit);
        Data.INSTANCE.addStudentOrganization(bigCityLights);

 
	
	}
}
