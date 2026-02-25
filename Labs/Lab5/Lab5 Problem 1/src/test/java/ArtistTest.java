import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtistTest {

  private Actor      actor;
  private Musician   musician;
  private Poet       poet;
  private Painter    painter;

  @BeforeEach
  void setUp() {
    actor = new Actor(
        new Name ("Cate", "Blanchett"), 55,
        new String[]{"Drama", "Thriller"},
        new String[]{"Academy Award"},
        new String[]{"Tar", "Notes on a Scandal"},
        new String[]{"Sharp Objects"},
        new String[]{}
    );

    musician = new Musician(
        new Name("Jimi", "Hendrix"), 27,
        new String[]{"Rock", "Blues"},
        new String[]{"Grammy Hall of Fame"},
        "Reprise Records",
        "Electric Ladyland"
    );

    poet = new Poet(
        new Name("Maya", "Angelou"), 86,
        new String[]{"Poetry", "Memoir"},
        new String[]{"Presidential Medal of Freedom"},
        "Random House",
        "And Still I Rise"
    );

    painter = new Painter(
        new Name("Jacob", "Lawrence"), 82,
        new String[]{"Modernism"},
        new String[]{},
        new String[]{"Seattle Art Museum", "MoMA"}
    );
  }

  @Test
  void testArtistName() {
    assertEquals("Cate", actor.getName().getFirstName());
    assertEquals("Blanchett", actor.getName().getLastName());
  }

  @Test
  void testArtistAge() {
    assertEquals(55, actor.getAge());
  }

  @Test
  void testInvalidAgeTooHigh() {
    assertThrows(IllegalArgumentException.class, () ->
        new Actor(new Name("A", "B"), 200,
            new String[]{}, new String[]{},
            new String[]{}, new String[]{}, new String[]{}));
  }

  @Test
  void testInvalidAgeNegative() {
    assertThrows(IllegalArgumentException.class, () ->
        new Actor(new Name("A", "B"), -1,
            new String[]{}, new String[]{},
            new String[]{}, new String[]{}, new String[]{}));
  }

  @Test
  void testReceiveAward() {
    actor.receiveAward("BAFTA");
    String[] awards = actor.getAwards();
    assertEquals(2, awards.length);
    assertEquals("BAFTA", awards[1]);
  }

  @Test
  void testReceiveMultipleAwards() {
    musician.receiveAward("Rock Hall of Fame");
    musician.receiveAward("Grammy");
    assertEquals(3, musician.getAwards().length);
  }

  @Test
  void testMusicianRecordingCompany() {
    assertEquals("Reprise Records", musician.getRecordingCompany());
  }

  @Test
  void testMusicianLastAlbum() {
    assertEquals("Electric Ladyland", musician.getLastRecordAlbum());
  }

  @Test
  void testPoetPublishingCompany() {
    assertEquals("Random House", poet.getPublishingCompany());
  }

  @Test
  void testPoetLastCollection() {
    assertEquals("And Still I Rise", poet.getLastPublishedCollection());
  }

  @Test
  void testActorMovies() {
    assertArrayEquals(new String[]{"Tar", "Notes on a Scandal"}, actor.getMovies());
  }

  @Test
  void testActorSeries() {
    assertArrayEquals(new String[]{"Sharp Objects"}, actor.getSeries());
  }

  // ── VisualArtist (Painter) ────────────────────────────────────────────────

  @Test
  void testPainterExhibits() {
    assertArrayEquals(new String[]{"Seattle Art Museum", "MoMA"}, painter.getExhibits());
  }
}