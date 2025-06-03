/**
 * Manages a list of movies.
 */
public class MovieList {
    // Customized array list to store movies
    CustomArrayList movies = new CustomArrayList();

    /**
     * Adds a new movie to the list.
     *
     * @param title       The title of the movie.
     * @param releaseYear The release year of the movie.
     * @param rating      The rating of the movie.
     */
    public void addMovie(String title, int releaseYear, double rating) {
        // Create a new movie object
        Movie movie = new Movie(title, releaseYear, rating);
        // Add the movie to the list
        movies.add(movie);
    }

    /**
     * Displays all the movies in the list with their details.
     */
    public void displayMovies() {
        // Check if the list is empty
        if (movies.isEmpty()) {
            // Message if there are no movies
            System.out.println("There are no movies in the list.");
        }
        // Iterate through the list of movies
        for (int i = 0; i < movies.size(); i++) {
            // Get each movie from the list
            Movie movie = (Movie) movies.get(i);
            // Print the movie details
            System.out.println(movie.toString());
        }
    }

    /**
     * Calculates the average rating of all movies in the list.
     *
     * @return The average rating of all movies.
     */
    public double calculateAverageRating() {
        // Check if the list is empty
        if (movies.isEmpty()) {
            // Return 0 if there are no movies
            return 0.0;
        }

        // Variable to store the total rating
        double totalRating = 0.0;
        // Iterate through the list of movies
        for (int i = 0; i < movies.size(); i++) {
            // Get each movie from the list
            Movie movie = (Movie) movies.get(i);
            // Add the movie's rating to the total rating
            totalRating += movie.getRating();
        }

        // Calculate and return the average rating
        return totalRating / movies.size();
    }

    /**
     * Removes all movies from the list with the specified title.
     *
     * @param title The title of the movies to be removed.
     */
    public Movie removeMovie(String title) {
        // Check if a movie was found
        boolean found = false;
        // Index to iterate through the list
        int i = 0;
        // Variable to store the removed movie
        Movie removedMovie = null;
        // Iterate through the list
        while (i < movies.size()) {
            // Get each movie from the list
            Movie movie = (Movie) movies.get(i);
            // Check if the movie's title matches the specified title
            if (movie.getTitle().equals(title)) {
                // Store the removed movie
                removedMovie = movie;
                // Remove the movie from the list
                movies.remove(movie);
                // Set the found flag to true as a movie has been removed
                found = true;
                //Increase the index to check if  there is another object with the same title
                i++;
            } else {
                // Increase the index if no movie is removed
                i++;
            }
        }

        // If no movie was found, print a message
        if (!found) {
            System.out.println("No movie with the title '" + title + "' was found.");
        }
        // Return the removed movie
        return removedMovie;
    }
}
