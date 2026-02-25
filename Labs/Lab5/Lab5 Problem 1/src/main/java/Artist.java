import java.util.Arrays;

public abstract class Artist {

  private Name name;
  private int age;
  private String[] genres;
  private String[] awards;

  /**
   * All Artists contain the following information:
   *
   * @param name   containing information about an Artist’s first and last name
   * @param age    which is an Integer in the range [0, 128], containing information an Artist’s
   *               age
   * @param genres which is a String array, representing an Artist’s genres
   * @param awards which is a String array, representing all awards that an Artist received
   */
  public Artist(Name name, int age, String[] genres, String[] awards) {
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("Age should between 0 and 128.");
    }
    this.name = name;
    this.age = age;
    this.genres = Arrays.copyOf(genres, genres.length);
    this.awards = Arrays.copyOf(awards, awards.length);
  }

  public Name getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String[] getGenres() {
    return Arrays.copyOf(genres, genres.length);
  }

  public String[] getAwards() {
    return Arrays.copyOf(awards, awards.length);
  }

  public void receiveAward(String award) {
    String[] updated = Arrays.copyOf(awards, awards.length + 1);
    updated[awards.length] = award;
    awards = updated;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public void setAge(int age) {
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("Age should be between 0 and 128.");
    }
    this.age = age;
  }

  public void setGenres(String[] genres) {
    this.genres = Arrays.copyOf(genres, genres.length);
  }

  public void setAwards(String[] awards) {
    this.awards = Arrays.copyOf(awards, awards.length);
  }

  public String toString() {
    return "Name: " + name + ", Age: " + age + ", Genres: " + Arrays.toString(genres) + ", Awards: "
        + Arrays.toString(awards);
  }
}
