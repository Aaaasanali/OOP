package oop;


/**
* @generated
*/
public class ResearchProject {
    
    /**
    * @generated
    */
    private String topic;
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private String descr;
    
    /**
    * @generated
    */
    private int publishedPapers;
    
    /**
    * @generated
    */
    private Set<Researcher> participants;
    
    /**
    * @generated
    */
    private ResearchPaper researchPaper;
    
    
    /**
    * @generated
    */
    private GraduateStudent graduateStudent;
    
    /**
    * @generated
    */
    private Set<ResearchPaper> researchPaper2;
    
    

    /**
    * @generated
    */
    private String getTopic() {
        return this.topic;
    }
    
    /**
    * @generated
    */
    private String setTopic(String topic) {
        this.topic = topic;
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
    private int getPublishedPapers() {
        return this.publishedPapers;
    }
    
    /**
    * @generated
    */
    private int setPublishedPapers(Integer publishedPapers) {
        this.publishedPapers = publishedPapers;
    }
    
    
    /**
    * @generated
    */
    private Set<Researcher> getParticipants() {
        if (this.participants == null) {
            this.participants = new HashSet<Researcher>();
        }
        return this.participants;
    }
    
    /**
    * @generated
    */
    private Set<Researcher> setParticipants(Researcher participants) {
        this.participants = participants;
    }
    
    
    /**
    * @generated
    */
    private ResearchPaper getResearchPaper() {
        return this.researchPaper;
    }
    
    /**
    * @generated
    */
    private ResearchPaper setResearchPaper(ResearchPaper researchPaper) {
        this.researchPaper = researchPaper;
    }
    
    
    
    /**
    * @generated
    */
    public GraduateStudent getGraduateStudent() {
        return this.graduateStudent;
    }
    
    /**
    * @generated
    */
    public GraduateStudent setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }
    
    
    /**
    * @generated
    */
    public Set<ResearchPaper> getResearchPaper2() {
        if (this.researchPaper2 == null) {
            this.researchPaper2 = new HashSet<ResearchPaper>();
        }
        return this.researchPaper2;
    }
    
    /**
    * @generated
    */
    public Set<ResearchPaper> setResearchPaper2(ResearchPaper researchPaper2) {
        this.researchPaper2 = researchPaper2;
    }
    
    
    

    //                          Operations                                  
    
    
}
