/**
 * Represents a movie with its title, release year, and rating.
 */
public class Movie {
    private String title;
    private int releaseYear;
    private double rating;

    /**
     * A constructor to create an instance of the movie class with the specified title, release year, and rating.
     *
     * @param title       The title of the movie.
     * @param releaseYear The release year of the movie.
     * @param rating      The rating of the movie.
     */
    public Movie(String title, int releaseYear, double rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    /**
     * Gets the title of the movie.
     *
     * @return The title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the movie.
     *
     * @param title The title of the movie.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the release year of the movie.
     *
     * @return The release year of the movie.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Sets the release year of the movie.
     *
     * @param releaseYear The release year of the movie.
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Gets the rating of the movie.
     *
     * @return The rating of the movie.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the rating of the movie.
     *
     * @param rating The rating of the movie.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Returns a string representation of the movie.
     *
     * @return A string representation of the movie.
     */
    @Override
    public String toString() {
        return "Movie{" + "title='" + title + "', releaseYear=" + releaseYear +", rating=" + rating + "}";
    }
}
