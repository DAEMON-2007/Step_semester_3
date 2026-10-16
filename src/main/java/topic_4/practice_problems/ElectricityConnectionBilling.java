package topic_4.practice_problems;

import java.util.Scanner;

public class ElectricityConnectionBilling {
    private abstract static class Connection {
        private final int units;

        protected Connection(int units) {
            this.units = units;
        }

        protected int units() {
            return units;
        }

        protected abstract String type();

        protected abstract double bill();
    }

    private static final class HomeConnection extends Connection {
        private HomeConnection(int units) {
            super(units);
        }

        @Override
        protected String type() {
            return "HOME";
        }

        @Override
        protected double bill() {
            return Math.min(units(), 100) * 5.0 + Math.max(0, units() - 100) * 7.0;
        }
    }

    private static final class ShopConnection extends Connection {
        private ShopConnection(int units) {
            super(units);
        }

        @Override
        protected String type() {
            return "SHOP";
        }

        @Override
        protected double bill() {
            return units() * 8.0 + 100.0;
        }
    }

    private static final class FactoryConnection extends Connection {
        private FactoryConnection(int units) {
            super(units);
        }

        @Override
        protected String type() {
            return "FACTORY";
        }

        @Override
        protected double bill() {
            return Math.max(units() * 6.0, 1000.0);
        }
    }

    private static Connection createConnection(String type, int units) {
        return switch (type) {
            case "HOME" -> new HomeConnection(units);
            case "SHOP" -> new ShopConnection(units);
            case "FACTORY" -> new FactoryConnection(units);
            default -> throw new IllegalArgumentException("Unknown connection type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int connectionCount = scanner.nextInt();
        double total = 0.0;

        for (int index = 0; index < connectionCount; index++) {
            Connection connection = createConnection(scanner.next(), scanner.nextInt());
            double bill = connection.bill();
            System.out.printf("%s: %.2f%n", connection.type(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
