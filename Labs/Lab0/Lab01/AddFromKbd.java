import java.util.Scanner;

public class AddFromKbd {
    public class void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int num1 = in.nextInt();

        System.out.print("Enter second integer: ");
        int num2 = in.nextInt();

        int sum = num1 + num2;
        System.out.println("Sum = " + sum);

        in.close();
    }
}