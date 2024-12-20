package research;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import students.GraduateStudent;

public class ResearchProject implements Serializable{
    

    private String topic;
   
    private String description;

    private int publishedPapers;
    
    private Set<Researcher> participants;
    
    private ResearchPaper researchPaper;
    
    
    private String getTopic() {
        return this.topic;
    }
    

    private void setTopic(String topic) {
        this.topic = topic;
    }
    
 
    private String getDescription() {
        return this.description;
    }

    
    private void setDescr(String description) {
        this.description = description;
    }
    
    

    private int getPublishedPapers() {
        return this.publishedPapers;
    }
    
 
    private void setPublishedPapers(Integer publishedPapers) {
        this.publishedPapers = publishedPapers;
    }
    
    

    private Set<Researcher> getParticipants() {
        if (this.participants == null) {
            this.participants = new HashSet<Researcher>();
        }
        return this.participants;
    }
    

    private void addParticipants(Researcher participant) {								//add participant
        this.participants.add(participant);
    }
    
    

    private ResearchPaper getResearchPaper() {
        return this.researchPaper;
    }
    

    private void setResearchPaper(ResearchPaper researchPaper) {
        this.researchPaper = researchPaper;
    }
    
    

    
    

    //                          Operations                                  
    
    
}
