/**
 * A class to represent the User class of the MentorConnect.
 * It is a sub class in which inherit from the user class.
 **/
import java.util.ArrayList;
public class User {
    private String fullName;
    private String email;
    private String password;
    private String meetingType;
    private ArrayList<String> interests;
    private String userName;
    private ArrayList<String> personalityTraits;
    private String[][] availability;
    private String preferredLanguage;

    //Constructor
    public User(String name, String password, String email, ArrayList<String> interests, String userName, ArrayList<String> traits, String language, String meetingType, String [][]availability){
        this.userName = userName;
        this.availability = availability;
        this.email = email;
        this.meetingType= meetingType;
        this.interests = interests;
        this.password = password;
        this.preferredLanguage = language;
        this.personalityTraits = traits;
        this.fullName = name;
    }

    //getters
    public String getFullName(){
        return this.fullName;
    }

    public String getPassword(){
        return this.password;
    }
    public ArrayList<String> getInterests(){
        return this.interests;
    }

    public String getEmail(){
        return this.email;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getLanguage(){
        return this.preferredLanguage;
    }

    public ArrayList<String> getTraits(){
        return this.personalityTraits;
    }

    public String getMeetingType(){
        return this.meetingType;
    }

    public String[][] getAvailability(){
        return this.availability;
    }

    //setters
    public void setFullName(String name){
        this.fullName = name;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setInterests(ArrayList<String> interests){
        this.interests = interests;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setLanguage(String language){
        this.preferredLanguage = language;
    }

    public void setTraits(ArrayList<String> traits){
        this.personalityTraits = traits;
    }

    public void setMeetingType(String meetType){
        this.meetingType = meetType;
    }

    public void setAvailability(String[][] availability){
        this.availability = availability;
    }

    //authenticate
    public boolean authenticate(String userName, String password){
        return getUserName().equals(userName) && getPassword().equals(password);
    }

    //to string
    public String toString(){
        return "Name: " + getFullName() + "Email: " + getEmail() + "Password: " + getPassword() + "Meeting Type :" + getMeetingType() + "Interest: " + getInterests() + "User name: " + getUserName() + "Language: " + getLanguage();
    }
}