package topic_4.assignment_problems;

import java.util.Scanner;

public class MovieTicketCounter {
    private static final double CONVENIENCE_FEE = 20.0;

    private static double ticketPrice(String seatType) {
        return switch (seatType) {
            case "REGULAR" -> 150.0;
            case "PREMIUM" -> 250.0;
            case "RECLINER" -> 400.0;
            default -> throw new IllegalArgumentException("Unknown seat type: " + seatType);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookingCount = scanner.nextInt();
        double total = 0.0;

        for (int index = 0; index < bookingCount; index++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();
            double amount = count * (ticketPrice(seatType) + CONVENIENCE_FEE);
            System.out.printf("%s: %.2f%n", seatType, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
