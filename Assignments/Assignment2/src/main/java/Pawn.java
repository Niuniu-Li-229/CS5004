/**
 * Pawn chess piece. A pawn can move only “ahead,” not backwards towards where its color started. It
 * can move only one place forward in its own column, except for first moves from its "game start
 * row" (row 1 for White pawns; row 6 for Black pawns) - in which case it can (optionally) move two
 * places forward. In other words, a pawn can opt to move one square or two squares forward from its
 * game start. Additionally, to kill it must move one place forward diagonally (it cannot kill by
 * moving straight).
 * <p>
 * No pawns may be created in the "royal" row for their color. In other words, White pawns may not
 * be created in row 0 and Black pawns may not be created in row 7. Raise an
 * IllegalArgumentException if either of those constraints are broken.
 */

public class Pawn extends ChessPiece {

  /**
   * Constructor
   *
   * @param theRow
   * @param theCol
   * @param theColor
   * @throws IllegalArgumentException if white pawn is created in row 0 or black created in row 7
   */
  public Pawn(int theRow, int theCol, Color theColor) {
    super(theRow, theCol, theColor);

    // White pawns cannot be created in the row 0
    // Black pawns cannot be created in the row 7
    if ((theColor == Color.WHITE && theRow == 0) || (theColor == Color.BLACK && theRow == 7)) {
      throw new IllegalArgumentException("Pawn cannot be place in royal row");
    }

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

    // Black pawn can only move down and white pawn can only move up.
    int rowDiff = targetRow - this.row;
    // For white pawns
    if (this.color == Color.WHITE) {
      // if start at row 1, can move 1 or 2 forward
      if (this.row == 1) {
        return rowDiff == 1 || rowDiff == 2;
      }
      // elsewise can only move 1 step
      else {
        return rowDiff == 1;
      }
    }
    // For black pawns
    else {
      // if start at row 6, can move 1 or 2 downward
      if (this.row == 6) {
        return rowDiff == -1 || rowDiff == -2;
      }
      // elsewise can only move 1 step
      else {
        return rowDiff == -1;
      }
    }
  }

  @Override
  public boolean canKill(ChessPiece piece){
    if (piece == null || piece.getColor() == this.color){
      return false;
    }

    int targetRow = piece.getRow();
    int targetCol = piece.getColumn();

    // Pawn can only kill diagonally
    int colDiff = Math.abs(targetCol - this.column);

    // Pawn can only move one column when kill
    if (colDiff != 1){
      return false;}

    // white pawn must move upwards and black must move downwards
    if (this.color == Color.WHITE) {
      return targetRow - this.row == 1;}
    else {
      return targetRow - this.row == -1;
    }
  }

}