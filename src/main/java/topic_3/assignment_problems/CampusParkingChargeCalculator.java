package topic_3.assignment_problems;

import java.util.Scanner;

public class CampusParkingChargeCalculator {
    private abstract static class Vehicle {
        private final int hours;

        protected Vehicle(int hours) {
            this.hours = hours;
        }

        protected int hours() {
            return hours;
        }

        protected abstract String type();

        protected abstract double charge();
    }

    private static final class Bike extends Vehicle {
        private Bike(int hours) {
            super(hours);
        }

        @Override
        protected String type() {
            return "BIKE";
        }

        @Override
        protected double charge() {
            return hours() * 10.0;
        }
    }

    private static final class Car extends Vehicle {
        private Car(int hours) {
            super(hours);
        }

        @Override
        protected String type() {
            return "CAR";
        }

        @Override
        protected double charge() {
            return hours() == 1 ? 30.0 : 30.0 + (hours() - 1) * 20.0;
        }
    }

    private static final class Truck extends Vehicle {
        private Truck(int hours) {
            super(hours);
        }

        @Override
        protected String type() {
            return "TRUCK";
        }

        @Override
        protected double charge() {
            return Math.max(100.0, hours() * 50.0);
        }
    }

    private static Vehicle createVehicle(String type, int hours) {
        return switch (type) {
            case "BIKE" -> new Bike(hours);
            case "CAR" -> new Car(hours);
            case "TRUCK" -> new Truck(hours);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vehicleCount = scanner.nextInt();
        double total = 0;

        for (int index = 0; index < vehicleCount; index++) {
            Vehicle vehicle = createVehicle(scanner.next(), scanner.nextInt());
            double charge = vehicle.charge();
            System.out.printf("%s: %.2f%n", vehicle.type(), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
