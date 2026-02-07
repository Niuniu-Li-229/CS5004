import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleTest {

  private Triangle rightTriangle;
  private Triangle equilateralTriangle;
  private Triangle scaleneTriangle;
  private Triangle collinearTriangle;

  @BeforeEach
  void setUp() {
    rightTriangle = new Triangle(0, 0, 4, 0, 0, 3);
    equilateralTriangle = new Triangle(0, 0, 2, 0, 1, Math.sqrt(3));
    scaleneTriangle = new Triangle(0, 0, 5, 0, 2, 4);
    collinearTriangle = new Triangle(0, 0, 5, 0, 10, 0);
  }

  /**
   * Test constructor that create a valid triangle.
   */
  @Test
  void testConstructor_valid() {
    Triangle t = new Triangle(1, 2, 3, 4, 5, 6);
    assertNotNull(t);
  }

  /**
   * Test that constructor throws exception when points are identical.
   */
  @Test
  void testConstructor_identicalPoint1andPoint2() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(1, 1, 1, 1, 2, 3);
    });
  }

  /**
   * Test that constructor throws exception when points are identical.
   */
  @Test
  void testConstructor_identicalPoint2andPoint3() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(1, 1, 3, 3, 3, 3);
    });
  }

  /**
   * Test that constructor throws exception when points are identical.
   */
  @Test
  void testConstructor_identicalPoint1andPoint3() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(1, 1, 3, 4, 1, 1);
    });
  }

  /**
   * Test that constructor throws exception when points are identical.
   */
  @Test
  void testConstructor_identicalPoint1andPoint2andPoint3() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(1, 1, 1, 1, 1, 1);
    });
  }

  /**
   * Test area calculation
   */
  @Test
  void areaRightTriangle() {
    assertEquals(6.0, rightTriangle.area(), 0.001);
  }

  /**
   * Test area calculation
   */
  @Test
  void areaEquilateralTriangle() {
    assertEquals(Math.sqrt(3), equilateralTriangle.area(), 0.001);
  }

  /**
   * Test area calculation
   */
  @Test
  void areaScaleneTriangle() {
    double a = 5.0;
    double b = Math.sqrt(20);
    double c = Math.sqrt(25);
    double s = (a + b + c) / 2;
    assertEquals(Math.sqrt((s * (s - a) * (s - b) * (s - c))), scaleneTriangle.area(), 0.001);
  }

  /**
   * Test area calculation
   */
  @Test
  void areaCollinearTriangle() {
    assertEquals(0, collinearTriangle.area(), 0.001);
  }

  /**
   * Test perimeter calculation
   */
  @Test
  void perimeterRightTriangle() {
    assertEquals(12.0, rightTriangle.perimeter(), 0.001);
  }

  /**
   * Test perimeter calculation
   */
  @Test
  void perimeterEquilateralTriangle() {
    assertEquals(6.0, equilateralTriangle.perimeter(), 0.001);
  }

  /**
   * Test perimeter calculation
   */
  @Test
  void perimeterScaleneTriangle() {
    double a = 5.0;
    double b = Math.sqrt(20);
    double c = Math.sqrt(25);
    assertEquals(a+b+c, scaleneTriangle.perimeter(), 0.001);
  }

  /**
   * Test perimeter calculation
   */
  @Test
  void perimeterCollinearTriangle() {
    assertEquals(20, collinearTriangle.perimeter(), 0.001);
  }

  /**
   * Test resize method - scaling
   */
  @Test
  void resizeScaling() {
    Shape resized = rightTriangle.resize(4.0);
    assertEquals(4.0 * rightTriangle.area(), resized.area(), 0.001);
  }

  /**
   * Test resize method - shrink
   */
  @Test
  void resizeShrink() {
    Shape resized = rightTriangle.resize(0.25);
    assertEquals(0.25*rightTriangle.area(), resized.area(), 0.001);
  }

  /**
   * Test toString method
   */
  @Test
  void testToString() {
    String result = rightTriangle.toString();
    assertTrue(result.contains("0.000"));
    assertTrue(result.contains("4.000"));
    assertTrue(result.contains("3.000"));
    assertTrue(result.contains("Triangle"));
  }
}