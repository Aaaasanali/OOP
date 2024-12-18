package oop;

import java.util.Map;
import java.util.Scanner;

import Factories.NamedRunnable;
import database.Data;
import employees.Admin;
import employees.Employee;
import employees.Manager;
import students.Master;
import students.Student;
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
		

		
	
		User current = null;

		User admin = new Admin("popa1", "popapassword");
		User current1 = admin;

		Master master = new Master();
//		while(current == null) {
//			current = login();
//		}
		
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

}
