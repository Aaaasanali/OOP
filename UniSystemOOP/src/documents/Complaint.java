package documents;

import java.io.Serializable;

import communication.Message;
import employees.UrgencyLevel;

public class Complaint extends Message implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String teacherName;
	private final String complaintText;
	private final UrgencyLevel urgencyLevel;

	public Complaint(String teacherName, String complaintText, UrgencyLevel urgencyLevel) {
		this.teacherName = teacherName;
		this.complaintText = complaintText;
		this.urgencyLevel = urgencyLevel;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getComplaintText() {
		return complaintText;
	}

	public UrgencyLevel getUrgencyLevel() {
		return urgencyLevel;
	}

	@Override
	public String toString() {
		return String.format("Complaint from %s: [%s] %s", teacherName, urgencyLevel, complaintText);
	}
}