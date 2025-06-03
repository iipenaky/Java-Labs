/**
 * PatientQueue class implementing the queue with a linked list.
 */
public class PatientQueue {
    private PatientNode front;
    private PatientNode rear;

    /**
     * Constructor to create an empty PatientQueue.
     */
    public PatientQueue() {
        this.front = null;
        this.rear = null;
    }

    /**
     * Enqueue operation to add a patient to the queue.
     * @param patient the patient to be added to the queue.
     */
    public void enqueue(Patient patient) {
        PatientNode newPatientNode = new PatientNode(patient);
        if (rear == null) {
            front = rear = newPatientNode;
        } else {
            rear.next = newPatientNode;
            rear = newPatientNode;
        }
    }

    /**
     * Dequeue operation to remove and monitor the next patient in line.
     * @return the patient to be monitored.
     * @throws IllegalStateException if the queue is empty.
     */
    public Patient dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        Patient patientToMonitor = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return patientToMonitor;
    }

    /**
     * Peek operation to view the next patient to be monitored.
     * @return the next patient to be monitored.
     * @throws IllegalStateException if the queue is empty.
     */
    public Patient peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.patient;
    }

    /**
     * Display the entire queue for debugging purposes.
     * * @throws IllegalStateException if the queue is empty.
     */
    public void displayQueue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        PatientNode current = front;
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }
}
