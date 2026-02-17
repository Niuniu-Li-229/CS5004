/**
 * A concrete implementation of the Fraction interface. Represents a fraction with an integer
 * numerator and positive denominator.
 */

public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructor for Fractionalmpl class that takes a numerator and denominator as integers.
   *
   * @param numerator   numerator to be passed to fraction
   * @param denominator denominator to be passed to fraction
   * @throws IllegalArgumentException when denominator is 0 or negative
   */
  public FractionImpl(int numerator, int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive");
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  /**
   * Getter for numerator
   *
   * @return the numerator
   */
  @Override
  public int getNumerator() {
    return this.numerator;
  }

  /**
   * Getter for denominator
   *
   * @return the denominator
   */
  @Override
  public int getDenominator() {
    return this.denominator;
  }

  /**
   * Setter for numerator
   *
   * @param n int to be set as numerator
   */
  @Override
  public void setNumerator(int n) {
    this.numerator = n;
  }

  /**
   * Setter for denominator
   *
   * @param d int to be set as denominator, must be positive
   * @throws IllegalArgumentException if new denominator is not positive
   */
  @Override
  public void setDenominator(int d) {
    if (d <= 0) {
      throw new IllegalArgumentException("Denominator must be positive");
    }
    this.denominator = d;
  }

  /**
   * Return the scientific value (decimal) of the fraction
   *
   * @return scientific value of the fraction
   */
  @Override
  public double toDouble() {
    return (double) this.numerator / this.denominator;
  }

  /**
   * Return a string depicting the fraction's value as a fraction in simplest form. For example
   * "4/2" should be simplified to "2/1", etc.
   *
   * @return fraction in simplest form.
   */
  @Override
  public String toString() {
    int gcdValue = gcd(Math.abs(this.numerator), this.denominator);
    return this.numerator / gcdValue + " / " + this.denominator / gcdValue;
  }

  /**
   * Euclid's algorithm for finding the greatest common divisor for two integers
   *
   * @param a integer a
   * @param b integer b
   * @return the greatest common divisor for a and b
   */
  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

  /**
   * Return the reciprocal of this fraction. Beware of the case where the numerator of the original
   * fraction is 0.
   *
   * @return the reciprocal of this fraction
   * @throws IllegalArgumentException when the numerator is 0
   */
  @Override
  public Fraction reciprocal() {
    if (this.numerator == 0) {
      throw new IllegalArgumentException("Invalid reciprocal since numerator is 0");
    }
    if (this.numerator < 0) {
      return new FractionImpl(-this.denominator, -this.numerator);
    }
    return new FractionImpl(this.denominator, this.numerator);
  }

  /**
   * Add this fraction to the one passed to it and returns the result as a fraction.
   *
   * @param other another fraction passed to this method
   * @return the fraction with the another one add to the existing one.
   */
  @Override
  public Fraction add(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Invalid addition since another fraction is null");
    }

    int newNumerator =
        this.numerator * other.getDenominator() + this.denominator * other.getNumerator();
    int newDenominator = this.denominator * other.getDenominator();

    return new FractionImpl(newNumerator, newDenominator);
  }

  /**
   * Compare this fraction to another fraction Uses cross-multiplication to determine the ordering
   *
   * @param other the fraction to compare to
   * @return a negative integer if this < other, zero if this == other, positive if this > other
   */
  @Override
  public int compareTo(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Invalid comparison since another fraction is null");
    }

    int leftSide = this.numerator * other.getDenominator();
    int rightSide = this.denominator * other.getNumerator();

    return leftSide - rightSide;
  }
}