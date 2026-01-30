import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoeTest {

  /**
   * Test valid shoe construction and getters.
   */
  @Test
  void setUp() {
     Shoe shoe = new Shoe (
        Kind.SNEAKER,
        Color.RED,
        Brand.NIKE,
        5.5);

    assertEquals(Kind.SNEAKER, shoe.getKind());
    assertEquals(Color.RED, shoe.getColor());
    assertEquals(Brand.NIKE, shoe.getBrand());
    assertEquals(5.5, shoe.getSize());;

  }

  /**
   * Test invalid Nike Dress shoe construction.
   */
  @Test
  void testInvalidNikeDressShoe(){
    assertThrows(IllegalArgumentException.class, ()-> {
      new Shoe (Kind.DRESS, Color.BLACK, Brand.NIKE, 10.5);
    }, "Should throw IllegalArgumentException for Nike Dress shoes.");
  }

  /**
   * Test the toString output has all attributes.
   */
  @Test
  void testToString() {
    Shoe shoe = new Shoe(Kind.BOOT, Color.WHITE, Brand.CHANEL, 6.0);
    String result = shoe.toString();

    assertTrue(result.contains("Boot"), "toString should contain the kind 'Boot'");
    assertTrue(result.contains("Chanel"), "toString should contain the brand 'Chanel'");
    assertTrue(result.contains("White"), "toString should contain the color 'White'");
    assertTrue(result.contains("6.0"), "toString should contain the size '6.0'");
  }
}