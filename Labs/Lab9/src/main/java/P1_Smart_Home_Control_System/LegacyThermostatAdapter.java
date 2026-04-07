package P1_Smart_Home_Control_System;

public class LegacyThermostatAdapter implements SmartDevice{

  /**
   * Note: add boolean isOn to track power state separately.
   */
  private LegacyThermostat thermostat;
  private boolean isOn;
  private int temperature;

  public LegacyThermostatAdapter(LegacyThermostat thermostat){
    this.thermostat = thermostat;
    this.isOn = false;
    this.temperature = thermostat.getCurrentTemp();
  }

  @Override
  public void turnOn(){
    thermostat.activate();
    isOn = true;
  }

  @Override
  public void turnOff(){
    thermostat.deactivate();
    isOn = false;
  }

  @Override
  public String getStatus(){
    if (isOn){
      return "Thermostat is ON, current temperature: " + temperature;
    }
    else {
      return "Thermostat is OFF";
    }
  }

  public int getTemperature(){
    return temperature;
  }

  public void setTemperature(int temp){
    temperature = temp;
  }
}