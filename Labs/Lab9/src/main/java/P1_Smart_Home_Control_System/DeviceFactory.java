package P1_Smart_Home_Control_System;

public class DeviceFactory {

  public static SmartDevice createDevice(String type){
    if (type.equals("light")){
      return new SmartLight();
    }
    else if (type.equals("speaker")){
      return new SmartSpeaker();
    }
    else{
      throw new IllegalArgumentException("Unknown device type: " + type);
    }
  }
}