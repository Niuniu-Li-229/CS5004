public class CalendarEventV2 {
  // create a set of values
  enum DAY {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};

  static private int currentYear;
  private DAY dayofEvent;
  private String eventName;

  public static void setCurrentYear(int year){
    currentYear = year; //do NOT use "this" no object. It's a class variable
  }

  public static int getCurrentYear() {
    System.out.println(currentYear);
    if (currentYear == 0){
      currentYear = 2020; // Java initializes primitive types like ints to zero
    }
  }

}
