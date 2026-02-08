/**
 * Knight chess piece, a knight can move only in an L pattern: two cells horizontally and one
 * vertically or vice versa.
 */

public class Knight extends ChessPiece {

  /**
   * Constructor for Knight
   *
   * @param theRow
   * @param theCol
   * @param theColor
   */
  public Knight(int theRow, int theCol, Color theColor) {
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

    int rowDiff = Math.abs(this.row - targetRow);
    int colDiff = Math.abs(this.column - targetCol);

    return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
  }

}
