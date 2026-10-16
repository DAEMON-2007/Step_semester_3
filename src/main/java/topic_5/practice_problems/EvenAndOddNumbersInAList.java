package topic_5.practice_problems;

import java.util.Scanner;

public class EvenAndOddNumbersInAList {
    public static int[] countEvenAndOdd(int[] numbers) {
        int even = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                even++;
            }
        }
        return new int[]{even, numbers.length - even};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int index = 0; index < count; index++) {
            numbers[index] = scanner.nextInt();
        }
        int[] result = countEvenAndOdd(numbers);
        System.out.printf("Even: %d%nOdd: %d%n", result[0], result[1]);
    }
}
