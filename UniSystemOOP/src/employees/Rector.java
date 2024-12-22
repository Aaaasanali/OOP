package employees;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import database.Data;
import documents.Request;
import utils.InputPrompt;

/**
 * The Rector class represents an employee responsible for reviewing and signing
 * student requests at the highest level.
 * <p>
 * The class includes methods for interacting with pending requests, including
 * approving or rejecting them.
 * </p>
 */
public class Rector extends Employee implements Serializable {

	private static List<Request> approvedRequests = new ArrayList<>();

	public Rector(String login, String password) {
		super(login, password);
	}

	public Rector(String login, String password, String name, String surname) {
		super(login, password, name, surname);
	}

	/**
	 * Retrieves the list of requests that have been approved by the Rector.
	 * 
	 * @return A list of approved requests.
	 */
	public static List<Request> getApprovedRequests() {
		return approvedRequests;
	}

	/**
	 * Process of student requests handling. Displays pending requests to the
	 * Rector, allows selection of requests to approve, and forwards approved
	 * requests to the Manager for further processing.
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
			String logMessage = "Approved request: " + approvedRequest.toString() + " by Rector " + this.getName() + " "
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

		functions.put(startIndex++, new NamedRunnable(this::signRequests, "Sign Request"));

		for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}

}
