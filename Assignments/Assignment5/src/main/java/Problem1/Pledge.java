package Problem1;

import java.time.LocalDateTime;

public class Pledge extends AbstractDonation {

  private LocalDateTime processingDateTime;

  public Pledge (double amount, LocalDateTime createdDateTime){
    super(amount, createdDateTime);
    this.processingDateTime = null;
  }

  public Pledge (double amount, LocalDateTime createdDateTime, LocalDateTime processingDateTime){
    super(amount, createdDateTime);
    if (processingDateTime != null
        && processingDateTime.isBefore(createdDateTime)){
      throw new IllegalArgumentException("Processing date must not be before creation date");
    }
    this.processingDateTime = processingDateTime;
  }

  public void setProcessingDateTime(LocalDateTime processingDateTime){
    if (processingDateTime == null){
      this.processingDateTime = null;
      return;
    }
    if(processingDateTime.isBefore(getCreatedDateTime())){
      throw new IllegalArgumentException("Processing date must not be before creation date.");
    }
    this.processingDateTime = processingDateTime;
  }

  @Override
  public double getAmountForYear(int year){
    if (processingDateTime == null){
      return 0;
    }
    if (processingDateTime.getYear() == year){
      return getAmount();
    }
    return 0;
  }
}
