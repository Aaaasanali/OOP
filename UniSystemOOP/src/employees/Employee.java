package employees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

import Factories.NamedRunnable;
import communication.Message;
import database.Data;
import documents.Request;
import students.Student;
import user.User;
import utils.InputPrompt;

public class Employee extends User implements Serializable {

	private static final long serialVersionUID = -4055598320012630398L;

	public String department;
	private Stack<Message> messageInbox = new Stack<>();

	public Employee() {
        super();
        this.department = "";
    }

	public Employee(String login, String password) {
		super(login, password);
	}

	public Employee(String login, String password, String name, String surname) {
		super(login, password, name, surname);
	}

	protected String getDepartment() {
		return department;
	}

	protected void setDepartment(String department) {
		this.department = department;
	}

	private Stack<Message> getMessage() {
		return messageInbox;
	}

	private void checkInbox() {

		if (messageInbox.isEmpty()) {
			System.out.println("Your inbox is empty.");
			return;
		}

		System.out.println("Your Inbox:");
		for (int i = 0; i < messageInbox.size(); i++) {
			Message message = messageInbox.get(i);
			System.out.printf("%d. %s... \nFrom: %s%n", i + 1,
					message.getContent().substring(0, Math.min(10, message.getContent().length())),
					message.getSender());
		}

		String choice = InputPrompt.promptInput("Choose an option (1-4): ");
		if (choice == null || choice.equals("4")) {
			return;
		}

		switch (choice) {
		case "1":
			viewMessage();
			break;
		case "2":
			deleteMessage();
			break;
		case "3":
			clearInbox();
			break;
		default:
			System.out.println("Invalid choice. Returning to main menu.");
			break;
		}

	}

	private void viewMessage() {
		String messageNum = InputPrompt.promptInput("Enter the message number to view: ");
		if (messageNum == null || messageNum.equalsIgnoreCase("quit"))
			return;

		try {
			int index = Integer.parseInt(messageNum) - 1;
			if (index >= 0 && index < messageInbox.size()) {
				Message message = messageInbox.get(index);
				System.out.println("\nMessage Details:");
				System.out.println("From: " + message.getSender());
				System.out.println("Content: " + message.getContent());
			} else {
				System.out.println("Invalid message number.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a number.");
		}
	}

	private void deleteMessage() {
		String input = InputPrompt.promptInput("Enter the message number to delete: ");
		if (input == null)
			return;

		try {
			int index = Integer.parseInt(input) - 1;
			if (index >= 0 && index < messageInbox.size()) {
				messageInbox.remove(index);
				System.out.println("Message deleted successfully.");
			} else {
				System.out.println("Invalid message number.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a number.");
		}
	}

	private void clearInbox() {
		String confirmation = InputPrompt.promptInput("Are you sure you want to clear all messages? \nYes/No");
		if ("Yes".equalsIgnoreCase(confirmation)) {
			messageInbox.clear();
			System.out.println("All messages cleared.");
		} else {
			System.out.println("Action canceled.");
		}
	}

	private void sendMessage() {

		System.out.println("Type 'quit' to exit");

		String employeeName = InputPrompt.promptInput("Enter the name of the Employee: ");
		if (employeeName == null || employeeName.equalsIgnoreCase("quit"))
			return;

		Employee targetEmployee = null;
		for (User user : Data.INSTANCE.getAllUsers()) {
			if (user instanceof Employee) {
				Employee employee = (Employee) user;
				if (employee.getName() != null && employee.getName().equalsIgnoreCase(employeeName)) {
					targetEmployee = employee;
					break;
				}
			}
		}

		if (targetEmployee == null) {
			System.out.println("User not found.");
			return;
		}

		String contentOfSender = InputPrompt.promptInput("Write the content: ");
		if (contentOfSender == null || employeeName.equalsIgnoreCase("quit"))
			return;

		Message m = new Message(targetEmployee, contentOfSender);
		targetEmployee.receiveMessage(m);
		System.out.println("Message was sent");

	}

	public void receiveMessage(Message message) {
		this.messageInbox.push(message);
	}

	public List<Request> getRequests() {
		if (Data.INSTANCE == null) {
			System.out.println("Data object is null");
			return null; // or return an empty list
		}
		Vector<Request> requests = Data.INSTANCE.getRequests();
		if (requests == null) {
			System.out.println("Requests list is null");
			return null; // or return an empty list
		}
		return requests;
	}

	public void sendRequest() {
		System.out.println("Type 'quit' at any time to exit.");

		while (true) {
			String content = InputPrompt.promptInput("Enter the request content: ");
			if (content == null) {
				// User chose to quit
				return;
			}

			if (content.trim().isEmpty()) {
				System.out.println("Request content cannot be empty. Please try again.");
				continue;
			}

			// Collect sender's name and surname
			String senderName = this.getName(); // Assuming Employee has a getName method
			String senderSurname = this.getSurname(); // Assuming Employee has a getSurname method

			// Create a new request and add it to the Data
			Request request = new Request(content, senderName, senderSurname);
			Data.INSTANCE.addRequest(request); // This adds the request to the data's list
			System.out.println("Request sent successfully: " + content);
			break; // Exit after a successful request
		}
	}

	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		functions.put(startIndex++, new NamedRunnable(this::sendMessage, "Send message"));
		functions.put(startIndex++, new NamedRunnable(this::sendRequest, "Send request"));

		for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}

	public String toString() {
		return "Employee is placed in " + department + " department";
	}

}
