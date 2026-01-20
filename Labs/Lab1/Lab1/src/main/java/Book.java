/**
 *  Represents a Book with its details--title, author, and pages
 *
 * @author wanjing
 */

public class Book {
  private String title;
  private String author;
  private int pages;

  /**
   * Creates a new book given the book's title, author and pages.
   * @param title the book's title
   * @param author the book's author
   * @param pages the number of pages the book has
   */
  public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
  }

  /**
   * @return the title
   */
  public String getTitle() { return this.title; }

  /**
   * @return the author
   */
  public String getAuthor() { return this.author; }

  /**
   * @return the pages
   */
  public int getPages() { return this.pages; }
}
