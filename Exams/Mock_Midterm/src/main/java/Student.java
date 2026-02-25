import java.util.Arrays;
import java.util.List;

public class Student implements Comparable<Student>{
  private String LastName;
  private int ID;

  public Student(String lastName, int id){
    if (id < 0){
      throw new IllegalArgumentException("Student ID cannot be negative");
    }
    this.LastName = lastName;
    this.ID = id;
  }

  public String getLastName(){
    return this.LastName;
  }

  public int getID(){
    return this.ID;
  }

  public void setLastName(String lastName){
    this.LastName = lastName;
  }

  public void setID(int id){
    this.ID = id;
  }

  @Override
  public int compareTo(Student other){
    return this.ID - other.getID();
  }

  public void main (Arrays Students){
    Students.sort();
  }
}
