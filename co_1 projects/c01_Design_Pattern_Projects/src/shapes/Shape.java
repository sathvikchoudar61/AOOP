package shapes;

import java.awt.Graphics2D;
import rendering.RenderMethod;

public interface Shape {
    void draw(Graphics2D g2d, RenderMethod renderMethod);
}
