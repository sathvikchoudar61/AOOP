package shapes;

import java.awt.Graphics2D;
import rendering.RenderMethod;

public class Square implements Shape {
    private int x, y, side;

    public Square(int x, int y, int side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    public void draw(Graphics2D g2d, RenderMethod renderMethod) {
        renderMethod.drawSquare(g2d, x, y, side);
    }
}
