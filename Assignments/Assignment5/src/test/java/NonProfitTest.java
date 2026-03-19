import Problem1.Donations;
import Problem1.MonthlyDonation;
import Problem1.NonProfit;
import Problem1.OneTimeDonation;
import Problem1.Pledge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class NonProfitTest {

  private NonProfit org;

  @BeforeEach
  void setUp() {
    org = new NonProfit("Test Org");
  }

  // ── OneTimeDonation ──────────────────────────────────────────────────────

  @Test
  void oneTimeDonation_countsInCorrectYear() {
    OneTimeDonation d = new OneTimeDonation(100.0, LocalDateTime.of(2026, 3, 1, 10, 0));
    org.addDonation(d);
    assertEquals(100.0, org.getTotalDonationsForYear(2026));
  }

  @Test
  void oneTimeDonation_notCountedInWrongYear() {
    OneTimeDonation d = new OneTimeDonation(100.0, LocalDateTime.of(2026, 3, 1, 10, 0));
    org.addDonation(d);
    assertEquals(0.0, org.getTotalDonationsForYear(2025));
    assertEquals(0.0, org.getTotalDonationsForYear(2027));
  }

  @Test
  void oneTimeDonation_getAmountForYearDirectly() {
    OneTimeDonation d = new OneTimeDonation(50.0, LocalDateTime.of(2025, 12, 31, 23, 59));
    assertEquals(50.0, d.getAmountForYear(2025));
    assertEquals(0.0, d.getAmountForYear(2026));
  }

  // ── MonthlyDonation ──────────────────────────────────────────────────────

  @Test
  void monthlyDonation_pdfExample_11months() {
    // PDF example: $10/month created 2/10/2026 → 11 payments in 2026 (Feb–Dec)
    MonthlyDonation d = new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 9, 0));
    assertEquals(110.0, d.getAmountForYear(2026));
  }

  @Test
  void monthlyDonation_createdJan_12months() {
    // Created Jan 1 2026 → 12 payments in 2026
    MonthlyDonation d = new MonthlyDonation(25.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    assertEquals(300.0, d.getAmountForYear(2026));
  }

  @Test
  void monthlyDonation_createdDec_only1monthInYear() {
    // Created Dec 15 2026 → only 1 payment in 2026
    MonthlyDonation d = new MonthlyDonation(20.0, LocalDateTime.of(2026, 12, 15, 12, 0));
    assertEquals(20.0, d.getAmountForYear(2026));
  }

  @Test
  void monthlyDonation_createdBeforeYear_allMonthsCounted() {
    // Created in 2025 → all 12 months of 2026 should count
    MonthlyDonation d = new MonthlyDonation(15.0, LocalDateTime.of(2025, 6, 5, 8, 0));
    assertEquals(180.0, d.getAmountForYear(2026));
  }

  @Test
  void monthlyDonation_noCancellation_countsFullYear() {
    MonthlyDonation d = new MonthlyDonation(30.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    // No cancellation set — should count all 12 months
    assertEquals(360.0, d.getAmountForYear(2026));
  }

  @Test
  void monthlyDonation_cancelledMidYear_countsFewer() {
    // Created Jan 1, cancelled April 1 → Jan, Feb, Mar counted (payment on April 1 is not before cancellation? Let's check)
    // cancellationDate = April 1. Payment on April 1 at same time → isBefore(cancellationDate) = false → not counted
    // So Jan, Feb, Mar = 3 months
    MonthlyDonation d = new MonthlyDonation(10.0, LocalDateTime.of(2026, 1, 1, 12, 0));
    d.setCancellationDate(LocalDateTime.of(2026, 4, 1, 12, 0));
    assertEquals(30.0, d.getAmountForYear(2026));
  }

  @Test
  void monthlyDonation_cancelledInFutureYear_allMonthsCountedThisYear() {
    MonthlyDonation d = new MonthlyDonation(10.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    d.setCancellationDate(LocalDateTime.of(2027, 6, 1, 0, 0));
    assertEquals(120.0, d.getAmountForYear(2026));
  }

  @Test
  void monthlyDonation_beforeCreationYear_returnsZero() {
    MonthlyDonation d = new MonthlyDonation(10.0, LocalDateTime.of(2026, 6, 1, 0, 0));
    assertEquals(0.0, d.getAmountForYear(2025));
  }

  @Test
  void monthlyDonation_setCancellationBeforeCreation_throwsException() {
    MonthlyDonation d = new MonthlyDonation(10.0, LocalDateTime.of(2026, 6, 1, 12, 0));
    assertThrows(IllegalArgumentException.class, () ->
        d.setCancellationDate(LocalDateTime.of(2026, 5, 1, 12, 0))
    );
  }

  // ── Pledge ───────────────────────────────────────────────────────────────

  @Test
  void pledge_noProcessingDate_returnsZero() {
    Pledge p = new Pledge(500.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    assertEquals(0.0, p.getAmountForYear(2026));
  }

  @Test
  void pledge_processingDateInMatchingYear_returnsAmount() {
    Pledge p = new Pledge(500.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    p.setProcessingDateTime(LocalDateTime.of(2026, 12, 31, 23, 59));
    assertEquals(500.0, p.getAmountForYear(2026));
  }

  @Test
  void pledge_processingDateInDifferentYear_returnsZero() {
    Pledge p = new Pledge(500.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    p.setProcessingDateTime(LocalDateTime.of(2027, 3, 1, 10, 0));
    assertEquals(0.0, p.getAmountForYear(2026));
    assertEquals(500.0, p.getAmountForYear(2027));
  }

  @Test
  void pledge_processingDateCanBeRemoved() {
    Pledge p = new Pledge(500.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    p.setProcessingDateTime(LocalDateTime.of(2026, 6, 1, 0, 0));
    p.setProcessingDateTime(null); // remove processing date
    assertEquals(0.0, p.getAmountForYear(2026));
  }

  @Test
  void pledge_setProcessingDateBeforeCreation_throwsException() {
    Pledge p = new Pledge(500.0, LocalDateTime.of(2026, 6, 1, 12, 0));
    assertThrows(IllegalArgumentException.class, () ->
        p.setProcessingDateTime(LocalDateTime.of(2026, 5, 1, 12, 0))
    );
  }

  // ── NonProfit getTotalDonationsForYear ───────────────────────────────────

  @Test
  void nonProfit_emptyDonations_returnsZero() {
    assertEquals(0.0, org.getTotalDonationsForYear(2026));
  }

  @Test
  void nonProfit_mixedDonations_correctTotal() {
    // One-time: $100 in 2026
    org.addDonation(new OneTimeDonation(100.0, LocalDateTime.of(2026, 3, 1, 10, 0)));
    // Monthly: $10/month starting Feb 2026 → 11 months = $110
    org.addDonation(new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 9, 0)));
    // Pledge: $200 processed in 2026
    Pledge pledge = new Pledge(200.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    pledge.setProcessingDateTime(LocalDateTime.of(2026, 7, 4, 0, 0));
    org.addDonation(pledge);

    assertEquals(410.0, org.getTotalDonationsForYear(2026));
  }

  @Test
  void nonProfit_unprocessedPledgeExcluded() {
    org.addDonation(new OneTimeDonation(50.0, LocalDateTime.of(2026, 1, 1, 0, 0)));
    Pledge unprocessed = new Pledge(1000.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    org.addDonation(unprocessed); // no processing date
    assertEquals(50.0, org.getTotalDonationsForYear(2026));
  }

  @Test
  void nonProfit_multipleOneTimeDonations() {
    org.addDonation(new OneTimeDonation(100.0, LocalDateTime.of(2026, 1, 15, 10, 0)));
    org.addDonation(new OneTimeDonation(200.0, LocalDateTime.of(2026, 6, 20, 14, 0)));
    org.addDonation(new OneTimeDonation(50.0, LocalDateTime.of(2025, 12, 31, 23, 59)));
    assertEquals(300.0, org.getTotalDonationsForYear(2026));
    assertEquals(50.0, org.getTotalDonationsForYear(2025));
  }

  @Test
  void nonProfit_polymorphismViaDonationsInterface() {
    // NonProfit holds Donations references — verifies subtype polymorphism
    Donations oneTime = new OneTimeDonation(75.0, LocalDateTime.of(2026, 4, 1, 0, 0));
    Donations monthly = new MonthlyDonation(5.0, LocalDateTime.of(2026, 12, 1, 0, 0));
    Pledge pledge = new Pledge(25.0, LocalDateTime.of(2026, 1, 1, 0, 0));
    pledge.setProcessingDateTime(LocalDateTime.of(2026, 3, 15, 0, 0));

    org.addDonation(oneTime);
    org.addDonation(monthly);
    org.addDonation(pledge);

    // oneTime=75, monthly=5 (only Dec), pledge=25 → 105
    assertEquals(105.0, org.getTotalDonationsForYear(2026));
  }
}
