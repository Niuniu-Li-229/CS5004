import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for queen
 */
class QueenTest {
  @Test
  void testQueenCreation() {
    Queen queen = new Queen(3, 3, Color.WHITE);

    assertEquals(3, queen.getRow());
    assertEquals(3, queen.getColumn());
    assertEquals(Color.WHITE, queen.getColor());
  }

  @Test
  void testQueenInvalidRow() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Queen(8, 3, Color.WHITE);
    });
  }

  @Test
  void testQueenInvalidColumn() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Queen(5, 10, Color.WHITE);
    });
  }

  @Test
  void testQueenMove() {
    Queen queen = new Queen(3, 3, Color.WHITE);

    // Queen can move diagonal
    assertTrue(queen.canMove(4, 4));
    assertTrue(queen.canMove(4, 2));
    assertTrue(queen.canMove(5, 5));
    assertTrue(queen.canMove(1, 5));

    // Queen can move horizontally
    assertTrue(queen.canMove(3, 4));
    assertTrue(queen.canMove(3, 2));
    assertTrue(queen.canMove(3, 6));
    assertTrue(queen.canMove(3, 1));

    // Queen can move vertically
    assertTrue(queen.canMove(4, 3));
    assertTrue(queen.canMove(2, 3));
    assertTrue(queen.canMove(5, 3));
    assertTrue(queen.canMove(1, 3));
  }

  @Test
  void testQuenKill() {
    Queen whiteQueen = new Queen(3, 3, Color.WHITE);
    Queen blackQueen = new Queen(4, 4, Color.BLACK);

    Pawn whitePawn = new Pawn(2, 3, Color.WHITE);
    Pawn blackPawn = new Pawn(4, 5, Color.BLACK);

    //can kill opponent on diagonal
    assertTrue(whiteQueen.canKill(blackQueen));
    //cannot kill same color
    assertFalse(whiteQueen.canKill(whitePawn));
    //cannot kill opponent with invalid move
    assertFalse(whiteQueen.canKill(blackPawn));
  }
}