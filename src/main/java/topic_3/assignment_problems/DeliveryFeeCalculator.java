package topic_3.assignment_problems;

import java.util.Scanner;

public class DeliveryFeeCalculator {
    private abstract static class Delivery {
        private final double weight;
        private final double distance;

        protected Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        protected double weight() {
            return weight;
        }

        protected double distance() {
            return distance;
        }

        protected abstract String type();

        protected abstract double fee();
    }

    private static final class StandardDelivery extends Delivery {
        private StandardDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        protected String type() {
            return "STANDARD";
        }

        @Override
        protected double fee() {
            return 5 + weight() * 0.50 + distance() * 0.10;
        }
    }

    private static final class ExpressDelivery extends Delivery {
        private ExpressDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        protected String type() {
            return "EXPRESS";
        }

        @Override
        protected double fee() {
            return 15 + weight() * 1.00 + distance() * 0.20;
        }
    }

    private static final class InternationalDelivery extends Delivery {
        private final double customsFee;

        private InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        protected String type() {
            return "INTERNATIONAL";
        }

        @Override
        protected double fee() {
            return 25 + weight() * 2.00 + distance() * 0.50 + customsFee;
        }
    }

    private static Delivery createDelivery(
            String type, double weight, double distance, double customsFee) {
        return switch (type) {
            case "STANDARD" -> new StandardDelivery(weight, distance);
            case "EXPRESS" -> new ExpressDelivery(weight, distance);
            case "INTERNATIONAL" -> new InternationalDelivery(weight, distance, customsFee);
            default -> throw new IllegalArgumentException("Unknown delivery type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int deliveryCount = scanner.nextInt();
        double total = 0;

        for (int index = 0; index < deliveryCount; index++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            double customsFee = type.equals("INTERNATIONAL") ? scanner.nextDouble() : 0;
            Delivery delivery = createDelivery(type, weight, distance, customsFee);
            double fee = delivery.fee();
            System.out.printf("%s: %.2f%n", delivery.type(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
