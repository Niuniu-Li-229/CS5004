// Legacy thermostat with incompatible interface
class LegacyThermostat {

  private boolean active;
  private int temperature;

  public LegacyThermostat() {
    this.active = false;
    this.temperature = 70;
  }

  public void active(){
    this.active = true;
  }

  public void deactivate() {
    this.active = false;
  }

  public int getCurrentTemp() {
    return temperature;
  }
}