/**
 * Represents a Electric Vehicle with their details--
 * name, battery size, state of charge, current efficiency and default efficiency.
 *
 * @author wanjing
 */

public class ElectricVehicle {
  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private final double defaultEfficiency;

  /**
   * Construction for an EV.
   * @param name
   * @param batterySize
   * @param stateOfCharge
   * @param defaultEfficiency
   */

  public ElectricVehicle (String name,
                                double batterySize,
                                double stateOfCharge,
                                double defaultEfficiency){

    // name check for unknown EV
    if (name == null || name.isEmpty()){
      this.name = "unknown EV";
    } else {
      this.name = name;
    }
    // Battery Clamping [10.0 to 150.0]
    this.batterySize = Math.max(10.0, Math.min(150.0,batterySize));
    // State of Charge (SoC) Clamping [0.15, 1.0]
    this.stateOfCharge = Math.max(0.15, Math.min(1.0, stateOfCharge));
    // Default Efficiency Clamping [0.5, 4.5]
    this.defaultEfficiency = Math.max(0.5, Math.min(4.5, defaultEfficiency));
    // Initial efficiency is default efficiency
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * @return the range
   */
  public double range(){
    return currentEfficiency * stateOfCharge * batterySize;
  }

  /**
   * @param currentTemp
   * Update the efficiency of EV based on the current temperature
   */
  public void updateEfficiency(double currentTemp){
    if (currentTemp >= 65.0 && currentTemp <= 77.0) {
      this.currentEfficiency = this.defaultEfficiency;
    } else if (currentTemp > 77.0) {
      this.currentEfficiency = this.defaultEfficiency * 0.85;
    } else {
      this.currentEfficiency = this.defaultEfficiency * (100.0 - Math.min(50.0, 65.0-currentTemp)) / 100.0;
    }
  }

  /**
   * @return the name of EV
   */
  public String getName(){
    return name;
  }

  /**
   * @return battery size
   */
  public double getBatterySize(){
    return batterySize;
  }

  /**
   * @return current state of charge
   */
  public double getStateOfCharge(){
    return stateOfCharge;
  }

  /**
   * @return current efficiency
   */
  public double getEfficiency(){
    return currentEfficiency;
  }

  /**
   * @param stateOfCharge
   * Set the state of charge
   */
  public void setStateOfCharge(double stateOfCharge){
    this.stateOfCharge = Math.max(0.15, Math.min(1.0, stateOfCharge));
  }

  public String toString(){
    double socPercentage = stateOfCharge * 100.0;
    return String.format(
        "%s SOC: %.1f%% Range (miles): %.1f",
        name,
        socPercentage,
        range()
    );
  }
}