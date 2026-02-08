import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KnightTest {

  @Test
  void testKnightCreation() {
    Knight knight = new Knight(3, 3, Color.WHITE);

    assertEquals(3, knight.getRow());
    assertEquals(3, knight.getColumn());
    assertEquals(Color.WHITE, knight.getColor());
  }

  @Test
  void testKnightInvalidRow() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Knight(8, 3, Color.WHITE);
    });
  }

  @Test
  void testKnightInvalidColumn() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Knight(5, 10, Color.WHITE);
    });
  }

  @Test
  void testKnightMove() {
    Knight knight = new Knight(3, 3, Color.WHITE);

    // Knight can move L-shape
    assertTrue(knight.canMove(5, 4));
    assertTrue(knight.canMove(4, 5));
    assertTrue(knight.canMove(1, 2));
    assertTrue(knight.canMove(2, 1));

    // But cannot move in other pattern
    assertFalse(knight.canMove(4,4));
    assertFalse(knight.canMove(3, 5));
    assertFalse(knight.canMove(1, 3));
    assertFalse(knight.canMove(3, 2));

  }

  @Test
  void testKnightKill() {
    Knight whiteKnight = new Knight(3, 3, Color.WHITE);
    Knight blackKnight = new Knight(5, 4, Color.BLACK);

    Pawn whitePawn = new Pawn(2, 1, Color.WHITE);
    Pawn blackPawn = new Pawn(3, 5, Color.BLACK);

    //can kill opponent
    assertTrue(whiteKnight.canKill(blackKnight));
    //cannot kill same color
    assertFalse(whiteKnight.canKill(whitePawn));
    //cannot kill opponent with invalid move
    assertFalse(whiteKnight.canKill(blackPawn));
  }
}