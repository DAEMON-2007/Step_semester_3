package topic_5.practice_problems;

import java.util.Scanner;

public class DigitSumAndNumberReversal {
    public static int[] sumAndReverse(int number) {
        int original = number;
        int sum = 0;
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return new int[]{sum, original == 0 ? 0 : reversed};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] result = sumAndReverse(scanner.nextInt());
        System.out.printf("Sum of digits: %d%nReverse: %d%n", result[0], result[1]);
    }
}
