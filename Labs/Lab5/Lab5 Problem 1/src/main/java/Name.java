public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructs a Name with first and last name.
   *
   * @param firstName the artist's first name
   * @param lastName  the artist's last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
