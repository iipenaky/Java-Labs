import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void guessGame(long seed) {
        Random random = new Random(seed); 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Welcome to the guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");
        int number = random.nextInt(100) + 1;
        int attempts = 0;

        while (true) {
            System.out.print("Guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < number) {
                System.out.println("Good try, but that's too low. Try again.");
            } else if (guess > number) {
                System.out.println("Good try, but that's too high. Try again.");
            } else {
                if (attempts == 1){
                    System.out.println("Yes! You guessed correctly after " + attempts + " try! Congratulations.");
                    break; 
                } else{
                    System.out.println("Yes! You guessed correctly after " + attempts + " tries! Congratulations.");
                    break;

                }
               
            }
        }

        
    }

    public static void main(String[] args) {
        guessGame(5); 
    }
}
