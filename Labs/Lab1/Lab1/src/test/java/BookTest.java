import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

  private Book AbsoluteJava;
  private Book HarryPotter;
  private Book SherlockHolmes;

  @BeforeEach
  void setUp() {
    this.AbsoluteJava = new Book("Absolute Java", " Walter Savitch, Kenrick Mock", 1296);
    this.HarryPotter = new Book("Harry Potter", "JK Rowling", 12345);
    this.SherlockHolmes = new Book("Sherlock Holmes", "Conan Doyle", 54321);

  }

  @Test
  void getTitle() {
    Assertions.assertEquals("Sherlock Holmes", this.SherlockHolmes.getTitle());
  }

  @Test
  void getAuthor() {
    Assertions.assertEquals("JK Rowling", this.HarryPotter.getAuthor());
  }

  @Test
  void getPages() {
    Assertions.assertEquals(1296, this.AbsoluteJava.getPages());
  }
}