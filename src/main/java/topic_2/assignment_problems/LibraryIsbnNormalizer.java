package topic_2.assignment_problems;

public class LibraryIsbnNormalizer {
    public String normalizeString(String raw) {
        if (raw == null) {
            return null;
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: publisher code must be 3 letters";
        }

        String publisher = code.substring(0, 3);
        if (!publisher.matches("[A-Z]{3}")) {
            return "Invalid: publisher code must be 3 letters";
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7);
        if (!year.matches("\\d{4}")) {
            return "Invalid: year must be 4 digits";
        }
        if (!catalog.matches("\\d{6}")) {
            return "Invalid: catalog number must be 6 digits";
        }

        return String.format("[%s] YEAR: %s | CATALOG: %s", publisher, year, catalog);
    }

    public static void main(String[] args) {
        LibraryIsbnNormalizer normalizer = new LibraryIsbnNormalizer();
        System.out.println(normalizer.validateAndFormat(
                normalizer.normalizeString(" pen2026004251 ")));
        System.out.println(normalizer.validateAndFormat("12N2026004251"));
    }
}
