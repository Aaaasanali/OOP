package students;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import Factories.NamedRunnable;
import research.DiplomaWork;

/**
 * The Bachelor class represents a student pursuing a Bachelor's degree.
 * 
 * <p>
 * This class stores information specific to Bachelors students, such as their
 * diploma work, and provides the ability to retrieve various details about the
 * student.
 * </p>
 * 
 */
public class Bachelor extends Student implements Serializable {

	private static final long serialVersionUID = -17710899551115796L;

	private DiplomaWork diplomaWork;

	public Bachelor() {
		// Default constructor
	}

	public Bachelor(String login, String password, String name, String surname) {
		super(login, password, name, surname);
	}

	/**
	 * Returns the diploma work of the Bachelor student.
	 * 
	 * @return The diploma work of the Bachelor student.
	 */
	public DiplomaWork getDiplomaWork() {
		return diplomaWork;
	}

	/**
	 * Sets the diploma work for this Bachelor student.
	 * 
	 * @param diplomaWork The diploma work to associate with this Bachelor student.
	 */
	public void setDiplomaWork(DiplomaWork diplomaWork) {
		this.diplomaWork = diplomaWork;
	}

	/**
	 * The method for registering available actions in the map
	 */
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();

		// Adding functions specific to the Bachelor class
		functions.put(startIndex++, new NamedRunnable(this::getDiplomaWork, "Get Thesis"));
		// functions.put(startIndex++, new NamedRunnable(this::getString, "Get
		// String"));

		// Adding functions from the superclass (Student)
		for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}

	/**
	 * Returns a string representation of the Bachelor student, including the
	 * diploma work information. This method overrides the toString method of the
	 * Student class.
	 * 
	 * @return A string representation of the Bachelor student, including details of
	 *         the diploma work.
	 */
	@Override
	public String toString() {
		return super.toString() + ", Thesis: " + (diplomaWork != null ? diplomaWork.toString() : "No thesis assigned");
	}
}