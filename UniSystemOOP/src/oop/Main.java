package oop;

import java.io.File;
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

public class Main {

	private static transient Scanner inp = new Scanner(System.in);
	
	public static Runnable pickFunc(Map<Integer, NamedRunnable> functions) {
		while(true) {
			int i=0;
			for (Map.Entry<Integer, NamedRunnable> entry : functions.entrySet()) {
	            System.out.println((++i) + " - " + entry.getValue().getName());
			}
	        int choice = inp.nextInt()-1;
	        
	        if(choice==-1) return null;
	        Runnable function = functions.get(choice);
	        if (function != null) {
	            return function;
	        }
	        System.out.println("Invalid input. This function does not exist.");
		}
	}
    public static User login() {
        while (true) {
            System.out.println("Welcome To UniSystem2000ProMax??");

            System.out.print("Login: ");
            String login = inp.next();

            System.out.print("Password: ");
            String password = inp.next();

            // Use validateLogin to validate the user login and password
            if (User.validateLogin(login, password)) {
                // If login is valid, fetch the user by login
                User u = Data.INSTANCE.findUserByLogin(login);
                System.out.println("Logging in...!");
                return u; // Return the logged-in user
            } else {
                System.out.println("Invalid login or password. Try again.");
            }
        }
    }

	
	public static void main(String[] args) {
	
		
		//Now all of this should be in daatabse.Generating file!
		
		//UPD: 		Если че то не работает покачто юзайте мэйн - удаляйте файл data, раскоменчиваете блок ниже "Adding users and data to the system" и опять коментите 
		
		
		
		User admin = new Admin("popa1", "popapassword");
		Manager manager = new Manager("mngr", "mngr");

		Bachelor student1 = new Bachelor("stud", "pswrd", "Ben", "Doe");
		Bachelor student2 = new Bachelor("stud2", "parol", "John", "Chan");
        Master student3 = new Master("stud3", "log", "Alex", "Smith");

        Teacher teacher1 = new Teacher("tchr", "tchr", "Pakizar", "Shamoi");
        Teacher teacher2 = new Teacher("tchr2", "tchr2", "Alimzhan", "Amanov");
        Teacher teacher3 = new Teacher("indus", "indus", "Suhrab", "Yoldash");

        Vector<Teacher> teachers = new Vector<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        
        Vector<Teacher> teachers2 = new Vector<>();
        teachers2.add(teacher3);

        Course ads = new Course("ADS", 2024, Semester.FALL);
        ads.setTeachers(teachers);

        Course oop = new Course("OOP", 2024, Semester.FALL);
        oop.setTeachers(teachers);

        Course cmp = new Course("CMP", 2024, Semester.FALL);
        //cmp.setTeachers(teachers2);								//no teacher for CMP course - test manager function to assign course to teacher

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
        
        
        Rector rector = new Rector("gbdln", "rctr", "Gabdulin", "Maratbek");
        Dean dean = new Dean("dean", "dean", "DeanName", "DeanSurname");

        // Adding users and data to the system
//        Data.INSTANCE.addUser(admin);
//        Data.INSTANCE.addUser(manager);
//        Data.INSTANCE.addUser(student1);
//        Data.INSTANCE.addUser(student2);
//        Data.INSTANCE.addUser(student3);
//        Data.INSTANCE.addUser(teacher1);
//        Data.INSTANCE.addUser(teacher2);
//        Data.INSTANCE.addUser(teacher3);
//
//        Data.INSTANCE.addCourse(oop);
//        Data.INSTANCE.addCourse(ads);
//        Data.INSTANCE.addCourse(cmp);
//
//        Data.INSTANCE.addStudentOrganization(faces);
//        Data.INSTANCE.addStudentOrganization(osit);
//        Data.INSTANCE.addStudentOrganization(bigCityLights);	

//        	Data.INSTANCE.addUser(rector);
//        	Data.INSTANCE.addUser(dean);																																			/*
        	
        /*
        
        	//TESTING USER
        
        1 - Change Password				Changing password of any user 
        2 - Change Language				Changing language of the system
        3 - Check news					Checking all existing news
        4 - Exit						Exit from system
        5 - Logout						Log out form system (Login from another account)
        	
        
        	// TESTING STUDENT:
        
        1 - View Courses				Shows all courses that student enrolled to
        2 - Register for Course			Registers student for specific course   							(OOP, 2024, Fall or ADS 2024, FALL)
        3 - View Teacher Info			View Info about all teachers of specific course						(ADS, 2024, Fall)
        4 - View Marks					Shows all marks for all enrolled courses
        5 - View Transcript				Shows transcript like info about mark 								(Letter mark, GPA, ECTS)
        6 - Get Transcript				--Not working now--
        7 - Rate Teacher				Rate specific teacher												(Pakizar, Shamoi, 10)
        8 - View Organizations			Shows student organization that student is part of
        9 - Join Organization			Function to join student organization								(OSIT)
        10 - Leave Organization			Function to leave student organization  							(OSIT)
        
        
        
        	//BACHELOR
       	1 - Get Diploma Work			Printing diploma work
       	
       	
       		//MASTER
        1 - Get Thesis					Printing thesis
        	
        	
        	//PHD	
        1 - Get Dissertation			Printing dissertation
        
        
        
        	// TESTING TEACHER
        1 - View Courses				Shows all courses that teacher assigned to
        2 - Put mark					Putting mark to specific student and course							(Ben, Doe, ADS, 2024, fall, 30, 30, 30)
        3 - Print research paper		--Not working now--
        4 - View students info			View info about all students of specific course						(Now realized by selection 1-n (May be ill change this))
        5 - Sent complaint				Sending complaint to all deans with urgency level					(Emergency!!!, HIGH)
        
        
        
        	//TESTING MANAGER
		1 - Add student					Create new students and add them to the system 						(Lionel, Messi, messi_30, 3030)					(name, surname, login, password)
        2 - Create news					Createing new news 													(Important, info, yes)							(Title, content, pin status)					
        3 - Add new course				Create new course 													(PP1, 2023, Fall, 1, Alimzhan)					(name, year, semester of course, number of teachers, teachers (shoud be in the system))
        4 - Assign teacher to course	Asigning teacher to specific course 							(PP1, 2023, Fall, Alimzan, Amanov)				(name, year, semester of course, name, surname of teacher)
	
		
        
        	//TESTING ADMIN
        
        1 - Create User					Creating new user 
		2 - Update User					Updating user
		3 - Delete User					Deleting user 
        
        
        
        
        
        
        	//TESTING DEAN
        1 - Get complaints 
        
 																					 																					*/
        
        
        User current = null;

        while (true) {

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

                System.out.println((i + 1) + " - Logout"); 										//Logout for every type of user

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