import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IListOfBooksTest {

  IListOfBooks listOfBooks,partialListOfBooks,emptyListOfBooks;

  /**
   * Test set up for empty list, partial list, and whole list of books.
   */
  @BeforeEach
  public void setUp() {
    emptyListOfBooks = new EmptyNode();

    partialListOfBooks =
        new ElementNode(new Book("HP 1", "J.K. Rowling", 1997, 19.99f),
            new ElementNode(new Book("HP 2", "J.K. Rowling", 1999, 29.99f),
                new ElementNode(new Book("HP 3", "J.K. Rowling", 2001,10.99f),
                    new EmptyNode())));

    listOfBooks =
        new ElementNode(new Book("HP 4", "J.K. Rowling", 2004, 15.49f),
            new ElementNode(new Book("HP 5", "J.K. Rowling", 2006, 12.99f),
                new ElementNode(new Book("HP 6", "J.K. Rowling", 2007, 7.99f),
                    partialListOfBooks)));
  }

  /**
   * Test for count() method
   */
  @Test
  public void testCounts() {
    // count of book in the list, should be 0
    assertEquals(0, emptyListOfBooks.count());
    // count of book in the partial list, should be 3
    assertEquals(3, partialListOfBooks.count());
    // count of book in the whole list, should be 6
    assertEquals(6, listOfBooks.count());
    // extra test for a new EmptyNode
    assertEquals(0, new EmptyNode().count());
  }

  /**
   * Test for totalPrice() method
   */
  @Test
  public void testTotalPrice() {

    float emptyListTotalPrice = 0;
    float partialListTotalPrice = 19.99f + 29.99f + 10.99f;
    float totalListTotalPrice = partialListTotalPrice + 15.49f + 12.99f + 7.99f;

    //check the total price for the empty list, should be 0
    assertEquals(emptyListTotalPrice, emptyListOfBooks.totalPrice());
    //check the total price for the partial list, should be equal to the partialListTotalPrice
    assertEquals(partialListTotalPrice, partialListOfBooks.totalPrice());
    //check the total price for the whole list, should be equal to the totalListTotalPrice
    assertEquals(totalListTotalPrice, listOfBooks.totalPrice());
    // extra test for a new EmptyNode
    assertEquals(0.0f, new EmptyNode().totalPrice());
  }

  /**
   * Test for allBefore() method
   */
  @Test
  public void testAllBefore(){

    // the count of book earlier than year 1995 should be 0 for all lists.
    assertEquals(0, emptyListOfBooks.allBefore(1995).count());
    assertEquals(0, partialListOfBooks.allBefore(1995).count());
    assertEquals(0, listOfBooks.allBefore(1995).count());

    // the count of book earlier than year 2005 should be 0, 3, 4 for empty, partial and all
    assertEquals(0, emptyListOfBooks.allBefore(2005).count());
    assertEquals(3, partialListOfBooks.allBefore(2005).count());
    assertEquals(4, listOfBooks.allBefore(2005).count());

    // extra test for a new EmptyNode
    assertEquals(0, new EmptyNode().allBefore(2020).count());
  }

  /**
   * Test for addAtEnd() method
   */
  @Test
  public void testAddAtEnd(){
    Book HP7 = new Book("HP 7", "J.K. Rowling", 2007, 19.99f);

    // the count of books for three list after adding HP7 should be 1, 4, 7
    assertEquals(1, emptyListOfBooks.addAtEnd(HP7).count());
    assertEquals(4, partialListOfBooks.addAtEnd(HP7).count());
    assertEquals(7, listOfBooks.addAtEnd(HP7).count());

    // extra test for a new EmptyNode
    assertEquals(1, new EmptyNode().addAtEnd(HP7).count());

  }

  /**
   * Test for toString() method
   */
  @Test
  public void testToString(){

    String emptyListString = " ";
    String partialListString = "(Title: HP 1 Author: J.K. Rowling Year: 1997 Price: 19.99)"
        + "(Title: HP 2 Author: J.K. Rowling Year: 1999 Price: 29.99)"
        + "(Title: HP 3 Author: J.K. Rowling Year: 2001 Price: 10.99) ";
    String wholeListString = "(Title: HP 4 Author: J.K. Rowling Year: 2004 Price: 15.49)"
        + "(Title: HP 5 Author: J.K. Rowling Year: 2006 Price: 12.99)"
        + "(Title: HP 6 Author: J.K. Rowling Year: 2007 Price: 7.99)"
        + partialListString;

    assertEquals(emptyListString, emptyListOfBooks.toString());
    assertEquals(partialListString, partialListOfBooks.toString());
    assertEquals(wholeListString, listOfBooks.toString());

    // extra test for a new EmptyNode
    assertEquals(" ", new EmptyNode().toString());
  }
}