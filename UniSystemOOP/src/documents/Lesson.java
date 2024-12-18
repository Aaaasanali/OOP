package documents;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;
import java.util.Date;

import employees.Teacher;
import students.Student;

public class Lesson implements Serializable{
    

    private LessonType lessonType;

    private Date time;

    private int classNumber;
    
    private String name;
    
    private Teacher teacher;

    private String discription;

    private Faculty faculty;

    private Set<Student> students;

    


    private LessonType getLessonType() {
        return this.lessonType;
    }
    
    private void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }
    
    
 
    private Date getTime() {
        return this.time;
    }

    private void setTime(Date time) {
        this.time = time;
    }
    
    

    
    private int getClassNumber() {
        return this.classNumber;
    }

    private void setClassNumber(int classNum) {
        this.classNumber = classNum;
    }
    
    

    
    
    private String getName() {
        return this.name;
    }
   
    private void setName(String name) {
        this.name = name;
    }
    
    

    private Teacher getTeacher() {
        return this.teacher;
    }
 
    
    private void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    

    private String getDiscription() {
        return this.discription;
    }
    

    private void setDiscription(String discription) {
        this.discription = discription;
    }
    
    

    private Faculty getFaculty() {
        return this.faculty;
    }
    

    private void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    

    private Set<Student> getStudents() {
        if (this.students == null) {
            this.students = new HashSet<Student>();
        }
        return this.students;
    }
    

    private void addStudents(Student student) {
        this.students.add(student);
    }

    

    
    
    
}
