/**
 * Rook chess piece, a Rook can move horizontally or vertically.
 */

public class Rook extends ChessPiece {

  /**
   * Constructor
   *
   * @param theRow
   * @param theCol
   * @param theColor
   */
  public Rook(int theRow, int theCol, Color theColor) {
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
    return
        //can move horizontally
        (Math.abs(row - targetRow) == 0) ||
            //can move vertically
            (Math.abs(column - targetCol) == 0);
  }
}
