import java.util.List;

/**
 * Represents a non-empty node in a linked list of Strings. Each node holds a head element and a
 * reference to the rest (tail) of the list.
 */
public class NonEmptyListOfString implements ListOfStrings {

  private final String head;
  private final ListOfStrings tail;

  public NonEmptyListOfString(String head, ListOfStrings tail) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null");
    }
    if (tail == null) {
      throw new IllegalArgumentException("Tail cannot be null");
    }
    this.head = head;
    this.tail = tail;
  }

  public NonEmptyListOfString(String head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null");
    }
    this.head = head;
    this.tail = new EmptyListOfString();
  }

  public String getHead() {
    return head;
  }

  public ListOfStrings getTail() {
    return tail;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 1 + tail.size();
  }

  @Override
  public boolean contains(String s) {
    return head.equals(s) || tail.contains(s);
  }

  @Override
  public boolean containsAll(ListOfStrings other) {
    return other.contains(head) && tail.containsAll(other);
  }

  @Override
  public ListOfStrings filterLargerThan(int maxLength) {
    ListOfStrings filteredTail = tail.filterLargerThan(maxLength);
    if (head.length() > maxLength) {
      return filteredTail;
    }
    return new NonEmptyListOfString(head, filteredTail);
  }

  @Override
  public boolean hasDuplicates() {
    return tail.contains(head) || tail.hasDuplicates();
  }

  @Override
  public ListOfStrings removeDuplicates() {
    ListOfStrings uniqueTail = tail.removeDuplicates();
    if (uniqueTail.contains(head)) {
      return uniqueTail;
    }
    return new NonEmptyListOfString(head, uniqueTail);
  }

  @Override
  public String toString(){
    return "(" + head + " -> " + tail + ")";
  }
}
