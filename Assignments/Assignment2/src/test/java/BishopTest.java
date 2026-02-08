import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for Bishop
 */

class BishopTest {

  @Test
  void testBishopCreation() {
    Bishop bishop = new Bishop(3, 3, Color.WHITE);

    assertEquals(3, bishop.getRow());
    assertEquals(3, bishop.getColumn());
    assertEquals(Color.WHITE, bishop.getColor());
  }

  @Test
  void testBishopInvalidRow(){
    assertThrows(IllegalArgumentException.class, ()-> {
      new Bishop(8, 3, Color.WHITE);
    });
  }

  @Test
  void testBishopInvalidColumn(){
    assertThrows(IllegalArgumentException.class, ()-> {
      new Bishop(5, 10, Color.WHITE);
    });
  }

  @Test
  void testBishopDiagonalMove() {
    Bishop bishop = new Bishop(3, 3, Color.WHITE);

    assertTrue(bishop.canMove(0, 0));
    assertTrue(bishop.canMove(5, 5));
    assertTrue(bishop.canMove(0, 6));
    assertTrue(bishop.canMove(6, 0));
  }

  @Test
  void testBishopDiagonalMoveInvalid(){
    Bishop bishop = new Bishop(3, 3, Color.WHITE);

    assertFalse(bishop.canMove(3, 4));
    assertFalse(bishop.canMove(4, 3));
    assertFalse(bishop.canMove(10, 10));
    assertFalse(bishop.canMove(-1, -1));
  }

  @Test
  void testBishopKill(){
    Bishop whiteBishop = new Bishop(3, 3, Color.WHITE);
    Bishop blackBishop = new Bishop(5, 5, Color.BLACK);

    Pawn whitePawn = new Pawn(4, 4, Color.WHITE);
    Pawn blackPawn = new Pawn(3, 5, Color.BLACK);

    //can kill opponent on diagonal
    assertTrue(whiteBishop.canKill(blackBishop));
    //cannot kill same color on diagonal
    assertFalse(whiteBishop.canKill(whitePawn));
    //cannot kill opponent not on diagonal
    assertFalse(whiteBishop.canKill(blackPawn));
  }
}