package employees;


/**
* @generated
*/
public class Teacher extends Employee implements Researcher {
    
    /**
    * @generated
    */
    private Set<Course> courses;
    
    /**
    * @generated
    */
    private double rating;
    
    /**
    * @generated
    */
    private Set<Lesson> lessons;
    
    /**
    * @generated
    */
    private boolean ;
    
    /**
    * @generated
    */
    private TeacherTitle teacherType;
    
    /**
    * @generated
    */
    private Set<Document> documents;
    
    
    /**
    * @generated
    */
    private Set<Lesson> lesson;
    
    /**
    * @generated
    */
    private Set<Course> course;
    
    /**
    * @generated
    */
    private Set<Document> document;
    
    /**
    * @generated
    */
    private Set<Student> student;
    
    

    /**
    * @generated
    */
    private Set<Course> getCourses() {
        if (this.courses == null) {
            this.courses = new HashSet<Course>();
        }
        return this.courses;
    }
    
    /**
    * @generated
    */
    private Set<Course> setCourses(Course courses) {
        this.courses = courses;
    }
    
    
    /**
    * @generated
    */
    private double getRating() {
        return this.rating;
    }
    
    /**
    * @generated
    */
    private double setRating(Real rating) {
        this.rating = rating;
    }
    
    
    /**
    * @generated
    */
    private Set<Lesson> getLessons() {
        if (this.lessons == null) {
            this.lessons = new HashSet<Lesson>();
        }
        return this.lessons;
    }
    
    /**
    * @generated
    */
    private Set<Lesson> setLessons(Lesson lessons) {
        this.lessons = lessons;
    }
    
    
    /**
    * @generated
    */
    private boolean get() {
        return this.;
    }
    
    /**
    * @generated
    */
    private boolean set(Boolean ) {
        this. = ;
    }
    
    
    /**
    * @generated
    */
    private TeacherTitle getTeacherType() {
        return this.teacherType;
    }
    
    /**
    * @generated
    */
    private TeacherTitle setTeacherType(TeacherTitle teacherType) {
        this.teacherType = teacherType;
    }
    
    
    /**
    * @generated
    */
    private Set<Document> getDocuments() {
        if (this.documents == null) {
            this.documents = new HashSet<Document>();
        }
        return this.documents;
    }
    
    /**
    * @generated
    */
    private Set<Document> setDocuments(Document documents) {
        this.documents = documents;
    }
    
    
    
    /**
    * @generated
    */
    public Set<Student> getStudent() {
        if (this.student == null) {
            this.student = new HashSet<Student>();
        }
        return this.student;
    }
    
    /**
    * @generated
    */
    public Set<Student> setStudent(Student student) {
        this.student = student;
    }
    
    
    /**
    * @generated
    */
    public Set<Course> getCourse() {
        if (this.course == null) {
            this.course = new HashSet<Course>();
        }
        return this.course;
    }
    
    /**
    * @generated
    */
    public Set<Course> setCourse(Course course) {
        this.course = course;
    }
    
    
    /**
    * @generated
    */
    public Set<Document> getDocument() {
        if (this.document == null) {
            this.document = new HashSet<Document>();
        }
        return this.document;
    }
    
    /**
    * @generated
    */
    public Set<Document> setDocument(Document document) {
        this.document = document;
    }
    
    
    /**
    * @generated
    */
    public Set<Lesson> getLesson() {
        if (this.lesson == null) {
            this.lesson = new HashSet<Lesson>();
        }
        return this.lesson;
    }
    
    /**
    * @generated
    */
    public Set<Lesson> setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
    
    

    //                          Operations                                  
    
    
}
