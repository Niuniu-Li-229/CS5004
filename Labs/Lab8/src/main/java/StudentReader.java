import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentReader {

  private ArrayList<Student> studentList;
  private String filePath;
  private Scanner scanner;

  public StudentReader(String filePath) {
    this.studentList = new ArrayList<>();
    this.filePath = filePath;
    this.scanner = new Scanner(System.in);
  }

  /**
   * Read the file into studentList. The student info can be divided into 4 parts and be stored
   * accordingly.
   */
  public void readFile() throws IOException {
    studentList.clear();
    BufferedReader br = new BufferedReader(new FileReader(filePath));
    String line;

    while ((line = br.readLine()) != null) {
      String[] parts = line.split(" ");
      if (parts.length == 4) {
        studentList.add(new Student(parts[0], parts[1], parts[2], parts[3]));
      }
    }
    br.close();
  }

  /**
   * Print all students with line numbers.
   */
  public void printStudents() {
    for (int i = 0; i < studentList.size(); i++) {
      Student s = studentList.get(i);
      System.out.println((i + 1) + "." +
          " Name: " + s.getFirstName() + " " + s.getLastName() +
          " | ID: " + s.getStudentID() +
          " | Email: " + s.getEmail()
      );
    }
  }

  /**
   * Rewrite the entire file from current studentList
   */
  private void saveFile() throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
    for (Student s : studentList) {
      bw.write(s.getFirstName() + " " + s.getLastName() +
          " " + s.getStudentID() + " " + s.getEmail());
      bw.newLine();
    }
    bw.close();
  }

  /**
   * 1. Add a new student: a. which will prompt the user for the information about the new student.
   * b. Add an object to represent the new student c. Update the students.txt file d. Print the new
   * list of students
   */
  public void addStudent() throws IOException {
    System.out.print("First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Last Name: ");
    String lastName = scanner.nextLine();
    System.out.print("StudentID: ");
    String studentID = scanner.nextLine();
    System.out.print("Email: ");
    String email = scanner.nextLine();

    studentList.add(new Student(firstName, lastName, studentID, email));
    saveFile();
    System.out.println("Student added. Updated list: ");
    printStudents();
  }

  /**
   * 2. Remove a student by specifying the ID number: a. Which will delete the object corresponding
   * to the chosen student. b. And delete the information about that student from the students.txt
   * file.
   */
  public void removeStudent() {
    System.out.print("Enter student ID to remove: ");
    String studentID = scanner.nextLine();
    boolean found = false;

    for (int i = 0; i < studentList.size(); i++) {
      if (studentList.get(i).getStudentID().equals(studentID)) {
        studentList.remove(i);
        found = true;
        break;
      }
    }
    if (found) {
      try {
        saveFile();
        System.out.println("Student removed. Updated list: ");
        printStudents();
      } catch (IOException error) {
        System.out.println("Error saving file: " + error.getMessage());
      }
    } else {
      System.out.println("Student with ID: " + studentID + " not found.");
    }
  }

  /**
   * 3. Search for a student by ID number: a. Which will display the information about the student
   * with the required ID number if the student exists in the database b. Display an error message
   * indicating the student does not exist
   */
  public void searchStudent() {
    System.out.print("Enter student ID to search: ");
    String studentID = scanner.nextLine();
    boolean found = false;

    for (Student s : studentList) {
      if (s.getStudentID().equals(studentID)) {
        System.out.println("Student Found: " +
            " Name: " + s.getFirstName() + " " + s.getLastName() +
            " | ID: " + s.getStudentID() +
            " | Email: " + s.getEmail()
        );
        return;
      }
    }
    System.out.println("Student with ID: " + studentID + " not found.");
  }

  /**
   * Main menu
   */
  public void showMenu() {
    boolean running = true;
    while (running) {
      System.out.println("\n--- Student Menu ---");
      System.out.println("1. Add a student");
      System.out.println("2. Remove a student by ID");
      System.out.println("3. Search for a student by ID");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");
      String choice = scanner.nextLine();
      switch (choice) {
        case "1":
          try {
            addStudent();
          } catch (IOException e) {
            System.out.println("Error adding student: " + e.getMessage());
          }
          break;
        case "2":
          removeStudent();
          break;
        case "3":
          searchStudent();
          break;
        case "4":
          running = false;
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    }
    scanner.close();
  }

  public static void main(String[] args) {
    StudentReader reader = new StudentReader("students.txt");
    try {
      reader.readFile();
      System.out.println("Current students:");
      reader.printStudents();
      reader.showMenu();
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
  }
}