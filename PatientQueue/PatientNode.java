/**
 * Node class representing each patient in the queue.
 */
class PatientNode {
    Patient patient;
    PatientNode next;

    /**
     * Constructor to create a Node.
     * @param patient the patient to be added to the queue.
     */
    public PatientNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}
