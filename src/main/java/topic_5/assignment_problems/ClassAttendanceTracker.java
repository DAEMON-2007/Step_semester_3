package topic_5.assignment_problems;

public class ClassAttendanceTracker {
    private ClassAttendanceTracker() {
    }

    public static AttendanceSummary attendanceSummary(int[] days) {
        int presentDays = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentDays++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }

        return new AttendanceSummary(presentDays, longestStreak);
    }

    public record AttendanceSummary(int presentDays, int longestStreak) {
    }
}
