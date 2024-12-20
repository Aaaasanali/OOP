package research;

import employees.Teacher;
import students.Student;

public class ResearchDecorator implements Researcher {
    

    private Researcher baseObject;
    

    private  papers;
    
    

    private Teacher teacher;
    

    private Student student;
    


    public Researcher getBaseObject() {
        return this.baseObject;
    }
    

    public Researcher setBaseObject(Researcher baseObject) {
        this.baseObject = baseObject;
    }
    
    

    public  getPapers() {
        return this.papers;
    }
    

    public  setPapers(invalid papers) {
        this.papers = papers;
    }
    
    
    

    public Teacher getTEacher() {
        return this.tEacher;
    }
    

    public void setTEacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    

    public Student getStudent() {
        return this.student;
    }
    

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    

    //                          Operations                                  
    

    public Researcher baseObject:() {
        //TODO
        return null;
    }
	@Override
	public void addResearchPaper() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ResearchPaper getresearchPaper() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void printResearchPaper() {
		// TODO Auto-generated method stub
		
	}
    
    
}
