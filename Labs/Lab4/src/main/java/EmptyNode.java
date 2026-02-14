/**
 * EmptyNode class which implement the IListOfBooks interface.
 * Implement the five required methods for IListOfBooks.
 */

public class EmptyNode implements IListOfBooks{

  /**
   * Return the number of books in this list
   * @return the size of this list
   * since it is an empty list, the count should be 0.
   */

  @Override
  public int count(){
    return 0;
  };

  /**
   * Return the sum of the prices of all books in this list
   * @return the total price of the list of books
   * since it is an empty list, the count should be 0.
   */
  @Override
  public float totalPrice(){
    return 0;
  };

  /**
   * Return a sublist containing the books published before the given year
   * <p></p>
   * @param year the year before which all the returned books are published
   * @return the list of all books published before the given year
   * since it is an empty node, just return an empty list
   */
  @Override
  public IListOfBooks allBefore(int year){
    return new EmptyNode();
  };

  /**
   * Return an IListOfBooks obtained by appending a specified book to the end
   * <p></p>
   * @param book an instance of Class Book
   * @return IListOfBooks the modified list
   * since it is an empty node, add the new book to this empty list.
   */
  @Override
  public IListOfBooks addAtEnd(Book book){
    return new ElementNode(book, this);
  };

  /**
   * Create and return a string that can be used to print this list
   * Since toString is inherited from Object, this is merely a reminder
   * to provide a more useful version in your implementation.
   * @return String for printing
   * since it is an empty list, return " "
   */
  @Override
  public String toString(){
    return " ";
  };
}
