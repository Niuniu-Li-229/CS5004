public class Musician extends Artist {

  private String recordingCompany;
  private String lastRecordAlbum;

  /**
   * Constructor for class Musician
   *
   * @param name             containing information about an Artist’s first and last name
   * @param age              which is an Integer in the range [0, 128], containing information an
   *                         Artist’s age
   * @param genres           which is a String array, representing an Artist’s genres
   * @param awards           which is a String array, representing all awards that an Artist
   *                         received
   * @param recordingCompany a String representing a Musician’s recording company
   * @param lastRecordAlbum  a String representing the title of the latest recorded album
   */
  public Musician(Name name, int age, String[] genres, String[] awards, String recordingCompany,
      String lastRecordAlbum) {
    super(name, age, genres, awards);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  // Additional getters for its additional features.
  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastRecordAlbum() {
    return lastRecordAlbum;
  }

  // Additional setters for its additional features.
  public void setRecordingCompany(String recordingCompany) {
    this.recordingCompany = recordingCompany;
  }

  public void setLastRecordAlbum(String lastRecordAlbum) {
    this.lastRecordAlbum = lastRecordAlbum;
  }
}
