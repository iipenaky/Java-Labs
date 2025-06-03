import java.util.Scanner;

/**
 * The FlashcardManager class provides methods to manage multiple subjects of flashcards.
 * It allows creating new subject, adding flashcards to subjects, studying flashcards by popping them from subjectstacks,
 * printing the contents of a specific subject, and printing the progress of all subject.
 */
public class FlashcardManager {
     /**
     * Main method to demonstrate the FlashCard Manager operations.
     * @param args command-line arguments.
     */
      public static void main(String[] args) {
        SubjectsList subject = new SubjectsList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your revision site. You can be assured that your revision would go smoothly.");
        while (true) {
            try {
                System.out.println("\n--- Flashcard Manager ---");
                System.out.println("1. Create Subject Stack");
                System.out.println("2. Add Flashcard to Subject Stack");
                System.out.println("3. Print Flashcards in a Specific Subject");
                System.out.println("4. Print Learning Progress");
                System.out.println("5. Study Flashcard");
                System.out.println("6. Exit");
                System.out.print("Choose an option (1-6): ");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Enter the subject name: ");
                        String stackName = scanner.nextLine();
                        subject.addSubject(stackName);
                        break;

                    case 2:
                        System.out.print("Enter the subject stack name: ");
                        String subjectName = scanner.nextLine();
                        System.out.print("Enter the flashcard question: ");
                        String question = scanner.nextLine();
                        System.out.print("Enter the flashcard answer: ");
                        String answer = scanner.nextLine();
                        SubjectStack stack = subject.findSubject(subjectName);
                        stack.push(new Flashcard(question, answer));
                        break;

                    case 3:
                        System.out.print("Enter the subject stack name to print: ");
                        subjectName = scanner.nextLine();
                        stack = subject.findSubject(subjectName);
                        if (stack.isEmpty() == true) {
                            throw new IllegalStateException("Oops..... The stack is empty");
                                }
                        System.out.println(stack.toString());
                        break;

                    case 4:
                        System.out.println();
                        subject.printSubjects();
                        break;

                    case 5:
                        System.out.print("Enter the subject stack name to study: ");
                        subjectName = scanner.nextLine();
                        stack = subject.findSubject(subjectName);
                        if (stack.isEmpty() == true){
                            throw new IllegalStateException("The stack is empty");
                        }
                        Flashcard flashcard = stack.pop();
                        System.out.println("Studying Flashcard:");
                        System.out.println("Question: " + flashcard.getQuestion());
                        System.out.println("Answer: " + flashcard.getAnswer());
                        break;

                    case 6:
                        System.out.println("Exiting... Thank you for using the Flashcard Manager! Hope to see you sooooooon");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 6.");
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage() +"\nPress enter to continue.");
                scanner.nextLine();
            }
        }
    }
}
