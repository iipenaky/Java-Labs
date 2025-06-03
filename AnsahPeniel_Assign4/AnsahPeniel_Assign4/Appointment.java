/**
 * A class to represent an appointment
 **/
public class Appointment {
  private String studentName;
  private String venue;
  private String purpose;
  
  // Constructor
  public Appointment(String name, String location, String whatFor) {
    studentName = name;
    venue = location;
    purpose = whatFor;
  }
  
  // Accessor method for the studentName variable
  public String getStudentName() {
    return studentName;
  }

  // Accessor method for the venue variable
  public String getVenue() {
    return venue;
  }

  // Accessor method for the purpose variable
  public String getPurpose() {
    return purpose;
  }

  // Mutator method for the studentName variable
  public void setStudentName(String name){
    studentName = name;
  }

  // Mutator method for the venue variable
  public void setVenue(String location){
    venue = location;
  }

  // Mutator method for the purpose variable
  public void setPurpose(String whatFor){
    purpose = whatFor;
  }

  // A method to display the details of the appointment
  public void displayDetails() {
    System.out.println("Student name: " + getStudentName());
    System.out.println("Venue: " + getVenue());
    System.out.println("Purpose: " + getPurpose());
  }
  
  // A method to return a String representation of the appointment
  public String toString() {
    return ("Name: " + getStudentName() + ", venue: " + getVenue() +
            ", purpose: " + getPurpose());
  }
}