import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {

  private List<Vehicle> vehicles = new ArrayList<>();

  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  /**
   * Filter the old vehicles and print out the make, model and year of all the vehicles manufactured
   * before 1999.
   *
   * @return a List of strings with make, model and year for vehicles manufactured before 1999
   */
  public List<String> filterOlderVehilces() {
    return vehicles.stream()
        .filter(v -> v.getYear() < 1999)
        .map(v -> v.getMake() + " " + v.getModel() + " " + v.getYear())
        .collect(Collectors.toList());
  }
}