import java.util.Arrays;

/**
 * Abstract PerformingArtist class for Actors, Dancers and Filmmakers.
 */
public abstract class PerformingArtist extends Artist {

  private String[] movies;
  private String[] series;
  private String[] otherMultimedia;

  /**
   * Constructor for class Actor
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
  public PerformingArtist(Name name, int age, String[] genres, String[] awards, String[] movies,
      String[] series, String[] otherMultimedia) {
    super(name, age, genres, awards);
    this.movies = Arrays.copyOf(movies, movies.length);
    this.series = Arrays.copyOf(series, series.length);
    this.otherMultimedia = Arrays.copyOf(otherMultimedia, otherMultimedia.length);
    ;
  }

  // Getters for the PerformingArtist class
  public String[] getMovies() {
    return Arrays.copyOf(movies, movies.length);
  }

  public String[] getSeries() {
    return Arrays.copyOf(series, series.length);
  }

  public String[] getOtherMultimedia() {
    return Arrays.copyOf(otherMultimedia, otherMultimedia.length);
  }


  // Setters for PerformingArtist class
  public void setMovies(String[] movies) {
    this.movies = Arrays.copyOf(movies, movies.length);
  }

  public void setSeries(String[] series) {
    this.series = Arrays.copyOf(series, series.length);
  }

  public void setOtherMultimedia(String[] otherMultimedia) {
    this.otherMultimedia = Arrays.copyOf(otherMultimedia, otherMultimedia.length);
  }

}
