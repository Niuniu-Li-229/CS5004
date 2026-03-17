public class Program2 {

    public static void printArray(Integer[] array) {
        for (Integer element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(Double[] array) {
        for (Double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(Character[] array) {
        for (Character element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(String[] array) {
        for (String element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArry = {1, 2, 3, 4, 5};
        Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
        Character[] charArry = {'H', 'E', 'L', 'L', 'O'};
        String[] strArry = {"once", "upon", "a", "time"};

        printArray(intArry);
        printArray(doubArry);
        printArray(charArry);
        printArray(strArry);
    }
}
