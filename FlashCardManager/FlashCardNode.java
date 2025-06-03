/**
 * The FlashCardNode class represents a Flashcard in a the subjectstack.
 * Each node contains a Flashcard and a reference to the next node in the list.
 */
class FlashCardNode {
    Flashcard data;
    FlashCardNode next;

    /**
     * Constructs a FlashCardNode with the specified Flashcard.
     * The next node is initialized to null.
     *
     * @param data the Flashcard data to store in this node
     */
    public FlashCardNode(Flashcard data) {
        this.data = data;
        this.next = null;
    }
}
