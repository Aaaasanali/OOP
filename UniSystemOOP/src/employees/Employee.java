package employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import Factories.NamedRunnable;
import enumerations.MessageType;
import messages.Message;
import messages.MessageFactory;
import user.User;

public class Employee extends User {

	public String department;
	private Stack<Message> messageInbox;

	{
		messageInbox = new Stack<>();
	}

	public Employee() {

	}

	public Employee(String login, String password) {

	}

	private void checkInfo() {

	}


	private void checkInbox() {
		if (messageInbox.isEmpty()) {
			System.out.println("Your inbox is empty.");
			return;
		}

		System.out.println("Inbox:");
		int index = 1;
		for (Message message : messageInbox) {
			System.out.println(index++ + ". " + message.getShortInfo());
		}

		System.out.println("0 - Back");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Choose a message to view details or 0 to go back: ");
			int choice;
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
				continue;
			}

			if (choice == 0) {
				System.out.println("Returning to the main menu...");
				break;
			}

			if (choice > 0 && choice <= messageInbox.size()) {
				Message selectedMessage = messageInbox.get(choice - 1);
				System.out.println("\nFull Message Details:");
				System.out.println(selectedMessage.getFullInfo());
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}



	private void sendMessage(Employee other, Message message) {
		Scanner input = new Scanner(System.in);

		System.out.println("Which message you want to send?");
		System.out.println("1 - Simple\n2 - Request\n3 - Complaint");

		int messageTypeChoice = input.nextInt();
		input.nextLine();
		MessageType messageType = null;
		switch (messageTypeChoice) {
		case 1:
			messageType = MessageType.SIMPLE;
			break;
		case 2:
			messageType = MessageType.REQUEST;
			break;
		case 3:
			messageType = MessageType.COMPLAINT;
			break;
		default:
			System.out.println("Invalid choice");
			messageType = MessageType.SIMPLE;
		}

		MessageFactory messageFactory = new MessageFactory();
		Message message = messageFactory.createMessage(messageType);

		String content = input.nextLine();
		message.setContent(content);

		other.messageInbox.push(message);

		System.out.println("Message was sent");
	}

	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {

		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();

		functions.put(startIndex++, new NamedRunnable(this::checkInfo, "Check Info"));
		functions.put(startIndex++, new NamedRunnable(this::checkInbox, "Check Inbox"));
		functions.put(startIndex++, new NamedRunnable(() -> sendMessage(new Employee(), new Message()), "Send Message"));

		for(Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}

}

