import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElectricVehicleTest {

  /**
   * Test constructor clamping, value initialization and getters.
   */
  @Test
  void setUp() {
    ElectricVehicle EV1 = new ElectricVehicle(
        "",
        200.0,
        0.05,
        10.0
    );

    assertEquals("unknown EV", EV1.getName());  //unknown EV should have "unknown EV" for name
    assertEquals(150.0, EV1.getBatterySize());  //battery size should be clamped to [10.0, 150.0]
    assertEquals(0.15, EV1.getStateOfCharge()); //state of charge should be clamped to [0.15, 1.0]
    assertEquals(4.5,
        EV1.getEfficiency());     //efficiency should be set as default and clamped to [0.5, 4.5]
  }

  /**
   * Test the range calculation of the EV.
   */
  @Test
  void testRangeCalculation() {
    ElectricVehicle EV2 = new ElectricVehicle(
        "Ford MachE",
        60.0,
        1.0,
        4.0
    );
    assertEquals(240.0, EV2.range());  //range = 60.0*1.0*4.0 = 240.0

  }

  /**
   * Test the efficiency under different temperature.
   */
  @Test
  void testEfficiencyUnderDiffTemp() {
    ElectricVehicle EV2 = new ElectricVehicle(
        "Ford MachE",
        60.0,
        1.0,
        4.0
    );

    EV2.updateEfficiency(70.0);
    assertEquals(4.0,
        EV2.getEfficiency()); //normal temp, current efficiency = default efficiency = 4.0

    EV2.updateEfficiency(80.0);
    assertEquals(3.4,
        EV2.getEfficiency()); //high temp, current efficiency = default efficiency*0.85 = 4.0*0.85 = 3.4

    EV2.updateEfficiency(0.0);
    assertEquals(2.0,
        EV2.getEfficiency()); //low temp, current efficiency = default efficiency*0.5 = 2.0
  }

  /**
   * Test the state of charge setter clamping.
   */
  @Test
  void testSetStateOfCharge() {
    ElectricVehicle EV2 = new ElectricVehicle(
        "Ford MachE",
        60.0,
        1.0,
        4.0
    );
    EV2.setStateOfCharge(2.0);
    assertEquals(1.0, EV2.getStateOfCharge());  //state of charge should not be larger than 100%
  }

  /**
   * Test the toString method and result.
   */
  @Test
  void testToString() {
    ElectricVehicle EV3 = new ElectricVehicle(
        "Tesla Model S",
        70.0,
        0.5,
        3.77
    );

    String result = EV3.toString();
    assertTrue(result.contains("Tesla Model S"));
    assertTrue(result.contains("50.0%"));
    assertTrue(result.contains("Range (miles): 132.0"));
  }
}