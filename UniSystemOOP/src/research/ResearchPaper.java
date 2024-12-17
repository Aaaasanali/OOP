package research;

import java.util.Date;

import user.User;

public class ResearchPaper {
    

    private String title;
    

    private Researcher authors;
    

    private Date submitionDate;
    

    private String citations;
    
    private int pages;
    
    
    

    
    

    private String getTitle() {
        return this.title;
    }
 
    private void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
    
    private Researcher getAuthors() {
        return this.authors;
    }
    
    private void setAuthors(Researcher authors) {
        this.authors = authors;
    }
    
    
    
    
    
    private Date getSubmitionDate() {
        return this.submitionDate;
    }
  
    private void setSubmitionDate(Date submitionDate) {
        this.submitionDate = submitionDate;
    }
    
    
  

    

    private String getCitations() {
        return this.citations;
    }
    
    private void setCitations(String citations) {
        this.citations = citations;
    }
    

    
    
    private int getPages() {
        return this.pages;
    }
   
    private void setPages(Integer pages) {
        this.pages = pages;
    }

    
    
    

    //                          Operations                                  
    
    
}
