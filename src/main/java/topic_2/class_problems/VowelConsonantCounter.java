package topic_2.class_problems;

public class VowelConsonantCounter {
    public void countVowelsAndConsonants(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }

        int vowels = 0;
        int consonants = 0;
        for (int index = 0; index < text.length(); index++) {
            char character = Character.toLowerCase(text.charAt(index));
            if (character == 'a' || character == 'e' || character == 'i'
                    || character == 'o' || character == 'u') {
                vowels++;
            } else if (character >= 'a' && character <= 'z') {
                consonants++;
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }

    public static void main(String[] args) {
        new VowelConsonantCounter().countVowelsAndConsonants("Java Programming");
    }
}
