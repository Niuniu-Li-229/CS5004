import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for Rook
 */

class RookTest {
  @Test
  void testRookCreation() {
    Rook Rook = new Rook(3, 3, Color.WHITE);

    assertEquals(3, Rook.getRow());
    assertEquals(3, Rook.getColumn());
    assertEquals(Color.WHITE, Rook.getColor());
  }

  @Test
  void testRookInvalidRow() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Rook(8, 3, Color.WHITE);
    });
  }

  @Test
  void testRookInvalidColumn() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Rook(5, 10, Color.WHITE);
    });
  }

  @Test
  void testRookMove() {
    Rook Rook = new Rook(3, 3, Color.WHITE);

    // Rook cannot move diagonal
    assertFalse(Rook.canMove(4, 4));
    assertFalse(Rook.canMove(4, 2));
    assertFalse(Rook.canMove(5, 5));
    assertFalse(Rook.canMove(1, 5));

    // Rook can move horizontally
    assertTrue(Rook.canMove(3, 4));
    assertTrue(Rook.canMove(3, 2));
    assertTrue(Rook.canMove(3, 6));
    assertTrue(Rook.canMove(3, 1));

    // Rook can move vertically
    assertTrue(Rook.canMove(4, 3));
    assertTrue(Rook.canMove(2, 3));
    assertTrue(Rook.canMove(5, 3));
    assertTrue(Rook.canMove(1, 3));

    // Rook cannot move L-shape
    assertFalse(Rook.canMove(5, 4));
    assertFalse(Rook.canMove(4, 5));
    assertFalse(Rook.canMove(1, 2));
    assertFalse(Rook.canMove(2, 1));

  }

  @Test
  void testRookKill() {
    Rook whiteRook = new Rook(3, 3, Color.WHITE);
    Rook blackRook = new Rook(6, 3, Color.BLACK);

    Pawn whitePawn = new Pawn(2, 3, Color.WHITE);
    Pawn blackPawn = new Pawn(4, 5, Color.BLACK);

    //can kill opponent on diagonal
    assertTrue(whiteRook.canKill(blackRook));
    //cannot kill same color
    assertFalse(whiteRook.canKill(whitePawn));
    //cannot kill opponent with invalid move
    assertFalse(whiteRook.canKill(blackPawn));
  }
}