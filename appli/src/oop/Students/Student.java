package oop.Students;

import oop.User;

 class Student extends User implements Researcher {
    private int course;
    private int ects;
    private String id;
 
    
    public Student(String login, String password, String name, String surname, int course, int ects, String id) {
        super(login, password, name, surname);
        this.course = course;
        this.ects = ects;
        this.id = id;
    }
    
 
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return super.toString() +
                ", Student{" +
                "course=" + course +
                ", ects=" + ects +
                ", id=" + id +
                '}';
    }
}
 
}
