package topic_1.assignment_problems;

public class MovieReviewWordLengthProfiler {
    public void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        String[] words = review.trim().split("\\s+");

        for (String word : words) {
            int length = word.length();
            if (length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n",
                shortWords, mediumWords, longWords);
    }

    public static void main(String[] args) {
        MovieReviewWordLengthProfiler profiler = new MovieReviewWordLengthProfiler();
        profiler.classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
