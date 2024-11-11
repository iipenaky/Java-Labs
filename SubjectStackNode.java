/**
 * The SubjectStackNode class represents a node in a linked list of subjects.
 * Each node contains the name of the subject, the subject itself, and a reference to the next node in the list.
 */
class SubjectStackNode {
    String name;
    SubjectStack stack;
    SubjectStackNode next;

    /**
     * Constructs a SubjectStackNode with the specified stack name.
     * Initializes the stack and sets the next node to null.
     *
     * @param name the name of the stack
     */
    public SubjectStackNode(String name) {
        this.name = name;
        this.stack = new SubjectStack();
        this.next = null;
    }
}
