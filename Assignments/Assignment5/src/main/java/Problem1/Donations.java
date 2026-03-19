package Problem1;

/**
 * Interface Donations only have one function getAmountForYear()
 * And it will be overridden in each concrete classes (OneTimeDonation, MonthlyDonation, Pledge).
 */

public interface Donations {

  /**
   * Check the donation for a year.
   *
   * @param year the year to lookup donation amount
   * @return the donation amount for a given year
   */
  double getAmountForYear(int year);
}
