import java.util.List;
import java.util.stream.Collectors;

public class TrendingTopics {


  /**
   *   Method countTopics() takes a List<String> as input, and returns the number of
   *   occurrences of every String in the input list as a Map, where every distinct String
   *   represents the Map key, and the number of the String’s occurrences the Map value.
   *   For example, given the list of Strings:
   * @return
   */

  public int countTopics(List<String> inputList){
    inputList.stream()
        .collect(Collectors.groupingBy(, ???));

  }

}
