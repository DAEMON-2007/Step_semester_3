package topic_5.practice_problems;

import java.util.Scanner;

public class WordReverserAndPalindromeChecker {
    public static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public static boolean isPalindrome(String word) {
        return word.equals(reverse(word));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();
            String reversed = reverse(word);
            System.out.printf("%s - %s%n", reversed,
                    isPalindrome(word) ? "palindrome" : "not a palindrome");
        }
    }
}
