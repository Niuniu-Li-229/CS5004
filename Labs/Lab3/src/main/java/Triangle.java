/**
 * This class represents a triangle defined by three points.
 * It defines all the operations mandated by the Shape interface.
 */
public class Triangle extends AbstractShape {
  private Point2D point2;
  private Point2D point3;

  /**
   * Constructs a triangle object with three points.
   * The first point is the reference point.
   *
   * @param x1 x coordinate of the first point (reference point)
   * @param y1 y coordinate of the first point (reference point)
   * @param x2 x coordinate of the second point
   * @param y2 y coordinate of the second point
   * @param x3 x coordinate of the third point
   * @param y3 y coordinate of the third point
   * @throws IllegalArgumentException if any two points are identical
   */
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
    super(new Point2D(x1, y1));
    this.point2 = new Point2D(x2, y2);
    this.point3 = new Point2D(x3, y3);

    // Check if any two points are identical
    if (pointsAreEqual(reference, point2) ||
        pointsAreEqual(reference, point3) ||
        pointsAreEqual(point2, point3)) {
      throw new IllegalArgumentException("Triangle cannot have two or more identical points");
    }
  }

  /**
   * Helper method to check if two points are equal
   *
   * @param p1 first point
   * @param p2 second point
   * @return true if the points have the same coordinates, false otherwise
   */
  private boolean pointsAreEqual(Point2D p1, Point2D p2) {
    return p1.getX() == p2.getX() && p1.getY() == p2.getY();
  }

  /**
   * Helper method to calculate distance between two points
   * Uses the Euclidean distance formula: sqrt((x2-x1)^2 + (y2-y1)^2)
   *
   * @param p1 first point
   * @param p2 second point
   * @return the distance between the two points
   */
  private double distanceBetween(Point2D p1, Point2D p2) {
    double dx = p1.getX() - p2.getX();
    double dy = p1.getY() - p2.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public double area() {
    // Calculate the three side lengths using the distance formula
    double a = distanceBetween(reference, point2);
    double b = distanceBetween(point2, point3);
    double c = distanceBetween(point3, reference);

    // Calculate semi-perimeter
    double s = (a + b + c) / 2.0;

    // Use Heron's formula: area = sqrt(s * (s-a) * (s-b) * (s-c))
    double areaSquared = s * (s - a) * (s - b) * (s - c);

    // Handle collinear points (area would be 0 or negative due to rounding)
    if (areaSquared <= 0) {
      return 0.0;
    }

    return Math.sqrt(areaSquared);
  }

  @Override
  public double perimeter() {
    // Calculate distances between all three pairs of points
    double side1 = distanceBetween(reference, point2);
    double side2 = distanceBetween(point2, point3);
    double side3 = distanceBetween(point3, reference);

    return side1 + side2 + side3;
  }

  @Override
  public Shape resize(double factor) {
    // To resize by area factor, we need to scale each side by sqrt(factor)
    // We'll move the points relative to the reference point

    // Calculate the scaling factor for distances
    double scaleFactor = Math.sqrt(factor);

    // Calculate vectors from reference point to other points
    double dx2 = point2.getX() - reference.getX();
    double dy2 = point2.getY() - reference.getY();
    double dx3 = point3.getX() - reference.getX();
    double dy3 = point3.getY() - reference.getY();

    // Scale the vectors
    double newX2 = reference.getX() + dx2 * scaleFactor;
    double newY2 = reference.getY() + dy2 * scaleFactor;
    double newX3 = reference.getX() + dx3 * scaleFactor;
    double newY3 = reference.getY() + dy3 * scaleFactor;

    return new Triangle(
        reference.getX(), reference.getY(),
        newX2, newY2,
        newX3, newY3
    );
  }

  @Override
  public String toString() {
    return String.format("Triangle: vertices (%.3f,%.3f) (%.3f,%.3f) (%.3f,%.3f)",
        reference.getX(), reference.getY(),
        point2.getX(), point2.getY(),
        point3.getX(), point3.getY());
  }
}
