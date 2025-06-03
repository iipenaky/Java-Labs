import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RandomPasswordGenerator {

    // Method to generate a random password based on specified criteria
    public static String generatePassword(int minLength, int minSpecial, int minDigit, int minUpper, String specialChars) {
        // Create a random number generator
        Random random = new Random();

        // Determine the total length of the password
        int length = random.nextInt(minLength) + minLength;

        // Get the number of characters for each category
        int specialNum = random.nextInt(length - minSpecial) + minSpecial;
        int upperNum = random.nextInt(specialNum - minUpper + 1) + minUpper;
        int digitNum = random.nextInt(upperNum - minDigit + 1) + minDigit;
        int lowerNum = length - specialNum - upperNum - digitNum;

        // Initialize an empty string to store the password
        String password = "";

        // Generate random uppercase letters to put in the password
        int firstUppercaseIndex = (int) 'A';
        for (int i = 0; i < upperNum; i++) {
            Random r = new Random();
            int letterIndex = r.nextInt(26);
            char randomUpperCase = (char) (firstUppercaseIndex + letterIndex);
            password = password + randomUpperCase;
        }

        // Generate random lowercase letters to put in the password
        int firstLowercaseIndex = (int) 'a';
        for (int i = 0; i < lowerNum; i++) {
            Random rand = new Random();
            int letterIndex = rand.nextInt(26);
            char randomLowerCase = (char) (firstLowercaseIndex + letterIndex);
            password = password + randomLowerCase;
        }

        // Generate random digits to put in the password
        for (int i = 0; i < digitNum; i++) {
            Random rand = new Random();
            int randomDigit = rand.nextInt(10);
            password = password + randomDigit;
        }

        // Generate random special characters from characters given to put in the password
        for (int i = 0; i < specialNum; i++) {
            Random rand = new Random();
            int index = rand.nextInt(specialChars.length());
            password = password + specialChars.charAt(index);
        }

        // Convert the password string to an ArrayList to make shuffling possible
        ArrayList<Character> passcode = new ArrayList<>();
        for (int i = 0; i < password.length(); i++) {
            passcode.add(password.charAt(i));
        }

        // Shuffle the characters in the ArrayList
        Collections.shuffle(passcode);

        // Convert the shuffled ArrayList back to a string
        StringBuilder builder = new StringBuilder();
        for (Character ch : passcode) {
            builder.append(ch);
        }
        String finalPassword = builder.toString();

        // Return the generated password
        return finalPassword;
    }

    // Function to check the validity of a given password based on specified criteria
    public static boolean checkPassword(int minLength, int minSpecial, int minDigit, int minUpper, String specialChars, String yourPassword) {
        // Convert the given password string to a character array
        char[] yourPasswordList = new char[yourPassword.length()];
        boolean result;

        for (int i = 0; i < yourPassword.length(); i++) {
            yourPasswordList[i] = yourPassword.charAt(i);
        }

        // Count the number of uppercase letters, digits, and special characters in the password
        int upperCount = 0;
        int specialsCount = 0;
        int digitCount = 0;

        for (int i = 0; i < yourPasswordList.length; i++) {
            if (Character.isUpperCase(yourPasswordList[i])) {
                upperCount += 1;
            } else if (Character.isDigit(yourPasswordList[i])) {
                digitCount += 1;
            } else if (specialChars.contains(String.valueOf(yourPasswordList[i]))) {
                specialsCount += 1;
            }
        }

        // Check if the password meets the specified criteria
        if (yourPassword.length() >= minLength) {
            if (upperCount >= minUpper) {
                if (specialsCount >= minSpecial) {
                    if (digitCount >= minDigit) {
                        result = true;
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        } else {
            result = false;
        }

        // Return the result of the password validity check
        return result;
    }

    // Main method to take user input and demonstrate the password generator and checker
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter criteria for password generation and checking
        System.out.print("Please enter the minimum length of the password: ");
        int minLength = scanner.nextInt();

        System.out.print("Please enter the minimum number of special characters you'd like: ");
        int minSpecial = scanner.nextInt();

        System.out.print("Please enter the minimum number of digits you'd like: ");
        int minDigit = scanner.nextInt();

        System.out.print("Please enter the minimum number of uppercase letters you'd like: ");
        int minUppercase = scanner.nextInt();

        System.out.print("Please enter the special characters you would want to include in your password: ");
        scanner.nextLine(); // Consume the newline character
        String specialChars = scanner.nextLine();

        System.out.print("Please enter the password you want to check: ");
        String userPassword = scanner.nextLine();

        // Close the scanner to prevent resource leaks
        scanner.close();

        // Generate and display the password
        String generatedPassword = generatePassword(minLength, minSpecial, minDigit, minUppercase, specialChars);
        System.out.println("Generated Password: " + generatedPassword);

        // Check the validity of the password user provided
        boolean isValid = checkPassword(minLength, minSpecial, minDigit, minUppercase, specialChars, userPassword);
        System.out.println("Is it valid?: " + isValid);
    }
}
