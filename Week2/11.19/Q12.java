import java.util.Scanner;

public class Q12 {
    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            // Check if the next character is the same as the current one
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                // Append the current character and its total consecutive count
                compressed.append(str.charAt(i)).append(count);
                count = 1; // Reset count for the next distinct character
            }
        }

        return compressed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Output: " + compressString(input));
        scanner.close();
    }
}
