package topic_5.practice_problems;

import java.util.Scanner;

public class PrimeNumberChecker {
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.printf("%d is %s%n", number, isPrime(number) ? "prime" : "not prime");
    }
}
