package topic_2.assignment_problems;

public class Scorecard {
    private final boolean[] results;
    private int recordedAnswers;

    public Scorecard(int questionCount) {
        if (questionCount < 0) {
            throw new IllegalArgumentException("Question count cannot be negative");
        }
        results = new boolean[questionCount];
    }

    public void recordAnswer(boolean correct) {
        if (recordedAnswers == results.length) {
            throw new IllegalStateException("All questions have been answered");
        }
        results[recordedAnswers++] = correct;
    }

    public int getScore() {
        int score = 0;
        for (int index = 0; index < recordedAnswers; index++) {
            if (results[index]) {
                score++;
            }
        }
        return score;
    }
}
