package research;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

/**
* @generated
*/
public class Dissertation implements Serializable{
    

    private String title;
    
    private String fieldOfStudy;
    
    private Date submitionDate;

    private int numberOfChapters;
    
    private Vector<ResearchPaper> publishedResearchPapers;
    

    
    


    public Vector<ResearchPaper> getPublishedResearchPapers() {
		return publishedResearchPapers;
	}

	public void setPublishedResearchPapers(Vector<ResearchPaper> publishedResearchPapers) {
		this.publishedResearchPapers = publishedResearchPapers;
	}
	

	private String getTitle() {
        return this.title;
    }
    
    private void setTitle(String title) {
        this.title = title;
    }
    
    
    
    private String getFieldOfStudy() {
        return this.fieldOfStudy;
    }

    private void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
    
    
    
    private Date getSubmitionDate() {
        return this.submitionDate;
    }

    private void setSubmitionDate(Date submitionDate) {
        this.submitionDate = submitionDate;
    }
    
    
  
    private int getNumberOfChapters() {
        return this.numberOfChapters;
    }
    
    private void setNumberOfChapters(Integer numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }
    
    


    
    
    
    

    //                          Operations                                  
    
    
}
