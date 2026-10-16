package topic_5.assignment_problems;

public class SecondBestScore {
    private SecondBestScore() {
    }

    public static int secondHighest(int[] scores) {
        Integer highest = null;
        Integer secondHighest = null;

        for (int score : scores) {
            if (highest != null && score == highest) {
                continue;
            }
            if (highest == null || score > highest) {
                secondHighest = highest;
                highest = score;
            } else if (secondHighest == null || score > secondHighest) {
                secondHighest = score;
            }
        }

        return secondHighest == null ? -1 : secondHighest;
    }
}
