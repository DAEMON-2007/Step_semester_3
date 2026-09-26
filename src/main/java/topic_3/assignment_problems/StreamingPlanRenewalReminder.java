package topic_3.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {
    private abstract static class Subscription {
        private final String name;
        private final LocalDate startDate;

        protected Subscription(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        protected String name() {
            return name;
        }

        protected LocalDate startDate() {
            return startDate;
        }

        protected abstract int validityDays();

        protected LocalDate renewalDate() {
            return startDate().plusDays(validityDays());
        }
    }

    private static final class BasicPlan extends Subscription {
        private BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        protected int validityDays() {
            return 30;
        }
    }

    private static final class StandardPlan extends Subscription {
        private StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        protected int validityDays() {
            return 90;
        }
    }

    private static final class PremiumPlan extends Subscription {
        private PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        protected int validityDays() {
            return 365;
        }
    }

    private static Subscription createSubscription(
            String plan, String name, LocalDate startDate) {
        return switch (plan) {
            case "BASIC" -> new BasicPlan(name, startDate);
            case "STANDARD" -> new StandardPlan(name, startDate);
            case "PREMIUM" -> new PremiumPlan(name, startDate);
            default -> throw new IllegalArgumentException("Unknown plan: " + plan);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subscriberCount = scanner.nextInt();

        for (int index = 0; index < subscriberCount; index++) {
            Subscription subscription = createSubscription(
                    scanner.next(),
                    scanner.next(),
                    LocalDate.parse(scanner.next()));
            System.out.printf("%s: %s%n", subscription.name(), subscription.renewalDate());
        }
    }
}
