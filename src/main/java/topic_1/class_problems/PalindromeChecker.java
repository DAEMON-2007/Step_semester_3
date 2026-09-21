package topic_1.class_problems;

public class PalindromeChecker {
    public boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }

        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        return text.charAt(left) == text.charAt(right)
                && isPalindromeRecursive(text, left + 1, right - 1);
    }

    public boolean isPalindromeArrayReverse(String text) {
        if (text == null) {
            return false;
        }

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int index = 0; index < original.length; index++) {
            reversed[index] = original[original.length - 1 - index];
        }
        return new String(original).equals(new String(reversed));
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        String[] examples = {"madam", "hello"};

        for (String example : examples) {
            System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                    example,
                    checker.isPalindromeIterative(example) ? "Palindrome" : "Not Palindrome",
                    checker.isPalindromeRecursive(example) ? "Palindrome" : "Not Palindrome",
                    checker.isPalindromeArrayReverse(example) ? "Palindrome" : "Not Palindrome");
        }
    }
}
