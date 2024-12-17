package oop;

import java.util.Scanner;

import database.Data;
import employees.Admin;
import employees.Employee;
import employees.Manager;
import user.User;

public class Main {

	private static Scanner inp = new Scanner(System.in);
	
	public static User login() {
		System.out.println("Welcome To UniSystem2000ProMax??");
		
		System.out.print("Login: ");
		String login = inp.next();
		
		User u = Data.findUser(login); 
		if(u == null) {
			System.out.println("User's not found");
			return null;
		}
		System.out.print("Password: ");
		String password = inp.next();
		
		while(password.hashCode() != u.getPassword()) {
			System.out.println("Incorrect Password(0 to leave)");
			System.out.print("Password: ");
			password = inp.next();
			if(password.equals("0")) return null;
		}
		System.out.println("Loginning...!");
		return u;
	}
	
	public static void main(String[] args) {
		
		User admin = new Admin("popa1", "popapassword");
		User admin2 = new Admin("popa3", "popapassword2	");
		User emp = new Manager("PPA", "lola");
		System.out.println(admin.getId());
		User current = login();
		if(current==null) System.exit(0);
		if(current instanceof Manager) current = (Manager)current;
		System.out.println();
		System.out.println(current.getFunc());
	}

}
