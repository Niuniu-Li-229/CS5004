import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for pawn
 */

class PawnTest {
  @Test
  void testPawnCreation() {
    Pawn pawn = new Pawn(3, 3, Color.WHITE);

    assertEquals(3, pawn.getRow());
    assertEquals(3, pawn.getColumn());
    assertEquals(Color.WHITE, pawn.getColor());
  }

  @Test
  void testPawnInvalidRow() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Pawn(8, 3, Color.WHITE);
    });
    // If white pawn, cannot be in the row 0
    assertThrows(IllegalArgumentException.class, () -> {
      new Pawn(0, 3, Color.WHITE);
    });
  }

  @Test
  void testPawnInvalidColumn() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Pawn(5, 10, Color.WHITE);
    });
    // If black pawn, cannot be in the row 7
    assertThrows(IllegalArgumentException.class, () -> {
      new Pawn(7, 3, Color.BLACK);
    });
  }

  @Test
  void testPawnMove() {
    Pawn whitePawn1 = new Pawn(1, 1, Color.WHITE);
    Pawn whitePawn2 = new Pawn(3, 3, Color.WHITE);


    // White Pawn can move 1 or 2 step in the first row
    assertTrue(whitePawn1.canMove(2, 1));
    assertTrue(whitePawn1.canMove(3, 1));
    // But cannot move more than 1 step or move horizontally, or move one step back
    assertFalse(whitePawn1.canMove(4, 1));
    assertFalse(whitePawn1.canMove(1, 2));
    assertFalse(whitePawn1.canMove(0, 1));

    // If not on its original row, can only move 1 step
    assertTrue(whitePawn2.canMove(4, 3));
    // and cannot move horizontally or more than 1 step or backward
    assertFalse(whitePawn2.canMove(5, 4));
    assertFalse(whitePawn2.canMove(3, 4));
    assertFalse(whitePawn2.canMove(2,3));

    Pawn blackPawn1 = new Pawn(6,6, Color.BLACK);
    Pawn blackPawn2 = new Pawn(4, 4, Color.BLACK);

    // Black Pawn can move down 1 or 2 step from original row
    assertTrue(blackPawn1.canMove(5, 6));
    assertTrue(blackPawn1.canMove(4, 6));

    // But cannot move more than 1 step or move horizontally, or move one step back
    assertFalse(blackPawn1.canMove(3, 6));
    assertFalse(blackPawn1.canMove(7, 6));
    assertFalse(blackPawn1.canMove(6, 7));

    // If not on its original row, can only move 1 step
    assertTrue(blackPawn2.canMove(3, 4));
    // and cannot move horizontally or more than 1 step or backward
    assertFalse(blackPawn2.canMove(2, 4));
    assertFalse(blackPawn2.canMove(4, 5));
    assertFalse(blackPawn2.canMove(5,4));
  }

  @Test
  void testPawnKill() {

    // For white pawn
    Pawn whitePawn0 = new Pawn(2, 2, Color.WHITE);
    Pawn blackPawn0 = new Pawn(3, 3, Color.BLACK);
    Pawn blackPawn1 = new Pawn(1, 1, Color.BLACK);

    //can kill opponent on diagonal
    assertTrue(whitePawn0.canKill(blackPawn0));
    //but cannot move backward to kill opponent
    assertFalse(whitePawn0.canKill(blackPawn1));

    // For black pawn
    Pawn blackPawn2 = new Pawn(3, 3, Color.BLACK);
    Pawn whitePawn1 = new Pawn(2, 2, Color.WHITE);
    Pawn whitePawn2 = new Pawn(4, 4, Color.WHITE);

    //can kill opponent on diagonal
    assertTrue(blackPawn2.canKill(whitePawn1));
    //but cannot move backward to kill opponent
    assertFalse(blackPawn2.canKill(whitePawn2));

  }
}