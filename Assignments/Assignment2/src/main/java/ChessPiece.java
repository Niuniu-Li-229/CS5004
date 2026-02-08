/**
 * Abstract class for all chess pieces
 */

public abstract class ChessPiece implements ChessPieceContract{
  protected int row;
  protected int column;
  protected Color color;

  /**
   * Constructor for a chess piece
   * @param row initial row 0-7
   * @param col initial column 0-7
   * @param color initial color black or white
   * @throws IllegalArgumentException if position out of bounds
   */
  public ChessPiece(int row, int col, Color color) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      throw new IllegalArgumentException("Position out of bounds");
    }
    this.row = row;
    this.column = col;
    this.color = color;
  }

  @Override
  public int getRow(){
    return row;
  }

  @Override
  public int getColumn(){
    return column;
  }

  @Override
  public Color getColor(){
    return color;
  }

  @Override
  public abstract boolean canMove(int row, int col);

  @Override
  public boolean canKill(ChessPiece piece){
    if (piece == null || piece.getColor() == this.color){
      return false;
    }
    return canMove(piece.getRow(), piece.getColumn());
  }
}
