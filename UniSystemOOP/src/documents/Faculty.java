package documents;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import students.Student;

import java.util.*;

public class Faculty{
    private String name;
    private String discription;
    private final Vector<Student> students = new Vector<>();
    private final Vector<Speciality> specialities = new Vector<>();

    public Faculty() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Vector<Student> getStudents() {
		return students;
	}

	public Vector<Speciality> getSpecialities() {
		return specialities;
	}
    
    public void addSpeciality(Speciality s) {
    	this.specialities.add(s);
    }
    
    public void addStudent(Student s) {
    	this.students.add(s);
    }
}                                  