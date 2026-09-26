package topic_3.assignment_problems;

import java.util.Scanner;

public class PaymentSystemFeeCalculation {
    private abstract static class Payment {
        private final double amount;

        protected Payment(double amount) {
            this.amount = amount;
        }

        protected double amount() {
            return amount;
        }

        protected abstract String type();

        protected abstract double adjustedAmount();
    }

    private static final class CardPayment extends Payment {
        private CardPayment(double amount) {
            super(amount);
        }

        @Override
        protected String type() {
            return "CARD";
        }

        @Override
        protected double adjustedAmount() {
            return amount() * 1.02;
        }
    }

    private static final class WalletPayment extends Payment {
        private WalletPayment(double amount) {
            super(amount);
        }

        @Override
        protected String type() {
            return "WALLET";
        }

        @Override
        protected double adjustedAmount() {
            return amount() * 1.01;
        }
    }

    private static final class BankTransferPayment extends Payment {
        private BankTransferPayment(double amount) {
            super(amount);
        }

        @Override
        protected String type() {
            return "BANKTRANSFER";
        }

        @Override
        protected double adjustedAmount() {
            return amount();
        }
    }

    private static Payment createPayment(String type, double amount) {
        return switch (type) {
            case "CARD" -> new CardPayment(amount);
            case "WALLET" -> new WalletPayment(amount);
            case "BANKTRANSFER" -> new BankTransferPayment(amount);
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int transactionCount = scanner.nextInt();
        double total = 0;

        for (int index = 0; index < transactionCount; index++) {
            Payment payment = createPayment(scanner.next(), scanner.nextDouble());
            double adjustedAmount = payment.adjustedAmount();
            System.out.printf("%s: %.2f%n", payment.type(), adjustedAmount);
            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
