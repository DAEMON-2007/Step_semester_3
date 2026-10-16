package topic_5.assignment_problems;

public class DutyRosterRotation {
    private DutyRosterRotation() {
    }

    public static String[] rotateRoster(String[] names, long k) {
        int length = names.length;
        String[] rotated = new String[length];
        int shift = (int) (k % length);

        for (int index = 0; index < length; index++) {
            rotated[(index + shift) % length] = names[index];
        }
        return rotated;
    }
}
