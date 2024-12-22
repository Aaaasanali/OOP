package students;

import research.Thesis;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;

/**
 * The Master class represents a graduate student pursuing a Masters degree.
 *
 * The class includes functionality for handling a thesis and provides
 * 
 * <p>
 * This class stores information specific to Master's students, such as their
 * thesis, and provides the ability to retrieve various details about the
 * student.
 * </p>
 * 
 */
public class Master extends GraduateStudent implements Serializable {

	private Thesis thesis;

	public Master() {
	}

	public Master(String login, String password, String name, String surname) {
		super(login, password, name, surname);
	}

	/**
	 * Retrieves the thesis of the Master student and prints it to the console.
	 * 
	 * <p>
	 * This method prints the string representation of the thesis to the console.
	 * </p>
	 */
	private void getThesis() {
		System.out.println(this.thesis);
	}

	/**
	 * Prints the object representation of the Master student
	 */
	private void getString() {
		System.out.println(this);
	}

	/**
	 * Sets the thesis for this Master student.
	 * 
	 * @param thesis The thesis to associate with this Master student.
	 */
	private void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	/**
	 * The method for registering available actions in the map
	 */
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();

		// Adding functions specific to the Master class
		functions.put(startIndex++, new NamedRunnable(this::getThesis, "Get Thesis"));
		// functions.put(startIndex++, new NamedRunnable(this::getString, "Get
		// String"));

		// Adding functions from the superclass (GraduateStudent)
		for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}

	@Override
	public String toString() {
		return super.toString() + ", Thesis: " + (thesis != null ? thesis.toString() : "No thesis assigned");
	}
}