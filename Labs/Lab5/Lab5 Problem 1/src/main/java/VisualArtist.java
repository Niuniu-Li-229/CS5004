import java.util.Arrays;

/**
 * Abstract VisualArtist class for Painters and Photographers.
 */
public abstract class VisualArtist extends Artist {

  private String[] exhibits;

  /**
   * Constructor for VisualArtist
   *
   * @param name     containing information about an Artist’s first and last name
   * @param age      which is an Integer in the range [0, 128], containing information an Artist’s
   *                 age
   * @param genres   which is a String array, representing an Artist’s genres
   * @param awards   which is a String array, representing all awards that an Artist received
   * @param exhibits a String array of all exhibits where their art was shown
   */
  public VisualArtist(Name name, int age, String[] genres, String[] awards, String[] exhibits) {
    super(name, age, genres, awards);
    this.exhibits = Arrays.copyOf(exhibits, exhibits.length);
  }

  // Additional Getters for Painter regarding its additional features.
  public String[] getExhibits() {
    return Arrays.copyOf(exhibits, exhibits.length);
  }

  // Additional Setters for Painter regarding its additional features.
  public void setExhibits(String[] exhibits) {
    this.exhibits = Arrays.copyOf(exhibits, exhibits.length);
  }

}
