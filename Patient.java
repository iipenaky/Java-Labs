
/**
 * Patient class representing a patient with vital signs, room number, and priority level.
 */
class Patient {
    String name;
    String vitalSigns;
    int ID;
    int priority;

    /**
     * Constructor to create a Patient.
     * @param name the name of the patient.
     * @param vitalSigns the vital signs of the patient.
     * @param ID the room number of the patient.
     * @param priority the priority level of the patient.
     */
    public Patient(String name, String vitalSigns, int ID, int priority) {
        this.name = name;
        this.vitalSigns = vitalSigns;
        this.ID = ID;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', vitalSigns='" + vitalSigns + "', ID=" + ID + ", priority=" + priority + '}';
    }
}
