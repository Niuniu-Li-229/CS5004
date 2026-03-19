package Problem1;

import java.time.LocalDateTime;

public abstract class AbstractDonation implements Donations {

  private final double amount;
  private final LocalDateTime createdDateTime;

  protected AbstractDonation(double amount, LocalDateTime createdDateTime){
    this.amount = amount;
    this.createdDateTime = createdDateTime;
  }

  public double getAmount(){
    return amount;
  }

  public LocalDateTime getCreatedDateTime(){
    return createdDateTime;
  }

}
