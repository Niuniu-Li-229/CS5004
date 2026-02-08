import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for Rock
 */

class RockTest {
  @Test
  void testRockCreation() {
    Rock rock = new Rock(3, 3, Color.WHITE);

    assertEquals(3, rock.getRow());
    assertEquals(3, rock.getColumn());
    assertEquals(Color.WHITE, rock.getColor());
  }

  @Test
  void testRockInvalidRow() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Rock(8, 3, Color.WHITE);
    });
  }

  @Test
  void testRockInvalidColumn() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Rock(5, 10, Color.WHITE);
    });
  }

  @Test
  void testRockMove() {
    Rock rock = new Rock(3, 3, Color.WHITE);

    // Rock cannot move diagonal
    assertFalse(rock.canMove(4, 4));
    assertFalse(rock.canMove(4, 2));
    assertFalse(rock.canMove(5, 5));
    assertFalse(rock.canMove(1, 5));

    // Rock can move horizontally
    assertTrue(rock.canMove(3, 4));
    assertTrue(rock.canMove(3, 2));
    assertTrue(rock.canMove(3, 6));
    assertTrue(rock.canMove(3, 1));

    // Rock can move vertically
    assertTrue(rock.canMove(4, 3));
    assertTrue(rock.canMove(2, 3));
    assertTrue(rock.canMove(5, 3));
    assertTrue(rock.canMove(1, 3));

    // Rock cannot move L-shape
    assertFalse(rock.canMove(5, 4));
    assertFalse(rock.canMove(4, 5));
    assertFalse(rock.canMove(1, 2));
    assertFalse(rock.canMove(2, 1));

  }

  @Test
  void testRockKill() {
    Rock whiteRock = new Rock(3, 3, Color.WHITE);
    Rock blackRock = new Rock(6, 3, Color.BLACK);

    Pawn whitePawn = new Pawn(2, 3, Color.WHITE);
    Pawn blackPawn = new Pawn(4, 5, Color.BLACK);

    //can kill opponent on diagonal
    assertTrue(whiteRock.canKill(blackRock));
    //cannot kill same color
    assertFalse(whiteRock.canKill(whitePawn));
    //cannot kill opponent with invalid move
    assertFalse(whiteRock.canKill(blackPawn));
  }
}