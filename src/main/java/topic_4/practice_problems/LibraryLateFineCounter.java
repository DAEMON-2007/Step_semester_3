package topic_4.practice_problems;

import java.util.Scanner;

public class LibraryLateFineCounter {
    private abstract static class LibraryItem {
        private final String title;
        private final int daysLate;

        protected LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        protected String title() {
            return title;
        }

        protected int daysLate() {
            return daysLate;
        }

        protected abstract double fine();
    }

    private static final class Book extends LibraryItem {
        private Book(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        protected double fine() {
            return daysLate() * 2.0;
        }
    }

    private static final class Dvd extends LibraryItem {
        private Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        protected double fine() {
            return Math.min(daysLate() * 5.0, 50.0);
        }
    }

    private static final class Magazine extends LibraryItem {
        private Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        protected double fine() {
            return daysLate();
        }
    }

    private static LibraryItem createItem(Scanner scanner) {
        String type = scanner.next();
        String title = scanner.next();
        int daysLate = scanner.nextInt();
        return switch (type) {
            case "BOOK" -> new Book(title, daysLate);
            case "DVD" -> new Dvd(title, daysLate);
            case "MAGAZINE" -> new Magazine(title, daysLate);
            default -> throw new IllegalArgumentException("Unknown library item type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCount = scanner.nextInt();
        double totalFines = 0.0;

        for (int index = 0; index < itemCount; index++) {
            LibraryItem item = createItem(scanner);
            double fine = item.fine();
            System.out.printf("%s: %.2f%n", item.title(), fine);
            totalFines += fine;
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);
    }
}
