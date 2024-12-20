package students;

import java.io.Serializable;
import java.util.Vector;

public class StudentOrganization implements Serializable {

	private static final long serialVersionUID = -5796256263787456014L;

    private String name;
    private String description;
    private Vector<Student> students;

    public StudentOrganization(String name, String description) {
        this.name = name;
        this.description = description;
        this.students = new Vector<Student>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vector<Student> getStudents() {
        if (this.students == null) {
            this.students = new Vector<Student>();
        }
        return this.students;
    }

    public void addMember(Student student) {
        this.students.add(student);
    }

    public void removeMember(Student student) {
        this.students.remove(student);
    }

    public void assignHead(Student student) {
        // Logic for assigning a head (optional)
    }

    public Vector<String> getStudentsNames() {
        Vector<String> res = new Vector<>();
        for (Student student : students) {
            res.add(student.getName());
        }
        return res;
    }

    @Override
    public String toString() {
        return "Organization Name: " + name + ", Description: '" + description + "', Members: " + this.getStudentsNames();
    }
}