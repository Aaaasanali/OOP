package students;

import java.io.Serializable;
import java.util.*;

import Factories.NamedRunnable;
import research.Dissertation;
import research.Researcher;

/**
 * The PhD class represents a graduate student pursuing a PhD. It extends the
 * 
 * <p>
 * This class stores information specific to PhD students, such as their
 * dissertation, and provides the ability to retrieve various details about the
 * student
 * </p>
 * 
 */
public class PhD extends GraduateStudent implements Serializable {

	private Dissertation dissertation;

	public PhD(String login, String password, String name, String surname) {
		super(login, password, name, surname);
		this.setResearcherAccount(new Researcher(login, password, name, surname));
	}

	public PhD() {
		super.researcherStatus(true);
	}

	/**
	 * Returns the dissertation associated with this PhD student.
	 * 
	 * @return The dissertation of the PhD student, or null if no dissertation is
	 *         set.
	 */
	private Dissertation getDissertation() {
		return this.dissertation;
	}

	/**
	 * Sets the dissertation for this PhD student.
	 * 
	 * @param dissertation The dissertation to associate with this PhD student.
	 */
	private void setDissertation(Dissertation dissertation) {
		this.dissertation = dissertation;
	}

	private String getString() {
		return this.toString();
	}

	@Override
	public String toString() {
		return super.toString() + ", PhD{" + "dissertation="
				+ (dissertation != null ? dissertation.toString() : "No dissertation") + '}';
	}

	/**
	 * The method for registering available actions in the map
	 */
	public Map<Integer, NamedRunnable> getFunctionsMap(int startIndex) {
		Map<Integer, NamedRunnable> functions = new LinkedHashMap<>();

		// Adding functions specific to the PhD class
		functions.put(startIndex++, new NamedRunnable(this::getDissertation, "Get Dissertation"));
		functions.put(startIndex++, new NamedRunnable(this::getString, "Get String"));

		// Adding functions from the superclass (GraduateStudent)
		for (Map.Entry<Integer, NamedRunnable> entry : super.getFunctionsMap(startIndex).entrySet()) {
			functions.put(startIndex++, entry.getValue());
		}

		return functions;
	}
}