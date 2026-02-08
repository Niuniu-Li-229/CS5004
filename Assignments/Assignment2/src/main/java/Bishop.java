/**
 * Bishop chess piece, a Bishop can only move diagonally of squares.
 */

public class Bishop extends ChessPiece {

  /**
   * Constructor
   *
   * @param theRow
   * @param theCol
   * @param theColor
   */
  public Bishop(int theRow, int theCol, Color theColor) {
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
    // Can move diagonally
    return Math.abs(targetRow - this.row) == Math.abs(targetCol - this.column);
  }
}
