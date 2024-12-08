package oop;


/**
* @generated
*/
public class GraduateStudent extends Student {
    
    /**
    * @generated
    */
    private  projects;
    
    /**
    * @generated
    */
    private Set<ResearchProject> projects;
    
    /**
    * @generated
    */
    private Researcher supervisor;
    
    /**
    * @generated
    */
    private  attribute;
    
    
    /**
    * @generated
    */
    private Set<ResearchProject> researchProject;
    
    

    /**
    * @generated
    */
    private  getProjects() {
        return this.projects;
    }
    
    /**
    * @generated
    */
    private  setProjects(invalid projects) {
        this.projects = projects;
    }
    
    
    /**
    * @generated
    */
    private Set<ResearchProject> getProjects() {
        if (this.projects == null) {
            this.projects = new HashSet<ResearchProject>();
        }
        return this.projects;
    }
    
    /**
    * @generated
    */
    private Set<ResearchProject> setProjects(ResearchProject projects) {
        this.projects = projects;
    }
    
    
    /**
    * @generated
    */
    private Researcher getSupervisor() {
        return this.supervisor;
    }
    
    /**
    * @generated
    */
    private Researcher setSupervisor(Researcher supervisor) {
        this.supervisor = supervisor;
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
    public Set<ResearchProject> getResearchProject() {
        if (this.researchProject == null) {
            this.researchProject = new HashSet<ResearchProject>();
        }
        return this.researchProject;
    }
    
    /**
    * @generated
    */
    public Set<ResearchProject> setResearchProject(ResearchProject researchProject) {
        this.researchProject = researchProject;
    }
    
    
    

    //                          Operations                                  
    
    
}
