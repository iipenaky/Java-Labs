/**
 * A class of a customized ArrayList.
 */
public class CustomArrayList {
    private static int capacity = 10; // Capacity of the initial array
    private Object[] array  = new Object[capacity]; // The array to store elements
    private int size = 0; // The current size of the array list

    /**
     * A constructor to create an instance of the array list.
     */
    public CustomArrayList() {}

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added
     */
    public void add(Object element) {
        dynamicArraySizeIncrease(); // Checks the capacity before adding the element
        array[size++] = element; // Add the element
    }
     
    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to be removed
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range
    */
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        Object removedElement = array[index]; // Stores the element to be removed
        // Shift array to the left to remove the element
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        // Clear the last element
        array[size - 1] = null;
        // Update size
        size--;
        return removedElement; // Return the removed element
    }

    /**
     * Removes the first occurrence of the specified element from the array.
     * 
     * @param element the element to be removed
     * @return the removed element, or null if the element is not found
     */
    public Object remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                // Shift array to the left to remove the element
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                // Clear the last element
                array[size - 1] = null;
                // Update the size of the array
                size--;
                return element; // Return the removed element
            }
        }
        return null; // Return null if element is not found
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index]; // Return the element at the specified index
    }

    /**
     * Gives the current number of elements in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size; // Return the current size of the list
    }

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0; // Check if the size is zero
    }

    /**
     * Displays the contents of the list.
     * 
     * @return the ArrayList
     */
    public String display() {
        if (isEmpty()) {
            return "[]"; // Return empty list if size is zero
        }

        String list = "[";
        // Append each element to the String
        for (int i = 0; i < size - 1; i++) {
            list = list + array[i] + ",";
        }
        list = list + array[size - 1] + "]";

        return list; // Return the list
    }

    /**
     * Ensures that the internal array has sufficient capacity to accommodate new elements.
     */
    private void dynamicArraySizeIncrease() {
        if (size == array.length) {
            int newCapacity = array.length * 2; // Double the capacity
            Object[] newArray = new Object[newCapacity]; // Create a new array with increased capacity
            System.arraycopy(array, 0, newArray, 0, size); // Copy elements to the new array
            array = newArray; // Update the reference ggto the new array
        }
    }

    /**
     * Sets the element at the specified index to the specified element.
     *
     * @param index   the index of the element to be modified
     * @param element the new element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(int index, Object element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[index] = element; // Set the element at the specified index
    }
}