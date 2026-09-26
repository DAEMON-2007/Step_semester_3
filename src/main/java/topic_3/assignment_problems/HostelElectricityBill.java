package topic_3.assignment_problems;

import java.util.Scanner;

public class HostelElectricityBill {
    private abstract static class Room {
        private final int units;

        protected Room(int units) {
            this.units = units;
        }

        protected int units() {
            return units;
        }

        protected abstract String type();

        protected abstract double bill();
    }

    private static final class SingleRoom extends Room {
        private SingleRoom(int units) {
            super(units);
        }

        @Override
        protected String type() {
            return "SINGLE";
        }

        @Override
        protected double bill() {
            return units() * 8.0;
        }
    }

    private static final class SharedRoom extends Room {
        private final int occupants;

        private SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        protected String type() {
            return "SHARED";
        }

        @Override
        protected double bill() {
            return units() * 6.0 / occupants;
        }
    }

    private static final class AcRoom extends Room {
        private AcRoom(int units) {
            super(units);
        }

        @Override
        protected String type() {
            return "AC";
        }

        @Override
        protected double bill() {
            return units() * 10.0 + 200.0;
        }
    }

    private static Room createRoom(String type, int units, int occupants) {
        return switch (type) {
            case "SINGLE" -> new SingleRoom(units);
            case "SHARED" -> new SharedRoom(units, occupants);
            case "AC" -> new AcRoom(units);
            default -> throw new IllegalArgumentException("Unknown room type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roomCount = scanner.nextInt();
        double total = 0;

        for (int index = 0; index < roomCount; index++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            int occupants = type.equals("SHARED") ? scanner.nextInt() : 1;
            Room room = createRoom(type, units, occupants);
            double bill = room.bill();
            System.out.printf("%s: %.2f%n", room.type(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
