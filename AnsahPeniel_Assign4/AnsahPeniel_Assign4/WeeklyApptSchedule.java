
import java.util.Scanner;
public class WeeklyApptSchedule{
   
   private DailyApptSchedule[] apptsForTheWeek;
   
   public static final int NUM_DAYS = 5;
   public static final String[] DAYS = {"Monday", "Tuesday", "Wednesday", 
     "Thursday", "Friday"};
   public enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};
   
   // No-arg constructor creates an array of DailyApptSchedule 
   // for the week
   public WeeklyApptSchedule()
   {
      // TO-DO
      apptsForTheWeek = new DailyApptSchedule[NUM_DAYS];
      for(int i = 0; i < NUM_DAYS; i++){
         apptsForTheWeek[i] = new DailyApptSchedule();
      }
   }
   
   // display weekly appointments
   // Display the set of appointsments for the week by showing
   // the schedule for each day.
   public void displayWeeklyAppointments() {
      // TO-DO
      for(int i = 0; i < NUM_DAYS; i++){
         System.out.println(DAYS[i] + "'s Appointments are :");
         apptsForTheWeek[i].displayAppointments();
      }
      

   }
   
   // Add an appointment for a given timeslot on a given day.
   // Note: You may find it helpful to invoke day.ordinal()
   // ordinal() is a method automatically defined for enumerations 
   // it gives an "index" of a particular value in the enumeration.
   public boolean addAppointment(Appointment appt, Day day, int timeSlot){
     // TO-DO
     if((day.ordinal()< 0 || day.ordinal() >= Day.values().length) && apptsForTheWeek[day.ordinal()] != null ){
      return false;
     }
     apptsForTheWeek[day.ordinal()].addAppointment(timeSlot, appt);
     return true;
   }
   
   // Cancels (removes) the appointment in a given timeslot on
   // a given day
   public void cancelAppointment(Day day, int timeSlot) {
      // TO-DO 
      apptsForTheWeek[day.ordinal()].removeAppointment(timeSlot);
      
   }

    
    //A method to reschedule an appointment in a given day
   public boolean rescheduleAppointment(Day day, Appointment appt, int newSlot, int oldSlot) {

      if (day.ordinal() >= 0 && day.ordinal() < NUM_DAYS) {
         apptsForTheWeek[day.ordinal()].rescheduleAppointment(oldSlot, newSlot, appt);
         return true;
      }
      return false;
      }

   public static void main(String[] args) {
      //Create anew scanner object to interact with the user.
      Scanner scanner = new Scanner(System.in);
      //Creating a wekkly appointment schedule.
      WeeklyApptSchedule schedule = new WeeklyApptSchedule();

      //An infinite loop to keep the program running till the user chooses to exit the application.
      while(true) {
         //Display the options the user can choose from
          System.out.println("Enter 1 to book an appointment for a day and time.");
          System.out.println("Enter 2 to cancel an appointment.");
          System.out.println("Enter 3 to reschedule an appointment.");
          System.out.println("Enter 4 to display the list of appointments.");
          System.out.println("Enter 5 to exit the application.");

          //Store the user input
          int userResponse = scanner.nextInt();
          scanner.nextLine(); 

          //Switching based on user input
          switch (userResponse) {
            case 1:
              //book appointment
                  System.out.println("Please enter the day you want to book your appointment (Monday, Tuesday, etc.): ");
                  String day = scanner.nextLine();
                  WeeklyApptSchedule.Day apptDay = WeeklyApptSchedule.Day.valueOf(day.toUpperCase());

                  System.out.println("Please enter the timeslot for the desired appointment where 8am is 0 and 4pm is 8: ");
                  int timeSlot = scanner.nextInt();
                  scanner.nextLine();

                  System.out.println("Please enter your name: ");
                  String name = scanner.nextLine();
                  
                  System.out.println("Please enter the venue of the appointment: ");
                  String venue = scanner.nextLine();
                  
                  System.out.println("Please enter the purpose of the appointment: ");
                  String purpose = scanner.nextLine();

                  Appointment newAppt = new Appointment(name, venue, purpose);

                  boolean appointmentBooking = schedule.addAppointment(newAppt, apptDay, timeSlot);

                  if (appointmentBooking == true){
                     System.out.println("The appointment has been booked.");
                  }
                  else{
                     System.out.println("The appointment could not be booked due to reasons like invalid time, or the time is filled.");
                  }

                  break;
            case 2:
              // cancel appointment
                  System.out.println("Please enter the day of the appointment you want to cancel (Monday - Friday): ");
                  String cancelDay = scanner.nextLine();
                  WeeklyApptSchedule.Day cancelApptDay = WeeklyApptSchedule.Day.valueOf(cancelDay.toUpperCase());

                  System.out.println("Please enter the timeslot of the appointment you want to cancel where 8am is 0 and 4pm is 8:  ");
                  int cancelTimeSlot = scanner.nextInt();
                  scanner.nextLine(); 

                  schedule.cancelAppointment(cancelApptDay, cancelTimeSlot);
                  break;
            case 3:
                  // Reschedule Appointment
                  System.out.println("Please enter the day of the appointment you want to reschedule (Monday - Friday): ");
                  String rescheduleDay = scanner.nextLine();
                  WeeklyApptSchedule.Day reDay = WeeklyApptSchedule.Day.valueOf(rescheduleDay.toUpperCase());

                  System.out.println("Please enter the old slot of the appointment you want to reschedule: ");
                  int oldSlot = scanner.nextInt();

                  System.out.println("Please enter the slot you want to move your appointment to: ");
                  int newSlot = scanner.nextInt();
                  scanner.nextLine();


                  System.out.println("To verify if it is your appointment you are rescheduling: ");
                  System.out.println("Please enter the name you registered with: ");
                  String apptName = scanner.nextLine();

                  System.out.println("Please enter the venue of the appointment you registered for: ");
                  String apptVenue = scanner.nextLine();

                  System.out.println("Finally, please enter the purpose of the appointment you scheduled for: ");
                  String apptPurpose = scanner.nextLine();

                  Appointment appt = new Appointment(apptName, apptVenue, apptPurpose) ;
                  boolean appointmentReschedule = schedule.rescheduleAppointment(reDay, appt, newSlot, oldSlot);

                  if(appointmentReschedule == true){
                     System.out.println("Your appointment has been rescheduled successfully. ");
                  }
                  else{
                     System.out.println("The apointment can't be rescheduled because the information you gave about the appointment is wrong.");
                  }

                  break;
            case 4:
                  //Display the appointments of the week
                  schedule.displayWeeklyAppointments();
                  break;
            case 5:
                  //Exit the application
                  System.out.println("You have successfully exited the application.");
                  scanner.close();
                  return;
            default:
                  //Prompt user about invalid choice
                  System.out.println("The choice entered is invalid. Please try again.");
          }
      }
  }

}