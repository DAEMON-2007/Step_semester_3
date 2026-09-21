package topic_2.class_problems;

public class CsvStudentRecordParser {
    public void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3
                || fields[0].trim().isEmpty()
                || fields[1].trim().isEmpty()
                || fields[2].trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n",
                fields[0].trim(), fields[1].trim(), fields[2].trim());
    }

    public static void main(String[] args) {
        CsvStudentRecordParser parser = new CsvStudentRecordParser();
        parser.parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parser.parseStudentRecord("Ananya Verma,CSE");
    }
}
