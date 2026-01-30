/**
 * Represents a Shoe with its details--kind, color, brand, size
 *
 * @author wanjing 002442139
 */

public class Shoe {

  private Kind kind;
  private Color color;
  private Brand brand;
  private double size;

  /**
   * Creates a new Shoe given the shoe's kind, color, brand and size.
   *
   * @param kind  the shoe's kind
   * @param color the shoe's color
   * @param brand the shoe's brand
   * @param size  the shoe's size
   */

  public Shoe(Kind kind, Color color, Brand brand, double size) {

    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("Nike does not sell dress shoes.");
    }

    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;

  }

  /**
   * @return the shoe's kind
   */
  public Kind getKind() {
    return this.kind;
  }

  /**
   * @return the shoe's color
   */
  public Color getColor() { return this.color; }

  /**
   * @return the shoe's brand
   */
  public Brand getBrand() {
    return this.brand;
  }

  /**
   * @return the shoe's size
   */
  public double getSize() {
    return this.size;
  }

  /**
   * @return the summary of the shoe's attributes--kind, color, brand, size
   */
  public String toString() {

    String strKind;
    switch (this.kind) {
      case Kind.SNEAKER: strKind = "Sneaker";
      break;
      case Kind.DRESS: strKind = "Dress";
      break;
      case Kind.BOOT: strKind = "Boot";
      break;
      case Kind.HEEL: strKind = "Heel";
      break;
      default:
        throw new IllegalStateException("Unexpected value: " + kind);
    }

    String strBrand = "";
    switch (this.brand) {
      case Brand.NIKE: strBrand = "Nike";
      break;
      case Brand.ADIDAS: strBrand = "Adidas";
      break;
      case Brand.PUMA: strBrand = "Puma";
      break;
      case Brand.CHANEL: strBrand  = "Chanel";
      break;
    }

    String strColor;
    switch (this.color) {
      case Color.BROWN: strColor = "Brown";
      break;
      case Color.BLACK: strColor = "Black";
      break;
      case Color.RED: strColor = "Red";
      break;
      case Color.WHITE: strColor = "White";
      break;
      default: strColor = "Neutral";
    }


    return "The summary of this shoe: " + "kind='"+ strKind + ", color='"+ strColor + ", brand='" + strBrand + ", size='" + size;
  }

}
