import java.util.ArrayList;
import java.util.List;

public class SmartHomeController {

  /**
   * Declare a private static field to hold the single instance
   */
  private static SmartHomeController instance;

  /**
   * A private list to hold all the devices.
   */
  private List<SmartDevice> devices;

  /**
   * Make the constructor private and initialize the devices list here.
   */
  private SmartHomeController() {
    devices = new ArrayList<>();
  }

  /**
   * Implement getInstance(), if the instance doesn't exist yet, create it; otherwise return it.
   *
   * @return the instance if it exits, otherwise create a new instance
   * <p>
   * Note: "synchronized" is not needed for lab. In a real multithreaded system, two threads could
   * both pass the null check simultaneously and create two instances.
   */
  public static synchronized SmartHomeController getInstance() {
    if (instance == null) {
      instance = new SmartHomeController();
    }
    return instance;
  }

  /**
   * Add device to the list.
   *
   * @param device new device to be added
   */
  public void addDevice(SmartDevice device) {
    devices.add(device);
  }

  /**
   * Show the status of all the devices in the list.
   */
  public void showAllStatus() {
    for (SmartDevice d : devices) {
      System.out.println(d.getStatus());
    }
  }
}
