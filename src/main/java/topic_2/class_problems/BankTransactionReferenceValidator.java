package topic_2.class_problems;

public class BankTransactionReferenceValidator {
    public String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        if (!bankCode.matches("[A-Z]{3}")) {
            return "Invalid: bank code must be 3 letters";
        }

        String date = reference.substring(3, 9);
        for (int index = 0; index < date.length(); index++) {
            if (!Character.isDigit(date.charAt(index))) {
                return "Invalid: date must be 6 digits";
            }
        }

        String sequence = reference.substring(9);
        for (int index = 0; index < sequence.length(); index++) {
            if (!Character.isDigit(sequence.charAt(index))) {
                return "Invalid: sequence must be 5 digits";
            }
        }

        String formattedDate = date.substring(0, 2) + "/"
                + date.substring(2, 4) + "/" + date.substring(4);
        return String.format("[%s] DATE: %s | SEQ: %s", bankCode, formattedDate, sequence);
    }

    public static void main(String[] args) {
        BankTransactionReferenceValidator validator = new BankTransactionReferenceValidator();
        String normalized = validator.normalizeReference(" hdf03022600042 ");
        System.out.println(validator.validateAndFormat(normalized));
        System.out.println(validator.validateAndFormat("12F03022600042"));
    }
}
