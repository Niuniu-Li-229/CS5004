public class ActionMovie extends Movie {

  public ActionMovie() {
    super();
  }

  public ActionMovie(int ID, String title, String rating) {
    super(ID, title, rating);
  }

  public double calcLateFees(int daysLate) {
    return (3.0 * daysLate);
  }
}