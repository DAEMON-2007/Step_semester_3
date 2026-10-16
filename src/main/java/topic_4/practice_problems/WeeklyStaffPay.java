package topic_4.practice_problems;

import java.util.Scanner;

public class WeeklyStaffPay {
    private abstract static class StaffMember {
        private final String name;

        protected StaffMember(String name) {
            this.name = name;
        }

        protected String name() {
            return name;
        }

        protected abstract double pay();
    }

    private static final class FullTimeStaff extends StaffMember {
        private final double weeklySalary;

        private FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        protected double pay() {
            return weeklySalary;
        }
    }

    private static final class HourlyStaff extends StaffMember {
        private final int hours;
        private final double rate;

        private HourlyStaff(String name, int hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        protected double pay() {
            return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5;
        }
    }

    private static final class Intern extends StaffMember {
        private final double stipend;

        private Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        protected double pay() {
            return stipend;
        }
    }

    private static StaffMember createStaffMember(Scanner scanner) {
        String type = scanner.next();
        String name = scanner.next();
        return switch (type) {
            case "FULLTIME" -> new FullTimeStaff(name, scanner.nextDouble());
            case "HOURLY" -> new HourlyStaff(name, scanner.nextInt(), scanner.nextDouble());
            case "INTERN" -> new Intern(name, scanner.nextDouble());
            default -> throw new IllegalArgumentException("Unknown staff type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int staffCount = scanner.nextInt();
        double payroll = 0.0;

        for (int index = 0; index < staffCount; index++) {
            StaffMember staffMember = createStaffMember(scanner);
            double pay = staffMember.pay();
            System.out.printf("%s: %.2f%n", staffMember.name(), pay);
            payroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", payroll);
    }
}
