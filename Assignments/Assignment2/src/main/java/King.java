/**
 * King chess piece, a king can move horizontally, vertically and diagonally. However, kings are
 * limited in that they can only move one space at a time, in any of those directions.
 */

public class King extends ChessPiece {

  /**
   * Constructor
   *
   * @param theRow
   * @param theCol
   * @param theColor
   */
  public King(int theRow, int theCol, Color theColor) {
    super(theRow, theCol, theColor);
  }

  @Override
  public boolean canMove(int targetRow, int targetCol) {
    // Check if out of bounds
    if (targetRow < 0 || targetRow > 7 || targetCol < 0 || targetCol > 7) {
      return false;
    }
    // Cannot move to the current position
    if (row == targetRow && column == targetCol) {
      return false;
    }
    return (
        //can move diagonally, horizontally, vertically, but only can move one space
        (Math.abs(row - targetRow) <= 1) && (Math.abs(column - targetCol) <= 1)
    );
  }
}
