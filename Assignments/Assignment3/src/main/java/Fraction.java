/**
 * An interface that represent the protocol for fraction.
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Return the numerator
   *
   * @return the numerator
   */
  int getNumerator();

  /**
   * Return the denominator
   *
   * @return the denominator
   */
  int getDenominator();

  /**
   * set the numerator to int n
   *
   * @param n int to be set as numerator
   */
  void setNumerator(int n);

  /**
   * Set the denominator to int d, must remain positive
   *
   * @param d int to be set as denominator, must be positive
   */
  void setDenominator(int d);

  /**
   * Return the result as double
   *
   * @return the fractional number in double
   */
  double toDouble();

  /**
   * Return a string depicting the fraction's value as a fraction in simplest form. For example
   * "4/2" should be simplified to "2/1", etc.
   *
   * @return fraction in simplest form.
   */
  String toString();

  /**
   * Return the reciprocal of this fraction. Beware of the case where the numerator of the original
   * fraction is 0.
   *
   * @return the reciprocal of this fraction
   */
  Fraction reciprocal();

  /**
   * Add this fraction to the one passed to it and returns the result as a fraction.
   *
   * @param other another fraction passed to this method
   * @return the fraction with the another one add to the existing one.
   */
  Fraction add(Fraction other);

  /**
   * Compare this fraction to another fraction Uses cross-multiplication to determine the ordering
   *
   * @param other the fraction to compare to
   * @return a negative integer if this < other, zero if this == other, positive if this > other
   */
  int compareTo(Fraction other);

}
