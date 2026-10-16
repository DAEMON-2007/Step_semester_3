package topic_4.assignment_problems;

import java.util.Scanner;

public class HomeApplianceEnergyReport {
    private static final double SAVER_FACTOR = 0.75;

    private static double powerRating(String appliance) {
        return switch (appliance) {
            case "FRIDGE" -> 150.0;
            case "AC" -> 1500.0;
            case "TV" -> 100.0;
            case "WASHER" -> 500.0;
            default -> throw new IllegalArgumentException("Unknown appliance: " + appliance);
        };
    }

    private static boolean supportsSaverMode(String appliance) {
        return appliance.equals("AC") || appliance.equals("WASHER");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int applianceCount = scanner.nextInt();
        double totalCost = 0.0;

        for (int index = 0; index < applianceCount; index++) {
            String appliance = scanner.next();
            double hours = scanner.nextDouble();
            boolean saverRequested = scanner.hasNext("SAVER") && scanner.next().equals("SAVER");

            if (saverRequested && !supportsSaverMode(appliance)) {
                System.out.printf("%s: saver mode not supported%n", appliance);
                continue;
            }

            double units = powerRating(appliance) * hours / 1000.0;
            if (saverRequested) {
                units *= SAVER_FACTOR;
            }
            double cost = units * 8.0;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance, units, cost);
            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
