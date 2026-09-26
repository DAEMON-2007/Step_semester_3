package topic_3.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {
    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    private abstract static class LibraryItem {
        private final String title;

        protected LibraryItem(String title) {
            this.title = title;
        }

        protected String title() {
            return title;
        }

        protected abstract int borrowingPeriod();

        protected LocalDate dueDate() {
            return CURRENT_DATE.plusDays(borrowingPeriod());
        }
    }

    private static final class Book extends LibraryItem {
        private Book(String title) {
            super(title);
        }

        @Override
        protected int borrowingPeriod() {
            return 14;
        }
    }

    private static final class Dvd extends LibraryItem {
        private Dvd(String title) {
            super(title);
        }

        @Override
        protected int borrowingPeriod() {
            return 7;
        }
    }

    private static final class Magazine extends LibraryItem {
        private Magazine(String title) {
            super(title);
        }

        @Override
        protected int borrowingPeriod() {
            return 3;
        }
    }

    private static LibraryItem createItem(String type, String title) {
        return switch (type) {
            case "BOOK" -> new Book(title);
            case "DVD" -> new Dvd(title);
            case "MAGAZINE" -> new Magazine(title);
            default -> throw new IllegalArgumentException("Unknown item type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCount = scanner.nextInt();
        scanner.nextLine();

        for (int index = 0; index < itemCount; index++) {
            String[] fields = scanner.nextLine().split(" ", 2);
            String title = fields[1].replaceAll("^\"|\"$", "");
            LibraryItem item = createItem(fields[0], title);
            System.out.printf("%s: %s%n", item.title(), item.dueDate());
        }
    }
}
