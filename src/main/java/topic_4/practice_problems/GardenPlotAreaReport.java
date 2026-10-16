package topic_4.practice_problems;

import java.util.Scanner;

public class GardenPlotAreaReport {
    private abstract static class Plot {
        private final String owner;

        protected Plot(String owner) {
            this.owner = owner;
        }

        protected String owner() {
            return owner;
        }

        protected abstract String shape();

        protected abstract double area();
    }

    private static final class Circle extends Plot {
        private final double radius;

        private Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override
        protected String shape() {
            return "CIRCLE";
        }

        @Override
        protected double area() {
            return Math.PI * radius * radius;
        }
    }

    private static final class Rectangle extends Plot {
        private final double length;
        private final double width;

        private Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override
        protected String shape() {
            return "RECTANGLE";
        }

        @Override
        protected double area() {
            return length * width;
        }
    }

    private static final class Triangle extends Plot {
        private final double base;
        private final double height;

        private Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override
        protected String shape() {
            return "TRIANGLE";
        }

        @Override
        protected double area() {
            return 0.5 * base * height;
        }
    }

    private static Plot createPlot(Scanner scanner) {
        String shape = scanner.next();
        String owner = scanner.next();
        return switch (shape) {
            case "CIRCLE" -> new Circle(owner, scanner.nextDouble());
            case "RECTANGLE" -> new Rectangle(owner, scanner.nextDouble(), scanner.nextDouble());
            case "TRIANGLE" -> new Triangle(owner, scanner.nextDouble(), scanner.nextDouble());
            default -> throw new IllegalArgumentException("Unknown plot shape: " + shape);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plotCount = scanner.nextInt();
        double totalArea = 0.0;

        for (int index = 0; index < plotCount; index++) {
            Plot plot = createPlot(scanner);
            double area = plot.area();
            System.out.printf("%s (%s): %.2f%n", plot.owner(), plot.shape(), area);
            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}
