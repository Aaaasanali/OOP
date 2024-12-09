package oop.Students;

import oop.User;

/**
* @generated
*/
public class Student extends User implements Researcher {

    private String name;
    
    /**
    * @generated
    */
    private int course;
    
    /**
    * @generated
    */
    private int ects;
    
    /**
    * @generated
    */
    private int admissionYear;
    
    /**
    * @generated
    */
    private Speciality speciality;
    
    /**
    * @generated
    */
    private int id;
    
    /**
    * @generated
    */
    private studyType studyType;
    
    /**
    * @generated
    */
    private  attribute2;
    
    /**
    * @generated
    */
    private  attribute;
    
    /**
    * @generated
    */
    private  attribute3;
    
    /**
    * @generated
    */
    private  attribute4;
    
    /**
    * @generated
    */
    private  attribute5;
    
    /**
    * @generated
    */
    private Set<Document> documents;
    
    /**
    * @generated
    */
    private Set<Lesson> lessons;
    
    /**
    * @generated
    */
    private  attribute6;
    
    /**
    * @generated
    */
    private Set<StudentOrganization> studentOrganizations;
    
    /**
    * @generated
    */
    private Set<int> fails;
    
    /**
    * @generated
    */
    private Set<int> MAXCREDITS;
    
    /**
    * @generated
    */
    private Faculty faculty;
    
    
    /**
    * @generated
    */
    private Set<Teacher> teaches;
    
    /**
    * @generated
    */
    private Faculty faculty2;
    
    /**
    * @generated
    */
    private Set<Lesson> lesson;
    
    /**
    * @generated
    */
    private Set<StudentOrganization> studentOrganization;
    
    /**
    * @generated
    */
    private Set<Mark> mark;
    
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
    private Mark mark;
    
    /**
    * @generated
    */
    private Set<Speciality> speciality2;
    
    /**
    * @generated
    */
    private Speciality speciality2;
    
    

    /**
    * @generated
    */
    public String getId() {
        return this.id;
    }
    
    /**
    * @generated
    */
    public String setId(String id) {
        this.id = id;
    }
    
    
    /**
    * @generated
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    public String setName(String name) {
        this.name = name;
    }
    
    
    /**
    * @generated
    */
    private int getCourse() {
        return this.course;
    }
    
    /**
    * @generated
    */
    private int setCourse(Integer course) {
        this.course = course;
    }
    
    
    /**
    * @generated
    */
    private int getEcts() {
        return this.ects;
    }
    
    /**
    * @generated
    */
    private int setEcts(Integer ects) {
        this.ects = ects;
    }
    
    
    /**
    * @generated
    */
    private int getAdmissionYear() {
        return this.admissionYear;
    }
    
    /**
    * @generated
    */
    private int setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }
    
    
    /**
    * @generated
    */
    private Speciality getSpeciality() {
        return this.speciality;
    }
    
    /**
    * @generated
    */
    private Speciality setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    
    
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
    private studyType getStudyType() {
        return this.studyType;
    }
    
    /**
    * @generated
    */
    private studyType setStudyType(studyType studyType) {
        this.studyType = studyType;
    }
    
    
    /**
    * @generated
    */
    public  getAttribute2() {
        return this.attribute2;
    }
    
    /**
    * @generated
    */
    public  setAttribute2(invalid attribute2) {
        this.attribute2 = attribute2;
    }
    
    
    /**
    * @generated
    */
    private  getAttribute() {
        return this.attribute;
    }
    
    /**
    * @generated
    */
    private  setAttribute(invalid attribute) {
        this.attribute = attribute;
    }
    
    
    /**
    * @generated
    */
    private  getAttribute3() {
        return this.attribute3;
    }
    
    /**
    * @generated
    */
    private  setAttribute3(invalid attribute3) {
        this.attribute3 = attribute3;
    }
    
    
    /**
    * @generated
    */
    private  getAttribute4() {
        return this.attribute4;
    }
    
    /**
    * @generated
    */
    private  setAttribute4(invalid attribute4) {
        this.attribute4 = attribute4;
    }
    
    
    /**
    * @generated
    */
    private  getAttribute5() {
        return this.attribute5;
    }
    
    /**
    * @generated
    */
    private  setAttribute5(invalid attribute5) {
        this.attribute5 = attribute5;
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
    private  getAttribute6() {
        return this.attribute6;
    }
    
    /**
    * @generated
    */
    private  setAttribute6(invalid attribute6) {
        this.attribute6 = attribute6;
    }
    
    
    /**
    * @generated
    */
    private Set<StudentOrganization> getStudentOrganizations() {
        if (this.studentOrganizations == null) {
            this.studentOrganizations = new HashSet<StudentOrganization>();
        }
        return this.studentOrganizations;
    }
    
    /**
    * @generated
    */
    private Set<StudentOrganization> setStudentOrganizations(StudentOrganization studentOrganizations) {
        this.studentOrganizations = studentOrganizations;
    }
    
    
    /**
    * @generated
    */
    private Set<int> getFails() {
        if (this.fails == null) {
            this.fails = new HashSet<int>();
        }
        return this.fails;
    }
    
    /**
    * @generated
    */
    private Set<int> setFails(Integer fails) {
        this.fails = fails;
    }
    
    
    /**
    * @generated
    */
    private Set<int> getMAXCREDITS() {
        if (this.MAXCREDITS == null) {
            this.MAXCREDITS = new HashSet<int>();
        }
        return this.MAXCREDITS;
    }
    
    /**
    * @generated
    */
    private Set<int> setMAXCREDITS(Integer MAXCREDITS) {
        this.MAXCREDITS = MAXCREDITS;
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
    public Set<StudentOrganization> getStudentOrganization() {
        if (this.studentOrganization == null) {
            this.studentOrganization = new HashSet<StudentOrganization>();
        }
        return this.studentOrganization;
    }
    
    /**
    * @generated
    */
    public Set<StudentOrganization> setStudentOrganization(StudentOrganization studentOrganization) {
        this.studentOrganization = studentOrganization;
    }
    
    
    /**
    * @generated
    */
    public Set<Teacher> getTeaches() {
        if (this.teaches == null) {
            this.teaches = new HashSet<Teacher>();
        }
        return this.teaches;
    }
    
    /**
    * @generated
    */
    public Set<Teacher> setTeaches(Teacher teaches) {
        this.teaches = teaches;
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
    public Set<Speciality> getSpeciality2() {
        if (this.speciality2 == null) {
            this.speciality2 = new HashSet<Speciality>();
        }
        return this.speciality2;
    }
    
    /**
    * @generated
    */
    public Set<Speciality> setSpeciality2(Speciality speciality2) {
        this.speciality2 = speciality2;
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
    
    
    /**
    * @generated
    */
    public Speciality getSpeciality2() {
        return this.speciality2;
    }
    
    /**
    * @generated
    */
    public Speciality setSpeciality2(Speciality speciality2) {
        this.speciality2 = speciality2;
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
    
    /**
    * @generated
    */
    public Course viewCourse() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public Course viewCourse() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void registeForCourse() {
        //TODO
    }
    
    /**
    * @generated
    */
    public String viewTeacherInfo() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public String viewMarks() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public String viewTranscript() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public String getTranscript() {
        //TODO
        return "";
    }
    
    
}
