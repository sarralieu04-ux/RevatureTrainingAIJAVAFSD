import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Q9 {
    public static void findFirstNonRepeated(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("No non-repeated character");
            return;
        }

        // LinkedHashMap maintains insertion order
        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        // Pass 1: Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            charCounts.put(current, charCounts.getOrDefault(current, 0) + 1);
        }

        // Pass 2: Find the first entry with a count of 1
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }

        System.out.println("No non-repeated character");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        findFirstNonRepeated(input);
        scanner.close();
    }
}
