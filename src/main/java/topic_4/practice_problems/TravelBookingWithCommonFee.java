package topic_4.practice_problems;

import java.util.Scanner;

public class TravelBookingWithCommonFee {
    private static final double BOOKING_FEE = 50.0;

    private abstract static class Booking {
        private final double distance;

        protected Booking(double distance) {
            this.distance = distance;
        }

        protected double distance() {
            return distance;
        }

        protected abstract String mode();

        protected abstract double baseFare();

        protected double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    private static final class BusBooking extends Booking {
        private BusBooking(double distance) {
            super(distance);
        }

        @Override
        protected String mode() {
            return "BUS";
        }

        @Override
        protected double baseFare() {
            return distance() * 2.0;
        }
    }

    private static final class TrainBooking extends Booking {
        private TrainBooking(double distance) {
            super(distance);
        }

        @Override
        protected String mode() {
            return "TRAIN";
        }

        @Override
        protected double baseFare() {
            return distance() * 1.5;
        }
    }

    private static final class FlightBooking extends Booking {
        private FlightBooking(double distance) {
            super(distance);
        }

        @Override
        protected String mode() {
            return "FLIGHT";
        }

        @Override
        protected double baseFare() {
            return 2500.0 + distance() * 4.0;
        }
    }

    private static Booking createBooking(String mode, double distance) {
        return switch (mode) {
            case "BUS" -> new BusBooking(distance);
            case "TRAIN" -> new TrainBooking(distance);
            case "FLIGHT" -> new FlightBooking(distance);
            default -> throw new IllegalArgumentException("Unknown travel mode: " + mode);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookingCount = scanner.nextInt();

        for (int index = 0; index < bookingCount; index++) {
            Booking booking = createBooking(scanner.next(), scanner.nextDouble());
            System.out.printf("%s: %.2f%n", booking.mode(), booking.total());
        }
    }
}
