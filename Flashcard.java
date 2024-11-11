/**
 * The Flashcard class represents a flashcard with a question and an answer.
 * It provides methods to retrieve the question and answer, and to display the flashcard as a string.
 */
public class Flashcard {
    private String question;
    private String answer;

    /**
     * Constructs a Flashcard with the specified question and answer.
     *
     * @param question the question of the flashcard
     * @param answer   the answer of the flashcard
     */
    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Returns the question of this flashcard.
     *
     * @return the question of this flashcard
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the answer of this flashcard.
     *
     * @return the answer of this flashcard
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns a string representation of this flashcard in the format "Q: {question}\nA: {answer}".
     *
     * @return a string representation of this flashcard
     */
    @Override
    public String toString() {
        return "Q: " + question + "\nA: " + answer;
    }
}
