/**
 * This is a concrete class.
 * It is the superclass of the class.
 */

class Movie {

  // private variables not accessable

  private int MovieID;
  private String title;
  private String rating;

  /**
   * Default constructor, which define the default value for class Movie should be 0, "", and ""
   */
  public Movie() {
    MovieID = 0;
    title = "";
    rating = "";
  }

  /**
   * Full variable constructor
   * @param ID
   * @param title
   * @param rating
   */
  public Movie(int ID, String title, String rating) {
    this.MovieID = ID;
    this.title = title;
    this.rating = rating;
  }

  public int getID() {
    return MovieID;
  }

  public void setID(int ID) {
    this.MovieID = ID;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String name) {
    this.title = name;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public boolean equals(Object other) {
    if (other == null) {
      return false;
    } else if (getClass() != other.getClass()) {
      return false;
    } else {
      Movie otherMovie = (Movie) other;
      if (otherMovie.getID() == this.getID()) {
        return true;
      }
    }
    return false;
  }

  public double calcLateFees(int daysLate) {
    return (2.0 * daysLate);
  }


}
