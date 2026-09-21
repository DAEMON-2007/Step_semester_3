package topic_2.class_problems;

public class FileExtensionValidator {
    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    public String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected - invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex <= 0 || dotIndex == filename.length() - 1) {
            return "Rejected - invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);
        for (String acceptedExtension : ACCEPTED_EXTENSIONS) {
            if (acceptedExtension.equalsIgnoreCase(extension)) {
                return "Accepted";
            }
        }
        return "Rejected - invalid file type";
    }

    public static void main(String[] args) {
        FileExtensionValidator validator = new FileExtensionValidator();
        System.out.println(validator.validateFileExtension("Assignment1.PDF"));
        System.out.println(validator.validateFileExtension("notes.txt"));
    }
}
