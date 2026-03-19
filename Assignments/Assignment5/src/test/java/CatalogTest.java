import Problem2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogTest {

  private Author tolkien;
  private Author orwell;
  private Author austen;

  private RecordingArtist freddie;
  private RecordingArtist david;
  private RecordingArtist taylor;

  private Band queen;
  private Band radiohead;

  private Book lotr;
  private Book nineteenEightyFour;
  private Book prideAndPrejudice;

  private Music bohemianRhapsody;
  private Music queenAlbum;
  private Music space;
  private Music taylorAlbum;

  private Catalog catalog;

  @BeforeEach
  void setUp() {
    tolkien = new Author("J.R.R.", "Tolkien");
    orwell = new Author("George", "Orwell");
    austen = new Author("Jane", "Austen");

    freddie = new RecordingArtist("Freddie", "Mercury");
    david = new RecordingArtist("David", "Bowie");
    taylor = new RecordingArtist("Taylor", "Swift");

    ArrayList<RecordingArtist> queenMembers = new ArrayList<>();
    queenMembers.add(freddie);
    queenMembers.add(new RecordingArtist("Brian", "May"));
    queen = new Band("Queen", queenMembers);

    ArrayList<RecordingArtist> radioheadMembers = new ArrayList<>();
    radioheadMembers.add(new RecordingArtist("Thom", "Yorke"));
    radiohead = new Band("Radiohead", radioheadMembers);

    lotr = new Book(tolkien, "The Lord of the Rings", 1954);
    nineteenEightyFour = new Book(orwell, "1984", 1949);
    prideAndPrejudice = new Book(austen, "Pride and Prejudice", 1813);

    bohemianRhapsody = new Music(freddie, "Bohemian Rhapsody", 1975);
    queenAlbum = new Music(queen, "A Night at the Opera", 1975);
    space = new Music(david, "Space Oddity", 1969);
    taylorAlbum = new Music(taylor, "Fearless", 2008);

    catalog = new Catalog();
    catalog.addItem(lotr);
    catalog.addItem(nineteenEightyFour);
    catalog.addItem(prideAndPrejudice);
    catalog.addItem(bohemianRhapsody);
    catalog.addItem(queenAlbum);
    catalog.addItem(space);
    catalog.addItem(taylorAlbum);
  }

  // ── Catalog constructors ─────────────────────────────────────────────────

  @Test
  void emptyCatalog_searchReturnsEmpty() {
    Catalog empty = new Catalog();
    assertEquals(0, empty.search("anything").size());
  }

  @Test
  void catalogWithItems_constructedCorrectly() {
    ArrayList<LibraryItem> items = new ArrayList<>();
    items.add(lotr);
    items.add(space);
    Catalog c = new Catalog(items);
    assertEquals(2, c.search("").size()); // empty string matches everything
  }

  // ── addItem / removeItem ─────────────────────────────────────────────────

  @Test
  void addItem_increasesSearchResults() {
    Catalog c = new Catalog();
    assertEquals(0, c.search("Rings").size());
    c.addItem(lotr);
    assertEquals(1, c.search("Rings").size());
  }

  @Test
  void removeItem_itemNoLongerFound() {
    catalog.removeItem(lotr);
    assertEquals(0, catalog.search(tolkien).size());
  }

  @Test
  void removeItem_itemNotInCatalog_throwsException() {
    Book notAdded = new Book(austen, "Emma", 1815);
    assertThrows(IllegalArgumentException.class, () -> catalog.removeItem(notAdded));
  }

  @Test
  void removeItem_emptyCatalog_throwsException() {
    Catalog empty = new Catalog();
    assertThrows(IllegalArgumentException.class, () -> empty.removeItem(lotr));
  }

  // ── search(String keyword) ───────────────────────────────────────────────

  @Test
  void searchKeyword_exactTitleMatch() {
    ArrayList<LibraryItem> result = catalog.search("1984");
    assertEquals(1, result.size());
    assertTrue(result.contains(nineteenEightyFour));
  }

  @Test
  void searchKeyword_partialTitleMatch() {
    ArrayList<LibraryItem> result = catalog.search("Lord");
    assertEquals(1, result.size());
    assertTrue(result.contains(lotr));
  }

  @Test
  void searchKeyword_caseInsensitive_lowercase() {
    ArrayList<LibraryItem> result = catalog.search("lord");
    assertEquals(1, result.size());
    assertTrue(result.contains(lotr));
  }

  @Test
  void searchKeyword_caseInsensitive_uppercase() {
    ArrayList<LibraryItem> result = catalog.search("LORD");
    assertEquals(1, result.size());
    assertTrue(result.contains(lotr));
  }

  @Test
  void searchKeyword_matchesBothBooksAndMusic() {
    // "a" appears in many titles — result should include both books and music
    ArrayList<LibraryItem> result = catalog.search("a");
    assertTrue(result.size() > 1);
    boolean hasBook = result.stream().anyMatch(i -> i instanceof Book);
    boolean hasMusic = result.stream().anyMatch(i -> i instanceof Music);
    assertTrue(hasBook);
    assertTrue(hasMusic);
  }

  @Test
  void searchKeyword_noMatch_returnsEmpty() {
    ArrayList<LibraryItem> result = catalog.search("zzznomatch");
    assertEquals(0, result.size());
  }

  @Test
  void searchKeyword_emptyString_matchesAll() {
    ArrayList<LibraryItem> result = catalog.search("");
    assertEquals(7, result.size());
  }

  @Test
  void searchKeyword_doesNotSearchByCreatorName() {
    // "Tolkien" is not in any title
    ArrayList<LibraryItem> result = catalog.search("Tolkien");
    assertEquals(0, result.size());
  }

  // ── search(Author author) ────────────────────────────────────────────────

  @Test
  void searchAuthor_returnsCorrectBook() {
    ArrayList<LibraryItem> result = catalog.search(tolkien);
    assertEquals(1, result.size());
    assertTrue(result.contains(lotr));
  }

  @Test
  void searchAuthor_noMatch_returnsEmpty() {
    Author unknown = new Author("Unknown", "Author");
    ArrayList<LibraryItem> result = catalog.search(unknown);
    assertEquals(0, result.size());
  }

  @Test
  void searchAuthor_doesNotReturnMusic() {
    ArrayList<LibraryItem> result = catalog.search(tolkien);
    assertTrue(result.stream().noneMatch(i -> i instanceof Music));
  }

  @Test
  void searchAuthor_matchesByName_newObjectSameName() {
    // A new Author object with same name should still match
    Author tolkienCopy = new Author("J.R.R.", "Tolkien");
    ArrayList<LibraryItem> result = catalog.search(tolkienCopy);
    assertEquals(1, result.size());
    assertTrue(result.contains(lotr));
  }

  @Test
  void searchAuthor_differentLastName_noMatch() {
    Author wrongName = new Author("J.R.R.", "Rowling");
    ArrayList<LibraryItem> result = catalog.search(wrongName);
    assertEquals(0, result.size());
  }

  @Test
  void searchAuthor_multipleBooksSameAuthor() {
    Book animalFarm = new Book(orwell, "Animal Farm", 1945);
    catalog.addItem(animalFarm);
    ArrayList<LibraryItem> result = catalog.search(orwell);
    assertEquals(2, result.size());
    assertTrue(result.contains(nineteenEightyFour));
    assertTrue(result.contains(animalFarm));
  }

  // ── search(RecordingArtist artist) ───────────────────────────────────────

  @Test
  void searchArtist_soloArtist_returnsMusic() {
    ArrayList<LibraryItem> result = catalog.search(freddie);
    assertTrue(result.contains(bohemianRhapsody));
  }

  @Test
  void searchArtist_bandMember_returnsBandMusic() {
    // Freddie is in Queen — should find the Queen album too
    ArrayList<LibraryItem> result = catalog.search(freddie);
    assertTrue(result.contains(queenAlbum));
  }

  @Test
  void searchArtist_soloAndBandMember_returnsBoth() {
    ArrayList<LibraryItem> result = catalog.search(freddie);
    assertEquals(2, result.size()); // bohemianRhapsody + queenAlbum
  }

  @Test
  void searchArtist_doesNotReturnBooks() {
    ArrayList<LibraryItem> result = catalog.search(taylor);
    assertTrue(result.stream().noneMatch(i -> i instanceof Book));
  }

  @Test
  void searchArtist_artistNotInCatalog_returnsEmpty() {
    RecordingArtist unknown = new RecordingArtist("Unknown", "Artist");
    ArrayList<LibraryItem> result = catalog.search(unknown);
    assertEquals(0, result.size());
  }

  @Test
  void searchArtist_matchesByName_newObjectSameName() {
    RecordingArtist davidCopy = new RecordingArtist("David", "Bowie");
    ArrayList<LibraryItem> result = catalog.search(davidCopy);
    assertEquals(1, result.size());
    assertTrue(result.contains(space));
  }

  @Test
  void searchArtist_notMemberOfBand_doesNotReturnBandMusic() {
    // Taylor Swift is not in Queen — should not return Queen album
    ArrayList<LibraryItem> result = catalog.search(taylor);
    assertFalse(result.contains(queenAlbum));
  }

  @Test
  void searchArtist_memberOfOneBand_doesNotReturnOtherBandMusic() {
    RecordingArtist thom = new RecordingArtist("Thom", "Yorke");
    Music kidA = new Music(radiohead, "Kid A", 2000);
    catalog.addItem(kidA);

    ArrayList<LibraryItem> result = catalog.search(thom);
    assertTrue(result.contains(kidA));
    assertFalse(result.contains(queenAlbum)); // Thom is not in Queen
  }

  // ── LibraryItem fields ───────────────────────────────────────────────────

  @Test
  void book_getCreator_returnsAuthor() {
    assertTrue(lotr.getCreator() instanceof Author);
  }

  @Test
  void music_soloCreator_returnsRecordingArtist() {
    assertTrue(bohemianRhapsody.getCreator() instanceof RecordingArtist);
  }

  @Test
  void music_bandCreator_returnsBand() {
    assertTrue(queenAlbum.getCreator() instanceof Band);
  }

  @Test
  void libraryItem_getTitleAndYear() {
    assertEquals("The Lord of the Rings", lotr.getTitle());
    assertEquals(1954, lotr.getYear());
  }

  // ── Person / Creator hierarchy ───────────────────────────────────────────

  @Test
  void author_getName_returnsFullName() {
    assertEquals("J.R.R. Tolkien", tolkien.getName());
  }

  @Test
  void recordingArtist_getName_returnsFullName() {
    assertEquals("Freddie Mercury", freddie.getName());
  }

  @Test
  void band_getName_returnsBandName() {
    assertEquals("Queen", queen.getName());
  }

  @Test
  void band_hasMember_true() {
    assertTrue(queen.hasMember(freddie));
  }

  @Test
  void band_hasMember_false() {
    assertFalse(queen.hasMember(taylor));
  }

  @Test
  void person_equals_sameNameSameType_true() {
    Author a1 = new Author("Jane", "Austen");
    Author a2 = new Author("Jane", "Austen");
    assertEquals(a1, a2);
  }

  @Test
  void person_equals_differentType_false() {
    // Author and RecordingArtist with same name should NOT be equal
    Author a = new Author("Jane", "Austen");
    RecordingArtist r = new RecordingArtist("Jane", "Austen");
    assertNotEquals(a, r);
  }

  @Test
  void person_equals_null_false() {
    assertNotEquals(tolkien, null);
  }
}
