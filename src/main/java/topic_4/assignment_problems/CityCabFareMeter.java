package topic_4.assignment_problems;

import java.util.Scanner;

public class CityCabFareMeter {
    private static final double NIGHT_MULTIPLIER = 1.20;

    private static double rate(String cabType) {
        return switch (cabType) {
            case "MINI" -> 10.0;
            case "SEDAN" -> 14.0;
            case "SUV" -> 18.0;
            default -> throw new IllegalArgumentException("Unknown cab type: " + cabType);
        };
    }

    private static boolean supportsNightService(String cabType) {
        return !cabType.equals("MINI");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tripCount = scanner.nextInt();
        double total = 0.0;

        for (int index = 0; index < tripCount; index++) {
            String cabType = scanner.next();
            double distance = scanner.nextDouble();
            String time = scanner.next();

            if (time.equals("NIGHT") && !supportsNightService(cabType)) {
                System.out.printf("%s: night service not available%n", cabType);
                continue;
            }

            double fare = Math.max(100.0, distance * rate(cabType));
            if (time.equals("NIGHT")) {
                fare *= NIGHT_MULTIPLIER;
            }
            System.out.printf("%s: %.2f%n", cabType, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
