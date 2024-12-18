package employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import Messages.Message;
import user.User;

public class Employee extends User {

	public String department;
	private List<Message> messageInbox;

	{
		messageInbox = new ArrayList<Message>();
	}

	public Employee(String login, String password) {
		super(login, password);
	}

	public String getDepartment() {
		return department;
	}

	protected void setDepartment(String department) {
		this.department = department;
	}

	private void sendMessage(User other, String message) {

	}

	private void checkInbox() {

	}

	public String toString() {
		return "Employee is placed in " + department + " department";
	}

}
