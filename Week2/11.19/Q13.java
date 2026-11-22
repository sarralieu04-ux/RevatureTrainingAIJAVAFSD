import java.util.Scanner;

public class Q13 {
    public static String reverseWords(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int i = str.length() - 1;

        while (i >= 0) {
            // 1. Skip any trailing or multiple spaces
            while (i >= 0 && str.charAt(i) == ' ') {
                i--;
            }

            // Stop if we reached the beginning (handles leading spaces)
            if (i < 0) {
                break;
            }

            // 2. 'end' marks the last character of the current word
            int end = i;

            // 3. Move 'i' backward until the space before the word (or start of string)
            while (i >= 0 && str.charAt(i) != ' ') {
                i--;
            }

            // 4. Add a single space before appending if this isn't the first word added
            if (result.length() > 0) {
                result.append(' ');
            }

            // 5. Append the word in its original forward character order
            result.append(str.substring(i + 1, end + 1));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        System.out.println("Output: \"" + reverseWords(input) + "\"");
        scanner.close();
    }
}
