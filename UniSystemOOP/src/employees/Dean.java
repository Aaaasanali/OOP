package employees;

import java.util.*;

import documents.Complaint;


public class Dean {
    public static Vector<Complaint> complaints = new Vector<>();

    public static void printComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints have been filed.");
        } else {
            for (Complaint complaint : complaints) {
                System.out.println(complaint);
            }
        }
    }
}