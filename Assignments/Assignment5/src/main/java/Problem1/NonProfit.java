package Problem1;

import java.util.ArrayList;

public class NonProfit {

  private ArrayList<Donations> donations;
  private String name;

  public NonProfit(String name) {
    this.name = name;
    this.donations = new ArrayList<>();
  }

  public String getName(){
    return name;
  }

  public void addDonation(Donations donation) {
    this.donations.add(donation);
  }

  public double getTotalDonationsForYear(int year) {
    double amount = 0;
    for (Donations donation : donations) {
      amount += donation.getAmountForYear(year);
    }
    return amount;
  }
}
