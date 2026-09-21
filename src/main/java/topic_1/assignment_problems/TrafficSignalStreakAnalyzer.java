package topic_1.assignment_problems;

public class TrafficSignalStreakAnalyzer {
    public void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No Signal Readings Found");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        char currentColor = longestColor;
        int currentLength = 1;

        for (int index = 1; index < signalLog.length(); index++) {
            if (signalLog.charAt(index) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(index);
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestColor = currentColor;
                longestLength = currentLength;
            }
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n",
                longestColor, longestLength);
    }

    public static void main(String[] args) {
        TrafficSignalStreakAnalyzer analyzer = new TrafficSignalStreakAnalyzer();
        analyzer.findLongestStreak("RRGGGYRR");
        analyzer.findLongestStreak("RRRRYYGG");
    }
}
