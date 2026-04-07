package P1_Smart_Home_Control_System;

public class Main {
  public static void main(String[] args){
    SmartHomeController controller = SmartHomeController.getInstance();

    SmartDevice light = DeviceFactory.createDevice("light");
    SmartDevice speaker = DeviceFactory.createDevice("speaker");
    controller.addDevice(light);
    controller.addDevice(speaker);

    LegacyThermostat legacyThermostat = new LegacyThermostat();
    LegacyThermostatAdapter thermostat = new LegacyThermostatAdapter(legacyThermostat);

    SmartHomeFacade facade = new SmartHomeFacade(thermostat);

    System.out.println("--- Initial Status ---");
    controller.showAllStatus();
    System.out.println(thermostat.getStatus());

    System.out.println("\n--- Night Mode ---");
    facade.activateNightMode();
    controller.showAllStatus();
    System.out.println(thermostat.getStatus());

    System.out.println("\n--- Leaving Home ---");
    facade.leaveHome();
    controller.showAllStatus();
    System.out.println(thermostat.getStatus());
  }
}