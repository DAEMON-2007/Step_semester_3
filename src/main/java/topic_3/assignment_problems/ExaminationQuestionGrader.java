package topic_3.assignment_problems;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationQuestionGrader {
    private static final Pattern QUESTION_PATTERN =
            Pattern.compile("^(MCQ|TF|ESSAY)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$");

    private abstract static class Question {
        private final String questionText;
        private final String studentAnswer;
        private final double points;

        protected Question(String questionText, String studentAnswer, double points) {
            this.questionText = questionText;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        protected String questionText() {
            return questionText;
        }

        protected String studentAnswer() {
            return studentAnswer;
        }

        protected double points() {
            return points;
        }

        protected abstract String type();

        protected abstract double score();
    }

    private static final class MultipleChoiceQuestion extends Question {
        private final String correctAnswer;

        private MultipleChoiceQuestion(String text, String answer, String correctAnswer, double points) {
            super(text, answer, points);
            this.correctAnswer = correctAnswer;
        }

        @Override
        protected String type() {
            return "MCQ";
        }

        @Override
        protected double score() {
            return studentAnswer().equals(correctAnswer) ? points() : 0;
        }
    }

    private static final class TrueFalseQuestion extends Question {
        private final String correctAnswer;

        private TrueFalseQuestion(String text, String answer, String correctAnswer, double points) {
            super(text, answer, points);
            this.correctAnswer = correctAnswer;
        }

        @Override
        protected String type() {
            return "TF";
        }

        @Override
        protected double score() {
            return studentAnswer().equals(correctAnswer) ? points() : 0;
        }
    }

    private static final class EssayQuestion extends Question {
        private final String[] keywords;

        private EssayQuestion(String text, String answer, String correctAnswer, double points) {
            super(text, answer, points);
            keywords = correctAnswer.split(",");
        }

        @Override
        protected String type() {
            return "ESSAY";
        }

        @Override
        protected double score() {
            String answer = studentAnswer().toLowerCase(Locale.ROOT);
            int matchedKeywords = 0;
            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase(Locale.ROOT))) {
                    matchedKeywords++;
                }
            }
            return matchedKeywords >= 2
                    ? points() * 0.75
                    : matchedKeywords == 1 ? points() * 0.50 : 0;
        }
    }

    private static Question parseQuestion(String line) {
        Matcher matcher = QUESTION_PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid question: " + line);
        }

        String type = matcher.group(1);
        String questionText = matcher.group(2);
        String correctAnswer = matcher.group(3);
        String studentAnswer = matcher.group(4);
        double points = Double.parseDouble(matcher.group(5));
        return switch (type) {
            case "MCQ" -> new MultipleChoiceQuestion(
                    questionText, studentAnswer, correctAnswer, points);
            case "TF" -> new TrueFalseQuestion(
                    questionText, studentAnswer, correctAnswer, points);
            case "ESSAY" -> new EssayQuestion(
                    questionText, studentAnswer, correctAnswer, points);
            default -> throw new IllegalArgumentException("Unknown question type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questionCount = Integer.parseInt(scanner.nextLine().trim());
        double total = 0;

        for (int index = 0; index < questionCount; index++) {
            Question question = parseQuestion(scanner.nextLine());
            double score = question.score();
            System.out.printf("%s: %.2f%n", question.type(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
