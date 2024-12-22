package Factories;

import communication.Message;
import employees.Employee;
import employees.Teacher;
import documents.Complaint;
import documents.Request;
import communication.SimpleMessage;
import communication.WorkMessage;

public class MessageFactory {

	public static Message getMessage(String type, Employee caller) {
		switch (type) {
		case "Request":
			return new Request(type, type, type);
		case "Complaint":
			if (caller instanceof Teacher) {
				return new Complaint(type, type, null);
			} else {
				System.out.println("Only teachers can send complaints!");
			}
		default:
			throw new IllegalArgumentException("Message type is unknown: " + type);
		}
	}
}