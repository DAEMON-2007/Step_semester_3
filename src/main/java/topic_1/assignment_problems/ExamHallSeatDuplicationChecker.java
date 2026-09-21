package topic_1.assignment_problems;

public class ExamHallSeatDuplicationChecker {
    public void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        for (int first = 0; first < seatNumbers.length; first++) {
            for (int second = first + 1; second < seatNumbers.length; second++) {
                if (seatNumbers[first] == seatNumbers[second]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[first]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        ExamHallSeatDuplicationChecker checker = new ExamHallSeatDuplicationChecker();
        checker.checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checker.checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
