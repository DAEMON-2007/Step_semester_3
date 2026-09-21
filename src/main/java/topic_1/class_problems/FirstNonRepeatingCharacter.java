package topic_1.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public String findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return "No Non-Repeating Character Found";
        }

        Map<Character, Integer> frequencies = new LinkedHashMap<>();
        for (char character : text.toCharArray()) {
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }

        for (char character : text.toCharArray()) {
            if (frequencies.get(character) == 1) {
                return String.valueOf(character);
            }
        }

        return "No Non-Repeating Character Found";
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter finder = new FirstNonRepeatingCharacter();
        String[] examples = {"swiss", "aabbcc"};

        for (String example : examples) {
            String result = finder.findFirstNonRepeatingChar(example);
            if (result.length() == 1) {
                System.out.printf("First Non-Repeating Character: '%s'%n", result);
            } else {
                System.out.println(result);
            }
        }
    }
}
