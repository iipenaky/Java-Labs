import java.util.Scanner;

/**
 * Main class to demonstrate the operations of the PatientQueue with user interaction.
 */
public class Main {
    /**
     * Main method to demonstrate the PatientQueue operations.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        PatientQueue queue = new PatientQueue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- Patient Queue Management ---");
                System.out.println("1. Add Patient");
                System.out.println("2. View Next Patient");
                System.out.println("3. Monitor Patient");
                System.out.println("4. Display All Patients");
                System.out.println("5. Exit");
                System.out.print("Choose an option (1-5): ");

                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter patient condition (Stable, Moderate, Critical): ");
                        String condition = scanner.nextLine();
                        System.out.print("Enter patient ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter priority level (1-5, where 1 is highest priority): ");
                        int priority = Integer.parseInt(scanner.nextLine());

                        Patient patient = new Patient(name, condition, id, priority);
                        queue.enqueue(patient);
                        System.out.println("Patient added to the queue.");
                        break;

                    case 2:
                        System.out.println("Next patient to monitor:");
                        Patient nextPatient = queue.peek();
                        if (nextPatient != null) {
                            System.out.println(nextPatient);
                        } else {
                            System.out.println("No patients in the queue.");
                        }
                        break;

                    case 3:
                        System.out.println("Monitoring patient:");
                        Patient monitoredPatient = queue.dequeue();
                        if (monitoredPatient != null) {
                            System.out.println(monitoredPatient);
                        } else {
                            System.out.println("No patients to monitor.");
                        }
                        break;

                    case 4:
                        System.out.println("Current queue:");
                        queue.displayQueue();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
