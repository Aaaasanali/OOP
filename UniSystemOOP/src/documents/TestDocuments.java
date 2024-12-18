package documents;

public class TestDocuments {

	public static void main(String[] args) {
		
		
		
		
//		Mark m = new Mark();
//		
//		m.setFirstAttestation(60);
//		m.setSecondAttestation(0);
//		m.setFinalExamScore(29);
//		
//		
//		
//		System.out.println(m.calculateGrade());
//		System.out.println(m.calculateLetterGrade());
//		System.out.println(m);


		
		
		
		/*
        Lesson lesson1 = new Lesson("Lecture 1", "Introduction to Programming");
        Lesson lesson2 = new Lesson("Lecture 2", "Object-Oriented Programming");

        // Creating a sample teacher
        Teacher teacher1 = new Teacher("Dr. John Doe");
        Teacher teacher2 = new Teacher("Prof. Jane Smith");
*/
		
        
//        CourseType courseType = CourseType.MAJOR;  

        
        //Course prerequisiteCourse = new Course(101, "Intro to CS", 3, Arrays.asList(lesson1, lesson2), "Basic knowledge of CS", 2023, Arrays.asList(teacher1), courseType, Arrays.asList(lesson1), "Introduction to computer science", null);

        // Creating a new Course
//        Course newCourse = new Course(
//                202, // id
//                "Advanced Programming", // name
//                5, // credits
//                
//                //Arrays.asList(lesson1, lesson2), // lessons
//                
//                "Advanced topics in programming", // formula
//                2024, // year
//                //Arrays.asList(teacher1, teacher2), // teachers
//                courseType, // type
//               // Arrays.asList(lesson1, lesson2), // schedule
//                "This course will cover advanced programming concepts such as algorithms and data structures", // description
//               // Arrays.asList(prerequisiteCourse) // prerequisites
//        );

        // Print course details
        //System.out.println(newCourse);
		
        
        
        
        
        Course c1 = new Course("OOP", 2024, Semester.FALL);
        Course c2 = new Course("1", "OOP", 6, "2/0/1", 2024, CourseType.MAJOR, "descr", Semester.FALL);
		
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        System.out.println(c1.equals(c2));
        
	}

}
