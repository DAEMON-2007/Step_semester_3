package topic_4.assignment_problems;

import java.util.Scanner;

public class ParcelShippingDesk {
    private abstract static class Parcel {
        private final double weight;
        private final double declaredValue;

        protected Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        protected double weight() {
            return weight;
        }

        protected double declaredValue() {
            return declaredValue;
        }

        protected abstract String type();

        protected abstract double charge();

        protected abstract double insurance();
    }

    private static final class StandardParcel extends Parcel {
        private StandardParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        protected String type() {
            return "STANDARD";
        }

        @Override
        protected double charge() {
            return 40.0 + weight() * 10.0;
        }

        @Override
        protected double insurance() {
            return 0.0;
        }
    }

    private static final class ExpressParcel extends Parcel {
        private ExpressParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        protected String type() {
            return "EXPRESS";
        }

        @Override
        protected double charge() {
            return 80.0 + weight() * 15.0;
        }

        @Override
        protected double insurance() {
            return declaredValue() * 0.02;
        }
    }

    private static final class FragileParcel extends Parcel {
        private FragileParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        protected String type() {
            return "FRAGILE";
        }

        @Override
        protected double charge() {
            return 40.0 + weight() * 10.0 + 50.0;
        }

        @Override
        protected double insurance() {
            return declaredValue() * 0.02;
        }
    }

    private static Parcel createParcel(String type, double weight, double declaredValue) {
        return switch (type) {
            case "STANDARD" -> new StandardParcel(weight, declaredValue);
            case "EXPRESS" -> new ExpressParcel(weight, declaredValue);
            case "FRAGILE" -> new FragileParcel(weight, declaredValue);
            default -> throw new IllegalArgumentException("Unknown parcel type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parcelCount = scanner.nextInt();
        double grandTotal = 0.0;

        for (int index = 0; index < parcelCount; index++) {
            Parcel parcel = createParcel(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
            double charge = parcel.charge();
            double insurance = parcel.insurance();
            double total = charge + insurance;
            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), charge, insurance, total);
            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
