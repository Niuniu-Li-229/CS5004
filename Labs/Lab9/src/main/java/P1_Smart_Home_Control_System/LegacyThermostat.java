package P1_Smart_Home_Control_System;

// Legacy thermostat with incompatible interface
class LegacyThermostat {

  private boolean active;
  private int temperature;

  public LegacyThermostat() {
    this.active = false;
    this.temperature = 70;
  }

  public void activate(){
    this.active = true;
  }

  public void deactivate() {
    this.active = false;
  }

  public int getCurrentTemp() {
    return temperature;
  }
}