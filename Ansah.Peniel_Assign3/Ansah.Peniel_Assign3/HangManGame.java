import java.util.Random;
import java.util.Scanner;

public class HangManGame {
    public static void main(String[] args) {
        
        // Array of words to choose from
        String [] words = {"something", "fun", "crazy", "lover", "loathe", "peripheral"};
        // Check if there are words provided to use in the command line.
        if (args.length > 0) {
            words = args;
        }

        // Get a random word for the user to guess
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        String randWord = words[index];
        String randomWord = randWord.toLowerCase();
       
        // Generate the asterisks of the chosen word's length.
        String hidden = "";
        for (int i = 0; i < randomWord.length(); i++) {
            hidden += "*";
        }

        // Change hidden word's length of asterisks into an array to be mutable.
        char [] hiddenArray = new char[hidden.length()];
        for (int i = 0; i < hiddenArray.length; i++) {
            hiddenArray[i] = hidden.charAt(i);
        }
        String str = new String(hiddenArray);
        // Display the current state of the word with guessed letters revealed
        str = new String(hiddenArray);
        //System.out.println(str);

        // Initialize scanner to take user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for the first guess
        System.out.println("(Guess) Enter a letter in the word:" + str + " >");
        char guessedLetter = scanner.next().toLowerCase().charAt(0);
        
        // Number of allowed guesses
        int numGuessAllowed = 10;
        

        // Main game loop
        while (numGuessAllowed > 0) {
            if(str.contains(String.valueOf(guessedLetter))){
                // Display the current state of the word with guessed letters revealed
                str = new String(hiddenArray);
                //System.out.println(str);
                System.out.println("The letter guessed is already in the word. You have "+ numGuessAllowed+" gueses left. Please try again!"  + str + " >");
                
                // Prompt user for the next guess
                guessedLetter = scanner.next().charAt(0);
            }
             else if (randomWord.contains(String.valueOf(guessedLetter))) {
                // If the guessed letter is in the word
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == guessedLetter) {
                        hiddenArray[i] = guessedLetter;
                    }
                }
                str = new String(hiddenArray);
                System.out.println(guessedLetter + " is in the word to guess." + str + " >");
                
                // Check if the word is completely guessed
                if (new String(hiddenArray).equals(randomWord)) {
                    System.out.println("Congratulations! You guessed the word correctly: " + randomWord);
                    break;
                } else {
                    // Prompt user for the next guess
                    System.out.println("(Guess) Enter a letter in the word: ");
                    guessedLetter = scanner.next().toLowerCase().charAt(0);
                }
            }
            else {
                // Decrement the number of allowed guesses
                numGuessAllowed--;
                // Display the current state of the word with guessed letters revealed
                str = new String(hiddenArray);

                // If the guessed letter is not in the word
                System.out.println("The letter guessed is not in the word. You have "+ numGuessAllowed+" gueses left. Please try again!" + str + " >");
                
                // Prompt user for the next guess
                guessedLetter = scanner.next().toLowerCase().charAt(0);
            } 
        }  
        
        // Close scanner.   
        scanner.close();   
    }
}
