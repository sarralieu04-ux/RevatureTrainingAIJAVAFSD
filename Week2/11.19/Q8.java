import java.util.Scanner;

public class Q8 {
    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // Tracks ASCII characters seen so far

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            // If the character hasn't been seen yet, append it and mark as seen
            if (!seen[current]) {
                seen[current] = true;
                result.append(current);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String output = removeDuplicates(input);
        System.out.println("Output: " + output);

        scanner.close();
    }
}
