package topic_2.assignment_problems;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int classSize) {
        if (classSize < 0) {
            throw new IllegalArgumentException("Class size cannot be negative");
        }
        presentStudents = new String[classSize];
    }

    public void markPresent(String studentName) {
        if (studentName == null || isPresent(studentName)) {
            return;
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount++] = studentName;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String studentName) {
        for (int index = 0; index < presentCount; index++) {
            if (presentStudents[index].equals(studentName)) {
                return true;
            }
        }
        return false;
    }
}
