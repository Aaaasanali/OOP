package documents;

import java.io.Serializable;

public class Mark implements Serializable{
    private int firstAttestation;
    private int secondAttestation;
    private int finalExam;
    
    public Mark() {
    	this.firstAttestation = 0;
    	this.secondAttestation = 0;
    	this.finalExam = 0;
    }
    
    public Mark(int firstAttestation, int secondAttestation, int finalExam) {
    	
        setFirstAttestation(firstAttestation);
        setSecondAttestation(secondAttestation);
        this.finalExam = finalExam; 													
    }

    public void setFirstAttestation(int firstAttestation) {
        if (firstAttestation > 60) {
            throw new IllegalArgumentException("Attestation cannot be more than 60.");
        }
        this.firstAttestation = firstAttestation;
    }

    
    
    public void setSecondAttestation(int secondAttestation) {
        if (secondAttestation > 60) {
            throw new IllegalArgumentException("Attestation cannot be more than 60.");
        }
        if ((this.firstAttestation + secondAttestation) > 60) {
            throw new IllegalArgumentException("Sum of attestations cannot be more than 60.");
        }
        this.secondAttestation = secondAttestation;
    }

    public void setFinalExamScore(int finalScore) {
    	this.finalExam = finalScore;
    }
    
    


    
    
    
    public int getFirstAttestation() {
        return firstAttestation;
    }

    public int getSecondAttestation() {
        return secondAttestation;
    }

    public int getFinalExam() {
        return finalExam;
    }
    
    
    
    
    public double calculateGrade() {
        int total = this.firstAttestation + this.secondAttestation + this.finalExam;

        if (total >= 95) return 4.0;
        else if (total >= 90) return 3.67;
        else if (total >= 85) return 3.33;
        else if (total >= 80) return 3.0;
        else if (total >= 75) return 2.67;
        else if (total >= 70) return 2.33;
        else if (total >= 65) return 2.0;
        else if (total >= 60) return 1.67;
        else if (total >= 55) return 1.33;
        else if (total >= 50) return 1.0;
        else return 0.0;
    }
    
    
    public String calculateLetterGrade() {
    	return this.convertGradeToLetter(this.calculateGrade());
    }
    
    
    public String convertGradeToLetter(double grade) {
        if (grade == 4.0) return "A";
        else if (grade >= 3.67) return "A-";
        else if (grade >= 3.33) return "B+";
        else if (grade >= 3.0) return "B";
        else if (grade >= 2.67) return "B-";
        else if (grade >= 2.33) return "C+";
        else if (grade >= 2.0) return "C";
        else if (grade >= 1.67) return "C-";
        else if (grade >= 1.33) return "D+";
        else if (grade >= 1.0) return "D";
        else return "F"; 
    }
    
    
    
    
    
    
    public String toString() {
		return "Mark [att1=" + this.firstAttestation + ", att2=" + this.secondAttestation + ", finalExam=" + this.finalExam + "]";
	}
}