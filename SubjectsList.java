/**
 * The SubjectsList class represents a list of stacks, where each stack is associated with a subject.
 * It provides methods to add a new stack, find a stack by name, and print all stacks.
 */
public class SubjectsList {
    private SubjectStackNode head = null;

    /**
     * Adds a new subject with the specified name to the list.
     *
     * @param subjectName the name of the new stack
     */
    public void addSubject(String subjectName) {
        SubjectStackNode newNode = new SubjectStackNode(subjectName);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Finds and returns the stack associated with the specified name.
     *
     * @param subjectName the name of the subject to find
     * @return the stack associated with the specified name, or null if no such stack exists
     * @throws IllegalStateException if the list is empty or there is no subject in the list provided
     */
    public SubjectStack findSubject(String subjectName) {
        if (head == null) {
            throw new IllegalStateException("Oops..... The list is empty");
        }
        boolean found = false;
        SubjectStackNode current = head;
        while (current != null) {
            if (current.name.equals(subjectName)) {
                found = true;
                return current.stack;
            }
            current = current.next;
        }
        if (found == false){
            throw new IllegalStateException("There is no subject called "+ subjectName + " in the list.");
        }
        return null;     
    }

    /**
     * Prints the name and the remainig cards of each subject in the list.
     * @throws IllegalStateException if the list is empty.
     */
    public void printSubjects() {
        if (head == null) {
            throw new IllegalStateException("Oops..... The list is empty");
        }
        SubjectStackNode current = head;
        while (current != null) {
            System.out.println("Subject: " + current.name + " - Remaining Cards: " + current.stack.getSize());
            current = current.next;
        }
    }

}
