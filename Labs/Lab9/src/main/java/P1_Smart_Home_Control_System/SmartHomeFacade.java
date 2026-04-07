package P1_Smart_Home_Control_System;

public class SmartHomeFacade {

  private SmartHomeController controller;
  private LegacyThermostatAdapter thermostat;

  public SmartHomeFacade(LegacyThermostatAdapter thermostat){
    this.controller = SmartHomeController.getInstance();
    this.thermostat = thermostat;
  }

  public void activateNightMode(){
    System.out.println("Activating Night Mode, turning off lights and speaker, adjusting temperature...");
    for (SmartDevice d : controller.getDevices()){
      d.turnOff();
    }
    thermostat.turnOn();
    thermostat.setTemperature(65);
  }

  public void leaveHome(){
    System.out.println("Leaving home, turning off the devices...");
    for (SmartDevice d : controller.getDevices()){
      d.turnOff();
    }
    thermostat.turnOff();
  };
}
