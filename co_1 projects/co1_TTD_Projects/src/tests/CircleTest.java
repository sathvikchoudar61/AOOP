package tests;

import org.junit.jupiter.api.Test;
import shapes.Circle;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void testCircleCreation() {
        Circle circle = new Circle(5);
        assertEquals(5, circle.getRadius());
    }

    @Test
    void testCircleRendering() {
        Circle circle = new Circle(5);
        String expectedRenderingOutput = "Expected rendering output for Circle";
        assertEquals(expectedRenderingOutput, circle.render());
    }
}
