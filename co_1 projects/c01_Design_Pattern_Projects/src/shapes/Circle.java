package shapes;

import java.awt.Graphics2D;
import rendering.RenderMethod;

public class Circle implements Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g2d, RenderMethod renderMethod) {
        renderMethod.drawCircle(g2d, x, y, radius);
    }
}
