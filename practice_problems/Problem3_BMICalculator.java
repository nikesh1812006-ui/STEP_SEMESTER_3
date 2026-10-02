/**
 * Problem 3: BMI Calculator for a Team
 * Scenario: The Corporate Wellness Program
 * 
 * Computes Body Mass Index (BMI = weight / (height * height)) and classifies health status
 * for team members in a tabular report.
 */
public class Problem3_BMICalculator {

    /**
     * Classifies health status based on BMI.
     * BMI < 18.5 -> Underweight
     * 18.5 - 24.9 -> Normal
     * 25 - 29.9 -> Overweight
     * >= 30 -> Obese
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Prints a wellness report table for employees.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid data: heights and weights arrays must match in size.");
            return;
        }

        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    (i + 1), h, w, bmi, status);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Sample demonstration data
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70};
        double[] weights = {70.0, 90.0, 62.0, 72.0, 95.0};

        System.out.println("=== Corporate Wellness Program: BMI Report ===");
        printWellnessReport(heights, weights);
    }
}
