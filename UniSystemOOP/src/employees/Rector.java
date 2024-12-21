package employees;

import java.io.Serializable;
import java.util.*;


import Factories.NamedRunnable;
import database.Data;
import documents.Request;
import utils.InputPrompt;

public class Rector extends Employee implements Serializable {

	private static List<Request> approvedRequests = new ArrayList<>();

	
	public Rector(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}
	
    public Rector(String login, String password, String name, String surname) {
    	super(login, password, name, surname);
	}
    
    
	
	public static List<Request> getApprovedRequests() {
        return approvedRequests;
    }
	
	
	
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
            int requestIndex = InputPrompt.promptIntInput("Enter the number of the request to approve (or type 'quit' to exit): ");
            if (requestIndex == -1) {
                return; // User chose to quit
            }

            if (requestIndex < 1 || requestIndex > pendingRequests.size()) {
                System.out.println("Invalid request number. Please try again.");
                continue;
            }

            // Approve the selected request
            Request approvedRequest = pendingRequests.remove(requestIndex - 1);
            approvedRequests.add(approvedRequest);
//            System.out.println("Approved request: " + approvedRequest);			To logs

            // Forward to Manager
            Manager.receiveRequest(approvedRequest);

            // Check if there are more requests to process
            if (pendingRequests.isEmpty()) {
                System.out.println("No more pending requests.");
                break;
            }
        }
    }
		

	
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Reference the static method with the class name
        
        functions.put(startIndex++, new NamedRunnable(this::signRequests, "Sign Request"));

        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }

}
