package Problem2;

public abstract class LibraryItem {

  private Creator creator;
  private String title;
  private int year;

  public LibraryItem (Creator creator, String title, int year){
    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  public Creator getCreator(){
    return creator;
  }

  public String getTitle(){
    return title;
  }

  public int getYear(){
    return year;
  }

}
