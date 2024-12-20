package oop;

import java.util.*;

import communication.*;
import database.*;
import documents.*;
import employees.*;
import Factories.*;
import Factories.NamedRunnable;
<<<<<<< HEAD
import Interfaces.*;
import news.*;
import oop.*;
import research.*;
import students.*;
import user.*;
=======
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
<<<<<<< HEAD
import students.StudentOrganization;
=======
>>>>>>> refs/remotes/origin/Alkash
import user.User;
>>>>>>> branch 'master' of https://github.com/Aaaasanali/OOP

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
<<<<<<< HEAD
		
=======
		
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/Aaaasanali/OOP
		User admin = new Admin("popa1", "popapassword");
=======

		
<<<<<<< HEAD
		Manager manager = new Manager("mngr", "mngr");
=======
	
		User current = null;

		User admin = new Admin("popa1", "popapassword");
		User current1 = admin;

		Master master = new Master();
//		while(current == null) {
//			current = login();
//		}
>>>>>>> refs/remotes/origin/Alkash
>>>>>>> branch 'master' of https://github.com/Aaaasanali/OOP
		
<<<<<<< HEAD
		
		
        Student student1 = new Student("stud", "pswrd", "Ben", "Doe");
        Student student2 = new Student("stud2", "parol", "John", "Chan");
        Master student3 = new Master("stud3", "log", "Alex", "Smith");
=======
<<<<<<< HEAD
		
        Student student1 = new Student("studentLogin", "studentPassword123", "Ben", "Doe");
        Student student2 = new Student("john_doe", "password", "John", "Doe");
        Master student3 = new Master("john_smith", "password123", "Alex", "Smith");
=======
		while(true) {	
			
	        Map<Integer, NamedRunnable> functionsMap = current1.getFunctionsMap(0);
	
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
>>>>>>> refs/remotes/origin/Alkash
>>>>>>> branch 'master' of https://github.com/Aaaasanali/OOP

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
        
        
        Mark mark75 = new Mark(30,30,15);
        Mark mark85 = new Mark(30,30,25);
        Mark mark95 = new Mark(30,30,35);
        Mark mark100 = new Mark(30,30,40);
        
        StudentOrganization bigCityLights = new StudentOrganization("BigCityLights", "A club for city dwellers and enthusiasts of urban culture.");
        StudentOrganization osit = new StudentOrganization("OSIT", "A student organization for open source and IT enthusiasts.");
        StudentOrganization faces = new StudentOrganization("Faces", "A student group for those interested in arts, creativity, and expression.");

        
        List<String> comments = new ArrayList<String>();
        comments.add("123");
        comments.add("123213");
        
        News news1 = new News("News1", "New news about news", false, comments);
        News news2 = new News("News2", "New news about news2", false, comments);
        
        
        
        
        Data.INSTANCE.addUser(admin);
        Data.INSTANCE.addUser(manager);
        
        Data.INSTANCE.addUser(student1);
        Data.INSTANCE.addUser(student2);
        Data.INSTANCE.addUser(student3);
        
        Data.INSTANCE.addCourse(oop);
        Data.INSTANCE.addCourse(ads);
        Data.INSTANCE.addCourse(cmp);
        
        Data.INSTANCE.addStudentOrganization(faces);
        Data.INSTANCE.addStudentOrganization(osit);
        Data.INSTANCE.addStudentOrganization(bigCityLights);
        
        Data.INSTANCE.addUser(teacher1);
        Data.INSTANCE.addUser(teacher2);
        Data.INSTANCE.addUser(teacher3);
		
		
						//TESTING STUDENT:
        //Function 						Test texts
        
		//register for course - 		OOP, 2024, FALL or ADS 2024, FALL 
		//view courses		  -			
		//view teacher info	  - 		OOP, 2024, FALL 										only after registration
        
        //add mark to course, then check
        
        //view|get transcript for now empty
        
        //Rate teacher 		-			Pakizar, Shamoi, 10
        //View organization		
        //Join organization -  			OSIT
        //Leave organization -  			OSIT
        
        
        
        				//TESTING TEACHER
        
        //Put mark 							log to student Register logout - log to teacher Put mark logout - log to student then see marks 					 
        //												
        
//      User current = teacher1;
        
        
        
        
        
        
        User current = null;
        while (true) {
            // Login loop
            while (current == null) {
                current = login();
            }

            // User menu loop
            while (true) {
                System.out.println("");

                Map<Integer, NamedRunnable> functionsMap = current.getFunctionsMap(0);
                int i = 0;

                for (Map.Entry<Integer, NamedRunnable> entry : functionsMap.entrySet()) {
                    System.out.println((++i) + " - " + entry.getValue().getName());
                }

                System.out.println((i + 1) + " - Logout"); // Add a logout option

                int choice = inp.nextInt() - 1;

                if (choice == i) { 
                    current.logout();
                    current = null; 
                    break;
                }

                Runnable function = functionsMap.get(choice);
                if (function != null) {
                    function.run();
                } else {
                    System.out.println("Invalid input. This function does not exist.");
                }
            }
        }
    }
}
