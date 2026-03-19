package Problem1;

import java.time.LocalDateTime;
import java.time.YearMonth;

public class MonthlyDonation extends AbstractDonation {

  private LocalDateTime cancellationDate;

  public MonthlyDonation(double amount, LocalDateTime createdDateTime) {
    super(amount, createdDateTime);
    this.cancellationDate = null;
  }

  public void setCancellationDate(LocalDateTime cancellationDate) {
    if (!cancellationDate.isBefore(getCreatedDateTime())) {
      this.cancellationDate = cancellationDate;
    } else {
      throw new IllegalArgumentException("Cancellation date must not be before creation time");
    }
  }

  @Override
  public double getAmountForYear(int year) {
    double total = 0;
    int dayOfMonth = getCreatedDateTime().getDayOfMonth();

    for (int month = 1; month <= 12; month++) {
      YearMonth ym = YearMonth.of(year, month);
      // Use the actual day, or the last day of the month if day doesn't exist
      int actualDay = Math.min(dayOfMonth, ym.lengthOfMonth());

      LocalDateTime paymentDate = LocalDateTime.of(
          year, month, actualDay,
          getCreatedDateTime().getHour(),
          getCreatedDateTime().getMinute(),
          getCreatedDateTime().getSecond()
      );

      boolean startedByThen = !paymentDate.isBefore(getCreatedDateTime());
      boolean notYetCancelled = cancellationDate == null || paymentDate.isBefore(cancellationDate);

      if (startedByThen && notYetCancelled) {
        total += getAmount();
      }
    }
    return total;
  }

}