package tests;

import org.junit.jupiter.api.Test;
import shapes.Rectangle;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testRectangleCreation() {
        Rectangle rectangle = new Rectangle(4, 6);
        assertEquals(4, rectangle.getWidth());
        assertEquals(6, rectangle.getHeight());
    }

    @Test
    void testRectangleRendering() {
        Rectangle rectangle = new Rectangle(4, 6);
        String expectedRenderingOutput = "Expected rendering output for Rectangle";
        assertEquals(expectedRenderingOutput, rectangle.render());
    }
}
