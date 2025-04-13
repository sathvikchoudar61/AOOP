package tests;

import org.junit.jupiter.api.Test;
import shapes.Square;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testSquareCreation() {
        Square square = new Square(4);
        assertEquals(4, square.getSideLength());
    }

    @Test
    void testSquareRendering() {
        Square square = new Square(4);
        String expectedRenderingOutput = "Expected rendering output for Square";
        assertEquals(expectedRenderingOutput, square.render());
    }
}
