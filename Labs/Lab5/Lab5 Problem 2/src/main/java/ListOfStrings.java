import java.util.List;

/**
 * ADT interface for a List of Strings.
 * Implemented as a linked (recursive) data structure.
 */
public interface ListOfStrings {

  /**
   * checks whether or not the list is empty.
   * @return true if there are no elements, false otherwise.
   */
  boolean isEmpty();

  /**
   * Gets the total number of elements in the list.
   * @return size of the list.
   */
  int size();

  /**
   * Cconsumes a String, and checks if the String is in the list or not.
   * @param string the string to search for
   * @return true if string is in the list, false otherwise
   */
  boolean contains(String string);

  /**
   * Consumes another list of Strings, and checks that all elements
   * of this list are in the list passed as argument.
   * @return true if all elements of this list appear in another.
   */
  boolean containsAll(ListOfStrings other);

  /**
   * Takes the maximum String length, and returns a list
   * with all elements whose length is greater than the maximum length removed.
   * @param maxLength the maximum string length
   * @return a list with all elements whose length is greater than the maximum length removed.
   */
  ListOfStrings filterLargerThan(int maxLength);

  /**
   * Check if the list has at least one duplicate element.
   * @return true if the list has at least one duplicate element.
   */
  boolean hasDuplicates();

  /**
   * Returns the list with all duplicates removed.
   * @return the list with duplicates removed.
   */
  ListOfStrings removeDuplicates();
}