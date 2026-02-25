public class Dancer extends PerformingArtist{
  /**
   * Constructor for class Dancer
   *
   * @param name            containing information about an Artist’s first and last name
   * @param age             which is an Integer in the range [0, 128], containing information an
   *                        Artist’s age
   * @param genres          which is a String array, representing an Artist’s genres
   * @param awards          which is a String array, representing all awards that an Artist
   *                        received
   * @param movies          a String array, listing all movies that they worked on (acted in)
   * @param series          a String array, listing all TV series that they worked on (acted in)
   * @param otherMultimedia a String array, listing all other multimedia content that they worked on
   *                        (acted in)
   */
  public Dancer(Name name, int age, String[] genres, String[] awards, String[] movies, String[] series,
      String[] otherMultimedia) {
    super(name, age, genres, awards, movies, series, otherMultimedia);
  }
}
