import java.util.Arrays;
import java.util.Scanner;

public class Q10 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Tracks the last index where each ASCII character appeared
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1); // -1 means the character has not been seen yet

        int maxLength = 0;
        int left = 0; // Start of the current non-repeating window

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // If 'current' was already seen inside our current window,
            // move 'left' right past that previous occurrence
            if (lastSeen[current] >= left) {
                left = lastSeen[current] + 1;
            }

            // Record the latest position of 'current'
            lastSeen[current] = right;

            // Calculate window size and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Output: " + lengthOfLongestSubstring(input));
        scanner.close();
    }
}
