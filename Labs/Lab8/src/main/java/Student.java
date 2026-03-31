public class Student {
  private String firstName;
  private String lastName;
  private String studentID;
  private String email;

  public Student (String firstName, String lastName, String studentID, String email){
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentID = studentID;
    this.email = email;
  }

  public String getFirstName(){
    return  firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public String getStudentID(){
    return studentID;
  }

  public String getEmail(){
    return email;
  }

}
