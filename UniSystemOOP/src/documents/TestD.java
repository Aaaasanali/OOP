package documents;

import database.Data;

public class TestD {

	public static void main(String[] args) {
		Data.INSTANCE.addCourse(new Course("Introduction to Programming", "CSE101", 2024, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Data Structures", "CSE102", 2024, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Algorithms", "CSE201", 2025, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Computer Organization", "CSE202", 2025, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Operating Systems", "CSE203", 2025, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Database Systems", "CSE204", 2025, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Software Engineering", "CSE301", 2026, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Artificial Intelligence", "CSE302", 2026, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Machine Learning", "CSE303", 2026, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Computer Networks", "CSE304", 2026, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Cybersecurity", "CSE305", 2026, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Human-Computer Interaction", "CSE306", 2026, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Advanced Algorithms", "CSE401", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Parallel Computing", "CSE402", 2027, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Quantum Computing", "CSE403", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Compiler Design", "CSE404", 2027, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Big Data Analytics", "CSE405", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Blockchain Technology", "CSE406", 2027, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Cloud Computing", "CSE407", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Robotics", "CSE408", 2027, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Introduction to Cybersecurity", "CSE409", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Web Development", "CSE410", 2027, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Mobile App Development", "CSE411", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Game Development", "CSE412", 2027, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Introduction to VR and AR", "CSE413", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Digital Signal Processing", "CSE414", 2027, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Natural Language Processing", "CSE415", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("Introduction to Cloud Technologies", "CSE416", 2027, Semester.SPRING));
		Data.INSTANCE.addCourse(new Course("Introduction to Embedded Systems", "CSE417", 2027, Semester.FALL));
		Data.INSTANCE.addCourse(new Course("IoT Fundamentals", "CSE418", 2027, Semester.SPRING));
		
		
		
		
		Faculty fuc = new Faculty("Computer Science");
		Speciality s = new Speciality("Information Systems", fuc, true);
		
		
		s.viewCarriculum();
	}

}
