package employees;

import java.io.*;
import java.util.*;

import Factories.NamedRunnable;
import database.Data;
import documents.Complaint;
import documents.Request;
import utils.InputPrompt;

/**
 * The Dean class represents an employee who manages student complaints and
 * requests.
 *
 * <p>
 * The class includes methods for interacting with complaints and requests,
 * including the ability to approve or reject requests.
 * </p>
 */
public class Dean extends Employee implements Serializable {

	public static Vector<Complaint> complaints = new Vector<>();

	private static List<Request> approvedRequests = new ArrayList<>();

	public Dean(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	public Dean(String login, String password, String name, String surname) {
		super(login, password, name, surname);
	}

	/**
	 * Retrieves and prints all complaints filed by students.
	 */
	public static void getComplaints() {
		if (complaints.isEmpty()) {
			System.out.println("No complaints have been filed.");
		} else {
			for (Complaint complaint : complaints) {
				System.out.println(complaint);
			}
		}
	}

	/**
	 * Retrieves the list of approved requests.
	 * 
	 * @return A list of all approved requests.
	 */
	public static List<Request> getApprovedRequests() {
		return approvedRequests;
	}

	/**
	 * Process of student requests handling. Displays pending requests to the Dean,
	 * allows selection of requests to approve, and forwards approved requests to
	 * the Manager for further processing.
	 */
	public void signRequests() {
		List<Request> pendingRequests = Data.INSTANCE.getRequests();

		if (pendingRequests.isEmpty()) {
			System.out.println("No requests to review.");
			return;
		}

		System.out.println("Pending Requests:");
		for (int i = 0; i < pendingRequests.size(); i++) {
			System.out.println((i + 1) + ". " + pendingRequests.get(i));
		}

		while (true) {
			int requestIndex = InputPrompt
					.promptIntInput("Enter the number of the request to approve (or type 'quit' to exit): ");
			if (requestIndex == -1) {
				return;
			}

			if (requestIndex < 1 || requestIndex > pendingRequests.size()) {
				System.out.println("Invalid request number. Please try again.");
				continue;
			}

			// Approve
			Request approvedRequest = pendingRequests.remove(requestIndex - 1);
			approvedRequests.add(approvedRequest);

			// Log
			String logMessage = "Approved request: " + approvedRequest.toString() + " by Dean " + this.getName() + " "
					+ this.getSurname();
			Data.INSTANCE.addLog(logMessage);

			// Send to Manager
			Manager.receiveRequest(approvedRequest);

			// Check for more
			if (pendingRequests.isEmpty()) {
				System.out.println("No more pending requests.");
				break;
			}
		}
	}

	/**
	 * The method for registering available actions in the map
	 */
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();

		functions.put(startIndex++, new NamedRunnable(Dean::getComplaints, "Get Complaints"));
		functions.put(startIndex++, new NamedRunnable(this::signRequests, "Sign Request"));

		for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}
}