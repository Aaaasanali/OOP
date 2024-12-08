package oop;


/**
* @generated
*/
public class Course {
    
    /**
    * @generated
    */
    private int id;
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private int credits;
    
    /**
    * @generated
    */
    private Set<Lesson> lessons;
    
    /**
    * @generated
    */
    private String formula;
    
    /**
    * @generated
    */
    private int year;
    
    /**
    * @generated
    */
    private Set<Teacher> teachers;
    
    /**
    * @generated
    */
    private CourseType type;
    
    /**
    * @generated
    */
    private Set<Lesson> schedule;
    
    /**
    * @generated
    */
    private  attribute;
    
    /**
    * @generated
    */
    private String descr;
    
    /**
    * @generated
    */
    private Course prerequisites;
    
    
    /**
    * @generated
    */
    private Set<Lesson> lesson;
    
    /**
    * @generated
    */
    private Admin admin;
    
    /**
    * @generated
    */
    private Set<Mark> mark;
    
    /**
    * @generated
    */
    private Student student;
    
    /**
    * @generated
    */
    private Mark mark;
    
    /**
    * @generated
    */
    private Set<Teacher> teacher;
    
    

    /**
    * @generated
    */
    private int getId() {
        return this.id;
    }
    
    /**
    * @generated
    */
    private int setId(Integer id) {
        this.id = id;
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
    private int getCredits() {
        return this.credits;
    }
    
    /**
    * @generated
    */
    private int setCredits(Integer credits) {
        this.credits = credits;
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
    private String getFormula() {
        return this.formula;
    }
    
    /**
    * @generated
    */
    private String setFormula(String formula) {
        this.formula = formula;
    }
    
    
    /**
    * @generated
    */
    private int getYear() {
        return this.year;
    }
    
    /**
    * @generated
    */
    private int setYear(Integer year) {
        this.year = year;
    }
    
    
    /**
    * @generated
    */
    private Set<Teacher> getTeachers() {
        if (this.teachers == null) {
            this.teachers = new HashSet<Teacher>();
        }
        return this.teachers;
    }
    
    /**
    * @generated
    */
    private Set<Teacher> setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }
    
    
    /**
    * @generated
    */
    private CourseType getType() {
        return this.type;
    }
    
    /**
    * @generated
    */
    private CourseType setType(CourseType type) {
        this.type = type;
    }
    
    
    /**
    * @generated
    */
    private Set<Lesson> getSchedule() {
        if (this.schedule == null) {
            this.schedule = new HashSet<Lesson>();
        }
        return this.schedule;
    }
    
    /**
    * @generated
    */
    private Set<Lesson> setSchedule(Lesson schedule) {
        this.schedule = schedule;
    }
    
    
    /**
    * @generated
    */
    public  getAttribute() {
        return this.attribute;
    }
    
    /**
    * @generated
    */
    public  setAttribute(invalid attribute) {
        this.attribute = attribute;
    }
    
    
    /**
    * @generated
    */
    private String getDescr() {
        return this.descr;
    }
    
    /**
    * @generated
    */
    private String setDescr(String descr) {
        this.descr = descr;
    }
    
    
    /**
    * @generated
    */
    private Course getPrerequisites() {
        return this.prerequisites;
    }
    
    /**
    * @generated
    */
    private Course setPrerequisites(Course prerequisites) {
        this.prerequisites = prerequisites;
    }
    
    
    
    /**
    * @generated
    */
    public Set<Teacher> getTeacher() {
        if (this.teacher == null) {
            this.teacher = new HashSet<Teacher>();
        }
        return this.teacher;
    }
    
    /**
    * @generated
    */
    public Set<Teacher> setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
    /**
    * @generated
    */
    public Mark getMark() {
        return this.mark;
    }
    
    /**
    * @generated
    */
    public Mark setMark(Mark mark) {
        this.mark = mark;
    }
    
    
    /**
    * @generated
    */
    public Admin getAdmin() {
        return this.admin;
    }
    
    /**
    * @generated
    */
    public Admin setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    /**
    * @generated
    */
    public Student getStudent() {
        return this.student;
    }
    
    /**
    * @generated
    */
    public Student setStudent(Student student) {
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
    
    
    
}
