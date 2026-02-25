public class Painter extends VisualArtist {

  /**
   * Constructor for Painter
   *
   * @param name     containing information about an Artist’s first and last name
   * @param age      which is an Integer in the range [0, 128], containing information an Artist’s
   *                 age
   * @param genres   which is a String array, representing an Artist’s genres
   * @param awards   which is a String array, representing all awards that an Artist received
   * @param exhibits a String array of all exhibits where their art was shown
   */
  public Painter(Name name, int age, String[] genres, String[] awards, String[] exhibits) {
    super(name, age, genres, awards, exhibits);
  }
}