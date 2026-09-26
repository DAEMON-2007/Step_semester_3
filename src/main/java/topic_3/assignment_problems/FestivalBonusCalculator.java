package topic_3.assignment_problems;

import java.util.Scanner;

public class FestivalBonusCalculator {
    private abstract static class Employee {
        private final String name;
        private final double salary;

        protected Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        protected String name() {
            return name;
        }

        protected double salary() {
            return salary;
        }

        protected abstract double bonus();
    }

    private static final class FullTimeEmployee extends Employee {
        private FullTimeEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        protected double bonus() {
            return salary() * 0.10;
        }
    }

    private static final class PartTimeEmployee extends Employee {
        private PartTimeEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        protected double bonus() {
            return salary() * 0.05;
        }
    }

    private static final class Intern extends Employee {
        private Intern(String name, double salary) {
            super(name, salary);
        }

        @Override
        protected double bonus() {
            return 2000.0;
        }
    }

    private static Employee createEmployee(String type, String name, double salary) {
        return switch (type) {
            case "FULLTIME" -> new FullTimeEmployee(name, salary);
            case "PARTTIME" -> new PartTimeEmployee(name, salary);
            case "INTERN" -> new Intern(name, salary);
            default -> throw new IllegalArgumentException("Unknown employee type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeCount = scanner.nextInt();
        double total = 0;

        for (int index = 0; index < employeeCount; index++) {
            Employee employee = createEmployee(scanner.next(), scanner.next(), scanner.nextDouble());
            double bonus = employee.bonus();
            System.out.printf("%s: %.2f%n", employee.name(), bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
