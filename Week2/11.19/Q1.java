import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt(); // Or use Integer.parseInt(args[0]) for CLI input

        int reverse = 0;
        int lastDigit = 0;

        // Loop while number is not 0 (not remainder)
        while (number != 0) {
            lastDigit = number % 10;

            // Check for integer overflow before updating reverse
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                System.out.println("Overflow! Reversed number exceeds 32-bit integer limit.");
                scanner.close();
                return;
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                System.out.println("Underflow! Reversed number exceeds 32-bit integer limit.");
                scanner.close();
                return;
            }

            reverse = reverse * 10 + lastDigit;
            number /= 10;
        }

        System.out.println("The reverse of the number is: " + reverse);
        scanner.close();
    }
}
/*
Q2: The answers to Q2 prompts.

Printing out result will result in 13.5, because a double is bigger than an int so the reusult will be a double.
Printing out value will result in a number that is the ASCII value of 'A' + the int 5 which is 70.
Type casting value to a char will result in a ASCII value being printed out for 70 which is 'F'.

*/
