public class ElementNode implements IListOfBooks{
  private Book book;
  private IListOfBooks rest;

  public ElementNode(Book book, IListOfBooks rest){
    this.book = book;
    this.rest = rest;
  }

  /**
   * Return the number of books in this list
   * <p></p>
   * @return the size of this list
   * Used recursive method
   */
  @Override
  public int count(){
    return 1+this.rest.count();
  };

  /**
   * Return the sum of the prices of all books in this list
   * <p></p>
   * @return the total price of the list of books
   * Use recursive method
   */
  @Override
  public float totalPrice(){
    return book.getPrice() + this.rest.totalPrice();
  };

  /**
   * Return a sublist containing the books published before the given year
   * @param year the year before which all the returned books are published
   * @return the list of all books published before the given year
   * use recursive method
   */
  @Override
  public IListOfBooks allBefore(int year){
    if (book.before(year)) {
      return new ElementNode(this.book, this.rest.allBefore(year));
    }
    else {
      return this.rest.allBefore(year);
    }
  };

  /**
   * Return an IListOfBooks obtained by appending a specified book to the end
   * @param book an instance of Class Book
   * @return IListOfBooks the modified list
   * Add the new book to this element book list.
   */
  @Override
  public IListOfBooks addAtEnd(Book book){
    return new ElementNode(this.book, this.rest.addAtEnd(book));
  };

  /**
   * Create and return a string that can be used to print this list
   * Since toString is inherited from Object, this is merely a reminder
   * to provide a more useful version in your implementation.
   *
   * @return String for printing
   */
  @Override
  public String toString(){
    return "(" + this.book.toString() + ")" + this.rest.toString();
  };
}
