package employees;

import java.util.*;

import Factories.NamedRunnable;
import documents.Complaint;

public class Dean extends Employee {

    public static Vector<Complaint> complaints = new Vector<>();

    public Dean(String login, String password) {
        super(login, password);			
        // TODO Auto-generated constructor stub
    }

    public static void getComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints have been filed.");
        } else {
            for (Complaint complaint : complaints) {
                System.out.println(complaint);
            }
        }
    }

    public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
        Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();
        // Reference the static method with the class name
        functions.put(startIndex++, new NamedRunnable(Dean::getComplaints, "Get complaints"));

        for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
            functions.put(startIndex++, entry.getValue());
        }

        return functions;
    }
}