import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionImplTest {

  FractionImpl f1, f2, f3, f4, f5, f6;

  @BeforeEach
  public void setUp() {
    f1 = new FractionImpl(3, 4);
    f2 = new FractionImpl(-1, 2);
    f3 = new FractionImpl(0, 5);
    f4 = new FractionImpl(4, 2);
    f5 = new FractionImpl(4, 8);
    f6 = new FractionImpl(7, 4);
  }

  // constructor tests
  @Test
  public void testValidConstructor() {
    assertEquals(3, f1.getNumerator());
    assertEquals(4, f1.getDenominator());

    assertEquals(-1, f2.getNumerator());
    assertEquals(2, f2.getDenominator());

    assertEquals(0, f3.getNumerator());
    assertEquals(5, f3.getDenominator());
  }

  @Test
  public void testConstructorNegativeDenominator() {
    // Test when denominator is negative, should throw IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> {
      new FractionImpl(4, -2);
    });
  }

  @Test
  public void testConstructorZeroDenominator() {
    // Test when denominator is 0, should throw IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> {
      new FractionImpl(4, 0);
    });
  }

  //Getter Tests
  @Test
  public void testGetNumerator() {
    assertEquals(3, f1.getNumerator());
    assertEquals(-1, f2.getNumerator());
    assertEquals(0, f3.getNumerator());
  }

  @Test
  public void testGetDenominator() {
    assertEquals(4, f1.getDenominator());
    assertEquals(2, f2.getDenominator());
    assertEquals(5, f3.getDenominator());
  }

  // Setter Tests
  @Test
  public void testSetNumeratorPositive() {
    f1.setNumerator(5);
    assertEquals(5, f1.getNumerator());
  }

  @Test
  public void testSetNumeratorNegative() {
    f1.setNumerator(-8);
    assertEquals(-8, f1.getNumerator());
  }

  @Test
  public void testSetNumeratorZero() {
    f1.setNumerator(0);
    assertEquals(0, f1.getNumerator());
  }

  @Test
  public void testSetDenominatorPositive() {
    f1.setDenominator(20);
    assertEquals(20, f1.getDenominator());
  }

  @Test
  public void testSetDenominatorNegative() {
    // Test when denominator is negative, should throw IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> {
      f1.setDenominator(-20);
    });
    // Ensure original value is unchanged after the exception
    assertEquals(4, f1.getDenominator());
  }

  @Test
  public void testSetDenominatorZero() {
    // Test when denominator is zero, should throw IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> {
      f1.setDenominator(0);
    });
    // Ensure original value is unchanged after the exception
    assertEquals(4, f1.getDenominator());
  }

  // toDouble Test
  @Test
  public void testToDoubleSimple() {
    assertEquals(0.75, f1.toDouble());
  }

  @Test
  public void testToDoubleNegative() {
    assertEquals(-0.5, f2.toDouble());
  }

  @Test
  public void testToDoubleZero() {
    assertEquals(0, f3.toDouble());
  }

  @Test
  public void testToDoubleSimplifiable() {
    assertEquals(2, f4.toDouble());   //  4/2 = 2
    assertEquals(0.5, f5.toDouble()); //  4/8 = 0.5
  }

  // toString Test
  @Test
  public void testToStringSimple() {
    assertEquals("3 / 4", f1.toString());
  }

  @Test
  public void testToStringNegative() {
    assertEquals("-1 / 2", f2.toString());
  }

  @Test
  public void testToStringZero() {
    assertEquals("0 / 1", f3.toString()); // The simplest form of 0/5 is 0/1
  }

  @Test
  public void testToStringSimplifiable() {
    assertEquals("2 / 1", f4.toString()); // The simplest form of 4/2 is 2/1
    assertEquals("1 / 2", f5.toString()); // The simplest form of 4/8 is 1/2
  }

  // Reciprocal Test
  @Test
  public void testReciprocalSimple() {
    assertEquals("4 / 3", f1.reciprocal().toString());
  }

  @Test
  public void testReciprocalNegative() {
    assertEquals("-2 / 1", f2.reciprocal().toString()); // Negative sign go with numerator
  }

  @Test
  public void testReciprocalZero() {
    // Zero denominator should throw IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> {
      f3.reciprocal();
    });
  }

  // Add Test
  @Test
  public void testAddCommonDeno() {
    assertEquals("5 / 2", f1.add(f6).toString()); // 3/4+7/4 = 10/4 = 5/2
  }

  @Test
  public void testAddDiffDeno() {
    assertEquals("11 / 4", f1.add(f4).toString()); // 3/4 + 4/2 = 11/4
  }

  @Test
  public void testAddNegative() {
    assertEquals("1 / 4", f1.add(f2).toString()); // 3/4 + -1/2 = 1/4
  }

  @Test
  public void testAddZero() {
    assertEquals("3 / 4", f1.add(f3).toString()); // 3/4 + 0/5 = 3/4
  }

  @Test
  public void testAddingToZero() {
    assertEquals(0.0, f1.add(new FractionImpl(-3, 4)).toDouble()); // 3/4+-3/4 = 0
  }

  @Test
  public void testAddSimplifiable() {
    assertEquals("-2 / 1",
        f1.add(new FractionImpl(-11, 4)).toString()); // 3/4 + -11/4 = -8/4 = -2/1
    assertEquals("-2 / 1",
        f1.add(new FractionImpl(-22, 8)).toString()); // 3/4 + -22/8 = -16/8 = -2/1
  }

  // compareTo Test
  @Test
  public void testCompareToLess() {
    assertTrue(f1.compareTo(f2) > 0); // 3/4 > -1/2
  }

  @Test
  public void testCompareToLarger() {
    assertTrue(f2.compareTo(f1) < 0); // -1/2 < 3/4
  }

  @Test
  public void testCompareToEqual() {
    assertTrue(f1.compareTo(f1) == 0); // 3/4 = 3/4
    assertTrue(f1.compareTo(new FractionImpl(6, 8)) == 0); // 3/4 = 6/8
  }

  @Test
  public void testCompareToCrossSign() {
    assertTrue(f1.compareTo(new FractionImpl(-3, 4)) > 0); // 3/4 > -3/4
    assertTrue(f2.compareTo(new FractionImpl(1, 2)) < 0); // -1/2 < 1/2
  }

  @Test
  public void testCompareToLargeNumber() {
    assertTrue((new FractionImpl(10000001, 10000000)).compareTo(new FractionImpl(9999999, 10000000))
        > 0); // 10000001/10000000 > 9999999/10000000
  }

  @Test
  public void testCompareToZero() {
    assertTrue(f1.compareTo(f3) > 0); // 3/4 > 0/5
    assertTrue(f2.compareTo(f3) < 0); // -1/2 < 0/5
  }

  @Test
  public void testCompareZeroToZero() {
    assertTrue(f3.compareTo(new FractionImpl(0, 10)) == 0); // 0/5 = 0/10
  }

  // Exceptional behavior tested “if and only if appropriate”
  @Test
  public void testExceptionalBehavior() {
    // negative numerator is allowed
    assertDoesNotThrow(() -> {
      new FractionImpl(-3, 4);
    });
    // zero numerator is allowed
    assertDoesNotThrow(() -> {
      new FractionImpl(0, 4);
    });
    // negative reciprocal is allowed
    assertDoesNotThrow(() -> {
      new FractionImpl(-2, 3).reciprocal();
    });
    // negative addition is allowed
    assertDoesNotThrow(() -> {
      new FractionImpl(-2, 3).add(new FractionImpl(-5, 8));
    });
  }
}