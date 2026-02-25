public class Poet extends Artist {

  private String publishingCompany;
  private String lastPublishedCollection;


  /**
   * Constructor for class Poet.
   *
   * @param name                    containing information about an Artist’s first and last name
   * @param age                     which is an Integer in the range [0, 128], containing
   *                                information an Artist’s age
   * @param genres                  which is a String array, representing an Artist’s genres
   * @param awards                  which is a String array, representing all awards that an Artist
   *                                received
   * @param publishingCompany       a String representing a Poet’s publishing company
   * @param lastPublishedCollection a String representing the title of the latest published
   *                                collection of poems
   */
  public Poet(Name name, int age, String[] genres, String[] awards, String publishingCompany,
      String lastPublishedCollection) {
    super(name, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  // Additional getters for its additional features.
  public String getPublishingCompany() {
    return publishingCompany;
  }

  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }

  // Additional setters for its additional features.
  public void setPublishingCompany(String publishingCompany) {
    this.publishingCompany = publishingCompany;
  }

  public void setLastPublishedCollection(String lastPublishedCollection) {
    this.lastPublishedCollection = lastPublishedCollection;
  }
}
