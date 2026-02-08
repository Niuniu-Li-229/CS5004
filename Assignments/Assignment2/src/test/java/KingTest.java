import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for King
 */

class KingTest {

  @Test
  void testKingCreation() {
    King king = new King(3, 3, Color.WHITE);

    assertEquals(3, king.getRow());
    assertEquals(3, king.getColumn());
    assertEquals(Color.WHITE, king.getColor());
  }

  @Test
  void testKingInvalidRow() {
    assertThrows(IllegalArgumentException.class, () -> {
      new King(8, 3, Color.WHITE);
    });
  }

  @Test
  void testKingInvalidColumn() {
    assertThrows(IllegalArgumentException.class, () -> {
      new King(5, 10, Color.WHITE);
    });
  }

  @Test
  void testKingMove() {
    King king = new King(3, 3, Color.WHITE);

    // King can move diagonal
    assertTrue(king.canMove(4, 4));
    assertTrue(king.canMove(4, 2));
    // But cannot move more than 1 step
    assertFalse(king.canMove(5, 5));
    assertFalse(king.canMove(1, 5));

    // King can move horizontally
    assertTrue(king.canMove(3, 4));
    assertTrue(king.canMove(3, 2));
    // But cannot move more than 1 step
    assertFalse(king.canMove(3, 6));
    assertFalse(king.canMove(3, 1));

    // King can move vertically
    assertTrue(king.canMove(4, 3));
    assertTrue(king.canMove(2, 3));
    // But cannot move more than 1 step
    assertFalse(king.canMove(5, 3));
    assertFalse(king.canMove(1, 3));
  }

  @Test
  void testKingKill() {
    King whiteKing = new King(3, 3, Color.WHITE);
    King blackKing = new King(4, 4, Color.BLACK);

    Pawn whitePawn = new Pawn(2, 3, Color.WHITE);
    Pawn blackPawn = new Pawn(3, 5, Color.BLACK);

    //can kill opponent on diagonal
    assertTrue(whiteKing.canKill(blackKing));
    //cannot kill same color
    assertFalse(whiteKing.canKill(whitePawn));
    //cannot kill opponent with invalid move
    assertFalse(whiteKing.canKill(blackPawn));
  }
}