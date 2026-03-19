package Problem2;

import java.util.ArrayList;

public class Catalog {

  private ArrayList<LibraryItem> libraryItems;

  public Catalog() {
    this.libraryItems = new ArrayList<>();
  }

  public Catalog(ArrayList<LibraryItem> libraryItems) {
    this.libraryItems = new ArrayList<>(libraryItems); // copy, not reference
  }

  public void addItem(LibraryItem item) {
    libraryItems.add(item);
  }

  public void removeItem(LibraryItem item) {
    if (libraryItems.isEmpty()) {
      throw new IllegalArgumentException("Cannot remove cause the catalog is empty");
    }
    if (!libraryItems.contains(item)) {
      throw new IllegalArgumentException("The item is not in the catalog");
    }
    libraryItems.remove(item);
  }

  public ArrayList<LibraryItem> search(String keyword) {
    ArrayList<LibraryItem> result = new ArrayList<>();
    for (LibraryItem item : libraryItems) {
      if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        result.add(item);
      }
    }
    return result;
  }

  public ArrayList<LibraryItem> search(Author author) {
    ArrayList<LibraryItem> result = new ArrayList<>();
    for (LibraryItem item : libraryItems) {
      if (item instanceof Book && item.getCreator().equals(author)) {
        result.add(item);
      }
    }
    return result;
  }

  public ArrayList<LibraryItem> search(RecordingArtist artist) {
    ArrayList<LibraryItem> result = new ArrayList<>();
    for (LibraryItem item : libraryItems) {
      if (item instanceof Music) {
        Creator creator = item.getCreator();
        if (creator instanceof Band && ((Band) creator).hasMember(artist)) {
          result.add(item);
        } else if (creator.equals(artist)) {
          result.add(item);
        }
      }
    }
    return result;
  }

}
