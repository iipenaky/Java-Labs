import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The MainMenu class interacts with the user to manipulate the movie list.
 */
public class MainMenu {
    // Scanner to take the user input
    private static Scanner scanner = new Scanner(System.in);
    // ArrayList using the customized array list to manage the list of movies
    private static MovieList movieListApp = new MovieList();

    /**
     * The main method of the application, presents a menu to the user and handles user input accordingly.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to your movie management list.\nWhat do you want to do?");
        // Loop to continuously show the menu until the user chooses to exit
        while (true) {
            try {
                System.out.println();
                System.out.println("1. Add a movie");
                System.out.println("2. Display all movies with their details");
                System.out.println("3. Calculate average rating");
                System.out.println("4. Remove a movie");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                // Read the user's choice
                int choice = scanner.nextInt();

                // Switch case to handle different menu options
                switch (choice) {
                    case 1:
                        addMovie(); // Add a movie
                        break;
                    case 2:
                        displayMovies(); // Display all movies
                        break;
                    case 3:
                        calculateAverageRating(); // Calculate average rating
                        break;
                    case 4:
                        removeMovie(); // Remove a movie
                        break;
                    case 5:
                        // Exit message and terminate the program
                        System.out.println("Thank you for using the program. I hope you liked it. See you soon!;)");
                        return;
                    default:
                        // Handle invalid menu choices
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input type
                System.out.println("Invalid input. Please enter a number from 0 to 5.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    /**
     * Adds a new movie to the movie list after taking the required inputs from the user.
     */
    private static void addMovie() {
        boolean checkInput = false; // Flag to check if input is valid
        while (!checkInput) {
            try {
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter the title of the movie: ");
                String title = takeTitle(); // Take the movie title

                System.out.print("Enter the release year of the movie: ");
                int releaseYear = takeReleaseYear(); // Take the release year

                System.out.print("Enter the rating of the movie from 0 to 5: ");
                double rating = takeRating(); // Take the rating

                // Add the movie to the list
                movieListApp.addMovie(title, releaseYear, rating);
                System.out.println("The movie " + title + " has been added successfully.");
                checkInput = true; // Input is valid
            } catch (InputMismatchException e) {
                // Handle invalid input for release year or rating
                System.out.println("Invalid input. Please enter a valid year or rating.");
                scanner.nextLine(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                // Handle other input errors.
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Takes the title of the movie as input from the user.
     *
     * @return The title of the movie.
     * @throws IllegalArgumentException If the title is empty.
     */
    private static String takeTitle() {
        String title = scanner.nextLine(); // Read the title
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be empty."); // Validate title
        }
        return title;
    }

    /**
     * Takes the release year of the movie as input from the user.
     *
     * @return The release year of the movie.
     * @throws IllegalArgumentException If the release year is not within a valid range.
     */
    private static int takeReleaseYear() {
        int releaseYear = scanner.nextInt(); // Read the release year
        if (releaseYear < 1888 || releaseYear > 2024) {
            throw new IllegalArgumentException("Release year must be between 1888 and 2024."); // Validate release year
        }
        return releaseYear;
    }

    /**
     * Takes the rating of the movie as input from the user.
     *
     * @return The rating of the movie.
     * @throws IllegalArgumentException If the rating is not within a valid range.
     */
    private static double takeRating() {
        double rating = scanner.nextDouble(); // Read the rating
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be from 0 and 5."); // Validate rating
        }
        return rating;
    }

    /**
     * Displays all movies in the movie list.
     */
    private static void displayMovies() {
        System.out.println("All Movies:"); // Print header
        movieListApp.displayMovies(); // Call method to display movies
    }

    /**
     * Calculates and displays the average rating of all movies in the movie list.
     */
    private static void calculateAverageRating() {
        double averageRating = movieListApp.calculateAverageRating(); // Calculate average rating
        System.out.println("Average Rating of all movies: " + averageRating); // Display average rating
    }

    /**
     * Removes a movie from the movie list after taking the title as input from the user.
     */
    private static void removeMovie() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the title of the movie to be removed: ");
        String title = scanner.nextLine(); // Read the title from the user
        movieListApp.removeMovie(title); // Remove the movie
    }
}