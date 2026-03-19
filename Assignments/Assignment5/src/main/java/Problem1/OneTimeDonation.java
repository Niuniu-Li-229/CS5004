package Problem1;

import java.time.LocalDateTime;

public class OneTimeDonation extends AbstractDonation {

  public OneTimeDonation (double amount, LocalDateTime createdDateTime){
    super(amount, createdDateTime);
  }

  @Override
  public double getAmountForYear(int year){
    if (getCreatedDateTime().getYear() == year){
      return getAmount();
    }
    else {
      return 0;
    }
  }
}
