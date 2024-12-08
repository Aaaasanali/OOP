package oop;


/**
* @generated
*/
public class Lesson {
    
    /**
    * @generated
    */
    private LessonType lessonType;
    
    /**
    * @generated
    */
    private DateTime time;
    
    /**
    * @generated
    */
    private int class;
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private Teacher teacher;
    
    /**
    * @generated
    */
    private String discription;
    
    /**
    * @generated
    */
    private Faculty faculty;
    
    /**
    * @generated
    */
    private Set<Student> students;
    
    
    /**
    * @generated
    */
    private Course course;
    
    /**
    * @generated
    */
    private Teacher teacher;
    
    /**
    * @generated
    */
    private Faculty faculty2;
    
    /**
    * @generated
    */
    private Set<Mark> mark;
    
    /**
    * @generated
    */
    private Set<Student> student;
    
    

    /**
    * @generated
    */
    private LessonType getLessonType() {
        return this.lessonType;
    }
    
    /**
    * @generated
    */
    private LessonType setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }
    
    
    /**
    * @generated
    */
    private DateTime getTime() {
        return this.time;
    }
    
    /**
    * @generated
    */
    private DateTime setTime(DateTime time) {
        this.time = time;
    }
    
    
    /**
    * @generated
    */
    private int getClass() {
        return this.class;
    }
    
    /**
    * @generated
    */
    private int setClass(Integer class) {
        this.class = class;
    }
    
    
    /**
    * @generated
    */
    private String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    private String setName(String name) {
        this.name = name;
    }
    
    
    /**
    * @generated
    */
    private Teacher getTeacher() {
        return this.teacher;
    }
    
    /**
    * @generated
    */
    private Teacher setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
    /**
    * @generated
    */
    private String getDiscription() {
        return this.discription;
    }
    
    /**
    * @generated
    */
    private String setDiscription(String discription) {
        this.discription = discription;
    }
    
    
    /**
    * @generated
    */
    private Faculty getFaculty() {
        return this.faculty;
    }
    
    /**
    * @generated
    */
    private Faculty setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    
    /**
    * @generated
    */
    private Set<Student> getStudents() {
        if (this.students == null) {
            this.students = new HashSet<Student>();
        }
        return this.students;
    }
    
    /**
    * @generated
    */
    private Set<Student> setStudents(Student students) {
        this.students = students;
    }
    
    
    
    /**
    * @generated
    */
    public Course getCourse() {
        return this.course;
    }
    
    /**
    * @generated
    */
    public Course setCourse(Course course) {
        this.course = course;
    }
    
    
    /**
    * @generated
    */
    public Teacher getTeacher() {
        return this.teacher;
    }
    
    /**
    * @generated
    */
    public Teacher setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
    public Set<Mark> getMark() {
        if (this.mark == null) {
            this.mark = new HashSet<Mark>();
        }
        return this.mark;
    }
    
    /**
    * @generated
    */
    public Set<Mark> setMark(Mark mark) {
        this.mark = mark;
    }
    
    
    /**
    * @generated
    */
    public Faculty getFaculty2() {
        return this.faculty2;
    }
    
    /**
    * @generated
    */
    public Faculty setFaculty2(Faculty faculty2) {
        this.faculty2 = faculty2;
    }
    
    
    
}
