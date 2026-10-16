package topic_5.practice_problems;

import java.util.Scanner;

public class VowelAndConsonantCounter {
    public static int[] count(String word) {
        int vowels = 0;
        for (char character : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(character) >= 0) {
                vowels++;
            }
        }
        return new int[]{vowels, word.length() - vowels};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] counts = count(scanner.next());
        System.out.printf("Vowels: %d%nConsonants: %d%n", counts[0], counts[1]);
    }
}
