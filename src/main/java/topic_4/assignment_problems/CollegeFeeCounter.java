package topic_4.assignment_problems;

import java.util.Scanner;

public class CollegeFeeCounter {
    private static double fee(String type) {
        return switch (type) {
            case "DAY_SCHOLAR" -> 40000.0 + 12000.0;
            case "HOSTELLER" -> 40000.0 + 60000.0;
            case "SCHOLAR" -> 20000.0 + 12000.0;
            default -> throw new IllegalArgumentException("Unknown student type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = scanner.nextInt();
        double total = 0.0;

        for (int index = 0; index < studentCount; index++) {
            String type = scanner.next();
            String name = scanner.next();
            double studentFee = fee(type);
            System.out.printf("%s: %.2f%n", name, studentFee);
            total += studentFee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}
