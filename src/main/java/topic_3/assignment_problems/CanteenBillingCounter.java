package topic_3.assignment_problems;

import java.util.Scanner;

public class CanteenBillingCounter {
    private abstract static class Customer {
        private final double amount;

        protected Customer(double amount) {
            this.amount = amount;
        }

        protected double amount() {
            return amount;
        }

        protected abstract String type();

        protected abstract double finalAmount();
    }

    private static final class Student extends Customer {
        private Student(double amount) {
            super(amount);
        }

        @Override
        protected String type() {
            return "STUDENT";
        }

        @Override
        protected double finalAmount() {
            return amount() * 0.90;
        }
    }

    private static final class Staff extends Customer {
        private Staff(double amount) {
            super(amount);
        }

        @Override
        protected String type() {
            return "STAFF";
        }

        @Override
        protected double finalAmount() {
            return amount() * 0.95;
        }
    }

    private static final class Guest extends Customer {
        private Guest(double amount) {
            super(amount);
        }

        @Override
        protected String type() {
            return "GUEST";
        }

        @Override
        protected double finalAmount() {
            return amount() + 10;
        }
    }

    private static Customer createCustomer(String type, double amount) {
        return switch (type) {
            case "STUDENT" -> new Student(amount);
            case "STAFF" -> new Staff(amount);
            case "GUEST" -> new Guest(amount);
            default -> throw new IllegalArgumentException("Unknown customer type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int billCount = scanner.nextInt();
        double total = 0;

        for (int index = 0; index < billCount; index++) {
            Customer customer = createCustomer(scanner.next(), scanner.nextDouble());
            double finalAmount = customer.finalAmount();
            System.out.printf("%s: %.2f%n", customer.type(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
