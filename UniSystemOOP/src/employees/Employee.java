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

	/**
	 * Retrieves the department of the employee
	 * 
	 * @return The department name
	 */
	protected String getDepartment() {
		return department;
	}

	/**
	 * Retrieves the list of requests.
	 * 
	 * Checks if the Data object and requests list are available
	 */
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

	/**
	 * Sets the department of the employee
	 * 
	 * @param department The department name to set
	 */
	protected void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Retrieves the employee's message inbox
	 * 
	 * @return A stack of messages in the employee's inbox
	 */
	private Stack<Message> getMessage() {
		return messageInbox;
	}

	/**
	 * Displays the user's inbox and allows them to choose an action for the
	 * messages
	 * 
	 * <b>If the inbox is empty, a message is shown. If there are messages, a
	 * preview is displayed and the user can choose to:</b>
	 * 
	 * <pre>
	 * - View a message
	 * - Delete a message
	 * - Clear the inbox
	 * - Exit the menu
	 * </pre>
	 */
	private void checkInbox() {
		System.out.println("Type 'quit' at any time to exit");
		
		if (messageInbox.isEmpty()) {
			System.out.println("Your inbox is empty.");
			return;
		}

		System.out.println("Your Inbox:");
		for (int i = 0; i < messageInbox.size(); i++) {
			Message message = messageInbox.get(i);
			System.out.printf("%d. %s...  From: %s%n", i + 1,
					message.getContent().substring(0, Math.min(10, message.getContent().length())),
					message.getSender().getName() + " " + message.getSender().getSurname());
		}

		String choice = InputPrompt.promptInput("Choose an option (0-3):\n 1 - View Message\n 2 - Delete Message\n 3 - Clear Inbox\n 0 - Back\n");
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

	/**
	 * Prompts the user to enter a message number to view.
	 * 
	 * If the input is valid, the details of the selected message are displayed,
	 * including the sender and content
	 */
	private void viewMessage() {
		System.out.println("Type 'quit' at any time to exit");
		
	    System.out.println("Your Inbox:");
	    for (int i = 0; i < messageInbox.size(); i++) {
	        Message message = messageInbox.get(i);
	        System.out.printf("%d. %s...  From: %s%n", i + 1,
	                message.getContent().substring(0, Math.min(10, message.getContent().length())),
	                message.getSender().getName() + " " + message.getSender().getSurname());
	    }

	    // Prompt for message number
	    String messageNum = InputPrompt.promptInput("Enter the message number to view: ");
	    if (messageNum == null || messageNum.equalsIgnoreCase("quit"))
	        return;

	    try {
	        int index = Integer.parseInt(messageNum) - 1;
	        if (index >= 0 && index < messageInbox.size()) {
	            Message message = messageInbox.get(index);
	            System.out.println("\nMessage Details:");
	            System.out.println("From: " + message.getSender().getName() + " " + message.getSender().getSurname());
	            System.out.println("Content: " + message.getContent());
	        } else {
	            System.out.println("Invalid message number.");
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input. Please enter a number.");
	    }
	}
	/**
	 * Prompts the user to enter the message number to delete. If the input is
	 * valid, the selected message is deleted from the inbox
	 */
	private void deleteMessage() {
		System.out.println("Type 'quit' at any time to exit");
		
	    System.out.println("Your Inbox:");
	    for (int i = 0; i < messageInbox.size(); i++) {
	        Message message = messageInbox.get(i);
	        System.out.printf("%d. %s...  From: %s%n", i + 1,
	                message.getContent().substring(0, Math.min(10, message.getContent().length())),
	                message.getSender().getName() + " " + message.getSender().getSurname());
	    }

	    // Prompt for message number to delete
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

	/**
	 * Clears all messages in the inbox after user confirmation.
	 * 
	 * Prompts the user to confirm the action. If the user enters "Yes", all
	 * messages are removed from the inbox and a success message is displayed.
	 */
	private void clearInbox() {
		System.out.println("Type 'quit' at any time to exit");
		String confirmation = InputPrompt.promptInput("Are you sure you want to clear all messages? \n(Yes/No)\n");
		if ("Yes".equalsIgnoreCase(confirmation)) {
			messageInbox.clear();
			System.out.println("All messages cleared.");
		} else {
			System.out.println("Action canceled.");
		}
	}

	/**
	 * Sends a message to an employee.
	 * 
	 * Prompts the user to enter the name of an employee and the content of the
	 * message. If the employee is found, the message is sent to the employee's
	 * inbox.
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Enter the name of the Employee: John Doe
	 * Write the content: Hello, this is a test message.
	 * Message was sent
	 * </pre>
	 */
	private void sendMessage() {
		System.out.println("Type 'quit' at any time to exit");

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
		
		// Log
		String logMessage = "Message sent by " + this.getName() + " " + this.getSurname() + " to "
				+ targetEmployee.getName() + ": " + contentOfSender;
		Data.INSTANCE.addLog(logMessage);
	}

	/**
	 * method to receive message for employee
	 * 
	 * @param message
	 */
	public void receiveMessage(Message message) {
		this.messageInbox.push(message);
	}

	/**
	 * Sends a request with the specified content.
	 * 
	 * Prompts the user to enter request content. If the content is valid, the
	 * request is created and added to the Data instance. The user's name and
	 * surname are automatically associated with the request. If the input is empty
	 * or null, the user is asked to try again.
	 * 
	 * <b>Example Usage:</b>
	 * 
	 * <pre>
	 * Request about something;
	 * Request sent successfully: Request about something
	 * </pre>
	 */
	public void sendRequest() {
		System.out.println("Type 'quit' at any time to exit");

		while (true) {
			String content = InputPrompt.promptInput("Enter the request content: ");
			if (content == null) {
				return;
			}

			if (content.trim().isEmpty()) {
				System.out.println("Request content cannot be empty. Please try again.");
				continue;
			}

			// Get senders name and surname
			String senderName = this.getName();
			String senderSurname = this.getSurname();

			// Create new request
			Request request = new Request(content, senderName, senderSurname);
			Data.INSTANCE.addRequest(request); // This adds the request to the data's list
			System.out.println("Request sent successfully: " + content);
			
				//Log
			String logMessage = "Request sent by " + senderName + " " + senderSurname + ": " + content;
	        Data.INSTANCE.addLog(logMessage);
			break;
		}
	}

	/**
	 * The method for registering available actions in the map
	 */
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
		functions.put(startIndex++, new NamedRunnable(this::sendMessage, "Send message"));
		functions.put(startIndex++, new NamedRunnable(this::sendRequest, "Send request"));
		functions.put(startIndex++, new NamedRunnable(this::checkInbox, "Check Inbox"));

		for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}

	public String toString() {
		return super.toString() + " [Employee is placed in " + department + " department]";
	}

}
