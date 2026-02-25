import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListOfStringsTest {

  // Helper: build list from varargs (first arg = head)
  private ListOfStrings listOf(String... items) {
    ListOfStrings list = new EmptyListOfString();
    for (int i = items.length - 1; i >= 0; i--) {
      list = new NonEmptyListOfString(items[i], list);
    }
    return list;
  }

  private ListOfStrings empty;
  private ListOfStrings list1;   // ("apple", "banana", "cherry")
  private ListOfStrings list2;   // ("apple", "banana", "cherry", "apple")  ← has duplicate

  @BeforeEach
  void setUp() {
    empty = new EmptyListOfString();
    list1 = listOf("apple", "banana", "cherry");
    list2 = listOf("apple", "banana", "cherry", "apple");
  }

  // ── isEmpty ───────────────────────────────────────────────────────────────

  @Test
  void testIsEmptyTrue() {
    assertTrue(empty.isEmpty());
  }

  @Test
  void testIsEmptyFalse() {
    assertFalse(list1.isEmpty());
  }

  // ── size ──────────────────────────────────────────────────────────────────

  @Test
  void testSizeEmpty() {
    assertEquals(0, empty.size());
  }

  @Test
  void testSizeNonEmpty() {
    assertEquals(3, list1.size());
  }

  // ── contains ──────────────────────────────────────────────────────────────

  @Test
  void testContainsTrue() {
    assertTrue(list1.contains("banana"));
  }

  @Test
  void testContainsFalse() {
    assertFalse(list1.contains("grape"));
  }

  @Test
  void testContainsEmpty() {
    assertFalse(empty.contains("apple"));
  }

  // ── containsAll ───────────────────────────────────────────────────────────

  @Test
  void testContainsAllTrue() {
    ListOfStrings sub = listOf("apple", "cherry");
    assertTrue(sub.containsAll(list1));
  }

  @Test
  void testContainsAllFalse() {
    ListOfStrings other = listOf("apple", "grape");
    assertFalse(other.containsAll(list1));
  }

  @Test
  void testContainsAllEmptyList() {
    // empty list trivially satisfies containsAll
    assertTrue(empty.containsAll(list1));
  }

  // ── filterLargerThan ──────────────────────────────────────────────────────

  @Test
  void testFilterLargerThanRemovesSomething() {
    // "banana"(6) and "cherry"(6) should be removed; only "apple"(5) stays
    ListOfStrings filtered = list1.filterLargerThan(5);
    assertEquals(1, filtered.size());
    assertTrue(filtered.contains("apple"));
    assertFalse(filtered.contains("banana"));
  }

  @Test
  void testFilterLargerThanKeepsAll() {
    ListOfStrings filtered = list1.filterLargerThan(10);
    assertEquals(3, filtered.size());
  }

  @Test
  void testFilterLargerThanRemovesAll() {
    ListOfStrings filtered = list1.filterLargerThan(0);
    assertEquals(0, filtered.size());
  }

  // ── hasDuplicates ─────────────────────────────────────────────────────────

  @Test
  void testHasDuplicatesTrue() {
    assertTrue(list2.hasDuplicates());
  }

  @Test
  void testHasDuplicatesFalse() {
    assertFalse(list1.hasDuplicates());
  }

  @Test
  void testHasDuplicatesEmpty() {
    assertFalse(empty.hasDuplicates());
  }

  // ── removeDuplicates ──────────────────────────────────────────────────────

  @Test
  void testRemoveDuplicatesSize() {
    ListOfStrings unique = list2.removeDuplicates();
    assertEquals(3, unique.size());
  }

  @Test
  void testRemoveDuplicatesContents() {
    ListOfStrings unique = list2.removeDuplicates();
    assertTrue(unique.contains("apple"));
    assertTrue(unique.contains("banana"));
    assertTrue(unique.contains("cherry"));
  }

  @Test
  void testRemoveDuplicatesOnCleanList() {
    ListOfStrings unique = list1.removeDuplicates();
    assertEquals(3, unique.size());
  }

  @Test
  void testRemoveDuplicatesEmpty() {
    ListOfStrings unique = empty.removeDuplicates();
    assertTrue(unique.isEmpty());
  }

  // ── null head guard ───────────────────────────────────────────────────────

  @Test
  void testNullHeadThrows() {
    assertThrows(IllegalArgumentException.class, () ->
        new NonEmptyListOfString(null, empty));
  }

  @Test
  void testNullTailThrows() {
    assertThrows(IllegalArgumentException.class, () ->
        new NonEmptyListOfString("hello", null));
  }
}