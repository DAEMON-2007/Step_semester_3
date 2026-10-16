package topic_5.practice_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentResultCardGenerator {
    public static char grade(double average) {
        return average >= 90 ? 'A' : average >= 75 ? 'B' : average >= 60 ? 'C' : 'D';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern studentPattern = Pattern.compile("(\\S+)\\s*\\[\\s*(\\d+(?:\\.\\d+)?)\\s*,\\s*"
                + "(\\d+(?:\\.\\d+)?)\\s*,\\s*(\\d+(?:\\.\\d+)?)\\s*\\]");
        while (scanner.hasNextLine()) {
            Matcher match = studentPattern.matcher(scanner.nextLine());
            if (!match.matches()) {
                continue;
            }
            String name = match.group(1);
            double first = Double.parseDouble(match.group(2));
            double second = Double.parseDouble(match.group(3));
            double third = Double.parseDouble(match.group(4));
            double average = (first + second + third) / 3.0;
            System.out.printf("%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), average, grade(average));
        }
    }
}
