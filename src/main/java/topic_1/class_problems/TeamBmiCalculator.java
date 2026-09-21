package topic_1.class_problems;

public class TeamBmiCalculator {
    public String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25) {
            return "Normal";
        }
        if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    public void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights must have the same length.");
        }

        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        for (int index = 0; index < heights.length; index++) {
            if (heights[index] <= 0 || weights[index] <= 0) {
                throw new IllegalArgumentException("Height and weight must be positive.");
            }
            double bmi = weights[index] / (heights[index] * heights[index]);
            System.out.printf("%6d | %11.2f | %11.2f | %5.2f | %s%n",
                    index + 1, heights[index], weights[index], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        TeamBmiCalculator calculator = new TeamBmiCalculator();
        calculator.printWellnessReport(
                new double[]{1.75, 1.60},
                new double[]{70, 90});
    }
}
