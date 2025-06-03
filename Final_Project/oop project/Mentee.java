/**
 * A class to represent the Mentee of the MentorConnect.
 * It is a sub class in which inherit from the user class.
 **/
import java.util.ArrayList;
public class Mentee extends User {
    private String major;
    private String careerChoice;
    private String funFact;

    //constructor
    public Mentee(String major, String careerChoice, String funFact, String fullName, String password, String email, ArrayList<String> interests, String userName, ArrayList<String> traits, String language, String meetingType, String [][]availability){
        super(fullName, password, email, interests, userName, traits, language, meetingType, availability);
        this.major = major;
        this.careerChoice = careerChoice;
        this.funFact = funFact;
    }

    //getters
    public String getMajor(){
        return this.major;
    }

    public String getCareerChoice(){
        return this.careerChoice;
    }
    
    public String getFunFact(){
        return this.funFact;
    }

    //mutators
    public void setMajor(String major){
        this.major = major;
    }

    public void setCareerChoice(String career){
        this.careerChoice = career;
    }

    public void setFunFact(String activities){
        this.funFact = activities;
    }

       
    //to string
    @Override
    public String toString(){
        return super.toString() + "Major: " + this.major + "Career Choice: " + this.careerChoice + "Perfomance: "
                + "Extra Curricualar Activities: " + this.funFact;

    }
}