import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrendingTopics {

  /**
   * Method countTopics() takes a List<String> as input, and returns the number of occurrences of
   * every String in the input list as a Map, where every distinct String represents the Map key,
   * and the number of the String’s occurrences the Map value
   *
   * @return Map storing the topics and the count of the topics
   */
  public Map<String, Long> countTopics(List<String> topics) {
    return topics.stream()
        .collect(Collectors.groupingBy(
            topic -> topic,
            Collectors.counting()
        ));
  }

}
