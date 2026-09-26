package topic_3.assignment_problems;

import java.util.Scanner;

public class PublicTransportFareCalculator {
    private abstract static class Transport {
        private final double distance;

        protected Transport(double distance) {
            this.distance = distance;
        }

        protected double distance() {
            return distance;
        }

        protected abstract String type();

        protected abstract double fare();
    }

    private static final class Bus extends Transport {
        private Bus(double distance) {
            super(distance);
        }

        @Override
        protected String type() {
            return "BUS";
        }

        @Override
        protected double fare() {
            return Math.min(10.0, 2.0 + distance() * 0.10);
        }
    }

    private static final class Train extends Transport {
        private Train(double distance) {
            super(distance);
        }

        @Override
        protected String type() {
            return "TRAIN";
        }

        @Override
        protected double fare() {
            return 3.0 + distance() * 0.15;
        }
    }

    private static final class Metro extends Transport {
        private final double peakHourFactor;

        private Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        protected String type() {
            return "METRO";
        }

        @Override
        protected double fare() {
            return (1.5 + distance() * 0.20) * peakHourFactor;
        }
    }

    private static Transport createTransport(String type, double distance, double peakHourFactor) {
        return switch (type) {
            case "BUS" -> new Bus(distance);
            case "TRAIN" -> new Train(distance);
            case "METRO" -> new Metro(distance, peakHourFactor);
            default -> throw new IllegalArgumentException("Unknown transport type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int journeyCount = scanner.nextInt();
        double total = 0;

        for (int index = 0; index < journeyCount; index++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            double peakHourFactor = type.equals("METRO") ? scanner.nextDouble() : 1;
            Transport transport = createTransport(type, distance, peakHourFactor);
            double fare = transport.fare();
            System.out.printf("%s: %.2f%n", transport.type(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
