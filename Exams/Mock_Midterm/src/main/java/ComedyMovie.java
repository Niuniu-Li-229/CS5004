public class ComedyMovie extends Movie {

  public ComedyMovie() {
    super();
  }

  public ComedyMovie(int ID, String title, String rating) {
    super(ID, title, rating);
  }

  public double calcLateFees(int daysLate) {
    return (2.5 * daysLate);
  }
}
