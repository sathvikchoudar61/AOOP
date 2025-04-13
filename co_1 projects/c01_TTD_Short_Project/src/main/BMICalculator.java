package main;

public class BMICalculator {

   
    public static double calculateBMI(double weightKg, double heightM) {
        if (weightKg <= 0 || heightM <= 0) {
            throw new IllegalArgumentException("Weight and height must be greater than zero.");
        }
        return weightKg / (heightM * heightM);
    }
    public static String determineBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
