package Problem2;

public abstract class Person implements Creator{

  private String firstName;
  private String lastName;

  public Person (String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String getName(){
    return firstName + " " + lastName;
  }

  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  @Override
  public boolean equals(Object other){
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Person otherPerson = (Person) other;
    return firstName.equals(otherPerson.getFirstName())
        && lastName.equals(otherPerson.getLastName());
  }

}
