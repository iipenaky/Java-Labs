
/**
 * A class to represent the appointment schedule for a given day.
 * Each day is assumed to have hour-long timeslots starting at 8am and
 * with the final timeslot starting at 4pm
 **/
public class DailyApptSchedule {

  private Appointment[] apptsForTheDay;  // An object array declaration

  public static final int NUM_SLOTS = 9;
  public static final String[] TIMES = {"8am", "9am", "10am", "11am", 
                                        "12noon", "1pm", "2pm", "3pm", "4pm"};

  // No-arg onstructor creates an empty schedule for a day
  public DailyApptSchedule() {
    // TO-DO
    apptsForTheDay = new Appointment[NUM_SLOTS];  
  }

  /**
   * A method to display the list of appointments for the day
   * In the format:
   *    time: appointment_info
   *    time: appointment_info ... etc
   * Any empty slots (null Appointments in the array) should be listed as Free
   */
  public void displayAppointments() {
    // TO-DO
    for (int i = 0; i < NUM_SLOTS; i++){
      if (apptsForTheDay[i] == null){
        System.out.println(TIMES[i] + " is free");
      }
      else{
        System.out.println(TIMES[i] + ": " + apptsForTheDay[i].toString());
      }
    }
  }

  /**
   * A method to add the given appointment to the schedule in the specified timeslot
   * @param whichSlot represents the index of the timeslot (Eg. 0 -> 8am, 1 -> 9am, ...)
   * @param appt represents the appointment object
   * @return true if it was successful and false if not successful
   */
  public boolean addAppointment(int whichSlot, Appointment appt) {
    // TO-DO
    if(whichSlot < 0 || whichSlot >= NUM_SLOTS || apptsForTheDay[whichSlot] != null){
      return false;
    }
    apptsForTheDay[whichSlot] = appt;
    return true;
  }

  /**
   * A method to add an appointment for the given person, venue and purpose to the schedule in the specified timeslot.
   * @param whichSlot represents the index of the timeslot (Eg. 0 -> 8am, 1 -> 9am, ...)
   * @param n represents the name of the student
   * @param v represents the location of the appointment
   * @param p represents the reason for the meeting
   * @return true if it was successful and false if not successful (i.e. if the given slot is invalid or taken)
   */
  public boolean addAppointment(int whichSlot, String n, String v, String p) {
    // TO-DO
    if(whichSlot < 0 || whichSlot >= NUM_SLOTS || apptsForTheDay[whichSlot] != null){
      return false;
    }
    Appointment appt = new Appointment(n, v, p);
    apptsForTheDay[whichSlot] = appt;
    return true;
  }

  /**
   * A method to add the given appointment to the schedule in any free timeslot.
   * @param appt represents the appointment object
   * @return the index of the chosen timeslot or -1 if no free timeslot exists.
   */
  public int addAppointment(Appointment appt) {
    // TO-DO
    for(int i = 0; i < NUM_SLOTS; i++ ){
      if (apptsForTheDay[i] == null){
        apptsForTheDay[i] = appt;
        return i;
      }  
    }
    return -1;
  }

  /**
   * A method to add an appointment for the given person, venue and purpose
   * @param n represents the name of the student
   * @param v represents the location of the appointment
   * @param p represents the reason for the meeting
   * @return the index of the chosen timeslot or -1 if no free timeslot exists.
   */
  public int addAppointment(String n, String v, String p) {
    // TO-DO
    Appointment appt = new Appointment(n,v,p);
    for(int i = 0; i < NUM_SLOTS; i++){
      if(apptsForTheDay[i] == null){
        apptsForTheDay[i] = appt;
        return i;
      }
    }
    return -1;
  }

  /**
   * Remove the appointment in the given slot
   * @param slot the index of the timeslot
   * @return true if operation was successful and false if not
   */
  public boolean removeAppointment(int slot){
    // TO-DO
    if (slot >= 0 && slot < NUM_SLOTS && apptsForTheDay[slot] != null) {
      apptsForTheDay[slot] = null;
      return true;
    }
    return false;
  }

  /**
   * Remove the appointment corresponding to the given student name
   * @param n represents the name of the student
   * @return true if operation was successful and false if not
   */
  public boolean removeAppointment(String n){
      // TO-DO
      for (int i = 0; i < NUM_SLOTS; i++) {
        if (apptsForTheDay[i] != null && apptsForTheDay[i].getStudentName().equalsIgnoreCase(n)) {
          apptsForTheDay[i] = null;
        }
        return true;
      }
      return false;
  }
   /**
   * A method to reschedule an appointment
   * @param newSlot represents the time to be rescheduled to
   * @param oldSlot represents the time of the old slot
   * @param appt represents the appointment to reschedule
   * @return true if it was successful and false if it wasn't.
   */
 
  public boolean rescheduleAppointment(int oldSlot, int newSlot, Appointment appt){
    // TO-DO
      if ((newSlot < 0 || newSlot >= NUM_SLOTS) && (oldSlot < 0 || oldSlot >= NUM_SLOTS) && apptsForTheDay[newSlot] != null && apptsForTheDay[oldSlot] == null && !(equals(appt, apptsForTheDay[oldSlot]))) {
        return false;
      }
      else{
        apptsForTheDay[newSlot] = apptsForTheDay[oldSlot];
        apptsForTheDay[oldSlot] = null;
        return true;
      }
}

//A method to check if two appointments are the same.
public boolean equals(Appointment appt1, Appointment appt2){
  if (appt1.getStudentName().equalsIgnoreCase(appt2.getStudentName()) && appt1.getVenue().equalsIgnoreCase(appt2.getVenue()) && appt1.getPurpose().equalsIgnoreCase(appt2.getPurpose())){
    return true;
  }
  return false;
}
   
}