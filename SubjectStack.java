/**
 * The SubjectStack class represents a stack data structure that holds Flashcards.
 * It provides methods to push, pop, peek, and check if the stack is empty, as well as to get the size of the stack.
 */
public class SubjectStack {
    private FlashCardNode top = null;
    private int size = 0;

    /**
     * Pushes a Flashcard onto the top of the stack.
     *
     * @param flashcard the Flashcard to be pushed onto the stack
     */
    public void push(Flashcard flashcard) {
        FlashCardNode newNode = new FlashCardNode(flashcard);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the Flashcard at the top of the stack.
     *
     * @return the Flashcard at the top of the stack
     */
    public Flashcard pop() {
        if (isEmpty() == true) {
            throw new IllegalStateException("Oops..... The stack is empty");
        }
        Flashcard data = top.data;
        top = top.next;
        size--;
        return data;
    }

    /**
     * Returns the Flashcard at the top of the stack without removing it.
     *
     * @return the Flashcard at the top of the stack
     */
    public Flashcard peek() {
        if (isEmpty() == true) {
            throw new IllegalStateException("Oops..... The stack is empty");
        }
        return top.data;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the number of Flashcards in the stack.
     *
     * @return the size of the stack
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns a string representation of the stack.
     * Each Flashcard in the stack is represented by its string representation, separated by newlines.
     *
     * @return a string representation of the stack
     */
    @Override
    public String toString() {
        String sb = "";
        FlashCardNode current = top;
        while (current != null) {
            sb = sb + current.data.toString() + "\n";
            current = current.next;
        }
        return sb;
    }
}
