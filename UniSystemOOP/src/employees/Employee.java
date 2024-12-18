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
		messageFactory.createMessage(messageType);

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

