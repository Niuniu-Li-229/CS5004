import java.util.Scanner;

public class AddFromKbd {
    public class void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int num1 = keyboard.nextInt();

        System.out.print("Enter second integer: ");
        int num2 = keyboard.nextInt();

        int sum = num1 + num2;
        System.out.println("Sum = " + sum);

        keyboard.close();
    }
}