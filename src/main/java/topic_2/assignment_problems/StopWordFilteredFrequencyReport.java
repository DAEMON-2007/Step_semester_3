package topic_2.assignment_problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StopWordFilteredFrequencyReport {
    private static final Set<String> STOP_WORDS = Set.of(
            "the", "was", "and", "in", "a", "is", "of", "to", "for");

    public void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        Map<String, Integer> frequencies = new HashMap<>();
        String cleanedFeedback = feedback.toLowerCase().replaceAll("[.,]", "");
        for (String word : cleanedFeedback.trim().split("\\s+")) {
            if (!STOP_WORDS.contains(word)) {
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
            }
        }

        frequencies.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        StopWordFilteredFrequencyReport report = new StopWordFilteredFrequencyReport();
        report.printFilteredWordFrequency(
                "The mentor was great, the session was great and clear.");
    }
}
