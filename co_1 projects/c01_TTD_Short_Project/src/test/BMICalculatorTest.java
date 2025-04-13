package test;

import main.BMICalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest {

    @Test
    void testCalculateBMI_ValidInputs() {
        double bmi = BMICalculator.calculateBMI(70, 1.75);
        assertEquals(22.86, bmi, 0.01, "BMI should be calculated correctly.");
    }

    @Test
    void testCalculateBMI_InvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> BMICalculator.calculateBMI(-70, 1.75));
        assertThrows(IllegalArgumentException.class, () -> BMICalculator.calculateBMI(70, -1.75));
        assertThrows(IllegalArgumentException.class, () -> BMICalculator.calculateBMI(0, 1.75));
        assertThrows(IllegalArgumentException.class, () -> BMICalculator.calculateBMI(70, 0));
    }

    @Test
    void testDetermineBMICategory_Underweight() {
        assertEquals("Underweight", BMICalculator.determineBMICategory(18.0));
    }

    @Test
    void testDetermineBMICategory_NormalWeight() {
        assertEquals("Normal weight", BMICalculator.determineBMICategory(22.0));
    }

    @Test
    void testDetermineBMICategory_Overweight() {
        assertEquals("Overweight", BMICalculator.determineBMICategory(27.0));
    }

    @Test
    void testDetermineBMICategory_Obese() {
        assertEquals("Obese", BMICalculator.determineBMICategory(30.0));
    }
}
