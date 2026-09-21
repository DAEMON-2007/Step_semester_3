package topic_1.assignment_problems;

public class TypingSpeedAccuracyChecker {
    public void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null || original.length() != typed.length()) {
            throw new IllegalArgumentException("Original and typed strings must have equal lengths.");
        }

        int matchedCharacters = 0;
        int firstMismatch = -1;
        for (int index = 0; index < original.length(); index++) {
            if (original.charAt(index) == typed.charAt(index)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = index;
            }
        }

        double accuracy = matchedCharacters * 100.0 / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatch + 1,
                    original.charAt(firstMismatch),
                    typed.charAt(firstMismatch));
        }
    }

    public static void main(String[] args) {
        TypingSpeedAccuracyChecker checker = new TypingSpeedAccuracyChecker();
        checker.checkTypingAccuracy("hello world", "hello wortd");
        checker.checkTypingAccuracy("coding", "coding");
    }
}
