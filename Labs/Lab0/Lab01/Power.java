public class PowerMethod1 {
    public static void main(String[] args) {
        // Calculate 2^31 using bit-shift operator.
        // Shifting 1 to the left by 31 positions effectively computes 2**31.
        // Note: need to use the L suffix to specify the starting value as a long, as 1 as an int would overflow.
        long result = 1L << 31;
        System.out.println("2^31 is: " + result);
    }
}

/*  Differences between Java and Python versions:
    1. Java requires an explicit class and a main method, while Python does not.
    2. Java is statically typed, while Python is dynamically typed.
    3. Java code must be complied before running, while Python is interpreted.
 */



// Below are other methods that I learned from Google.

public class PowerMethod2 {
    public static void main(String[] args) {
        /*  Calculate 2^31 using Math.pow().
            This method returns the result as a double and then cast to a long for precision.
            It is best practice to use a long data type as 2^31 is larger than the maximum value of a standard int.
         */
        long result = (long) Math.pow(2, 31);
        System.out.println("2^31 is: " + result);
    }
}

public class PowerMethod3 {
    public static void main(String[] args) {
        /*  Calculate 2^31 using BitInteger.
            For potentially larger powers that might exceed the capacity of a long,
            the BigInteger class is approprate as it handles artitrarily large numbers.
         */
        BigInteger base = new BigInteger("2");
        BigInteger exponent = new Big Integer("31");
        BigInteger result = base.pow(exponent.intValue());
        System.out.println("2^31 is: " + result);
    }
}

