package P1_Smart_Home_Control_System;

public class SmartLight implements SmartDevice {

  /**
   * Note: should use boolean instead of Boolean.
   * Boolean is a wrapper object and can be null, and will create unnecessary risk (NullPointerException).
   * boolean is primitive, can be only true/false,
   */
  private boolean isOn;

  public SmartLight() {
    this.isOn = false;
  }

  public boolean isOn() {
    return isOn;
  }

  @Override
  public void turnOn() {
    this.isOn = true;
  }

  @Override
  public void turnOff() {
    this.isOn = false;
  }

  @Override
  public String getStatus() {
    if (isOn) {
      return "Light is ON";
    } else {
      return "Light is OFF";
    }
  }
}