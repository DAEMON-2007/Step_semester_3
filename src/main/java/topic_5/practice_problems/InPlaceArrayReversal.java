package topic_5.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void reverse(int[] numbers) {
        for (int left = 0, right = numbers.length - 1; left < right; left++, right--) {
            int temporary = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temporary;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int index = 0; index < count; index++) {
            numbers[index] = scanner.nextInt();
        }
        reverse(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
