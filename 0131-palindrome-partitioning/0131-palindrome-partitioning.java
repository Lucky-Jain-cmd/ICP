import java.util.*;

public class Solution {
    
    // Function to find all palindrome partitions
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    // Backtracking helper function
    private static void backtrack(int start, String s, List<String> current, List<List<String>> result) {
        // Base case: if we've reached the end of the string
        if (start == s.length()) {
            result.add(new ArrayList<>(current)); // add copy of current partition
            return;
        }

        // Try every possible partition starting from 'start'
        for (int end = start; end < s.length(); end++) {
            // Check if substring s[start...end] is a palindrome
            if (isPalindrome(s, start, end)) {
                // Choose
                current.add(s.substring(start, end + 1));
                // Explore
                backtrack(end + 1, s, current, result);
                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    // Utility to check if substring s[left...right] is palindrome
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // Main method to test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        List<List<String>> result = partition(s);

        System.out.println("\nAll Palindrome Partitions:");
        for (List<String> partition : result) {
            System.out.println(partition);
        }

        sc.close();
    }
}
