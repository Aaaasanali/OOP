  package oop;

import java.io.File;
import java.io.IOException;
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

public class Main {

	private static transient Scanner inp = new Scanner(System.in);

	public static Runnable pickFunc(Map<Integer, NamedRunnable> functions) {
		while (true) {
			int i = 0;

			for (Map.Entry<Integer, NamedRunnable> entry : functions.entrySet()) {
				System.out.println((++i) + " - " + entry.getValue().getName());
			}

			System.out.println("0 - Back");

			int choice = inp.nextInt() - 1;

			if (choice == -1) {
				return null;
			}

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
				if(u.getResearcherStatus()) {
					while(true) {
						System.out.println("In which Account You want to log?\n1 - Standart\n2 - Researcher");
						int p = inp.nextInt();
						if(p == 1) return u;
						else if(p == 2) return u.getResearcherAccount();
						else System.out.println("Invalid login or password. Try again.");	
					}
				}
				System.out.println("Loginning...");
				return u; // Return the logged-in user
				
			} else {
				System.out.println("Invalid login or password. Try again.");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		try {

			/*
			User admin = new Admin("popa1", "popapassword");
			
			Manager manager1 = new Manager("mngr", "mngr", ManagerType.OR);
			Manager manager2 = new Manager("mngr2", "pass2", ManagerType.DEPARTMENT);
			Manager manager3 = new Manager("mngr3", "pass3", ManagerType.FINANCEMANAGER);
			
			Data.INSTANCE.addUser(manager1);
			Data.INSTANCE.addUser(manager2);
			Data.INSTANCE.addUser(manager3);
			
			
			
			Rector rector = new Rector("gbdln", "rctr", "Gabdulin", "Maratbek");
			Data.INSTANCE.addUser(rector);
			
			
			
			
			
			Dean dean1 = new Dean("dean1", "password1", "DeanName1", "DeanSurname1");
			Dean dean2 = new Dean("dean2", "password2", "DeanName2", "DeanSurname2");
			Dean dean3 = new Dean("dean3", "password3", "DeanName3", "DeanSurname3");
			
			Data.INSTANCE.addUser(dean1);
			Data.INSTANCE.addUser(dean2);
			Data.INSTANCE.addUser(dean3);
			
			
			
			
			

			Bachelor student1 = new Bachelor("stud", "pswrd", "Ben", "Doe");
			Bachelor student2 = new Bachelor("stud2", "parol", "John", "Chan");
	        Master student3 = new Master("stud3", "log", "Alex", "Smith");
	        
	        Data.INSTANCE.addUser(student1);
	        Data.INSTANCE.addUser(student2);
	        Data.INSTANCE.addUser(student3);
	        
	        
	        
	        
	        
	        
	        Bachelor bachelor1 = new Bachelor("bachelor1", "pass1", "Michael", "Scott");
	        Bachelor bachelor2 = new Bachelor("bachelor2", "pass2", "Jim", "Halpert");
	        Bachelor bachelor3 = new Bachelor("bachelor3", "pass3", "Pam", "Beesly");
	        Bachelor bachelor4 = new Bachelor("bachelor4", "pass4", "Dwight", "Schrute");
	        Bachelor bachelor5 = new Bachelor("bachelor5", "pass5", "Angela", "Martin");
	        Bachelor bachelor6 = new Bachelor("bachelor6", "pass6", "Kevin", "Malone");
	        Bachelor bachelor7 = new Bachelor("bachelor7", "pass7", "Oscar", "Martinez");
	        Bachelor bachelor8 = new Bachelor("bachelor8", "pass8", "Phyllis", "Vance");
	        Bachelor bachelor9 = new Bachelor("bachelor9", "pass9", "Stanley", "Hudson");
	        Bachelor bachelor10 = new Bachelor("bachelor10", "pass10", "Erin", "Hannon");

	        // Master students
	        Master master1 = new Master("master1", "pass1", "Rachel", "Green");
	        Master master2 = new Master("master2", "pass2", "Ross", "Geller");
	        Master master3 = new Master("master3", "pass3", "Monica", "Geller");
	        Master master4 = new Master("master4", "pass4", "Chandler", "Bing");
	        Master master5 = new Master("master5", "pass5", "Joey", "Tribbiani");
	        Master master6 = new Master("master6", "pass6", "Phoebe", "Buffay");
	        Master master7 = new Master("master7", "pass7", "Janice", "Litman");

	        // PhD students
	        PhD phd1 = new PhD("phd1", "pass1", "Sheldon", "Cooper");
	        PhD phd2 = new PhD("phd2", "pass2", "Leonard", "Hofstadter");
	        PhD phd3 = new PhD("phd3", "pass3", "Raj", "Koothrappali");
	        PhD phd4 = new PhD("phd4", "pass4", "Howard", "Wolowitz");
	        PhD phd5 = new PhD("phd5", "pass5", "Amy", "Farrah-Fowler");
	        PhD phd6 = new PhD("phd6", "pass6", "Bernadette", "Rostenkowski");
	        PhD phd7 = new PhD("phd7", "pass7", "Leslie", "Winkle");
	        PhD phd8 = new PhD("phd8", "pass8", "Barry", "Kripke");
	        
	        
	        Data.INSTANCE.addUser(bachelor1);
	        Data.INSTANCE.addUser(bachelor2);
	        Data.INSTANCE.addUser(bachelor3);
	        Data.INSTANCE.addUser(bachelor4);
	        Data.INSTANCE.addUser(bachelor5);
	        Data.INSTANCE.addUser(bachelor6);
	        Data.INSTANCE.addUser(bachelor7);
	        Data.INSTANCE.addUser(bachelor8);
	        Data.INSTANCE.addUser(bachelor9);
	        Data.INSTANCE.addUser(bachelor10);

	        Data.INSTANCE.addUser(master1);
	        Data.INSTANCE.addUser(master2);
	        Data.INSTANCE.addUser(master3);
	        Data.INSTANCE.addUser(master4);
	        Data.INSTANCE.addUser(master5);
	        Data.INSTANCE.addUser(master6);
	        Data.INSTANCE.addUser(master7);

	        Data.INSTANCE.addUser(phd1);
	        Data.INSTANCE.addUser(phd2);
	        Data.INSTANCE.addUser(phd3);
	        Data.INSTANCE.addUser(phd4);
	        Data.INSTANCE.addUser(phd5);
	        Data.INSTANCE.addUser(phd6);
	        Data.INSTANCE.addUser(phd7);
	        Data.INSTANCE.addUser(phd8);
	        
	        
	        
	        
	        
	        

	        Teacher teacher1 = new Teacher("tchr", "tchr", "Pakizar", "Shamoi");
	        Teacher teacher2 = new Teacher("tchr2", "tchr2", "Alimzhan", "Amanov");
	        Teacher teacher3 = new Teacher("indus", "indus", "Suhrab", "Yoldash");
	        Teacher teacher4 = new Teacher("tchr4", "tchrPass4", "Aidana", "Zhakupova");
	        Teacher teacher5 = new Teacher("tchr5", "tchrPass5", "Aidar", "Nursultanov");
	        Teacher teacher6 = new Teacher("tchr6", "tchrPass6", "Damir", "Kenzhebek");
	        Teacher teacher7 = new Teacher("tchr7", "tchrPass7", "Madina", "Yeskaliyeva");
	        Teacher teacher8 = new Teacher("tchr8", "tchrPass8", "Rustem", "Kassymov");
	        Teacher teacher9 = new Teacher("tchr9", "tchrPass9", "Zhanna", "Baimuratova");
	        Teacher teacher10 = new Teacher("tchr10", "tchrPass10", "Erbol", "Kurmanov");
	        Teacher teacher11 = new Teacher("tchr11", "tchrPass11", "Miras", "Aidarov");
	        Teacher teacher12 = new Teacher("tchr12", "tchrPass12", "Zarina", "Shaikenova");
	        Teacher teacher13 = new Teacher("tchr13", "tchrPass13", "Danel", "Seytkaliyev");
	        Teacher teacher14 = new Teacher("tchr14", "tchrPass14", "Nurzhan", "Alimkhanov");
	        Teacher teacher15 = new Teacher("tchr15", "tchrPass15", "Aigul", "Tileukhanova");
	        
	        Data.INSTANCE.addUser(teacher1);
	        Data.INSTANCE.addUser(teacher2);
	        Data.INSTANCE.addUser(teacher3);
	        Data.INSTANCE.addUser(teacher4);
	        Data.INSTANCE.addUser(teacher5);
	        Data.INSTANCE.addUser(teacher6);
	        Data.INSTANCE.addUser(teacher7);
	        Data.INSTANCE.addUser(teacher8);
	        Data.INSTANCE.addUser(teacher9);
	        Data.INSTANCE.addUser(teacher10);
	        Data.INSTANCE.addUser(teacher11);
	        Data.INSTANCE.addUser(teacher12);
	        Data.INSTANCE.addUser(teacher13);
	        Data.INSTANCE.addUser(teacher14);
	        Data.INSTANCE.addUser(teacher15);
	        
	        
	        
	        
	        
	        
	        

	        
	        Vector<Teacher> teachers1 = new Vector<>();
	        teachers1.add(teacher1);
	        teachers1.add(teacher2);
	        teachers1.add(teacher3);

	        Vector<Teacher> teachers2 = new Vector<>();
	        teachers2.add(teacher4);
	        teachers2.add(teacher5);
	        teachers2.add(teacher6);

	        Vector<Teacher> teachers3 = new Vector<>();
	        teachers3.add(teacher7);
	        teachers3.add(teacher8);
	        teachers3.add(teacher9);

	        Vector<Teacher> teachers4 = new Vector<>();
	        teachers4.add(teacher10);
	        teachers4.add(teacher11);
	        teachers4.add(teacher12);

	        Vector<Teacher> teachers5 = new Vector<>();
	        teachers5.add(teacher13);
	        teachers5.add(teacher14);
	        teachers5.add(teacher15);

	        Vector<Teacher> teachers6 = new Vector<>();
	        teachers6.add(teacher1);
	        teachers6.add(teacher4);
	        teachers6.add(teacher7);

	        Vector<Teacher> teachers7 = new Vector<>();
	        teachers7.add(teacher2);
	        teachers7.add(teacher5);
	        teachers7.add(teacher8);

	        Vector<Teacher> teachers8 = new Vector<>();
	        teachers8.add(teacher3);
	        teachers8.add(teacher6);
	        teachers8.add(teacher9);

	        Vector<Teacher> teachers9 = new Vector<>();
	        teachers9.add(teacher10);
	        teachers9.add(teacher13);
	        teachers9.add(teacher15);

	        Vector<Teacher> teachers10 = new Vector<>();
	        teachers10.add(teacher11);
	        teachers10.add(teacher12);
	        teachers10.add(teacher14);        
	        
	        
	        
	        
	        Course ads = new Course("ADS", 2024, Semester.FALL);
	        ads.setTeachers(teachers1);

	        Course oop = new Course("OOP", 2024, Semester.FALL);
	        oop.setTeachers(teachers2);

	        Course cmp = new Course("CMP", 2024, Semester.FALL);
	        cmp.setTeachers(teachers3);

	        Course dbms = new Course("DBMS", 2024, Semester.SPRING);
	        dbms.setTeachers(teachers4);

	        Course algorithms = new Course("Algorithms", 2024, Semester.SPRING);
	        algorithms.setTeachers(teachers5);

	        Course networks = new Course("Networks", 2024, Semester.SPRING);
	        networks.setTeachers(teachers6);

	        Course ai = new Course("AI", 2024, Semester.FALL);
	        ai.setTeachers(teachers7);

	        Course ml = new Course("Machine Learning", 2024, Semester.FALL);
	        ml.setTeachers(teachers8);

	        Course se = new Course("Software Engineering", 2024, Semester.SPRING);
	        se.setTeachers(teachers9);

	        Course cs = new Course("Cybersecurity", 2024, Semester.FALL);
	        cs.setTeachers(teachers10);
	        
	        

	        Data.INSTANCE.addCourse(ads);
	        Data.INSTANCE.addCourse(oop);
	        Data.INSTANCE.addCourse(cmp);
	        Data.INSTANCE.addCourse(dbms);
	        Data.INSTANCE.addCourse(algorithms);
	        Data.INSTANCE.addCourse(networks);
	        Data.INSTANCE.addCourse(ai);
	        Data.INSTANCE.addCourse(ml);
	        Data.INSTANCE.addCourse(se);
	        Data.INSTANCE.addCourse(cs);
	        
	        

	        StudentOrganization bigCityLights = new StudentOrganization("BigCityLights", "A club for city dwellers and enthusiasts of urban culture.");
	        StudentOrganization osit = new StudentOrganization("OSIT", "A student organization for open source and IT enthusiasts.");
	        StudentOrganization faces = new StudentOrganization("Faces", "A student group for those interested in arts, creativity, and expression.");
	        StudentOrganization techInnovators = new StudentOrganization("TechInnovators", "A group of students dedicated to exploring the latest in technology and innovation.");
	        StudentOrganization greenPlanet = new StudentOrganization("GreenPlanet", "A student organization focused on sustainability and environmental issues.");
	        StudentOrganization sportsClub = new StudentOrganization("SportsClub", "A student organization for sports enthusiasts and athletes.");
	        StudentOrganization literatureLovers = new StudentOrganization("LiteratureLovers", "A group for students who enjoy reading, writing, and discussing literature.");
	        StudentOrganization musicMinds = new StudentOrganization("MusicMinds", "A student club for musicians, composers, and music lovers.");
	        StudentOrganization debateSociety = new StudentOrganization("DebateSociety", "A student organization for those passionate about debating and public speaking.");
	        StudentOrganization culinaryArts = new StudentOrganization("CulinaryArts", "A student organization for those who are interested in cooking and exploring food culture.");

	        Data.INSTANCE.addStudentOrganization(bigCityLights);
	        Data.INSTANCE.addStudentOrganization(osit);
	        Data.INSTANCE.addStudentOrganization(faces);
	        Data.INSTANCE.addStudentOrganization(techInnovators);
	        Data.INSTANCE.addStudentOrganization(greenPlanet);
	        Data.INSTANCE.addStudentOrganization(sportsClub);
	        Data.INSTANCE.addStudentOrganization(literatureLovers);
	        Data.INSTANCE.addStudentOrganization(musicMinds);
	        Data.INSTANCE.addStudentOrganization(debateSociety);
	        Data.INSTANCE.addStudentOrganization(culinaryArts);
	        
	        


	        Data.INSTANCE.addUser(admin);
	        Data.INSTANCE.addUser(manager1);
	        Data.INSTANCE.addUser(teacher1);
	        Data.INSTANCE.addUser(teacher2);
	        Data.INSTANCE.addUser(teacher3);
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

				    System.out.println((i + 1) + " - Logout"); 

				    String input = inp.next(); 																																			//Here problem can occur
				    int choice;

				    try {
				        choice = Integer.parseInt(input) - 1; 
				    } catch (NumberFormatException e) {
				        System.out.println("Invalid input. Please enter a valid number.");
				        continue; 
				    }

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
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();

			if (InputPrompt.scanner != null) {
				InputPrompt.scanner.close(); // close the scanner
			}

			Data.write();

		}
	}
}