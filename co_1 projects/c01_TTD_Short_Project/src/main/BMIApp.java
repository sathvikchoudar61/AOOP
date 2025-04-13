package main;

import java.util.Scanner;

public class BMIApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Welcome to the BMI Calculator!");
            System.out.print("Enter your weight in kilograms: ");
            double weight = scanner.nextDouble();
            System.out.print("Enter your height in meters: ");
            double height = scanner.nextDouble();
            double bmi = BMICalculator.calculateBMI(weight, height);
            String category = BMICalculator.determineBMICategory(bmi);
            System.out.printf("Your BMI is: %.2f%n", bmi);
            System.out.println("BMI Category: " + category);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numerical values.");
        } finally {
            scanner.close();
        }
    }
}
