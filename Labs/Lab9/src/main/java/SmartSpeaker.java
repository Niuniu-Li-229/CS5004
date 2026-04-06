public class SmartSpeaker implements SmartDevice{
  private boolean isOn;

  public SmartSpeaker() {
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
      return "Speaker is ON";
    } else {
      return "Speaker is OFF";
    }
  }
}