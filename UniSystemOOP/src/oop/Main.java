package oop;

import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import Factories.NamedRunnable;
import database.Data;
import documents.Course;
import documents.Mark;
import documents.Semester;
import employees.Admin;
import employees.Employee;
import employees.Manager;
import employees.Teacher;
import students.Master;
import students.Student;
import students.StudentOrganization;
import user.User;

public class Main {

	private static Scanner inp = new Scanner(System.in);
	
	public static User login() {
		while(true) {
		System.out.println("Welcome To UniSystem2000ProMax??");
		
		System.out.print("Login: ");
		String login = inp.next();
		
		User u = Data.findUserByLogin(login); 
		if(u == null) {
			System.out.println("User's not found");
			continue;
		}
		
		System.out.print("Password: ");
		String password = inp.next();
		
		while(password.hashCode() != u.getPassword()) {
			System.out.println("0 - Back");
			System.out.print("Password: ");
			password = inp.next();
			if(password.equals("0")) return null;
			if(password.equals(u.getPassword())) break;
			System.out.print("Incorrect Password");
		}
		System.out.println("Loginning...!");
		return u;
		}
	}
	
	public static void main(String[] args) {
		
		User admin = new Admin("popa1", "popapassword");
		
		
		
		
		
		
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
		
		
		
        //Function 						Test texts
        
		//register for course - 		OOP, 2024, FALL or ADS 2024, FALL 
		//view courses		  -			
		//view teacher info	  - 		OOP, 2024, FALL 																						only after registration
        
        student2.addMarkToCourse(ads, mark100);					//Mark can be added only to registered course
        student2.addMarkToCourse(oop, mark85);						//Функция должна быть у teacher-а (Для теста пока что вручную)
        
        //add mark to course, then check
        
        //view|get transcript for now empty
        
        //Rate teacher 		-			Pakizar, Shamoi, 10
        //View organization		
        //Join organization -  			OSIT
        //Leave organization -  			OSIT
        
        
        
        
		
		User current = student3; //null
		Master master = new Master();
//		while(current == null) {
//			current = login();
//		}
		
		Map<Integer, NamedRunnable> functionsMap = current.getFunctionsMap(0);
		while(true) {	
	
	        int i = 0;
	        for (Map.Entry<Integer, NamedRunnable> entry : functionsMap.entrySet()) {
	            System.out.println((++i) + " - " + entry.getValue().getName());
	        }
	
	        int choice = inp.nextInt()-1;
	
	        Runnable function = functionsMap.get(choice);
	        if (function != null) {
	            function.run();
	        } else {
	            System.out.println("Неверный ввод. Такой функции не существует.");
	        }
	        
		}
	}

}
