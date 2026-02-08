/**
 * Interface defining the contract for all chess pieces.
 */

public interface ChessPieceContract {

  /**
   * Get the row position of the chess piece.
   * @return the row 0-7
   */
  int getRow();

  /**
   * Get the column position of the chess piece.
   * @return the column 0-7
   */
  int getColumn();

  /**
   * Get the color of the chess piece.
   * @return enum color BLACK or WHITE
   */
  Color getColor();

  /**
   * Determine if this chess piece can move to the given cell
   * @param row the target row
   * @param column the target column
   * @return true if this chess piece can be moved to the target position
   */
  boolean canMove(int row, int column);

  /**
   * Determine if this chess piece can kill the given piece
   * @param piece the target piece
   * @return true if this chess piece can kill the target piece
   */
  boolean canKill(ChessPiece piece);

}