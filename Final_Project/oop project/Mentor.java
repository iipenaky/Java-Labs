/**
 * A class to represent the Mentor of the MentorConnect.
 * It is a sub class in which inherit from the user class.
 **/
import java.util.ArrayList;

public class Mentor extends User{
    private int yearsOfExperience;
    private String jobPosition;
    private String jobTitle;
    private String funFact;


    //Constructor
    public Mentor(int yearsOfExperience, String jobPosition, String jobTitle, String funFact, String fullName, String password, 
    String email, ArrayList<String> interests, String userName, ArrayList<String> traits, String language, String meetingType, String availability[][]){
        super(fullName, password, email, interests, userName, traits, language, meetingType, availability);
        this.yearsOfExperience=yearsOfExperience;
        this.jobPosition=jobPosition;
        this.jobTitle=jobTitle;
        this.funFact=funFact;
    }

    //Getters
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getfunFact() {
        return funFact;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    //Mutators
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setfunFact(String funFact) {
        this.funFact = funFact;
    }

    //notify mentor
    public String notifyMentor(String menteeUsername, String mentorUsername) {
        Mentee mentee = Matching.dataMentees.get(menteeUsername);
        Mentor mentor = Matching.dataMentors.get(mentorUsername);
        return "Dear " + mentor.getUserName() + " Congratulations! You have been matched with " + mentee.getUserName() + " as your mentee. Please connect with " + mentee.getUserName() + " (" + mentee.getEmail() + ") to initiate the mentorship journey." ;
    }

    //to string
    @Override
    public String toString(){
        return super.toString() + "Years of experience:" + this.yearsOfExperience + "Job Position:" + this.jobPosition + "Job Title:" + this.jobTitle
                + "Areas of Expertise:" + this.funFact;
    }
}